package practice_Lambda;

public class Lambda_04 {
    static void aMethod(MyFunction f){
        f.myMethod();
    }

    static MyFunction myMethod(){
        MyFunction f = () -> {};
        return f;
    }
    public static void main(String[] args) {
        MyFunction f = () -> System.out.println("myMethod()");
        aMethod(f);

        aMethod(()-> System.out.println("myMethod()"));


    }
    @FunctionalInterface
    public interface MyFunction{
        public void myMethod();
    }
}
