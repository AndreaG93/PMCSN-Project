package nexteventsimulation.models.singleserver.event;

import nexteventsimulation.models.singleserver.SingleServer;
import nexteventsimulation.utility.SimulatedEvent;

public abstract class SingleServerEvent extends SimulatedEvent {

    protected SingleServer singleServer;

    public void setSingleServer(SingleServer singleServer) {
        this.singleServer = singleServer;
    }
}
