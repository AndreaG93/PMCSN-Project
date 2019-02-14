package fdsfdsfds;

import nexteventsimulation.utility.SimulatedEvent;

import java.util.PriorityQueue;

public class Scheduler {


    private PriorityQueue<SimulatedEvent> priorityQueue = new PriorityQueue<SimulatedEvent>();

    public void schedule(SimulatedEvent event) throws Exception {

        if (event.getTime() < 0)
            throw new Exception("Invalid event-time.");

        this.priorityQueue.add(event);
    }

    public void removeScheduledEvent(SimulatedEvent event){

    }


}
