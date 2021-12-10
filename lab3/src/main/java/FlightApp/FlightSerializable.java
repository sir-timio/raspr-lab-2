package FlightApp;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private float delay;
    private int isCancelled;

    public FlightSerializable(float delay, int isCancelled) {
        this.delay = delay;
        this.isCancelled = isCancelled;
    }

    public float getDelay() {
        return delay;
    }

    public int isCancelled() {
        return isCancelled;
    }
}
