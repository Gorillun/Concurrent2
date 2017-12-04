import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by keith on 11/2/16.
 */
    public class Courses {

    private int seatsAvailable, capacity, seatsTaken;
    private boolean classFull;
    private String name, code, description;
    private Courses next = null;
    private Courses parent =null;
    private volatile int reading = 0;
    private volatile int writing = 0;
    private final ReentrantLock lock = new ReentrantLock();
    Courses(String name)
    {
        this.name = name;
        capacity = 30;
        seatsAvailable = capacity;
        classFull = false;
    }
    public String getName()
    {
        return name;
    }

    public boolean getSeat()
    {
        boolean seats = false;
        lock.lock();
        try {

            if (seatsAvailable > 0) {
                seatsAvailable = seatsAvailable -1;
                seats = true;
            }
        }finally
        {
            lock.unlock();
        }
        return seats;
    }

    public int seatsAvailable()
    {
        lock.lock();
        try {
            //System.out.println(seatsAvailable);
            return seatsAvailable;
        }
        finally
        {
            lock.unlock();
        }
    }
    public Courses getParent()
    {
        return parent;
    }
    public Courses getNext()
    {
        return next;
    }
    public void setNext(Courses c)
    {
        next = c;
    }
    public void setParent(Courses c)
    {
        parent = c;
    }
    public boolean hasNext()
    {
        if(next!=null)
            return true;
        else
            return false;
    }

}
