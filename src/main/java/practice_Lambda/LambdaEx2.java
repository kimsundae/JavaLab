package practice_Lambda;

public class LambdaEx2 {
    @FunctionalInterface
    interface MyFunction{
        void myMethod();
    }

    public static void main(String[] args) {
        MyFunction function = () -> {};
        Object obj = (MyFunction)(()->{});
        String str = ((Object)(MyFunction)(()->{})).toString();

        System.out.println(function);
        System.out.println(obj);
        System.out.println(str);

        //System.out.println(()->{});
        System.out.println((MyFunction)(()->{}));
        //System.out.println((MyFunction)(()->{}).toString());
        System.out.println(((Object)(MyFunction)(()->{})).toString());

    }
}
