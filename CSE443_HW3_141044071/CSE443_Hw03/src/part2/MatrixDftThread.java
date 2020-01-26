package part2;

import java.util.List;

import static java.lang.Thread.sleep;

public class MatrixDftThread implements Runnable  {
    private TwoDimensionDFT dft;
    private List dftList;

    int index;

    public MatrixDftThread(TwoDimensionDFT dft, int index, List dftList) {
        this.dft = dft;
        this.index = index;
        this.dftList = dftList;
    }

    @Override
    public void run() {
        try
        {
            switch (index) {
                case 0:
                    dft.compute2dDft(dft.getArealFirst(), dft.getAimagFirst());
                    addFinishedThread("first dft");
                    break;
                case 1:
                    dft.compute2dDft(dft.getArealSecond(), dft.getAimagSecond());
                    addFinishedThread("second dft");
                    break;
                case 2:
                    dft.compute2dDft(dft.getArealThird(), dft.getAimagThird());
                    addFinishedThread("third dft");
                    break;
                case 3:
                    dft.compute2dDft(dft.getArealFourth(), dft.getAimagFourth());
                    addFinishedThread("fourth dft");
                    break;
            }
            //System.out.println ("Thread: " + Thread.currentThread().getId() + ", index: " + index);
        }
        catch (Exception e)
        {
            System.out.println ("e: " + e);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addFinishedThread(String element) {
        synchronized (dftList) {
            dftList.add(element);
            dftList.notifyAll();
        }
    }
}
