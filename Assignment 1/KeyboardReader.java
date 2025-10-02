import java.io.*;

public class KeyboardReader {
    private static BufferedReader in;
    static {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String readLine(String prompt) {
        try {
            System.out.println(prompt);
            return in.readLine();
        } catch (IOException ioe) {
            System.err.println("Your keyboard seems to have broken.");
            return "";
        }
    }

    public static String readLine() {
        try {
            return in.readLine();
        } catch (IOException ioe) {
            System.err.println("Your keyboard seems to have broken.");
            return "";
        }
    }

    public static byte readByte(String prompt) {
        while (true) {
            try {
                return Byte.parseByte(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE);
            }
        }
    }
    
    public static byte readByte() {
        while (true) {
            try {
                return Byte.parseByte(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE);
            }
        }
    }

    public static short readShort(String prompt) {
        while (true) {
            try {
                return Short.parseShort(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Short.MIN_VALUE + " and " + Short.MAX_VALUE);
            }
        }
    }
    
    public static short readShort() {
        while (true) {
            try {
                return Short.parseShort(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Short.MIN_VALUE + " and " + Short.MAX_VALUE);
            }
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE);
            }
        }
    }
    
    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value.");
            }
        }
    }

    public static long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Long.MIN_VALUE + " and " + Long.MAX_VALUE);
            }
        }
    }
    
    public static long readLong() {
        while (true) {
            try {
                return Long.parseLong(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value between " + Long.MIN_VALUE + " and " + Long.MAX_VALUE);
            }
        }
    }

    public static float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only a real number value between " + Float.MIN_VALUE + " and " + Float.MAX_VALUE);
            }
        }
    }
    
    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only a real number value between " + Float.MIN_VALUE + " and " + Float.MAX_VALUE);
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only a real number value between " + Double.MIN_VALUE + " and " + Double.MAX_VALUE);
            }
        }
    }
    
    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only a real number value between " + Double.MIN_VALUE + " and " + Double.MAX_VALUE);
            }
        }
    }

    public static char readChar(String prompt) {
        while (true) {
            try {
                return readLine(prompt).charAt(0);
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("Please enter a single character value.");
            }
        }
    }
    
    public static char readChar() {
        while (true) {
            try {
                return readLine().charAt(0);
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("Please enter a single character value.");
            }
        }
    }

    public static boolean readBoolean(String prompt) {
        while (true) {
            String input = readLine(prompt);
            if(input.equalsIgnoreCase("true")) {
                return true;
            }
            if(input.equalsIgnoreCase("false")) {
                return false;
            }
            System.out.println("Please enter only true or false.");
        }
    }
    
    public static boolean readBoolean() {
        while (true) {
            String input = readLine();
            if(input.equalsIgnoreCase("true")) {
                return true;
            }
            if(input.equalsIgnoreCase("false")) {
                return false;
            }
            System.out.println("Please enter only true or false.");
        }
    }

    public static final void main(String[] args) {
        // For testing
    }
}