/**
 * Created by keith on 11/7/16.
 */
public class Assignment2 {

    public static void main(String [] arg)
    {
        Initialize init = new Initialize();
        HashMap hm = init.getHashMap();
        String[] courses = init.getCourseList();
        ReadAndWrite rW = new ReadAndWrite(hm, courses);
        rW.runThreads();
    }


}
