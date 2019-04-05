package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.component.Component;

import java.text.MessageFormat;

public class EventFactory {




    public static Event built(String eventName) {

        Event event = null;

        String mClassName = MessageFormat.format("{0}.type.{1}",
                EventFactory.class.getPackage().getName(),
                eventName);

        try {
            event = (Event) Class.forName(mClassName).getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        return event;
    }

    public static Event built(String eventType, int eventClass) {

        Event event = null;

        String mClassName = String.format("%s.type.Class%dJob%s",
                EventFactory.class.getPackage().getName(),
                eventClass,
                eventType);
        try {
            event = (Event) Class.forName(mClassName).getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        return event;
    }


}
