package deque;  // 确保接口在 deque 包下

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    //boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    default boolean isEmpty(){
        return size() == 0;
    }
}
