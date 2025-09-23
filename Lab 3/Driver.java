import java.util.*;

public class Driver {
    public final static void main(String[] args) throws InvalidIndexException {
        Bag<Integer> boBag = new Bag<>(15);
        Random random = new Random();

        for(int i = 0; i < 15; i++) {
            int value = random.nextInt(100);
            // System.out.println("Adding " + value);
            boBag.add(value);
        }

        boBag.printAll();
        boBag.shake();
        System.out.println("Post shake:");
        boBag.printAll();

        Bag<Integer> noBag = new Bag<>(15);
        for(int i = 0; i < 15; i++) {
            int value = random.nextInt(100);
            // System.out.println("Adding " + value);
            noBag.add(value);
        }

        System.out.println("noBag equals boBag? " + boBag.equals(boBag, noBag));

        System.out.println("noBag: ");
        noBag.printAll();
        System.out.println("Length: " + noBag.getSize());

        noBag.retainAll(boBag);

        System.out.println("Post retain: ");
        noBag.printAll();
        System.out.println("Length: " + noBag.getSize());

        System.out.println("noBag equals boBag? " + boBag.equals(boBag, noBag));

        noBag.shuffle();

        noBag.removeAll(boBag);
        System.out.println("Post removeAll: ");
        noBag.printAll();
        System.out.println("Length: " + noBag.getSize());


        while(!boBag.isEmpty()) {
        // while(boBag.getSize() > 0) {
            try {
                int data = boBag.remove(0);
                System.out.println("Removed: " + data);
            } catch(InvalidIndexException ie) {
                System.err.println(ie.getLocalizedMessage());
                break;
            }
        }

        boBag.printAll();

        System.out.println("Adding identical data to test equals");

        boBag.add(0);
        noBag.add(0);

        boBag.printAll();
        noBag.printAll();

        System.out.println("boBag contains 0: " + boBag.contains(boBag, 0));
        System.out.println("noBag contains 0: " + noBag.contains(noBag, 0));

        System.out.println("boBag = noBag: " + boBag.equals(boBag, noBag));

        noBag.add(0);
        System.out.println("Add another 0 to test that it allows more than one matching value");
        System.out.println("boBag = noBag: " + boBag.equals(boBag, noBag));

        System.out.println("Number of 0s in noBag: ");
        System.out.println(noBag.numOccurrences(0));

    }    
}
