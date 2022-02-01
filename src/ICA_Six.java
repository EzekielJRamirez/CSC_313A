// import libraries
import java.util.Vector;

public class ICA_Six
{
    // time complexity is O(mn)
    // space complexity is O(mn)
    public static void lcs_len( String X, String Y )
    {
        // your code here
    }

    // time complexity is O(m) or O(n)
    // space complexity is O(mn)
    // input m and n for the first call to this function.
    public static void print_lcs( Vector< Vector< String > > b, String X, Integer i, Integer j )
    {
        // your code here
    }

    public static void main( String[] args )
    {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        Integer numRows = X.length()+1;
        Integer numCols = Y.length()+1;

        b = new Vector< Vector< String > >();
        c = new Vector< Vector< Integer > >();

        // initialize b
        for( int i = 0; i < numRows; i++ )
        {
            Vector< String > tempRow = new Vector< String >();
            for( int j = 0; j < numCols; j++ )
            {
                tempRow.addElement( "." );
            }
            b.addElement( tempRow );
        }

        System.out.println( b );

        // initialize c
        for( int i = 0; i < numRows; i++ )
        {
            Vector< Integer > tempRow = new Vector< Integer >();
            for( int j = 0; j < numCols; j++ )
            {
                tempRow.addElement( 0 );
            }
            c.addElement( tempRow );
        }

        System.out.println( c );

        // call the LCS function
        lcs_len( X, Y );

        // call the LCS-print function
        print_lcs( b, X, numRows-1, numCols-1 );
    }

    static Vector< Vector< String > > b;
    static Vector< Vector< Integer > > c;
}
