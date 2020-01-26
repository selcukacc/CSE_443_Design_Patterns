package part1;

import java.util.Random;

/**
 * It uses Roulette Wheel Selection technique for genetic algorithm.
 */
public class RouletteWheelSelection extends FunctionOptimization {

    /**
     * Selects two parent from population.
     */
    public void selection() {
        int index = -1;
        while(index == -1)
            index = rouletteWheelSelection();
        parent1 = index;
        index = -1;
        while(index == -1)
            index = rouletteWheelSelection();
        parent2 = index;
    }

    /**
     * Parent selection for new generation.
     * @return Population array index for selected parent.
     */
    public int rouletteWheelSelection() {
        double sumOfFitnesses = 0;
        for(int i = x1.length - 1; i >= 0 ; i--) {
            sumOfFitnesses += computeFitness(x1[i], x2[i]);
        }

        Random r = new Random();
        double rand = r.nextDouble() * sumOfFitnesses;
        double partialSum = 0;
        for(int i = x1.length - 1; i >= 0 ; i--) {
            partialSum += computeFitness(x1[i], x2[i]);
            if(partialSum >= rand) {
                return i;
            }
        }

        return -1;
    }

    /**
     * It makes one point crossover for roulette wheel selection.
     * @param binaryLength Chromosome array length for binary representation.
     */
    public void crossover(int binaryLength) {
        int[] child1X1 = new int[binaryLength];
        int[] child1X2 = new int[binaryLength];
        int[] child2X1 = new int[binaryLength];
        int[] child2X2 = new int[binaryLength];

        child1X1[0] = x1[parent2][0];
        child1X2[1] = x2[parent2][1];
        child1X2[2] = x2[parent2][2];
        child1X2[3] = x2[parent2][3];
        child1X2[4] = x2[parent2][4];
        this.child1x1 = child1X1;
        this.child1x2 = child1X2;

        child2X1[0] = x1[parent1][0];
        child2X2[1] = x2[parent1][1];
        child2X2[2] = x2[parent1][2];
        child2X2[3] = x2[parent1][3];
        child2X2[4] = x2[parent1][4];
        this.child2x1 = child2X1;
        this.child2x2 = child2X2;
    }
}
