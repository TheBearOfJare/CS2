public class Bag {

    private int[] bag;
    private int lastUsedIndex;
    private double overshoot = 1.05;

    public Bag() {
        this(20);
        this.overshoot = overshoot;
    }

    public Bag(int initialCapacity) {
        this.bag = new int[initialCapacity];
        this.lastUsedIndex = -1;
    }

    public void post(int data) {
        ensureCapacity(overshoot);
        bag[++lastUsedIndex] = data;
    }

    public int put(int data, int index) {
        int oldStuff = bag[index];
        bag[index] = data;
        return oldStuff;
    }

    public int get(int index) throws InvalidIndex {
        validateIndex(index);
        return bag[index];
    }

    public int delete(int index) throws InvalidIndex {
        validateIndex(index);
        int oldStuff = bag[index];
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
            int[] temp = new int[neededLength];
            System.arraycopy(bag, 0, temp, 0, lastUsedIndex+1);
            bag = temp;
        }
    }
    
}
