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

    /**
     * multiplying two Matrix in the class in multithreading
     *
     * @return - result Matrix
     */
    public Matrix multiplication() {
        // return number of processors available to the JVM
        int threadsCount = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        for (int i = 0; i < firstMatrix.getHeight(); i++) {
            service.execute(new MultiplicationThread(i));
        }
        service.shutdown();
        return resultMatrix;
    }

    private class MultiplicationThread implements Runnable {

        private int index;
        public MultiplicationThread(int index) {
            this.index = index;
        }

        /**
         * Calculates the values of the row with index
         */
        @Override
        public void run() {
            for (int i = 0; i < firstMatrix.getHeight(); i++) {
                for (int j = 0; j < secondMatrix.getHeight(); j++) {
                    double tmp = resultMatrix.get(index, i);
                    resultMatrix.set(index, i, tmp + (firstMatrix.get(index, j) * secondMatrix.get(j,i)));
                }
            }
        }
    }
}
