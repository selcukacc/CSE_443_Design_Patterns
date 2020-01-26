package part2;

import java.util.Random;

public class TwoDimensionDFT {

    private double[][] ArealInput;
    private double[][] ArealFirst;
    private double[][] ArealSecond;
    private double[][] ArealThird;
    private double[][] ArealFourth;

    private double[][] AimagInput;
    private double[][] AimagFirst;
    private double[][] AimagSecond;
    private double[][] AimagThird;
    private double[][] AimagFourth;

    private double[][] BrealInput;
    private double[][] BrealFirst;
    private double[][] BrealSecond;
    private double[][] BrealThird;
    private double[][] BrealFourth;

    private double[][] BimagInput;
    private double[][] BimagFirst;
    private double[][] BimagSecond;
    private double[][] BimagThird;
    private double[][] BimagFourth;

    public TwoDimensionDFT(int n) {
        int dividedSize = n/2;
        Random r = new Random();

        ArealInput = new double[n][n];
        ArealFirst = new double[dividedSize][dividedSize];
        ArealSecond = new double[dividedSize][dividedSize];
        ArealThird = new double[dividedSize][dividedSize];
        ArealFourth = new double[dividedSize][dividedSize];

        AimagInput = new double[n][n];
        AimagFirst = new double[dividedSize][dividedSize];
        AimagSecond = new double[dividedSize][dividedSize];
        AimagThird = new double[dividedSize][dividedSize];
        AimagFourth = new double[dividedSize][dividedSize];

        BrealInput = new double[n][n];
        BrealFirst = new double[dividedSize][dividedSize];
        BrealSecond = new double[dividedSize][dividedSize];
        BrealThird = new double[dividedSize][dividedSize];
        BrealFourth = new double[dividedSize][dividedSize];

        BimagInput = new double[n][n];
        BimagFirst = new double[dividedSize][dividedSize];
        BimagSecond = new double[dividedSize][dividedSize];
        BimagThird = new double[dividedSize][dividedSize];
        BimagFourth = new double[dividedSize][dividedSize];

        int k = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                ArealInput[i][j] = r.nextInt(10);
                AimagInput[i][j] = r.nextInt(10);
                BrealInput[i][j] = r.nextInt(10);
                BimagInput[i][j] = r.nextInt(10);
            }

        matrixDivision(ArealInput, ArealFirst, ArealSecond, ArealThird, ArealFourth);
        matrixDivision(AimagInput, AimagFirst, AimagSecond, AimagThird, AimagFourth);
        matrixDivision(BrealInput, BrealFirst, BrealSecond, BrealThird, BrealFourth);
        matrixDivision(BimagInput, BimagFirst, BimagSecond, BimagThird, BimagFourth);
    }

    public void computeDft(double[] inreal, double[] inimag, double[] outreal, double[] outimag) {
        int N = inreal.length;
        for (int k = 0; k < N; k++) {
            double real = 0;
            double imag = 0;
            for (int n = 0; n < N; n++) {
                double angle = 2 * Math.PI * n * k / N;
                real +=  inreal[n] * Math.cos(angle) + inimag[n] * Math.sin(angle);
                imag += -inreal[n] * Math.sin(angle) + inimag[n] * Math.cos(angle);
            }
            outreal[k] = real;
            outimag[k] = imag;
        }
    }

    public void compute2dDft(double[][] inreal, double[][] inimag) {
        int m = inreal.length;
        int n = inreal[0].length;

        for(int u = 0; u < n; u++) {
            double[] r = new double[n];
            double[] ri = new double[n];
            computeDft(inreal[u], inimag[u], r, ri);
            for(int i = 0; i < n; i++) {
                inreal[u][i] = r[i];
                inimag[u][i] = ri[i];
            }
        }

        for(int v = 0; v < m; v++) {
            double[] rin = new double[n];
            double[] rimagin = new double[n];
            double[] rout = new double[n];
            double[] rimagout = new double[n];

            for(int i = 0; i < n; i++) {
                rin[i] = inreal[i][v];
                rimagin[i] = inimag[i][v];
            }
            computeDft(rin, rimagin, rout, rimagout);

            for(int i = 0; i < n; i++) {
                inreal[i][v] = rout[i];
                inimag[i][v] = rimagout[i];
            }
        }
    }

    public void printComplexMatrix(double[][] inreal, double[][] inimag) {
        int n = inreal.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print((int)inreal[i][j] + "+(" + (int)inimag[i][j] + "j), ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void matrixDivision(double[][] input,
                                      double[][] firstPart,
                                      double[][] secondPart,
                                      double[][] thirdPart,
                                      double[][] fourthPart) {
        int n = input.length;
        int dividedSize = n / 2;

        for(int i = 0; i < dividedSize; i++) {
            for(int j = 0; j < dividedSize; j++) {
                firstPart[i][j] = input[i][j];
                secondPart[i][j] = input[i][j + dividedSize];
                thirdPart[i][j] = input[i + dividedSize][j];
                fourthPart[i][j] = input[i + dividedSize][j + dividedSize];
            }
        }
    }

    public double[][] matrixAddition(double[][] A,
                                     double[][] B) {
        double[][] result = new double[A.length][A.length];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length; j++) {
                A[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    public void assembleMatrices() {
        int n = ArealInput.length;
        int dividedSize = n / 2;

        for(int i = 0; i < dividedSize; i++) {
            for(int j = 0; j < dividedSize; j++) {
                ArealInput[i][j] = ArealFirst[i][j];
                ArealInput[i][j + dividedSize] = ArealSecond[i][j];
                ArealInput[i + dividedSize][j] = ArealThird[i][j];
                ArealInput[i + dividedSize][j + dividedSize] = ArealFourth[i][j];

                AimagInput[i][j] = AimagFirst[i][j];
                AimagInput[i][j + dividedSize] = AimagSecond[i][j];
                AimagInput[i + dividedSize][j] = AimagThird[i][j];
                AimagInput[i + dividedSize][j + dividedSize] = AimagFourth[i][j];
            }
        }
    }

    public void printMatrix(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++)
                System.out.print((int)matrix[i][j] + ", ");
            System.out.println();
        }
        System.out.println();
    }

    public double[][] getArealFirst() {
        return ArealFirst;
    }

    public double[][] getArealSecond() {
        return ArealSecond;
    }

    public double[][] getArealThird() {
        return ArealThird;
    }

    public double[][] getArealFourth() {
        return ArealFourth;
    }

    public double[][] getBrealFirst() {
        return BrealFirst;
    }

    public double[][] getBrealSecond() {
        return BrealSecond;
    }

    public double[][] getBrealThird() {
        return BrealThird;
    }

    public double[][] getBrealFourth() {
        return BrealFourth;
    }

    public double[][] getAimagFirst() {
        return AimagFirst;
    }

    public double[][] getAimagSecond() {
        return AimagSecond;
    }

    public double[][] getAimagThird() {
        return AimagThird;
    }

    public double[][] getAimagFourth() {
        return AimagFourth;
    }

    public double[][] getBimagFirst() {
        return BimagFirst;
    }

    public double[][] getBimagSecond() {
        return BimagSecond;
    }

    public double[][] getBimagThird() {
        return BimagThird;
    }

    public double[][] getBimagFourth() {
        return BimagFourth;
    }

    public double[][] getArealInput() {
        return ArealInput;
    }

    public double[][] getAimagInput() {
        return AimagInput;
    }

    public double[][] getBrealInput() {
        return BrealInput;
    }

    public double[][] getBimagInput() {
        return BimagInput;
    }
}
