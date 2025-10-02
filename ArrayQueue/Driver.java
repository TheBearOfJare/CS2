import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        Random random = new Random();

        while(!queue.isFull()) {
            queue.add(random.nextInt());
        }

        System.out.println(queue.toString());

        while(!queue.isEempty()) {
            try {
                queue.remove();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
            
        }
        
    }
}
