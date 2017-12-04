import java.util.Random;

/**
 * Created by keith on 11/2/16.
 */

public class HashMap {


    private final Courses[] hashTable;
    private final int SIZE =  30000;

    HashMap()
    {
        hashTable =  new Courses[SIZE];
    }
    public int getHash(String a)
    {
        String[] split = a.split("-");
        String name = split[0];
        String nameB = split[1];
        String[] splitA = name.split(" ");
        String[] splitB = nameB.split(" ");
        name = "";
        //name = name.concat(splitA[1]);
        //name = name.concat(splitB[splitB.length-1]);
        for(int i= 0;i<splitA.length;++i)
        {
            name = name.concat(splitA[i]);
        }
        for(int i = 0;i<splitB.length;++i)
        {
            name = name.concat(splitB[i]);
        }
        int hash = 0;
        int l = name.length();
        //System.out.println(l);
        for(int i=0;i<l;++i)
        {
                hash = a.charAt(i) + (hash << 6) + (hash << 16) - 31*hash;
        }
        if(hash<0)
            hash = hash*-1;
        hash = hash>>51;
        return hash;
    }

    public void insertCourse(int hash, Courses c)
    {
        if(hashTable[hash] != null)
        {
            //System.out.println("hit");
            //System.out.println(hash);
            Courses current = hashTable[hash];
            while(current.getNext() != null)
            {
                current = current.getNext();
            }
            current.setNext(c);
            c.setParent(current);
        }
        hashTable[hash] = c;
    }

    public int readCourse(String name)
    {
        int numOfSeats = 0;
        int h = getHash(name);
        Courses c = hashTable[h];
        //System.out.println(c.getName());
        if(c.getName().equalsIgnoreCase(name))
            numOfSeats=c.seatsAvailable();
        else{
            while(c.hasNext())
            {
                c = c.getNext();
                if(c.getName().equalsIgnoreCase(name))
                {
                    numOfSeats = c.seatsAvailable();
                    break;
                }
            }
        }
        return numOfSeats;
    }
    public boolean getSeat(String name)
    {
        boolean seat = false;
        int h = getHash(name);
        Courses c = hashTable[h];
        //System.out.println(c.getName());
        if(c.getName().equalsIgnoreCase(name))
            seat = c.getSeat();
        else{
            while(c.hasNext())
            {
                c = c.getNext();
                if(c.getName().equalsIgnoreCase(name))
                {
                    seat =  c.getSeat();
                    break;
                }
            }
        }
        return seat;
    }


}
