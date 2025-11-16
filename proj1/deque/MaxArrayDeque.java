package  deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max(){
        if(this.isEmpty()) {
            return null;
        }

        T maxx = this.get(0);
        for(int i = 1; i < this.size(); i++){
            if(comparator.compare(this.get(i),maxx) > 0) {
                maxx = this.get(i);
            }
        }
        return maxx;
    }

    private T max(Comparator<T> c){
        if(this.isEmpty()) {
            return null;
        }
        T maxx = this.get(0);
        for(int i = 1; i < this.size(); i++) {
            if(c.compare(this.get(i),maxx) > 0) {
                maxx = this.get(i);
            }
        }
        return maxx;
    }
}
