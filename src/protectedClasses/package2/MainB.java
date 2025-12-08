package protectedClasses.package2;

import protectedClasses.package1.A;

public class MainB extends A {

    public void start() {
        A a = new A();

        a.publicValue = 10; // public
        //a.protectedValue = 20; // same package
        //a.packageValue = 30; // same package
        //a.privateValue = 40; // not allowed - not in the same class


        this.publicValue = 10; // public
        this.protectedValue = 20; // same package
        //this.packageValue = 30; // same package
        //this.privateValue = 40; // not allowed - not in the same class
    }
}
