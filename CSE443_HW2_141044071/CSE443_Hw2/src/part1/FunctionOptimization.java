package part1;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Genetic algorithm implemented for a function optimization.
 * Function wants to get maximum value with convenient x1 and x2 values.
 */
public abstract class FunctionOptimization {
    protected int[][] x1;
    protected int[][] x2;
    protected int populationCounter;

    protected int parent1;
    protected int parent2;

    protected int[] child1x1;
    protected int[] child1x2;
    protected int[] child2x1;
    protected int[] child2x2;

    protected double maxFitness = 0;
    protected int generationCounter = 1;

    /**
     * Generates genetic algorithm for getting x1 and x2 value.
     */
    final void generateAlgorithm() {
        generatePopulation(100,5);
        for(int i = 0; i < 200; i++) {
            selection();
            crossover(5);
            mutation();
        }

        System.out.println("Maximum value: " + getMaxFitness() + "\n" +
                "x1: " + binToDoubleForGivenInterval(bin1, 5)
                + "\nx2: " + binToDoubleForGivenInterval(bin2, 5));

    }

    /**
     * Generates chromosomes for genetic algorithm. Chromosomes for x1 and x2
     * calculated with specific interval.
     * @param populationCounter It keeps total chromosomes number.
     * @param binaryLength  Chromosomes binary representation bit number.
     */
    public void generatePopulation(int populationCounter, int binaryLength) {
        this.populationCounter = populationCounter;
        Random random = new Random();
        int[][] x1 = new int[populationCounter][binaryLength];
        int[][] x2 = new int[populationCounter][binaryLength];


        for(int i = 0; i < populationCounter; i++) {
            double total = 6;
            while(total > 5) {
                x1[i] = randomBinNumber(binaryLength);
                x2[i] = randomBinNumber(binaryLength);

                total = binToDoubleForGivenInterval(x1[i], 5);
                total += binToDoubleForGivenInterval(x2[i], 5);;
            }
        }

        this.x1 = x1;
        this.x2 = x2;
    }

    /**
     * Selection step for genetic algorithm.
     */
    public abstract void selection();

    /**
     * Crossover step for genetic algorithm.
     * @param binaryLength Chromosome array length for binary representation.
     */
    public abstract void crossover(int binaryLength);

    public void mutation() {
        mutationHelper(10, child1x1);
        mutationHelper(10, child1x2);
        mutationHelper(10, child2x1);
        mutationHelper(10, child2x2);

        double total1 = binToDoubleForGivenInterval(child1x1, 5) +
                binToDoubleForGivenInterval(child1x2, 5);
        double total2 = binToDoubleForGivenInterval(child2x1, 5) +
                binToDoubleForGivenInterval(child2x2, 5);

        if(total2 <= 5 && total1 <= 5) {
            addPopulation(child1x1, child1x2);
            addPopulation(child2x1, child2x2);
            System.out.println("Generation " + generationCounter + ", Child 1: " + computeFitness(child1x1, child1x2));
            System.out.println("Generation " + generationCounter++ + ", Child 2: " + computeFitness(child2x1, child2x2));
        }
    }

    private void mutationHelper(int probability, int[] child) {
        Random r = new Random();
        for(int i = 0; i < child.length; i++) {
            int randomValue = r.nextInt(probability);
            if(randomValue == 0) {
                child[i] = 1 - child[i];
            }
        }
    }

    /**
     * Generates random binary array.
     * @param len array length
     * @return returns binary array
     */
    private int[] randomBinNumber(int len) {
        Random r = new Random();
        int[] number = new int[len];
        for(int i = 0; i < len; i++) {
            number[i] = r.nextInt(2);
        }

        return number;
    }

    private double binToDouble(int[] number) {
        int result = 0;

        for(int i = 0; i < number.length ; i++) {
            result += Math.pow(2, i) * number[number.length - i - 1];
        }

        return (double)result;
    }

    /**
     * Generates double value for given binary array and specific interval.
     * @param numBin
     * @param interval
     * @return
     */
    private double binToDoubleForGivenInterval(int[] numBin, double interval) {
        double numDouble = binToDouble(numBin);
        double maxValue = Math.pow(2, numBin.length) - 1;
        double result = (numDouble * interval) / maxValue;

        DecimalFormat df = new DecimalFormat("#.####");
        result = Double.parseDouble(df.format(result));
        return result;
    }

    /**
     * Calculates fitness according to the given function.
     * @param binaryX1 value x1 binary array
     * @param binaryX2 value x2 binary array
     * @return  returns function result
     */
    protected double computeFitness(int[] binaryX1, int[] binaryX2) {
        double result = 0;
        double x1, x2;
        x1 = binToDoubleForGivenInterval(binaryX1, 5);
        x2 = binToDoubleForGivenInterval(binaryX2, 5);

        result += 20 * x1 * x2 + 16 * x2;
        result -= 2 * Math.pow(x1, 2) + Math.pow(x2,2) +
                Math.pow(x1 + x2, 2);

        if(result > this.maxFitness) {
            this.maxFitness = result;
            this.bin1 = binaryX1;
            this.bin2 = binaryX2;
        }
        return result;
    }

    public int[] bin1;
    public int[] bin2;

    public void printPopulation() {
        for(int i = 0; i < populationCounter; i++) {
            System.out.print("[" + i + "]" + " x1: ");
            for(int j = 0; j < x1[i].length; j++) {
                System.out.print(x1[i][j] + " ");
            }
            double numberValue = binToDouble(x1[i]);
            double valueForInterval = binToDoubleForGivenInterval(x1[i], 5);
            System.out.print(", value: " + numberValue + ", interval value: " + valueForInterval + "\n");

            System.out.print("[" + i + "]" + " x2: ");
            for(int j = 0; j < x2[i].length; j++) {
                System.out.print(x2[i][j] + " ");
            }
            numberValue = binToDouble(x2[i]);
            valueForInterval = binToDoubleForGivenInterval(x2[i], 5);
            System.out.print(", value: " + numberValue + ", interval value: " + valueForInterval + "\n");
        }
    }

    /**
     * It adds generated childs to the population.
     * @param childX1
     * @param childX2
     */
    private void addPopulation(int[] childX1, int[] childX2) {
        if(x1.length == populationCounter) {
            int[][] x1 = new int[this.x1.length * 2][this.x1[0].length];
            int[][] x2 = new int[this.x1.length * 2][this.x1[0].length];
            for(int i = 0; i < this.x1.length; i++) {
                x1[i] = this.x1[i];
                x2[i] = this.x2[i];
            }

            this.x1 = x1;
            this.x2 = x2;
        }

        x1[populationCounter] = childX1;
        x2[populationCounter] = childX2;

        populationCounter++;
    }

    public double getMaxFitness() {
        return maxFitness;
    }
}
