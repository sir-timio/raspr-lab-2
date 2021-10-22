package FlightCompareApp;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable{
    private int airportID;
    private int isOverflight;

    public int getAirportID() {
        return airportID;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportID);
        dataOutput.writeInt(isOverflight);
    }


    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.airportID = dataInput.readInt();
        this.isOverflight = dataInput.readInt();
    }

    @Override
    public int compareTo(Object o) {
        FlightWritableComparable other = (FlightWritableComparable) o;
        if (other.airportID == this.airportID) {
            return (this.isOverflight < other.isOverflight) ? -1 : (())
        }
    }
}
