package FlightCompareApp;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class FlightWritable implements Writable{
    private int airportID;
    private int isOverflight;

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
}
