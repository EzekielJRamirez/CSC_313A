import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ICA_Three {

    public static void increment (int[] binary) {
        int i = 0;
        while (i < binary.length && binary[i] == 1) {
//            System.out.println(binary[i]); // used for debug purpose
            binary[i] = 0;
            i = i + 1;
        }
        if (i < binary.length) {
            binary[i] = 1;
        }
    }

    public static void incrementRight (int[] binary) {
        int i = binary.length - 1;
        while (i > 0 && binary[i] == 1) {
//            System.out.println(binary[i]); // used for debug purpose
            binary[i] = 0;
            i = i - 1;
        }
        if (i < binary.length) {
            binary[i] = 1;
        }
    }

    public static void incAllRight (int digits) {
        int[] binary = new int[digits];
        int base = 2;
        int j = 0;

        for (int k = 0; k < digits - 1; k++) {
            // 2^8 == 256, represents binary value for 8 digits
            base = base * 2;
        }

        while (j < base - 1) {
            int i = binary.length - 1;
            while (i > 0 && binary[i] == 1) {
                binary[i] = 0;
                i = i - 1;
            }
            if (i < binary.length) {
                binary[i] = 1;
            }
            j = j + 1;
            System.out.println(Arrays.toString(binary) + "\n1 Mississippi\n2 Mississippi");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] booler = new int[8];
        booler[0] = 0;
        booler[1] = 0;
        booler[2] = 0;
        booler[3] = 0;
        booler[4] = 0;
        booler[5] = 0;
        booler[6] = 0;
        booler[7] = 0;
        for (int i = 0; i < 16; i++) {
            incrementRight(booler);
            // increment binary values from right to left
            System.out.println(Arrays.toString(booler));
        }
//        incAllRight(8);
        //increment from 0 to user generated max amount of binary values
//        increment(booler);
//        System.out.println(Arrays.toString(booler));
    }
}
