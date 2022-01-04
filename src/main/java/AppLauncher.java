import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class AppLauncher {

    public static void main(String[] args) {
        String[][] matrix = new String[4][4];
        matrix[0] = new String[]{"1", "1", "1", "1"};
        matrix[1] = new String[]{"1", "1", "1", "1"};
        matrix[2] = new String[]{"1", "1", "1", "1"};
        matrix[3] = new String[]{"1", "1", "1", "1"};

        try {
            int matrixSum = sumMatrix(matrix);
            System.out.printf("Matrix sum is: %d", matrixSum);
        } catch (MyArraySizeException exception) {
            System.out.println(exception.getMessage());
        } catch (MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static int sumMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        int totalSum = 0;

        if (isMatrixSizeInvalid(matrix)) {
            throw new MyArraySizeException("Incorrect matrix size");
        }

        for (String[] row : matrix) {
            for (String cell : row) {
                totalSum += convertStringToInteger(cell);
            }
        }

        return totalSum;
    }

    private static boolean isMatrixSizeInvalid(String[][] matrix) {
        return matrix.length != 4
                || matrix[0].length != 4
                || matrix[1].length != 4
                || matrix[2].length != 4
                || matrix[3].length != 4;
    }

    private static int convertStringToInteger(String cellValue) throws MyArrayDataException {
        try {
            return Integer.parseInt(cellValue);
        } catch (Exception exception) {
            throw new MyArrayDataException(exception.getMessage());
        }
    }
}
