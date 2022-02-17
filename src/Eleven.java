import java.util.Random;
import java.util.Vector;

/**
 * time:    O(n^2)
 * space:   O(n)
 */
public class Eleven {

    public static void quick_sort(Vector<Integer> input, Integer p, Integer r) {
        Integer q;
        if (p < r) {
            q = partition(input, p, r);
            quick_sort(input, p, q - 1);
            quick_sort(input, q + 1, r);
        }
    }

    public static Integer partition(Vector<Integer> input, Integer p, Integer r) {
        Integer x = input.elementAt(r);
        Integer i = p - 1;
        // i noticed j in the for condition was always lower than r - 1 so I
        // changed the inequality and used increment instead
        for (Integer j = p; j <= r - 1; j++) {
            if (input.elementAt(j) <= x) {
                i = i + 1;
                //exchange
                Integer temp = input.elementAt(i);
                input.set(i, input.elementAt(j));
                input.set(j, temp);
            }
        }
        Integer temp = input.elementAt(i + 1);
        input.set((i + 1), input.elementAt(r));
        input.set(r, temp);
        return i + 1;
    }

    /**
     * optimization begins here
     * new time: O(n * log(n))
     */
    public static void randQuickSort(Vector<Integer> input, Integer p, Integer r) {
        Integer q;
        if (p < r) {
            q = randPartition(input, p, r);
            randQuickSort(input, p, q - 1);
            randQuickSort(input, q + 1, r);
        }
    }

    public static Integer randPartition(Vector<Integer> input, Integer p, Integer r) {
        Random rand = new Random();
        // Random in the book refers a random value from input[p] to input[r]
        // basically the range of random values are input[p...r]
        Integer i = rand.nextInt(r - p) + p;
        //exchange
        Integer temp = input.elementAt(i);
        input.set(i, input.elementAt(r));
        input.set(r, temp);
        return partition(input, p, r);
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Integer vSize = 15;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(99) + 1);
        }
        System.out.println(myData);
//        quick_sort(myData, 0, myData.size() - 1);
        randQuickSort(myData, 0, myData.size() - 1);
        System.out.println(myData);
    }
}
