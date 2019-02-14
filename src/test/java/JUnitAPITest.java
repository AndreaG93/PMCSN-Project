import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JUnitAPITest {


    @Test
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




    @Test
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


/*
        PriorityQueue<Double> ff = new PriorityQueue<Double>(new Comparator<Double>() {
            public int compare(Double o1, Double o2) {
                return (int) (o2.doubleValue() - o1.doubleValue());
            }
        });


        ff.add(new Double(5.9));
        ff.add(new Double(4.0));
        ff.add(new Double(7.0));

        assertEquals(7.0, ff.poll());
        assertEquals(5.9, ff.poll());
        assertEquals(4.0, ff.poll());

*/
    }


    @Test
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



