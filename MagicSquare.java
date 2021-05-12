/*
* Magicsquare program Generates all possible 3 by 3 magic squares.
*
* @author  Nicholas Brean & Mr. Coxall & Jay Lee
* @version 1.0
* @since   Dec 2018 & Sept 2020 & 2020-05-11
*/
// package ca.mths.ics4u.unit3.unit05.java.magicSquare;

public final class MagicSquare {
    private MagicSquare() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** Array to check for presence. */
    private static int[] presenceArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    /** sum of magic numbers. */
    public static final int MAGICNUM = 15;
    /** size of magic square array. */
    public static final int ARRAY_SIZE = 9;

    /**
    * This method generates default array of the magic square
    * and passes to the recursive procedure called genSquare.
    * @param args
    */
    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = new int[ARRAY_SIZE];
        for (int index = 0; index < ARRAY_SIZE; index++) {
            magicSquare[index] = index + 1;
        }
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, 0);
        System.out.println("\nDone.");
    }

    /**
    * This method uses recursion to generate the magic square.
    * @param square
    * @param magicIndex
    */
    public static void genSquare(final int[] square, final int magicIndex) {
        for (int index = 0; index < square.length; index++) {
            if (presenceArray[index] == 0) {
                square[magicIndex] = index + 1;
                presenceArray[index] = 1;
                if (magicIndex < square.length - 1) {
                    genSquare(square, magicIndex + 1);
                } else if (isMagic(square)) {
                        printMagicSquare(square);
                }
                presenceArray[index] = 0;
            }
        }
    }

    /** middle left index of 3x3 1D Array. */
    private static final int MIDDLE_LEFT = 3;
    /** middle centre index of 3x3 1D Array. */
    public static final int MIDDLE_CENTRE = 4;
    /** middle right index of 3x3 1D Array. */
    public static final int MIDDLE_RIGHT = 5;
    /** bottom left index of 3x3 1D Array. */
    private static final int BOTTOM_LEFT = 6;
    /** bottom centre index of 3x3 1D Array. */
    public static final int BOTTOM_CENTRE = 7;
    /** bottom right index of 3x3 1D Array. */
    public static final int BOTTOM_RIGHT = 8;

    /**
    * This method checks square is the magic square and return boolean.
    * @param possibleSquare
    * @return boolean
    */
    public static boolean isMagic(final int[] possibleSquare) {
        int row1 = possibleSquare[0] + possibleSquare[1] + possibleSquare[2];
        int row2 = possibleSquare[MIDDLE_LEFT] + possibleSquare[MIDDLE_CENTRE]
                   + possibleSquare[MIDDLE_RIGHT];
        int row3 = possibleSquare[BOTTOM_LEFT] + possibleSquare[BOTTOM_CENTRE]
                   + possibleSquare[BOTTOM_RIGHT];
        int col1 = possibleSquare[0] + possibleSquare[MIDDLE_LEFT]
                   + possibleSquare[BOTTOM_LEFT];
        int col2 = possibleSquare[1] + possibleSquare[MIDDLE_CENTRE]
                   + possibleSquare[BOTTOM_CENTRE];
        int col3 = possibleSquare[2] + possibleSquare[MIDDLE_RIGHT]
                   + possibleSquare[BOTTOM_RIGHT];
        int diag1 = possibleSquare[0] + possibleSquare[MIDDLE_CENTRE]
                   + possibleSquare[BOTTOM_RIGHT];
        int diag2 = possibleSquare[2] + possibleSquare[MIDDLE_CENTRE]
                   + possibleSquare[BOTTOM_LEFT];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
                && col1 == MAGICNUM && col2 == MAGICNUM && col3 == MAGICNUM
                && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * This method prints inputted array in a magic square format.
    * @param outputSquare
    */
    public static void printMagicSquare(final int[] outputSquare) {
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count % MIDDLE_LEFT == 0 && count != 0) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }
}
