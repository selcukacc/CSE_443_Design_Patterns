package part1;

import static java.lang.Thread.sleep;

public class MultithreadingTest implements Runnable
{
    BestDsEver_Adapter ds;

    public MultithreadingTest(BestDsEver_Adapter ds) {
        this.ds = ds;
    }

    public void run()
    {
        try
        {
            for(int i = 0; i < 10; i++) {
                ds.insert(Thread.currentThread().getId());
                System.out.println ("Thread: " + Thread.currentThread().getId() + " is making insertion operation.");

            }

            if(ds.size() == 10 * 10) {
                System.out.println(ds.toString());
            }
        }
        catch (Exception e)
        {
            System.out.println ("e: " + e);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}




