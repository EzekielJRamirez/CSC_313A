import java.util.Random;
import java.util.Vector;

/**
 * read page 200-204
 */

public class Fourteen {

    public static void bucketSort(Vector<Integer> input) {
        Vector<Vector<Integer>> buck = new Vector<>();
        // input size should be 9 for int and 25 for alphabet
        Integer n = 10;
//        System.out.println("input size: " + input.size());

        for (int i = 0; i < n; i++) {
            //make B[i] an empty list or an empty vector
            buck.addElement(new Vector<Integer>());
        }
        for (int i = 0; i < input.size(); i++) {
            //insert A[i] into list B[n * A[i]] with floor round
            // dividing by 100 makes numbers any 2 digit number less than 1     78 --> .78
//            Integer temp = n * input.elementAt(i) / 100;
            buck.elementAt((n * input.elementAt(i) / 100)).addElement(input.elementAt(i));
//            System.out.println(buck);
        }
        for (int i = 0; i < n; i++) {
            insertSort(buck.elementAt(i));
        }
//        System.out.println(buck);
        // next for loop is for debug purpose
        for(int i = 0; i < buck.size(); i++) {
            System.out.println(buck.elementAt(i));
        }
//        System.out.println(buck.elementAt(1));
        //TODO concatenate the arrays in order
    }

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
        Integer vSize = 25;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(99) + 1);
        }

//        myData.addElement(8);
//        myData.addElement(78);
//        myData.addElement(17);
//        myData.addElement(39);
//        myData.addElement(26);
//        myData.addElement(72);
//        myData.addElement(94);
//        myData.addElement(21);
//        myData.addElement(12);
//        myData.addElement(23);
//        myData.addElement(68);

        System.out.println("ICA 14\n" + myData);
        bucketSort(myData);
    }
}
