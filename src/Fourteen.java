import java.util.Random;
import java.util.Vector;

/**
 * read page 200-204
 */

//TODO make a string function for bucket sort
// Sanders said making the string all uppercase was fine

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
        // next for loop is for debug purpose
        for(int i = 0; i < buck.size(); i++) {
            for(int j = 0; j < buck.elementAt(i).size(); j++) {
                System.out.print(buck.elementAt(i).elementAt(j) + ", ");
                // Sanders said this is fine
            }
        }
        // if I really want to return the final sorted array I
        // could just make another auxillary array and return that
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

    /**
     * make string version here
     */
    public static void bucketStrings(String input) {
        Vector<Vector<Integer>> buck = new Vector<>();
        // input size should be 9 for int and 25 for alphabet
        Integer n = 25;
//        System.out.println("input size: " + input.size());

        for (int i = 0; i < n; i++) {
            //make B[i] an empty list or an empty vector
            buck.addElement(new Vector<Integer>());
        }
    }

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Integer vSize = 20;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(99) + 1);
        }

        /* test case */
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

//        System.out.println("ICA 14\n" + myData);
//        bucketSort(myData);

        /* String Vector here */
        Vector<Integer> strData = new Vector<>();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(str);
        System.out.println(str.length());
        // append to str using .concat()
        // ascii values a-z     97-122
        // ascii values A-Z     65-90

        for (int i = 0; i < 35; i++) {
            strData.addElement(r.nextInt(26) + 65);
        }

        str = "";
        for(int i = 0; i < strData.size(); i++){
            str = str.concat(Character.toString((char) (int)strData.elementAt(i)));
        }
        System.out.println(str + "\nlength: " + str.length());
    }
}
