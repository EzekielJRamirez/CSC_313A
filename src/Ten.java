import java.util.Random;
import java.util.Vector;

public class Ten {

    public static void heap_sort(Vector<Integer> input) {
        build_max_heap(input);
        for (int i = input.size() - 1; i >= 1; i--) {
            // exchange here
            Integer temp = input.elementAt(0);
            input.set(0, input.elementAt(i));
            input.set(i, temp);
            heap_size = heap_size - 1;
            max_heapify(input, 1);
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
     * this method is not used anywhere else in the program
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

    public static void main(String[] args) {
        Vector<Integer> myData = new Vector<>();
        Integer vSize = 6;
        Random r = new Random();
        for (int i = 0; i < vSize; i++) {
            myData.addElement(r.nextInt(24) + 1);
        }

//        heap_size = myData.size() - 1;
        System.out.println(myData);
        heap_sort(myData);
        System.out.println(myData);
    }

    static Integer heap_size;
}
