package protectedClasses.package3;


import protectedClasses.package3.package33.C;

public class MainC extends C {

    public void start() {
        C c = new C();
        c.publicValue = 10; // public
        //c.protectedValue = 20; // same package
        //c.packageValue = 30; // same package
        //c.privateValue = 40; // not allowed - not in the same class


        this.publicValue = 10; // public
        this.protectedValue = 20; // same package
        //this.packageValue = 30; // same package
        //this.privateValue = 40; // not allowed - not in the same class
    }
}
