import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by keith on 11/9/16.
 */
public class ReadAndWrite {

    private Thread reader1;
    private Thread reader2;
    private Thread reader3;
    private Thread reader4;
    private Thread reader5;
    private Thread reader6;
    private Thread writer1;
    private Thread writer2;
    private HashMap hm;
    private String[] courseList;
    private Random rand = new Random();
    private final int MAX = 199;
    private final int MIN = 0;
    ReadAndWrite(HashMap hm, String[] courseList)
    {
        this.hm = hm;
        this.courseList = courseList;

    }
    public void runThreads() {

        reader1 = new Thread() {
            public void run() {

            while(true)
            {
                viewCourse();
            }
        }
        };
        reader2 = new Thread() {
            public void run() {

                while(true)
                {
                    viewCourse();
                }
            }
        };
        reader3 = new Thread() {
            public void run() {

                while(true)
                {
                    viewCourse();
                }
            }
        };
        reader4 = new Thread() {
            public void run() {

                while(true)
                {
                    viewCourse();
                }
            }
        };
        reader5 = new Thread() {
            public void run() {

                while(true)
                {
                    viewCourse();
                }
            }
        };
        reader6 = new Thread() {
            public void run() {

                while(true)
                {
                    viewCourse();
                }
            }
        };
        writer1 = new Thread() {
            public void run() {

                while(true)
                {
                    signUpForCourse();
                }
            }
        };
        writer2 = new Thread() {
            public void run() {

                while(true)
                {
                    signUpForCourse();
                }
            }
        };
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
        reader6.start();
        writer1.start();
        writer2.start();
    }
    public void viewCourse()
    {

            int c = rand.nextInt(MAX - MIN) + 0;
            String course = courseList[c];
            hm.readCourse(course);


    }

    public void signUpForCourse()
    {

            int c = rand.nextInt(MAX - MIN) + 0;
            String course = courseList[c];
            hm.getSeat(course);

    }

}

