package protectedClasses.package3.package33;

public class C {

    public int publicValue;
    protected int protectedValue;
    int packageValue;
    private int privateValue;

    public C() {
        this.publicValue = 1;
        this.protectedValue = 2;
        this.packageValue = 3;
        this.privateValue = 4;

        C anotherC = new C();
        anotherC.publicValue = 1;
        anotherC.protectedValue = 2;
        anotherC.packageValue = 3;
        anotherC.privateValue = 4;
    }

}
