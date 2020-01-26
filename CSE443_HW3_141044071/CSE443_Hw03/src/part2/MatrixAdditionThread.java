package part2;

import java.util.List;

import static java.lang.Thread.sleep;

public class MatrixAdditionThread implements Runnable {
    TwoDimensionDFT dft;
    private List additionSyncList;

    int index;

    public MatrixAdditionThread(TwoDimensionDFT dft, int index, List synchedList) {
        this.dft = dft;
        this.index = index;
        this.additionSyncList = synchedList;
    }

    @Override
    public void run() {
        try
        {
            switch (index) {
                case 0:
                    dft.matrixAddition(dft.getArealFirst(), dft.getBrealFirst());
                    dft.matrixAddition(dft.getAimagFirst(), dft.getBimagFirst());
                    addFinishedThread("first");
                    break;
                case 1:
                    dft.matrixAddition(dft.getArealSecond(), dft.getBrealSecond());
                    dft.matrixAddition(dft.getAimagSecond(), dft.getBimagSecond());
                    addFinishedThread("second");
                    break;
                case 2:
                    dft.matrixAddition(dft.getArealThird(), dft.getBrealThird());
                    dft.matrixAddition(dft.getAimagThird(), dft.getBimagThird());
                    addFinishedThread("third");
                    break;
                case 3:
                    dft.matrixAddition(dft.getArealFourth(), dft.getBrealFourth());
                    dft.matrixAddition(dft.getAimagFourth(), dft.getBimagFourth());
                    addFinishedThread("fourth");
                    break;
            }
            //System.out.println ("Thread: " + Thread.currentThread().getId() + ", index: " + index);
        }
        catch (Exception e)
        {
            System.out.println("e: " + e);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addFinishedThread(String element) {
        synchronized (additionSyncList) {
            additionSyncList.add(element);
            additionSyncList.notifyAll();
        }
    }
}
