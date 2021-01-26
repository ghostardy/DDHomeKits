package family.dd.DDHomeKits.HomePage.domain.MeterReading.entity;

import java.sql.Timestamp;

public class MeterRecordData {
    private double recordNumber;
    private String meterType;

    public double getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(double recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }
}
