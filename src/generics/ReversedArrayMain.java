package generics;

public class ReversedArrayMain {

    public void start() {
        ReversedList<String> singers = new ReversedList<>();
        singers.add("A");
        singers.add("B");
        singers.add("C");
        singers.add("D");
        singers.add("E");

        singers.remove("R");

        for (int i = 0; i < 6; i++) {
            System.out.println(singers.get(i));
        }

    }
}
