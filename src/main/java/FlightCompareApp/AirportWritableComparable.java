package FlightCompareApp;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable{
    private int airportID;
    private int isOverflight;

    public int getAirportID() {
        return airportID;
    }

    public AirportWritableComparable(int airportID, int isOverflight) {
        this.airportID =  airportID;
        this.isOverflight = isOverflight;
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
        AirportWritableComparable other = (AirportWritableComparable) o;
        if (this.airportID == other.airportID) {
            if (this.isOverflight < other.airportID) {
                return -1;
            } else if (this.isOverflight == other.airportID) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return (this.airportID < other.airportID) ? -1 : 1;
        }
    }
}
