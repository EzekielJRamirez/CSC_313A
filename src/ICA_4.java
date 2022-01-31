import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

/**
 * space = linear O( )
 * time =
 * <p>
 * seven levels of complexity on BB
 * <p>
 * optimize hint
 * pass by reference or pass by value
 * <p>
 * arrays are not copied
 * other data types are copied
 * <p>
 * we are welcome to perform a constant improvement
 */

public class ICA_4 {
    public static void main(String[] args) {
        int[] randy = new int[10];
        randy[0] = 2;
        randy[1] = 10;
        randy[2] = 6;
        randy[3] = 28;
        randy[4] = 10;
        randy[5] = 22;
        randy[6] = 14;
        randy[7] = 26;
        randy[8] = 18;
        randy[9] = 20;
//        randomizedSelect(randy, 0, 8, 3);
        System.out.println(randomizedSelect(randy, 0, 6, 1));
        System.out.println(Arrays.toString(randy));
    }

    public static int randomizedSelect(int[] rad, int p, int r, int i) {
        if (p == r) {
            return rad[p];
        }

        int q = randomizedPartition(rad, p, r);
        int k = q - p + 1;

        if (i == k) {
            return rad[q];
        } else if (i < k) {
            return randomizedSelect(rad, p, q - 1, i);
        } else {
            return randomizedSelect(rad, q + 1, r, i - k);
        }
    }

    private static int randomizedPartition(int[] rad, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r) + p;
        //TODO fix the random number generator

        //exchanged the values
        int temp = rad[r];
        rad[r] = rad[i];
        rad[i] = temp;

        return Partition(rad, p, r);
    }

    private static int Partition(int[] rad, int p, int r) {
        int x = rad[r];
        int i = p - 1;

        for (int j = p; j < r - 1; j++) {
            if (rad[j] <= x) {
                i = i + 1;
                int temp = rad[i];
                rad[i] = rad[j];
                rad[j] = temp;
            }
        }

        int temp = rad[i + 1];
        rad[i + 1] = rad[r];
        rad[r] = temp;

        return i + 1;
    }
}
