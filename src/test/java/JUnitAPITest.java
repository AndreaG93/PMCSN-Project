import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitAPITest {

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



