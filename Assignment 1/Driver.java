import java.util.Arrays;

public class Driver {
    
    public static void main(String[] args) {

        KeyboardReader reader = new KeyboardReader();

        //Prompt the user for the size of two separate arrays (the user must be able to specify different sizes).  
        int[] a = new int[reader.readInt("Length of first array: ")];

        int[] b = new int[reader.readInt("Length of second array: ")];

        // Populate both arrays using integers entered by the user.
        for (int i = 0; i < a.length; i++) {
            a[i] = reader.readInt("Supply an integer for the first array (" + i + "/" + a.length + ")");
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = reader.readInt("Supply an integer for the second array (" + i + "/" + a.length + ")");
        }

        // Sort both arrays using the appropriate method from the java.util.Arrays class
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);

        // Create a third array that is large enough to hold all the elements from both previous arrays
        int[] c = new int[a.length + b.length];

        // Write for loops to manually copy the data from the two populated arrays into the third array.  Copy the data in such a way that the third array is populated with the numbers in ascending order - do not sort the third array after it is populated.
        int cdex = 0;
        int bdex = 0;
        for (int adx = 0; adx < a.length; adx++) {
            int adata = a[adx];

            for (int bdx = bdex; bdx < b.length; bdx++) {
                if (b[bdx] < adata) {
                    c[cdex++] = b[bdx];
                    bdex++;
                }
                
            }

            c[cdex++] = adata;
            
        }
        System.arraycopy(b, bdex, c, cdex, b.length - bdex);

        // Print all the arrays to check your work (you can use the toString method of the Arrays class to make this look nice).
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

    }

    

}
