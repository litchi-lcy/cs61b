package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node prev;
        private Node(T data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }
    private Node sentiment;
    private int size;
    public LinkedListDeque() {
        size = 0;
        sentiment = new Node(null);
    }
    public void addFirst(T value) {
        Node a = new Node(value);
        a.next = sentiment.next;
        a.prev = sentiment;
        sentiment.next.prev = a;
        sentiment.next = a;
        size++;
    }

    public void addLast(T value) {
        Node a = new Node(value);
        a.next = sentiment;
        a.prev = sentiment.prev;
        sentiment.prev.next = a;
        sentiment.prev = a;
        size++;
    }



    public int size() {
        return size;
    }

    public void printDeque() {
        Node current = sentiment.next;
        while (current != sentiment) {
            System.out.print(current.data);
            System.out.print(" ");
            current = current.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node removed = sentiment.next;
        sentiment.next = sentiment.next.next;
        sentiment.next.prev = sentiment;
        T data = removed.data;
        removed.prev = null;
        removed.next = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node removed = sentiment.prev;

        sentiment.prev = sentiment.prev.prev;
        sentiment.prev.next = sentiment;

        T data = removed.data;
        removed.prev = null;
        removed.next = null;
        size--;
        return data;
    }

    public T get(int index) {
        Node current = sentiment.next;
        int i = 0;
        while (current != sentiment) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return helpgetRecursive(sentiment.next, index);
    }

    private T helpgetRecursive(Node current, int index) {
        if (index == 0) {
            return current.data;
        }
        return helpgetRecursive(current.next, index - 1);
    }


    private class LIterator implements java.util.Iterator<T> {
        Node first;
        LIterator() {
            first = sentiment.next;
        }
        public boolean hasNext() {
            return first != sentiment;
        }
        public T next() {
            if (first == sentiment) {
                return null;
            }
            T item = (T) first.data;
            first = first.next;
            return item;
        }
    }

    public Iterator<T> iterator() {
        return new LIterator();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            if (((Deque<?>) o).size() == this.size) {
                Deque<?> d = (Deque<?>) o;
                for (int i = 0; i < this.size(); i++) {
                    Object item =  this.get(i);
                    Object item2 =  d.get(i);
                    if (item ==  null && item2 == null) {
                        continue;
                    } else if (item == null || item2 == null) {
                        return false;
                    } else if (!item.equals(item2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
