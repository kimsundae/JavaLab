package practice_Lambda;

public class LambdaEx3 {
    @FunctionalInterface
    interface MyFunction{
        void myMethod();
    }

}
class Outer{
    int val = 10;
    class Inner{
        int val = 20;
        void method(int i){
            int val = 30;
            i = 10;
        }
    }
}