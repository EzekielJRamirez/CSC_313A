// import libraries

import java.util.Vector;

public class ICA_Six {
    public static Vector<Vector<String>> b = new Vector<Vector<String>>();
    public static Vector<Vector<Integer>> c = new Vector<Vector<Integer>>();

    // time complexity is O(mn)
    // space complexity is O(mn)
    public static void lcs_len(String X, String Y) {
        int m = X.length();
        int n = Y.length();

//        b = new Vector<Vector<String>>();
//        c = new Vector<Vector<Integer>>();
        for (int i = 0; i < m; i++) {
            c.elementAt(i).set(0, 0);   //use this one
        }
        for (int j = 0; j < n; j++) {
//            c[0, j] = 0;
            c.elementAt(0).set(j, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X.charAt(i) == Y.charAt(j)) {
                    // check psuedocode
                    // symbols can be written as words
                    c.elementAt(i).set(j, c.elementAt(i - 1).elementAt(j - 1) + 1);
                    b.elementAt(i).set(j, "up and to left");
                    // my error comes from the folling else-if command
                } else if (c.elementAt(i - 1).elementAt(j) >= c.elementAt(i).elementAt(j - 1)) {
                    c.elementAt(i).set(j, c.elementAt(i - 1).elementAt(j));
                    b.elementAt(i).set(j, "up");
                } else {
                    c.elementAt(i).set(j, c.elementAt(i).elementAt(j - 1));
                    b.elementAt(i).set(j, "left");
                }
            }
        }
    }

    // time complexity is O(m) or O(n)
    // space complexity is O(mn)
    // input m and n for the first call to this function.
    public static void print_lcs(Vector<Vector<String>> b, String X, Integer i, Integer j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b.elementAt(i).elementAt(j) == "up and to left") {
            print_lcs(b, X, i - 1, j - 1);
        } else if (b.elementAt(i).elementAt(j) == "up") {
            print_lcs(b, X, i - 1, j);
        } else {
            print_lcs(b, X, i, j - 1);
        }
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        Integer numRows = X.length() + 1;
        Integer numCols = Y.length() + 1;

        b = new Vector<Vector<String>>();
        c = new Vector<Vector<Integer>>();

        // initialize b
        for (int i = 0; i < numRows; i++) {
            Vector<String> tempRow = new Vector<String>();
            for (int j = 0; j < numCols; j++) {
                tempRow.addElement(".");
            }
            b.addElement(tempRow);
        }

        System.out.println(b);

        // initialize c
        for (int i = 0; i < numRows; i++) {
            Vector<Integer> tempRow = new Vector<Integer>();
            for (int j = 0; j < numCols; j++) {
                tempRow.addElement(0);
            }
            c.addElement(tempRow);
        }

        System.out.println(c);

        // call the LCS function
        lcs_len(X, Y);

        // call the LCS-print function
        print_lcs(b, X, numRows - 1, numCols - 1);
    }

//    static Vector<Vector<String>> b;
//    static Vector<Vector<Integer>> c;
}
