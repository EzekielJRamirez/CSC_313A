import java.util.Arrays;
import java.util.Random;

public class ICA_Seven {

    public static void main(String[] args) {
        Random r = new Random();
        int[] numbers = new int[20];
        for ( int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = r.nextInt(29) + 1;
        }

        int[] ex2 = numbers;
        int[] ex3 = numbers;

        System.out.println(Arrays.toString(numbers));
        recSort(numbers, 0, numbers.length);
        numbers = bubbleSort(numbers);
        ex3 = RecursiveBubbleSort(ex3, 0, ex3.length - 1);
        System.out.println(Arrays.toString(ex3));
//        ex2 = recSort(ex2, 0, ex2.length - 1);
//        System.out.println(Arrays.toString(ex2));
    }

    public static int[] bubbleSort(int[] sortMe) {
        for (int i = 0; i < sortMe.length; i++) {
            // start begining of array
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

    //optimized solution
    public static int[] RecursiveBubbleSort(int[] sortMe, int start, int size) {
        if (sortMe[size] < sortMe[size - 1]) {
            int temp = sortMe[size];
            sortMe[size] = sortMe[size - 1];
            sortMe[size - 1] = temp;
        }
        if (start < sortMe.length) {
            RecursiveBubbleSort(sortMe, start + 1, size);
        } else if (size > start) {
            RecursiveBubbleSort(sortMe, start, size - 1);
        }

        return sortMe;
    }

    // here is the intermediate step to removing both for loops
    public static int[] recSort(int[] sortMe, int start, int size) {
        for (int j = sortMe.length - 1; j > 1; j--) {
            if (sortMe[j] < sortMe[j - 1]) {
                int temp = sortMe[j];
                sortMe[j] = sortMe[j - 1];
                sortMe[j - 1] = temp;
            }
        }
        if (start < sortMe.length) {
            recSort(sortMe, start + 1, size);
        }

        return sortMe;
    }
}
