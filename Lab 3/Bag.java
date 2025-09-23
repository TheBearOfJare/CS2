
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
        if (lastUsedIndex+1 > 0) {
            
            System.out.println("The entire contents of the bag are as follows:");
            for (int i = 0; i < lastUsedIndex+1; i++) {
                System.out.println(bagOfStuff[i]);
            }
        }
        else {
            System.out.println("The bag is empty");
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

    public void shuffle() throws InvalidIndexException {

        // shake the bag 3 times for highly randomnized output
        for (int count = 0; count < 3; count++) {
            shake();
        }

    }

    public int numOccurrences(E value) {
        int instances = 0;
        for (E bagOfStuffEnumerator : bagOfStuff) {
            if (bagOfStuffEnumerator.equals(value)) {
                instances++;
            }
        }

        return instances;
    }

    public boolean contains(Bag<E> bag, E value) {
        
        for(int i = 0; i <= bag.lastUsedIndex; i++) {
            // System.out.println(bag.bagOfStuff[i]);
            if(bag.bagOfStuff[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void retainAll(Bag<E> rule) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (!contains(rule, bagOfStuff[i])) {
                bagOfStuff[i] = bagOfStuff[lastUsedIndex--];
                i--;
            }
            
        }
    }

    public void removeAll(Bag<E> rule) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (contains(rule, bagOfStuff[i])) {
                bagOfStuff[i] = bagOfStuff[lastUsedIndex--];
                i--;
            }
            
        }
    }

    public boolean equals(Bag<E> bag, Bag<E> comparisonBag) {

        for (int i = 0; i <= comparisonBag.lastUsedIndex; i++) {

            if (!contains(bag, comparisonBag.bagOfStuff[i])) {
                return false;
            }
            
        }

        for (int i = 0; i <= bag.lastUsedIndex; i++) {

            if (!contains(comparisonBag, bag.bagOfStuff[i])) {
                return false;
            }
            
        }

        return true;

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
