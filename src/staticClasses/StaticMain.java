package staticClasses;

public class StaticMain {

    public static void start() {

        A a = new A();
        B b = new B();

        a.scan();
        A.print();

        b.scan();
        B.print();

    }
}
