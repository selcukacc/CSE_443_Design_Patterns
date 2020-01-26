package part2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    private List additionSyncList;
    private List dftSynchedList;
    private TwoDimensionDFT dft;

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.start();
    }

    public Main() {
        this.additionSyncList = Collections.synchronizedList(new LinkedList());
        this.dftSynchedList = Collections.synchronizedList(new LinkedList());
    }

    public void start() throws InterruptedException {

        dft = new TwoDimensionDFT(512);

        System.out.println("<<< Before addition >>>");
        System.out.println("<<< A: ");
        dft.printComplexMatrix(dft.getArealInput(), dft.getAimagInput());
        System.out.println("<<< B: ");
        dft.printComplexMatrix(dft.getBrealInput(), dft.getBimagInput());

        for (int i = 0; i < 4; i++)
        {
            Thread object = new Thread(new MatrixAdditionThread(dft, i, this.additionSyncList));
            object.start();
        }
        System.out.println("Waiting for Addition Operation...");
        waitForAddition();

        System.out.println("<<< End of addition >>>");
        dft.assembleMatrices();
        dft.printComplexMatrix(dft.getArealInput(), dft.getAimagInput());

        for (int i = 0; i < 4; i++)
        {
            Thread object = new Thread(new MatrixDftThread(dft, i, this.dftSynchedList));
            object.start();
        }
        System.out.println("Waiting for Calculation of Dft...");
        waitForDft();

        dft.assembleMatrices();
        System.out.println("<<< End of Dft >>>");

        dft.printComplexMatrix(dft.getArealInput(), dft.getAimagInput());

    }

    public void waitForAddition() throws InterruptedException {
        synchronized (additionSyncList) {
            while (additionSyncList.size() < 4) {
                additionSyncList.wait();
            }
        }
    }

    public void waitForDft() throws InterruptedException {
        synchronized (dftSynchedList) {
            while (dftSynchedList.size() < 4) {
                dftSynchedList.wait();
            }
        }
    }
}

