import java.util.Random;
import java.util.Vector;

/**
 * read page 194-196
 */

public class Fifteen {

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

        System.out.println("ICA 13\n" + myData);
        countingSort(myData,bData, temp + 1);
        System.out.println("Counting Sort\n" + bData);
    }
}
