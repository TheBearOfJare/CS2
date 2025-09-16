

public class Bag<E> {
    private E[] bagOfStuff;
    private int lastUsedIndex;

    public Bag() {
        this(20);
    }

    public Bag(int initialCapacity) {
        this.bagOfStuff = (E[])new Object[initialCapacity];
        this.lastUsedIndex = -1;
    }

    public void add(E data) {
        ensureCapacity(1);
        bagOfStuff[++lastUsedIndex] = data;
    }

    public E set(int index, E data) {
        E oldData = bagOfStuff[index];
        bagOfStuff[index] = data;
        return oldData;
    }

    private void validateIndex(int index) throws InvalidIndexException {
        if(index < 0 || index > lastUsedIndex) {
            throw new InvalidIndexException(index + " is invalid. Must be >= 0 and <= " + lastUsedIndex);
        }
    }

    public E remove(int index) throws InvalidIndexException {
        validateIndex(index);
        E oldData = bagOfStuff[index];
        bagOfStuff[index] = bagOfStuff[lastUsedIndex--];
        return oldData;
    }

    public Object get(int index) throws InvalidIndexException {
        validateIndex(index);
        return bagOfStuff[index];
    }

    public void printAll() {
        System.out.println("The entire contents of the bag are as follows:");
        for (int i = 0; i < lastUsedIndex+1; i++) {
            System.out.println(bagOfStuff[i]);
        }
    }

    public int getSize() {
        return lastUsedIndex + 1;
    }

    public boolean isEmpty() {
        return lastUsedIndex < 0;
    }

    public void shake() throws InvalidIndexException {

        for (int count = 0; count < lastUsedIndex + 1; count ++) {

            int randomStart = (int) (Math.random() * (lastUsedIndex + 1));
            int randomEnd = (int) (Math.random() * (lastUsedIndex + 1));

            E swapped = set(randomEnd, bagOfStuff[randomStart]);
            set(randomStart, swapped);

        }

    }

    public void clear() {
        lastUsedIndex = -1;
    }

    public void ensureCapacity(int neededCapacity) {
        int currentCapacity = (bagOfStuff.length - (lastUsedIndex + 1));
        if(currentCapacity < neededCapacity) {
            Object[] temp = new Object[(int)((bagOfStuff.length + neededCapacity) * 1.05)];
            System.arraycopy(bagOfStuff, 0, temp, 0, lastUsedIndex + 1);
            bagOfStuff = (E[])temp;
        }
    }
}
