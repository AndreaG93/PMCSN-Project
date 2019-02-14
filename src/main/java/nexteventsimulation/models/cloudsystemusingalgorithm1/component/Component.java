package nexteventsimulation.models.cloudsystemusingalgorithm1.component;

import nexteventsimulation.models.cloudsystemusingalgorithm1.SystemUsingAlgorithm1;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.type.Class1JobDeparture;
import nexteventsimulation.utility.SimulatedClock;

public abstract class Component {

    private int numberOfClass1Jobs;
    private int numberOfClass2Jobs;
    private int numberOfClass1DepartedJobs;
    private int numberOfClass2DepartedJobs;

    private double timeAveragedNumberOfClass1Jobs = 0;
    private double timeAveragedNumberOfClass2Jobs = 0;
    private double timeAveragedServiceTime = 0;

    protected SystemUsingAlgorithm1 system;

    public void incrementNumberOfClass1Jobs() {
        this.numberOfClass1Jobs++;
    }

    public void incrementNumberOfClass2Jobs() {
        this.numberOfClass2Jobs++;
    }

    public void decrementNumberOfClass1Jobs() {
        this.numberOfClass1Jobs--;
    }

    public void decrementNumberOfClass2Jobs() {
        this.numberOfClass2Jobs--;
    }

    public void incrementNumberOfClass1DepartedJobsJobs() {
        this.numberOfClass1DepartedJobs++;
    }

    public void incrementNumberOfClass2DepartedJobsJobs() {
        this.numberOfClass2DepartedJobs++;
    }



    private boolean isEmpty() {
        return (numberOfClass1Jobs + numberOfClass2Jobs) == 0;
    }

    public void scheduleClass1JobDeparture() {

        Event event = new Class1JobDeparture();
        event.setTime(this.computeNextClass1JobDepartureTime());
        event.setComponent(this);
        event.setSystem(this.system);

        this.system.scheduleEvent(event);
    }

    public void scheduleClass2JobDeparture() {

        Event event = new Class1JobDeparture();
        event.setTime(this.computeNextClass2JobDepartureTime());
        event.setComponent(this);
        event.setSystem(this.system);

        this.system.scheduleEvent(event);
    }




    public void updateStatistics(SimulatedClock clock) {

        if (!this.isEmpty()) {
            timeAveragedNumberOfClass1Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass1Jobs;
            timeAveragedNumberOfClass2Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass2Jobs;
            timeAveragedServiceTime += (clock.getNextEventTime() - clock.getTime());
        }
    }

    public abstract double computeNextClass1JobDepartureTime();

    public abstract double computeNextClass2JobDepartureTime();
}