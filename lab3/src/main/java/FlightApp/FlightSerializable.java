package FlightApp;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private float delay;
    private float isCancelled;

    public FlightSerializable(float delay, float isCancelled) {
        this.delay = delay;
        this.isCancelled = isCancelled;
    }

    public float getDelay() {
        return delay;
    }

    public float isCancelled() {
        return isCancelled;
    }
}
