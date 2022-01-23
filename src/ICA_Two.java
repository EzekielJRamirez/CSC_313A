import java.util.Arrays;

public class ICA_Two {

    public static int binSearch(int[] A, int lengthN, int T) {
        // binSearch(A, n, T)
        //        1 L = 0
//        2 R = n − 1
//        3 while L ≤ R
//        4 m = (L + R)/2
//        5 if A[m] < T
//        6 L = m + 1
//        7 elseif A[m] > T
//        8 R = m − 1
//        9 else
//        10 return m
//        11 return −1 // invalid, not found
        int left = 0;
        int right = lengthN - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] < T) {
                left = mid + 1;
            } else if (A[mid] > T) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binSearchAlt(int[] A, int lengthN, int T) {
        // binSearch(A, n, T)
        //        1 L = 0
//        2 R = n − 1
//        3 while L ≤ R
//        4 m = (L + R)/2
//        5 if A[m] < T
//        6 L = m + 1
//        7 elseif A[m] > T
//        8 R = m − 1
//        9 else
//        10 return m
//        11 return −1 // invalid, not found
        int left = 0;
        int right = lengthN - 1;
        while (left <= right) {
            int midLeft = (2*left + right) / 3;
            // 2*left represents closer proximity of first value, the left side value
            int midRight = (left + 2*right) /3;
            // 2*right represents closer proximity of last value, the right side value
            if (A[midLeft] > T) {
                right = midLeft - 1;
            } else if (A[midLeft] < T) {
                left = midLeft + 1;
            } else if (A[midRight] < T){
                left = midRight + 1;
            } else {
                return midLeft;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] jeff = new int[5];
        jeff[0] = 1;
        jeff[1] = 2;
        jeff[2] = 3;
        jeff[3] = 4;
        jeff[4] = 5;
        int n = jeff.length;
        // be open to change the int array to other struct
        int findValue = 2;
        // tea finds the index where the value is equal to 4

        /* TEST CASE 1A */
//        System.out.println(binSearch(jeff, n, findValue));

        int[] prime = new int[21];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = i + 1;
        }
        System.out.println(Arrays.toString(prime));   // used to debug

        /* TEST CASE 2A */
        System.out.println(binSearchAlt(prime, prime.length, 17));
    }
}
