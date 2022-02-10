import java.util.Vector;

public class ICA_Nine {

    public static void mergeSort(Vector<Integer> a, Integer p, Integer r) {
        if (p < r) {
            Integer q = (p + r) / 2;
            // do I need to cast to int if Integer naturally
            // truncates the value for floor round
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void merge(Vector<Integer> a, Integer p, Integer q, Integer r) {
        Integer nOne = q - p + 1;
        Integer nTwo = r - q;
        // let L[1...nOne + 1] and R[1...nTwo + 1] be new arrays
        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        for (int i = 1; i < nOne; i++) {
            // init L
            left.addElement(a.elementAt(p + i -1));
        }
        for (int j = 1; j < nTwo; j++) {
            // init R
            right.addElement(a.elementAt(q + j));
        }
        // to infinity?

        int i = 1;
        int j = 2;

        for (int k = p; k < r; k++) {
            if (left.elementAt(i) <= right.elementAt(i)) {
                a.set(k, left.elementAt(i));
                i = i + 1;
            } else {
                a.set(k, right.elementAt(j));
                j = j + 1;
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vInt = new Vector<Integer>();
        vInt.addElement(20);
        vInt.addElement(22);
    }
}
