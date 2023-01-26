import java.util.*;

class Thread_1 extends Thread
{
    public void run()
    {
        int i = 0;
        while(i<100)
        {
            try
            {
                Thread.sleep(10000);
                System.out.println("BMSCE");
            }
            catch(Exception e)
            {
                System.out.println("Exception: "+e);
            }
            i++;
        }
    }
}

class Thread_2 extends Thread
{
    public void run()
    {
        int i = 0;
        while(i<100)
        {
            try
            {
                Thread.sleep(2000);
                System.out.println("CSE");
            }
            catch(Exception e)
            {
                System.out.println("Exception "+e);
            }
            i++;
        }
    }
}

public class Threads
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread_1();
        Thread t2 = new Thread_2();
        t1.start();
        t2.start();
    }
}
