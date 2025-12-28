package generics;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class IsraeliQueue<S, T> {

    private LinkedHashMap<S, LinkedList<T>> map = new LinkedHashMap<>();
    private int size;

    public void add(S key, T item) {
        if (!map.containsKey(key)) {
            map.put(key, new LinkedList<>());
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

        S key = map.firstEntry().getKey();
        LinkedList<T> queue = map.get(key);
        T item = peek();

        if (remove) {
            if (queue.isEmpty()) {
                map.remove(key);
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
