import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Testdd {

    @Test
    public void test11(){

        String ff[] = {"dsad", "dasdas", "dsada", "dasdasdassadas","aaa"};

        System.out.println(String.format("%20s %10s", "Average Service Time", "32.33"));
        System.out.println(String.format("%15s %10s", "String", "dsaas"));


        Map<String, Double> my = new HashMap<String, Double>();
        my.put("sadsadasd", 22.3);
        my.put("QWE", 22.3);

        for (Map.Entry<String, Double> entry : my.entrySet())
        {
            String key = entry.getKey();
            Double value = entry.getValue();

            System.out.println(String.format("%s %s", key, value));
        }
    }
}
