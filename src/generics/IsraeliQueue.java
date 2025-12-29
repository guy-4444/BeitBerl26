package generics;

import java.util.HashMap;
import java.util.LinkedList;

public class IsraeliQueue<S, T> {

    private HashMap<S, LinkedList<T>> map = new HashMap<>();
    private LinkedList<S> keyQueue = new LinkedList<>();
    private int size;

    public IsraeliQueue() {

    }

    public void add(S key, T item) {
        if (!map.containsKey(key)) {
            map.put(key, new LinkedList<>());
            keyQueue.add(key);
        }

        map.get(key).add(item);
        size++;
    }

    public int getSize() {
        return size;
    }

    public T pop() throws IsraeliQueueException {
        return first(true);
    }

    public T peek() throws IsraeliQueueException {
        return first(false);
    }

    private T first(boolean remove) {
        if (getSize() == 0) {
            throw new IsraeliQueueException("No items");
        }

        S key = keyQueue.peek();
        LinkedList<T> queue = map.get(key);
        T item = remove ? queue.pop() : queue.peek();

        if (remove) {
            if (queue.isEmpty()) {
                map.remove(key);
                keyQueue.pop();
            }
            size--;
        }

        return item;
    }

    public static class IsraeliQueueException extends RuntimeException {
        public IsraeliQueueException(String message) {
            super(message);
        }
    }
}
