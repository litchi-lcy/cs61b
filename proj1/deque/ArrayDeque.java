package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T [] data;
    private int capacity = 8;
    private int size = 0;
    private int  front = 0;
    private int rear = 0;

    public ArrayDeque() {
        data = (T[]) new Object[capacity];
    }


    public int size() {
        return size;
    }



    public void addFirst(T item) {
        checkResize();
        if (size != 0) {
            front = (front - 1 + capacity) % capacity;
        }
        data[front] = item;
        size++;
    }

    public void addLast(T item) {
        checkResize();
        if (size == 0) {
            data[front] = item;
        } else {
            rear = (rear + 1) % capacity;
            data[rear] = item;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            rear = front;
        }
        checkResize();
        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = data[rear];
        data[rear] = null;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        if (size == 0) {
            front = rear;
        }
        checkResize();
        return removed;
    }

    public T get(int index) {
        return data[(front + index) % capacity];
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        int k = 0;
        int i = front;
        while (k < size) {
            newData[k++] = data[i];
            i = (i + 1) % capacity;
        }

        data = newData;
        front = 0;
        rear = size - 1;
    }

    private void checkResize() {

        if (size <= capacity / 4 && capacity > 8) {

            resize(size * 4);
            capacity = size * 4;
        } else if (size == capacity) {
            resize(capacity * 2);
            capacity *= 2;
        }
    }

    public void printDeque() {

        int k = 0;
        int it = front;
        while (k < size) {
            System.out.print(data[it] + " ");
            it = (it + 1) % capacity;
            k++;
        }
    }

    private class AIterator implements java.util.Iterator<T> {
        int first;
        int counts;
        AIterator() {
            first = front;
            counts = 0;
        }
        public boolean hasNext() {
            return counts < size;
        }
        public T next() {
            T item = (T) data[first];
            first = (first + 1) % capacity;
            counts++;
            return item;
        }
    }

    public Iterator<T> iterator() {
        return new AIterator();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Deque) {
            if (size != ((Deque) o).size()) {
                return false;
            }
            int k = 0;
            while (k < this.size()) {
                Object item = get(k);
                Object item2 = ((Deque) o).get(k);
                if (item == null && item2 == null) {
                    continue;
                }
                if (item == null || item2 == null) {
                    return false;
                } else if (!item.equals(item2)) {
                    return false;
                }
                k++;
            }
            return true;
        }
        return false;
    }


}
