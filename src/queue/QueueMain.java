package queue;

import java.util.*;

public class QueueMain {

    private Scanner scanner = new Scanner(System.in);
    public void start() {
        Comparator<Cat> catWeightComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getWeight() - o1.getWeight();
            }
        };


        PriorityQueue<Cat> cats = new PriorityQueue<>(catWeightComparator);

        cats.add(new Cat("Motti", 45, 5, 40));
        cats.add(new Cat("Herzel", 30, 5, 20));
        cats.add(new Cat("Binyamin", 90, 5, 60));
        cats.add(new Cat("Mitzi", 12, 5, 90));
        cats.add(new Cat("Salmon", 30, 7, 95));




        Stack<Cat> catStack = new Stack<>();
        catStack.add(new Cat("Motti", 45, 5, 40));
        catStack.add(new Cat("Herzel", 30, 5, 20));
        catStack.add(new Cat("Binyamin", 90, 5, 60));
        catStack.add(new Cat("Mitzi", 12, 5, 90));
        catStack.add(new Cat("Salmon", 30, 7, 95));


        while (true) {
            scanner.nextInt();

            System.out.println(catStack.pop());
        }
    }

}
