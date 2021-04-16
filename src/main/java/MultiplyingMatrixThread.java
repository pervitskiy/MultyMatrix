import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplyingMatrixThread {
    private Matrix firstMatrix;
    private Matrix secondMatrix;
    private volatile Matrix resultMatrix;

    public MultiplyingMatrixThread(Matrix firstMatrix, Matrix secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = new Matrix(firstMatrix.getHeight(), secondMatrix.getWidth());
    }

    public Matrix multiplication() {
        int threadsCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        for (int i = 0; i < firstMatrix.getHeight(); i++) {
            service.execute(new MultiplicationThread(i));
        }
        service.shutdown();
        return resultMatrix;
    }

    private class MultiplicationThread implements Runnable {

        private int stringIndex;

        public MultiplicationThread(int stringIndex) {
            this.stringIndex = stringIndex;
        }

        @Override
        public void run() {
            for (int i = 0; i < firstMatrix.getHeight(); i++) {
                for (int j = 0; j < secondMatrix.getHeight(); j++) {
                    double tmp = resultMatrix.get(stringIndex, i);
                    resultMatrix.set(stringIndex, i, tmp + (firstMatrix.get(stringIndex, j) * secondMatrix.get(j,i)));
                }
            }
        }
    }
}
