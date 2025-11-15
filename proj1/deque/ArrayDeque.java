package deque;


class ArrayDeque<T> implements Deque<T>{
    T[] data ;
    int capacity = 8 ;
    int size = 0;
    private int  front = 0;
    private int rear = 0;

    public ArrayDeque() {
        data =(T[]) new Object[capacity];
    }


    public int size(){
        return size;
    }

    public void addFirst(T item){
        check_resize();
        if(size == 0 ){
            data[front] = item;
        }
        else {
            front = (front - 1 + capacity) % capacity;
            data[front] = item;
        }
        size++;
    }

    public void addLast(T item){
        check_resize();
        if(size == 0 ){
            data[front] = item;
        }
        else {
            rear = (rear + 1) % capacity;
            data[rear] = item;
        }
        size++;
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T removed = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        if(size == 0 ){
            rear = front;
        }
        check_resize();
        return removed;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T removed = data[rear];
        data[rear] = null;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        if(size == 0 ){
            front = rear;
        }
        check_resize();
        return removed;
    }

    public T get(int index){
        return data[(front+index)%capacity];
    }

    public void resize(int newCapacity){
        T[] new_data = (T[]) new Object[newCapacity];
        int k = 0;
        int i = front;
        while(k<size){
            new_data[k++] = data[i];
            i = (i+1) % capacity;
        }

        data = new_data;
        front = 0;
        rear = size - 1;
    }

    public void check_resize(){

        if(size <= capacity / 4 && capacity > 8){

            resize(size * 4);
            capacity = size * 4;
        }
        else if(size == capacity){

            resize(capacity*2);
            capacity *= 2;
        }
    }

    public void printDeque(){
        for(int i = front; i != rear; i = (i + 1) % capacity){
            System.out.print(data[i] + " ");
        }
    }


}
