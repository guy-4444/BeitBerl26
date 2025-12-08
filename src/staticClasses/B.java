package staticClasses;

public class B extends A {

    @Override
    public void scan() {
        System.out.println("B scan");
    }

    public static void print() {
        System.out.println("B print");
    }

    // compile error
//    @Override
//    public void on() {
//        System.out.println("B scan");
//    }

    // compile error - can't override final function
//    public static void off() {
//        System.out.println("B print");
//    }
}
