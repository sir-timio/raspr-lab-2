package FlightApp;

import java.io.Serializable;

public class FlightStat implements Serializable {

    private float maxDelay;
    private int lateFlights;
    private int cancelledFlights;
    private int totalFlights;

    public FlightStat(float maxDelay, int lateFlights, int cancelledFlights, int totalFlights) {
        this.maxDelay = maxDelay;
        this.lateFlights = lateFlights;
        this.cancelledFlights = cancelledFlights;
        this.totalFlights = totalFlights;
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

