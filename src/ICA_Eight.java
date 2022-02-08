import java.util.Random;
import java.util.Vector;

public class ICA_Eight {
    /**
     * time O(n^2)
     * space O(n)
     */

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<Integer>();
        Random r = new Random();

        for (int i = 0; i < 12; i++) {
            myData.addElement(r.nextInt(30));
        }

        System.out.println(myData);
        insertSort(myData);
        System.out.println(myData);
    }

    public static void insertSort(Vector<Integer> sortData) {
        for (Integer j = 1; j < sortData.size(); j++) {
            Integer key = sortData.elementAt(j);
            // insert sortData[j] into A[1, ..., j - 1]
            Integer i = j - 1;
            while (i >= 0 && sortData.elementAt(i) > key) {
                sortData.set(i + 1, sortData.elementAt(i));
                i = i -1;
            }
            sortData.set(i + 1, key);
        }
    }
}