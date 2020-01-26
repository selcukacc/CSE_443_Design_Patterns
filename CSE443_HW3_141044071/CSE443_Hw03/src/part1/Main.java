package part1;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        BestDsEver_Adapter ds = new BestDsEver_Adapter(new ArrayList());

        for (int i = 0; i < 10; i++)
        {
            Thread object = new Thread(new MultithreadingTest(ds));
            object.start();
        }



    }
}