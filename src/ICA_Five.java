//import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * space
 * time
 */

public class ICA_Five {

    public static int[] findMaximumSubarray(int[] A, int low, int high) {
        // next lines are dummy values
        boolean thiis = true;
        boolean thaat = true;

        int[] reArray = new int[3];
        if (high == low) {
            reArray[0] = low;
            reArray[1] = high;
            reArray[2] = A[low];
            return reArray;
        } else {
            int mid = (low + high) / 2; // how do I implement the rounding?

            reArray = findMaximumSubarray(A, low, mid); // These values will change --> left : low,high,sum
            reArray = findMaximumSubarray(A, mid + 1, high); // These values will change --> right: low,high,sum
            // need to adjust next line
            reArray = findMaxCrossingSubarray(A, low, mid, high); // These values will change --> cross: low,high,sum

            if (thiis && thaat) {     //left sum >= right sum AND left sum >= cross sum
                return reArray;
            } else if (thiis && thaat) {  //right sum >= left sum AND right sum >= cross sum
                return reArray;
            } else {
                return reArray;
            }
        }
    }

    public static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        // psuedocode says leftSum should equal neg infinity
        int leftSum = -100;
        int sum = 0;

        for (int i = mid; i > low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) {
                leftSum = sum;
                int maxLeft = i;
            }
        }

        // psuedocode says rightSum should equal negative infinity
        int rightSum = -100;
        sum = 0;

        for (int j = mid + 1; j < high; j++) {
            sum = sum + A[j];
            if (sum > rightSum) {
                rightSum = sum;
                int maxRight = j;
            }
        }
        // return (maxleft, maxRight, leftSum+rightSum)
        return A;
    }

    public static void main(String[] args) {
//        System.out.println("hi");
        int[] v = new int[10];
        v[0] = 2;
        v[1] = 10;
        v[2] = 6;
        v[3] = 28;
        v[4] = 10;
        v[5] = 22;
        v[6] = 14;
        v[7] = 26;
        v[8] = 18;
        v[9] = 20;

        System.out.println(Arrays.toString(v));
        findMaximumSubarray(v, 2, 2);
//        System.out.println(findMaximumSubarray(v,2,2));
        System.out.println(Arrays.toString(v));
    }
}
