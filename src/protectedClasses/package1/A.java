package protectedClasses.package1;


public class A {

    public int publicValue;
    protected int protectedValue;
    int packageValue;
    private int privateValue;

    public A() {
        this.publicValue = 1;
        this.protectedValue = 2;
        this.packageValue = 3;
        this.privateValue = 4;
    }

    public void testInsideA() {
        publicValue = 10;
        protectedValue = 20;
        packageValue = 30;
        privateValue = 40;

        A anotherA = new A();
        anotherA.publicValue = 1;
        anotherA.protectedValue = 2;
        anotherA.packageValue = 3;
        anotherA.privateValue = 4;
    }
}
