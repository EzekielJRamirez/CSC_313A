import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

public class ICA_Nine {

    public static void mergeSort(Vector<Integer> a, Integer p, Integer r) {
        if (p < r) {
            Integer q = (p + r) / 2;
            // do I need to cast to int if Integer naturally
            // truncates the value for floor round?
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
        for (int i = 1; i <= nOne; i++) {
            // init L
            left.addElement(a.elementAt(p + i - 1));
        }
        for (int j = 1; j <= nTwo; j++) {
            // init R
            right.addElement(a.elementAt(q + j));
        }
        // to infinity? lines 8 and 9 of psuedocode
        left.addElement(Integer.MAX_VALUE);
        right.addElement(Integer.MAX_VALUE);

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (left.elementAt(i) <= right.elementAt(j)) {
                a.set(k, left.elementAt(i));
                i = i + 1;
            } else {
                a.set(k, right.elementAt(j));
                j = j + 1;
            }
        }
    }

    /*
        optimization here
     */


    public static void getPow(LinkedList<Integer> lt) {
        int loop = 0;
        if (lt.size() % 2 == 1) {
            loop = 2;
            while (loop < lt.size()) {
                // multiply by 2 til we have 2^n
                loop = loop * 2;
            }
        }
        // this for loop would not work!!!
        // this loop didn't work becuase I added to my list and that made increase which
        // caused the for-loop reach the end condition earlier than expected
//        for (int i = 0; i <= (loop - lt.size()); i++) {
//            lt.add(null);
//        }
        while (lt.size() < loop) {
            lt.add(null);
        }
    }

    public static void mergeLListSort(LinkedList<Integer> lt, Integer p, Integer r) {
        if (p < r) {
            Integer q = (p + r) / 2;
            mergeLListSort(lt, p, q);
            mergeLListSort(lt, q + 1, r);
            mergeLList(lt, p, q, r);
        }
    }

    public static void mergeLList(LinkedList<Integer> lt, Integer p, Integer q, Integer r) {
        Integer i = p;
        Integer j = i + 1;

        for (int k = p; k <= r; k++) {
            if(lt.get(i) <= lt.get(j)) {
                i++;
            } else if (lt.get(i) > lt.get(j)) {
                Integer temp = lt.get(j);
                lt.remove(j);
                lt.add(k, temp);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vInt = new Vector<Integer>();
        Random r = new Random();
        int size = r.nextInt(10) + 10;

        for (int i = 0; i < size; i++) {
            // the r.nextInt says generate a random number from 1 to vInt.size * 1.5
            vInt.addElement(r.nextInt((int)(size * 1.5)) + 1);
        }
        System.out.println(vInt);
        mergeSort(vInt, 0, vInt.size() - 1);
        System.out.println(vInt);

        //linkedList opt here
        LinkedList<Integer> lt = new LinkedList<>();
        lt.add(38);
        lt.add(27);
        lt.add(43);
        lt.add(3);
        lt.add(9);
        lt.add(82);
        lt.add(10);
//        lt.add(null);
//        for (int i = 0; i < size; i++) {
//            // the r.nextInt says generate a random number from 1 to vInt.size * 1.5
//            lt.add(r.nextInt(40));
//        }
        System.out.println("\n" + lt);
//        mergeLListSort(lt, 0, lt.size() - 1);
        System.out.println(lt.size());
        getPow(lt);
        System.out.println(lt);
        System.out.println(lt.size());
    }
}
