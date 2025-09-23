
import java.util.*;

public class Driver {

    public static final void main(String[] args) {
        LinkedList<Integer> listy = new LinkedList<>();
        int numElements = 20;
        Random random = new Random();
        for (int i = 0; i < numElements; i++) {
            int num = random.nextInt(100);
            System.out.println("Adding " + num);
            listy.add(num);
        }
        listy.print();
    }
}
