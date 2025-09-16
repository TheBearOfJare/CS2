import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag(15);
        Random random = new Random();

        for (int i = 0; i < 15000; i++) {
            int value = random.nextInt(1000);
//             System.out.println("Adding " + value);
            bag.post(value);
        }
        while (!bag.isEmpty()) {
            try {
//              System.out.println("Removed: " + bag.delete(0));
                bag.delete(0);
            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
            
        }

//         System.out.println("Bag size: " + bag.getSize() + "\nBag Capacity: " + bag.getCapacity());
    }
}
