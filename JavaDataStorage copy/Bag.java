public class Bag<E> {

    private E[] bag;
    private int lastUsedIndex;
    private double overshoot = 1.05;

    public Bag() {
        this(20);
        this.overshoot = overshoot;
    }

    public Bag(int initialCapacity) {
        this.bag = (E[]) new Object[initialCapacity];
        this.lastUsedIndex = -1;
    }

    public void post(E data) {
        ensureCapacity(overshoot);
        bag[++lastUsedIndex] = data;
    }

    public E put(E data, int index) {
        E oldStuff = bag[index];
        bag[index] = data;
        return oldStuff;
    }

    public E get(int index) throws InvalidIndex {
        validateIndex(index);
        return bag[index];
    }

    public E delete(int index) throws InvalidIndex {
        validateIndex(index);
        E oldStuff = bag[index];
        bag[index] = bag[lastUsedIndex--];
        return oldStuff;
    }

    public void clear() {
        lastUsedIndex = -1;
    }

    // helper functions

    public int getSize() {
        return lastUsedIndex + 1;
    }

    public int getCapacity() {
        return bag.length;
    }

    public boolean isEmpty() {
        return lastUsedIndex < 0;
    }

    public void validateIndex(int index) throws InvalidIndex {
        if (index < 0 || index > lastUsedIndex) {
            throw new InvalidIndex(index + " is out of bounds.");
        }
    }

    public void ensureCapacity(double overshoot) {
        int neededLength = (int)((lastUsedIndex + 2) * overshoot);
        
        if (bag.length <= neededLength) {
//             System.out.println("Needed length: " + neededLength);
            Object [] temp = new Object[neededLength];
            System.arraycopy(bag, 0, temp, 0, lastUsedIndex+1);
            bag = (E[])temp;
        }
    }
    
}
