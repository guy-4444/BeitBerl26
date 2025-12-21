package interfaces;

public class Bird implements Moveable, Flyable{
    @Override
    public void move() {

    }

    @Override
    public void fast() {
        Flyable.super.fast();
    }
}
