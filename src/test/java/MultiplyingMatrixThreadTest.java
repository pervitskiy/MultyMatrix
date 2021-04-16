import junit.framework.TestCase;

import static org.junit.Assert.*;

public class MultiplyingMatrixThreadTest  extends TestCase {

    public MultiplyingMatrixThreadTest() {
    }

    public MultiplyingMatrixThreadTest(String name) {
        super(name);
    }

    public void testMatrixMultiplication() {
        Matrix firstMatrix = new Matrix(new double[][]{{1, 3}, {4, 7}, {5, 8}});
        Matrix secondMatrix = new Matrix(new double[][]{{2, 5, 8}, {3, 9, 4}});
        Matrix result = new Matrix(new double[][]{{11, 32, 20}, {29, 83, 60}, {34, 97, 72}});
        MultiplyingMatrixThread matrixMultiplication = new MultiplyingMatrixThread(firstMatrix, secondMatrix);
        System.out.println(result.toString());
        Matrix matrixMultiplicationResult = matrixMultiplication.multiplication();
        System.out.println(matrixMultiplicationResult.toString());
        assertArrayEquals(result.toArray(), matrixMultiplicationResult.toArray());
    }

}
