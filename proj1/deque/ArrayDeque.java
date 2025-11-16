package deque;


public class ArrayDeque<T> implements Deque<T>{
    T[] data ;
    int capacity = 8 ;
    int size = 0;
    private int  front = 0;
    private int rear = 0;

    public ArrayDeque() {
        data =(T[]) new Object[capacity];
    }


    public int size() {
        return size;
    }



    public void addFirst(T item) {
        check_resize();
        if(size == 0 ) {
            data[front] = item;
        }
        else {
            front = (front - 1 + capacity) % capacity;
            data[front] = item;
        }
        size++;
    }

    public void addLast(T item) {
        check_resize();
        if(size == 0 ) {
            data[front] = item;
        }
        else {
            rear = (rear + 1) % capacity;
            data[rear] = item;
        }
        size++;
    }

    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T removed = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        if(size == 0 ) {
            rear = front;
        }
        check_resize();
        return removed;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T removed = data[rear];
        data[rear] = null;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        if(size == 0 ) {
            front = rear;
        }
        check_resize();
        return removed;
    }

    public T get(int index) {
        return data[(front+index)%capacity];
    }

    public void resize(int newCapacity) {
        T[] new_data = (T[]) new Object[newCapacity];
        int k = 0;
        int i = front;
        while(k<size) {
            new_data[k++] = data[i];
            i = (i+1) % capacity;
        }

        data = new_data;
        front = 0;
        rear = size - 1;
    }

    public void check_resize() {

        if(size <= capacity / 4 && capacity > 8) {

            resize(size * 4);
            capacity = size * 4;
        }
        else if(size == capacity) {

            resize(capacity*2);
            capacity *= 2;
        }
    }

    public void printDeque() {

        int k = 0;
        int it = front;
        while(k < size) {
            System.out.print(data[it] + " ");
            it = (it + 1) % capacity;
            k++;
        }
    }

    public class Iterator implements java.util.Iterator<T> {
        int first;
        int last;
        public Iterator() {
            first = front;
            last = rear;
        }
        public boolean hasNext(){
            return first != rear && size != 0;
        }
        public T next() {
            T item = (T) data[first];
            first = (first + 1) % capacity;

            return item;
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public boolean equals(Object o) {
        if(o == this){
            return true;
        }
        if(o instanceof Deque) {
            if(size != ((Deque)o).size()) {
                return false;
            }
            int k = 0;
            while(k<this.size()) {
                Object item = get(k);
                Object item2 = ((Deque)o).get(k);
                if(!item.equals(item2)) {
                    return false;
                }
                k++;
            }
            return true;
        }
        return false;
    }


}
