import java.util.*;
public class Driver {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        long startTime = 0;
        long endTime = 0;
        int length = 1000000;

        startTime = System.nanoTime();

        for (int i  = 0; i < length; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();

        System.out.println("Took " + ((endTime - startTime) / 1E6) + " msec.");

        // list.print();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(length*2);
            System.out.println("Contains: " + value + " is " + list.contains(value));
        }
    }
}
