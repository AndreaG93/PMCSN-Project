import next_event_simulation.Event;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JUnitEventList {




    @Test
    public void test() {

        double FIRST_SCHEDULED_TIME = 5.00f;
        double SECOND_SCHEDULED_TIME = 7.00f;
        double THIRD_SCHEDULED_TIME = 8.00f;



        PriorityQueue<Event> eventList = new PriorityQueue<Event>();

        Event firstEvent = new Event();
        firstEvent.setScheduledTime(FIRST_SCHEDULED_TIME);

        Event secondEvent = new Event();
        secondEvent.setScheduledTime(SECOND_SCHEDULED_TIME);

        Event thirdEvent = new Event();
        thirdEvent.setScheduledTime(THIRD_SCHEDULED_TIME);





        eventList.add(thirdEvent);
        eventList.add(secondEvent);
        eventList.add(firstEvent);

        Event retrievedObject;

        retrievedObject = eventList.poll();
        assertNotNull(retrievedObject);

        assertEquals(FIRST_SCHEDULED_TIME, retrievedObject.getScheduledTime());
        assertEquals(SECOND_SCHEDULED_TIME, eventList.poll().getScheduledTime());
        assertEquals(THIRD_SCHEDULED_TIME, eventList.poll().getScheduledTime());
    }
}
