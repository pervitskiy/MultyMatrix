import junit.framework.TestCase;

import static org.junit.Assert.*;

public class MultiplyingMatrixThreadTest  extends TestCase {

    public MultiplyingMatrixThreadTest() {
    }

    public MultiplyingMatrixThreadTest(String name) {
        super(name);
    }

    public void testMatrixMultiplication() {
        Matrix m1 = new Matrix(new double[][]{{1, 5}, {12, 7}, {3, 1}});
        Matrix m2 = new Matrix(new double[][]{{12, 5, 8}, {1, 6, 1}});
        Matrix result1 = new Matrix(new double[][]{{17, 35, 13}, {151, 102, 103}, {37, 21, 25}});
        multiplicationMatrix(m1, m2, result1);

        Matrix m3 = Utils.createRandomMatrix(10, 10, 25);
        Matrix m4 = Utils.createRandomMatrix(10, 10, 25);
        Matrix result2 = Utils.multiplyMatrix(m3,m4);
        multiplicationMatrix(m3, m4, result2);
    }

    private void multiplicationMatrix(Matrix m1, Matrix m2, Matrix result){
        MultiplyingMatrixThread matrixMultiplication = new MultiplyingMatrixThread(m1, m2);
        System.out.println(result.toString());
        Matrix matrixMultiplicationResult = matrixMultiplication.multiplication();
        System.out.println(matrixMultiplicationResult.toString());
        assertArrayEquals(result.toArray(), matrixMultiplicationResult.toArray());
    }
}
