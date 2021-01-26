package family.dd.DDHomeKits.HomePage.domain.MeterReading.repository;

import java.sql.Timestamp;

public class MeterRecordPO {
    private int recordId;
    private double recordNumber;
    private String meterType;
    private String recorder;
    private Timestamp recordDate;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

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

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }
}
