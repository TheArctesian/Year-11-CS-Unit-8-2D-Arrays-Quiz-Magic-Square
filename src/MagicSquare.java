public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int val = 0;
        for (int row = 0; row < array2d.length; row++) {
            val += array2d[row][0];
        }
        return val;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        if (calculateCheckSum(array2d) == checkSum) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or
     *         not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int rows = array2d.length;
        int col = array2d[0].length;

        for (int j = 0; j < col; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += array2d[i][j];
            }
            if (colSum != checkSum) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to
     *         checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int size = array2d.length;
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;

        for (int i = 0; i < size; i++) {
            diagonal1Sum += array2d[i][i]; // elements on diagonal 1
            diagonal2Sum += array2d[i][size - i - 1]; // elements on diagonal 2
        }

        return diagonal1Sum == checkSum && diagonal2Sum == checkSum;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int size = array2d.length;
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        int rowSum = 0;
        int colSum = 0;
        boolean rowSumIsSame = false;
        boolean colSumIsSame = false;

        for (int i = 0; i < size; i++) {

            diagonal1Sum += array2d[i][i]; // elements on diagonal 1
            diagonal2Sum += array2d[i][size - i - 1]; // elements on diagonal 2
            for (int j = 0; j < array2d[i].length; j++) {
                colSum += array2d[i][j];
                rowSum += array2d[j][i];
            }

        }

        int tempColSum = 0;
        int tempRowSum = 0;
        for (int i = 0; i < size; i++) {
            tempColSum = 0;
            tempRowSum = 0;
            for (int j = 0; j < array2d[i].length; j++) {
                tempColSum += array2d[i][j];
                tempRowSum += array2d[j][i];
            }
            if (tempColSum == (colSum / 3)) {
                colSumIsSame = true;
            }
            if (tempRowSum == (rowSum / 3)) {
                rowSumIsSame = true;
            }
        }

        return diagonal1Sum == diagonal2Sum &&
                rowSumIsSame &&
                colSumIsSame;

    }

}
