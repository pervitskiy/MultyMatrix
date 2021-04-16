public class Matrix {
    private final double[][] matrix;

    public Matrix(int height, int width) {
        matrix = new double[height][width];
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double get(int x, int y) {
        return matrix[x][y];
    }

    public void set(int x, int y, double value) {
        matrix[x][y] = value;
    }

    public int getHeight() {
        return matrix.length;
    }

    public int getWidth() {
        return matrix[0].length;
    }

    /**
     * converting a matrix to an array
     *
     * @return - matrix in the form of an array
     */
    public double[][] toArray() {
        double[][] matrixCopy = matrix.clone();
        for (int i = 0; i < getWidth(); i++) {
            matrixCopy[i] = matrixCopy[i].clone();
        }
        return matrixCopy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                sb.append(get(i, j));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
