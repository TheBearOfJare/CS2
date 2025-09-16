import java.util.*;

public class Driver {
    public final static void main(String[] args) throws InvalidIndexException {
        Bag<Integer> boBag = new Bag<>(15);
        Random random = new Random();

        for(int i = 0; i < 15000; i++) {
            int value = random.nextInt(1000);
            // System.out.println("Adding " + value);
            boBag.add(value);
        }

        boBag.printAll();
        boBag.shake();
        System.out.println("Post shake:");
        boBag.printAll();

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

    }    
}
