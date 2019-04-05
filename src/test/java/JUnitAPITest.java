import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JUnitAPITest {


    public void testOnConfigFiles() {

        Properties prop = new Properties();
        String fileName = "./src/test/java/config";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        prop.entrySet();
        assertEquals("Andrea", prop.getProperty("NAME"));
        assertEquals(27, Integer.valueOf(prop.getProperty("VALUE")));
    }



    public void test() {
        PriorityQueue<Double> ff = new PriorityQueue<Double>();

        ff.add(new Double(5.9));
        ff.add(new Double(4.0));
        ff.add(new Double(7.0));


        assertEquals(4.0, ff.poll());
        assertEquals(5.9, ff.poll());
        assertEquals(7.0, ff.poll());
    }

    @Test
    public void test2() {


        PriorityQueue<Double> ff = new PriorityQueue<Double>(20, Collections.reverseOrder());

        ff.add(new Double(5.9));
        ff.add(new Double(4.0));
        ff.add(new Double(7.0));

        assertEquals(7.0, ff.poll());
        assertEquals(5.9, ff.poll());
        assertEquals(4.0, ff.poll());


    }



    public void test3() {



        PriorityQueue<Double> ff = new PriorityQueue<Double>();

        ff.add(new Double(5.9));
        ff.add(new Double(4.0));
        ff.add(new Double(7.0));

        ff.remove(4.0);

        assertEquals(5.9, ff.poll());
        assertEquals(7.0, ff.poll());




    }


}



