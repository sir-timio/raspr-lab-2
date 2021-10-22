package FlightCompareApp;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritable implements Writable{
    private int code;
    private String description;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(code);
        dataOutput.writeBytes(description);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.code = dataInput.readInt();
        this.description = dataInput.readLine();
    }
}
