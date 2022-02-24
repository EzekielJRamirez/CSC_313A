import java.util.Random;
import java.util.Vector;

public class Thirteen {

    public static Integer partition(Vector<Integer> input, Integer p, Integer r) {
        Integer x = input.elementAt(r);
        Integer i = p - 1;
        // I noticed j in the for condition was always lower than r - 1 so I
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

    public static void tailRecSort(Vector<Integer> input, Integer p, Integer r) {
        Integer q;
        while (p < r) {
            // partition and sort left subarray
            q = partition(input, p, r);
            tailRecSort(input, p, q - 1);
            p = q + 1;
        }
    }

    //TODO begin optimization here

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Integer vSize = 15;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(100) + 1);
        }
        System.out.println("ICA 12\n" + myData);
//        randQuickSort(myData, 0, myData.size() - 1);
//        System.out.println("Random Quick sort\n" + myData);
        tailRecSort(myData, 0, myData.size() - 1);
        System.out.println("Tail Recursion sort\n" + myData);
    }
}
