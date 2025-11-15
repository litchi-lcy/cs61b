package deque;
public class LinkedListDeque<T> implements Deque<T>{
    class Node {
        T data;
        Node next;
        Node prev;
        public Node(T data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }
    Node sentiment;
    int size;
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
        sentiment.prev.next=a;
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
        if(size == 0){
            return null;
        }
        Node removed = sentiment.next;
        sentiment.next = sentiment.next.next;
        sentiment.next.prev=sentiment;
        T data = removed.data;
        removed.prev=null;
        removed.next=null;
        size--;
        return data;
    }

    public T removeLast() {
        if(size == 0){
            return null;
        }
        Node removed = sentiment.prev;

        sentiment.prev=sentiment.prev.prev;
        sentiment.prev.next=sentiment;

        T data = removed.data;
        removed.prev=null;
        removed.next=null;
        size--;
        return data;
    }

    public T get(int index) {
        Node current = sentiment.next;
        int i = 0;
        while (current != sentiment ) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if (index==0) {
            return sentiment.data;
        }
        return getRecursive(index-1);
    }


}