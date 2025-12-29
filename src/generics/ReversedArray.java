package generics;

import java.util.Arrays;
import java.util.Objects;

public class ReversedArray<T> {

    private T[] arr;
    private int size;

    public ReversedArray() {
        arr = (T[]) new Object[2];
        size = 0;
    }

    public void add(T item) {
        ensureCapacity();
        arr[size++] = item;
    }

    public T get(int index) {
        checkIndex(index);
        return arr[realIndex(index)];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int realIndex(int logicalIndex) {
        return size - 1 - logicalIndex;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ReversedArrayException("OutOfBounds!");
        }
    }

    private void ensureCapacity() {
        if (size < arr.length) return;
        int newCap = Math.max(1, arr.length * 2);
        arr = Arrays.copyOf(arr, newCap);
    }

    public boolean remove(T item) {
        for (int real = size - 1; real >= 0; real--) {
            if (Objects.equals(arr[real], item)) {
                removeByRealIndex(real);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        checkIndex(index);
        removeByRealIndex(realIndex(index));
        return true;
    }

    private void removeByRealIndex(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMoved);
        }
        arr[--size] = null;
    }

    public static class ReversedArrayException extends RuntimeException {
        public ReversedArrayException(String message) {
            super(message);
        }
    }
}
