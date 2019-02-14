package nexteventsimulation.models.singleserver.event;

import nexteventsimulation.models.singleserver.SingleServer;
import nexteventsimulation.utility.Event;

public abstract class SingleServerEvent extends Event {

    protected SingleServer singleServer;

    public void setSingleServer(SingleServer singleServer) {
        this.singleServer = singleServer;
    }

    public abstract void perform();

    public abstract void scheduleFollowingEvent();
}
