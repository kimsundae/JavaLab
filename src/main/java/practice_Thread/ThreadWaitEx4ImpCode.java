package practice_Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4ImpCode {
    public static void main(String[] args) throws Exception{
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0); // 프로그램 전체 종료. (모든 쓰레드가 종료됨)
    }
}

class Customer implements Runnable{
    private Table table;
    private String food;

    Customer(Table table, String food){
        this.table = table;
        this.food = food;
    }

    public void run(){
        while(true){
            try{Thread.sleep(100);}catch (InterruptedException e){}
            String name = Thread.currentThread().getName();
            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}
class Cook implements Runnable{
    private Table table;

    Cook(Table table){this.table = table; }

    public void run(){
        while(true){
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try{Thread.sleep(10);} catch (InterruptedException e){}
        }
    }

}
class Table{
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식 개수
    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forDonutCust = lock.newCondition();
    private Condition forBurgerCust = lock.newCondition();

    public synchronized void add(String dish){
        lock.lock();

        try{
            while( dishes.size() >= MAX_FOOD ){
                String name = Thread.currentThread().getName();
                System.out.println(name+ " is waiting. ");
                try{
                    forCook.await(); // wait(); COOK 쓰레드를 기다리게 한다.
                }catch (InterruptedException e){}
            }

            dishes.add(dish);
            switch (dish){
                case ("donut") : {
                    forDonutCust.signal();
                    break;
                }
                case ("burger") : {
                    forBurgerCust.signal();
                    break;
                }
            }
            System.out.println("Dishes:" + dishes.toString());

        }finally {
            lock.unlock();
        }
    }

    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();

        try{
            while(dishes.size() == 0 ){
                System.out.println(name + " is waiting ");
                try{
                    waitThread(dishName);
                    Thread.sleep(500);
                }catch (InterruptedException e){}
            }
            while(true){
                for(int i = 0; i < dishes.size(); i++){
                    if(dishName.equals(dishes.get(i))){
                        dishes.remove(i);
                        forCook.signal(); // notify(); 잠자고 있는 COOK을 깨움
                        return;
                    }
                }
                try{
                    System.out.println(name + " is waiting. ");
                    waitThread(dishName);
                    Thread.sleep(500);
                }catch (InterruptedException e){}
            } // while(true)
        }finally {
            lock.unlock();
        }
    }
    public int dishNum() {return dishNames.length;}
    public void waitThread(String dishName){
        try {
            switch (dishName) {
                case ("donut"): {
                    forDonutCust.await();
                    break;
                }
                case ("burger"): {
                    forBurgerCust.await();
                    break;
                }
            }
        } catch (InterruptedException e){}
    }
}
