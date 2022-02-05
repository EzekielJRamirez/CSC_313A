import java.util.Arrays;
import java.util.Random;

public class ICA_Seven {

    public static void main(String[] args) {
        Random r = new Random();
        int[] numbers = new int[15];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = r.nextInt(29) + 1;
        }
        System.out.println(Arrays.toString(numbers));
//        numbers = bubbleSort(numbers);
        // line 15 provides a space optimization of O[n * log(n)]
        numbers = recSort(numbers, 0);
//        numbers = recBubSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] bubbleSort(int[] sortMe) {
        for (int i = 0; i < sortMe.length; i++) {
            // start beginning of array
            for (int j = sortMe.length - 1; j > i; j--) {
                // iterate from end to start of array
                if (sortMe[j] < sortMe[j - 1]) {
                    // if sortMe[3] is less than sortMe[2]
                    // swap 3 and 2
                    int temp = sortMe[j];
                    sortMe[j] = sortMe[j - 1];
                    sortMe[j - 1] = temp;
                }
            }
        }
        return sortMe;
    }

    //optimized solution, both loops are now recursive
    public static int[] recBubSort(int[] sortMe, int start, int size) {
        if (sortMe[size] < sortMe[size - 1]) {
            int temp = sortMe[size];
            sortMe[size] = sortMe[size - 1];
            sortMe[size - 1] = temp;
        }
        // the size gets updated through recursion
        if (start < size && size > 1) {
            recBubSort(sortMe, start, size - 1);
        }
//        size = sortMe.length - 1;
        if (size > start) {
            recBubSort(sortMe, start + 1, size);
        }
        return sortMe;
    }

    // here is the intermediate step to remove the first loop
    public static int[] recSort(int[] sortMe, int start) {
        for (int j = sortMe.length - 1; j >= 1; j--) {
            if (sortMe[j] < sortMe[j - 1]) {
                int temp = sortMe[j];
                sortMe[j] = sortMe[j - 1];
                sortMe[j - 1] = temp;
            }
        }
        if (start < sortMe.length) {
            recSort(sortMe, start + 1);
        }
        return sortMe;
    }
}
