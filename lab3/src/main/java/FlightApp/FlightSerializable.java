package FlightApp;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private float delay;
    private boolean isCancelled;

    public FlightSerializable(float delay, boolean isCancelled) {
        this.delay = delay;
        this.isCancelled = isCancelled;
    }

    public float getDelay() {
        return delay;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}
