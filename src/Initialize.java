/**
 * Created by keith on 11/7/16.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Initialize {

    private HashMap hm = new  HashMap();
    private BufferedReader br = null;
    private String[] courses = new String[200];
    Initialize()
    {
        readFile();
    }
    public void readFile()
    {
	    ClassLoader cl = getClass().getClassLoader();

        String currentLine;
        try
        {
            br = new BufferedReader(new FileReader(cl.getResource("courses.txt").getFile()));
            int i =0;
            while((currentLine = br.readLine()) != null)
            {
                courses[i] = currentLine;
                System.out.println(currentLine);
                Courses c = new Courses(currentLine);
                int h = hm.getHash(currentLine);
                hm.insertCourse(h,c);
                //System.out.println(i);
                ++i;
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if (br != null)
                    br.close();
            }catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }
    public HashMap getHashMap()
    {
        return hm;
    }
    public String[] getCourseList()
    {
        return courses;
    }


}
