import java.util.Random;
import java.util.Vector;

public class ICA_Eight {
    /**
     * time O(n^2)
     * space O(n)
     * <p>
     * check optimization on page 179 - 184 or 151 - 160
     */

    public static void insertSort(Vector<Integer> sortData) {
        for (Integer j = 1; j < sortData.size(); j++) {
            Integer key = sortData.elementAt(j);
            // insert sortData[j] into A[1, ..., j - 1]
            Integer i = j - 1;
            while (i >= 0 && sortData.elementAt(i) > key) {
                sortData.set(i + 1, sortData.elementAt(i));
                i = i - 1;
            }
            sortData.set(i + 1, key);
        }
    }

    /**
     * time: less than polynomial - O(n * log(n))
     */
    public static void recInsertSort(Vector<Integer> sortData, Integer jay) {
        Integer key = sortData.elementAt(jay);
        Integer i = jay - 1;
        while (i >= 0 && sortData.elementAt(i) > key) {
            sortData.set(i + 1, sortData.elementAt(i));
            i = i - 1;
        }
        sortData.set(i + 1, key);

        // the jay should not be checking for data after the end of the vector
        // so jay must be < size - 1
        if (jay < sortData.size() - 1) {
            jay = jay + 1;
            recInsertSort(sortData, jay);
        }
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<Integer>();
        Random r = new Random();
        int size = r.nextInt(5) + 10;

        for (int i = 0; i < size; i++) {
            myData.addElement(r.nextInt(35));
        }

        System.out.println(myData);
//        insertSort(myData);
        recInsertSort(myData, 1);
        System.out.println(myData);
    }
}