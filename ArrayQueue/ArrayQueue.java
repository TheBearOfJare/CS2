import java.util.Arrays;

public class ArrayQueue<Q> {
    
    private Q[] q;
    private int head;
    private int end;

    public ArrayQueue() {
        this(15);
    }

    public ArrayQueue(int size) {
        q = (Q[]) new Object[size];
        java.util.Arrays.fill(q, Integer.MIN_VALUE);
        head = 0;
        end = -1;
    }

    public boolean add (Q data) {
        if (!isFull()) {
            q[++end % q.length] = data;

            return true;
        }
        return false;
    }

    public Q remove() throws EmptyQueueException {
        if(!isEempty()) {
            Q temp = q[head];
            q[head++ % q.length] = null;
            return temp;
        }
        throw new EmptyQueueException();
    }

    public boolean isFull() {
        return ((end - head) + 1) >= q.length;
    }

    public boolean isEempty() {
        return head > end;
    }

    public String toString() {
        return Arrays.toString(q);
    }

}