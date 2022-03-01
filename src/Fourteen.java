import java.util.Random;
import java.util.Vector;

/**
 * read page 200-204
 */

public class Fourteen {

    public static void bucketSort(Vector<Integer> input) {
        Vector<Vector<Integer>> buck = new Vector<>(10);
        // input size should be 9 for int and 25 for alphabet
        Integer n = input.size();
        for (int i = 0; i < n - 1; i++) {
            //make B[i] an empty list or an empty vector
//            buck.addElement(bee.addElement(0));
//            bee.addElement(0);
            buck.addElement(new Vector<Integer>());
        }
//        buck.addElement(bee);
        for (int i = 1; i < n; i++) {
            //insert A[i] into list B[n * A[i]] with floor round
//            buck.elementAt(bee.elementAt(i)).set(i,input.elementAt(i));
            Vector<Integer> bee = buck.elementAt(i);
//            bee
        }
        System.out.println(buck);
    }

//    public static void insertionSort() {
//        // add code
//    }

    public static void insertSort(Vector<Integer> input) {
        for (Integer j = 1; j < input.size(); j++) {
            Integer key = input.elementAt(j);
            // insert sortData[j] into A[1, ..., j - 1]
            Integer i = j - 1;
            while (i >= 0 && input.elementAt(i) > key) {
                input.set(i + 1, input.elementAt(i));
                i = i - 1;
            }
            input.set(i + 1, key);
        }
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
//        Vector<Integer> bData = new Vector<>();
//        int temp = 0;
        Integer vSize = 5;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(100) + 1);
//            bData.addElement(myData.elementAt(i));
//            if (temp < myData.elementAt(i)) { // if temp is less than value of myData[i]
//                // record larger value
//                temp = myData.elementAt(i);
//            }
        }

        System.out.println("ICA 13\n" + myData);
        bucketSort(myData);
    }
}
