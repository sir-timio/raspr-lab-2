package FlightApp;

import java.io.Serializable;

public class FlightStat implements Serializable {

    private float maxDelay;
    private int lateFlights;
    private float cancelledFlights;
    private int totalFlights;

    public FlightStat(float maxDelay, int lateFlights, int cancelledFlights, int totalFlights) {
        this.maxDelay = maxDelay;
        this.lateFlights = lateFlights;
        this.cancelledFlights = cancelledFlights;
        this.totalFlights = totalFlights;
    }

    public FlightStat makeStat(FlightSerializable flight)  {

        return new FlightStat(
                flight.getDelay(),
                flight.getDelay() > 0 ? 1 : 0,
                (int) flight.isCancelled(),
                1
        )
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

