package generics;

import java.util.Arrays;

public class ReversedList<T> {

    private T[] arr;
    private int size = 0;

    public ReversedList() {
        init();
    }

    private void init() {
        arr = (T[]) new Object[2];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        ensureCapacity();

        arr[size] = item;
        size++;
    }

    public T get(int index) throws ReversedListException {
        ensureSize(index);

        return arr[size - index - 1];
    }

    private void ensureSize(int index) throws ReversedListException {
        if (index < 0  ||  index >= size) {
            throw new ReversedListException("Out of bounds: (" + index + " from size of " + size + ")");
        }
    }

    private void ensureCapacity() {
        if (size < arr.length) {
            return;
        }

        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    public boolean remove(T item) throws ReversedListException {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                removeByRealIndex(i);
                return true;
            }
        }

        return false;
    }

    public boolean remove(int index) throws ReversedListException {
        ensureSize(index);
        int indexToRemove = size - index - 1;
        removeByRealIndex(indexToRemove);
        return true;
    }

    public void clear() {
        init();
    }

    private void removeByRealIndex(int index) {
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        arr[size - 1] = null;
        size--;
    }

    public static class ReversedListException extends RuntimeException {
        public ReversedListException(String message) {
            super(message);
        }
    }
}
