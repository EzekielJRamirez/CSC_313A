import java.util.Arrays;

public class ICA_Seven {

    public static void main(String[] args) {
        int[] numbers = new int[12];
        numbers[0] = 9;
        numbers[1] = 5;
        numbers[2] = 7;
        numbers[3] = 10;
        numbers[4] = 3;
        numbers[5] = 15;
        numbers[6] = 1;
        numbers[7] = 20;
        numbers[8] = 11;
        numbers[9] = 25;
        numbers[10] = 13;
        numbers[11] = 30;
        System.out.println(Arrays.toString(numbers));
        RecursiveBubbleSort(numbers, 0, numbers.length);
        numbers = bubbleSort(numbers);
//        System.out.println(Arrays.toString(numbers));
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
    public static void RecursiveBubbleSort(int[] sortMe, int start, int size) {
        // Marcus Mclatchy gave me some insight here
//        System.out.println(Arrays.toString(sortMe));
//        System.out.println(start);
//        System.out.println(size);

        if (sortMe[size - 1]  < sortMe[size - 2]) {
            int temp = sortMe[size - 1];
            sortMe[size - 1] = sortMe[size - 2];
            sortMe[size - 2] = temp;
        }

        // start and size replace the for loops from original bubble sort
        if (start > size) {
            RecursiveBubbleSort(sortMe, start + 1, sortMe.length);
        } else {
            RecursiveBubbleSort(sortMe, start, size - 1);
        }

    }
}
