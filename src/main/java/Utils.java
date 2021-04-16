import java.util.Random;

public class Utils {

    /**
     * Creates a matrix of rows, cols sizes with random values
     *
     * @param rows - the number of rows in the matrix
     * @param cols - the number of columns in the matrix
     * @param numbersLimit - the max random number
     * @return - new Matrix
     */
    public static Matrix createRandomMatrix(int rows, int cols, int numbersLimit) {
        Matrix matrix = new Matrix(rows,cols);
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.set(i, j, random.nextInt(numbersLimit));
            }
        }
        return matrix;
    }

    /**
     * standard matrix multiplication
     *
     * @param m1 - first matrix
     * @param m2 - second matrix
     * @return - resultMatrix
     */
    public static Matrix multiplyMatrix(Matrix m1, Matrix m2) {
       Matrix matrixResult = new Matrix(m1.getHeight(),m2.getWidth());
        for (int i = 0; i < m1.getHeight(); i++) {
            for (int j = 0; j < m2.getWidth(); j++) {
                for (int k = 0; k < m1.getHeight(); k++) {
                    double tmp = matrixResult.get(i, j);
                    matrixResult.set(i,j, tmp + (m1.get(i,k) * m2.get(k,j)));
                }
            }
        }
        return matrixResult;
    }
}
