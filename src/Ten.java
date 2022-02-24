import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * look to future ica for optimization this time
 */

public class Ten {

    public static void heap_sort(Vector<Integer> input) {
        build_max_heap(input);
        for (int i = input.size() - 1; i >= 1; i--) {
            // exchange here
            Integer temp = input.elementAt(0);
            input.set(0, input.elementAt(i));
            input.set(i, temp);
            heap_size = heap_size - 1;
            max_heapify(input, 0);
        }
    }

    public static void build_max_heap(Vector<Integer> input) {
        heap_size = input.size() - 1;
        for (int i = (input.size() - 1) / 2; i >= 0; i--) {
            max_heapify(input, i);
        }
    }

    public static void max_heapify(Vector<Integer> input, Integer i) {
        Integer l = left(i);
        Integer r = right(i);
        Integer largest = 0;
        if (l <= heap_size && input.elementAt(l) > input.elementAt(i)) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heap_size && input.elementAt(r) > input.elementAt(largest)) {
            largest = r;
        }
        if (largest != i) {
            // exchange here
            Integer temp = input.elementAt(i);
            input.set(i, input.elementAt(largest));
            input.set(largest, temp);
            max_heapify(input, largest);
        }
    }

    /**
     * this method is not used anywhere in the program according to psuedocode
     * maybe it is useful in optimizing the code?
     */
    public static Integer parent(Integer i) {
        return i / 2; // use floor round if not returning proper value
    }

    public static Integer left(Integer i) {
        return i * 2;
    }

    public static Integer right(Integer i) {
        return (2 * i) + 1;
    }

    /**
     * optimization begins here
     */
//    public static void countingSort(Vector<Integer> input, Vector<Integer> beeput, int k) {
//        // let c[0 - k] be a new array
//        Vector<Integer> c = new Vector<>();
//        for (int i = 0; i < k; i++) {
//            c.addElement(i);
//            c.set(i, 0);
//            beeput.addElement(i);
//            beeput.set(i,0);
//        }
//        for (int j = 0; j < input.size(); j++) {
////            c.set(j, input.elementAt(j) + 1);
////            c.set(j , )
//            // c[i] now contains the number of elements equal to i
//        }
//        for (int i = 1; i < k; i++) {
//            c.set(i, c.elementAt(i) + c.elementAt(i - 1));
//            //c[i] now contains the number of elements less than or equal to i
//        }
//        for (int j = input.size() - 1; j >= 0; j--) {
////            beeput.set(c.elementAt(input.elementAt(j)), input.elementAt(j));
//            beeput.set(j, input.elementAt(j));
////            c.set(j, c.elementAt(input.elementAt(j)) - 1);
//            c.set(j, input.elementAt(j)  - 1);
//        }
//    }

    // this opt would be O(n) time improvement
//    public static void bucketSort(Vector<Integer> input) {
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
//    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Vector<Integer> sortMe = new Vector<>();
        Integer vSize = 8;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(99) + 1);
        }

        System.out.println("ICA " + 10);
        System.out.println(myData);
        heap_sort(myData);
        System.out.println("heapsort\n" + myData);
//        countingSort(myData, sortMe, myData.size());
//        System.out.println("countSort\n" + sortMe);
    }

    static Integer heap_size;
}
