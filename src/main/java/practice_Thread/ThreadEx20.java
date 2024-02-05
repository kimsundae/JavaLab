package practice_Thread;

public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();
    }



}
class ThreadEx20_1 extends Thread{
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;
    public void run(){
        while(true){
            try{
               Thread.sleep(10 * 1000); // 10초를 기다린다.
            }catch (InterruptedException e){
                System.out.println("Awaken by interrupt().");
            }
            gc(); // garbage collection을 수행함.
            System.out.println("Garbage Collected.Free Memory :" + freeMemory());
        }
    }
    public void gc(){
        usedMemory -= 300;
        if(usedMemory < 0) usedMemory = 0;
    }
    public int totalMemory() {return MAX_MEMORY;}
    public int freeMemory() {return MAX_MEMORY - usedMemory; }
}
