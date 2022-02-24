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

    /**
     * TODO begin optimization here
     *  try bucket sort page 200 ICA 14
     *  or counting sort page 194-196 ICA 15
     *  Sanders recommends random partition
     */

    // this opt would be O(n) time improvement
    public static void countingSort(Vector<Integer> input, Vector<Integer> beeput, int k) {
        // let c[0...k] be a new array
        // k is equal to largest value in the array not the size of the array
        Vector<Integer> c = new Vector<>();
        for (int i = 0; i < k; i++) {
            c.addElement(0);
        }
        for (int j = 0; j < input.size(); j++) {
            // if c[j] and input[j] are same value then increment count of c[j]
            c.set(input.elementAt(j), c.elementAt(input.elementAt(j)) + 1);
        }
        for (int i = 1; i < k; i ++) {
            c.set(i, c.elementAt(i) + c.elementAt(i - 1));
        }
        for(int j = input.size() - 1; j >= 0; j--) {
            beeput.set(c.elementAt(input.elementAt(j)) - 1, input.elementAt(j));
            c.set(input.elementAt(j), c.elementAt(input.elementAt(j)) - 1);
        }
    }

    // this opt would be O(n) time improvement
    public static void bucketSort(Vector<Integer> input) {
//        //let b[0...n-1] be a new array
//        Vector<Integer> b = new Vector<>();
//        List a1 = new ArrayList();
//        int n = input.size() - 1;
//        for (int i = 0; i < n; i ++) {
//            // make b[i] an empty list
//            b.addElement(a1);
//
//        }
//        for (int i = 0; i < n; i++) {
//
//        }
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Vector<Integer> bData = new Vector<>();
        int temp = 0;
        Integer vSize = 15;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(100) + 1);
            bData.addElement(myData.elementAt(i));
            if (temp < myData.elementAt(i)) { // if temp is less than value of myData[i]
                // record larger value
                temp = myData.elementAt(i);
            }
        }

        System.out.println("ICA 12\n" + myData);
        countingSort(myData,bData, temp + 1);
        System.out.println("bData\n" + bData);
    }
}
