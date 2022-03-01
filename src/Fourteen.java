import java.util.Random;
import java.util.Vector;

/**
 * read page 200-204
 */

public class Fourteen {

    public static void bucketSort() {
        // add code
    }

    public static void insertionSort() {
        // add code
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
//        Vector<Integer> bData = new Vector<>();
//        int temp = 0;
        Integer vSize = 15;
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
    }
}
