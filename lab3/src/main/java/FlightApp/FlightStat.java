package FlightApp;

import java.io.Serializable;

public class FlightStat implements Serializable {

    private float maxDelay;
    private int delayedFlights;
    private int cancelledFlights;
    private int totalFlights;

    private final int ONE_FLIGHT = 1;
    public FlightStat(float maxDelay, int delayedFlights, int cancelledFlights, int totalFlights) {
        this.maxDelay = maxDelay;
        this.delayedFlights = delayedFlights;
        this.cancelledFlights = cancelledFlights;
        this.totalFlights = totalFlights;
    }

    public FlightStat makeStat(FlightSerializable flight)  {

        return new FlightStat(
                flight.getDelay(),
                flight.getDelay() > 0 ? 1 : 0,
                flight.isCancelled(),
                ONE_FLIGHT
        );
    }


    public FlightStat updateStat(FlightStat stat, FlightSerializable flight) {
        return new FlightStat(
                Float.max(stat.getMaxDelay(), flight.getDelay()),
                stat.getLateFlights() + flight.isDelayed(),
                stat.getCancelledFlights() + flight.isCancelled(),
                stat.getTotalFlights() + ONE_FLIGHT
        );
    }

    public FlightStat mergeStat(FlightStat stat1, FlightStat stat2) {
        return new FlightStat(
                Float.max(stat1.getMaxDelay(), stat2.getMaxDelay()),
                stat1.getLateFlights() + stat2.getLateFlights(),
                stat1.getCancelledFlights() + stat2.getCancelledFlights(),
                stat1.getTotalFlights() + stat2.getTotalFlights()
        );
    }

    public float calcPercent(int part, int total) {
        return (float) (100.0 * part / total);
    }

    @Override
    public String toString() {
        return "Max delay: %f\ndelayed"
    }

    protected float getMaxDelay() {
        return this.maxDelay;
    }

    protected int getLateFlights() {
        return this.lateFlights;
    }

    protected int getCancelledFlights() {
        return this.cancelledFlights;
    }

    protected int getTotalFlights() {
        return this.totalFlights;
    }
}

