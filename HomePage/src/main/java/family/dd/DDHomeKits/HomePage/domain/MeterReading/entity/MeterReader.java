package family.dd.DDHomeKits.HomePage.domain.MeterReading.entity;

import family.dd.DDHomeKits.HomePage.domain.MeterReading.repository.MeterRecordPO;
import family.dd.DDHomeKits.HomePage.domain.MeterReading.repository.MeterRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class MeterReader {
    private String reader;
    private MeterRecordRepository repository;

    @Autowired
    public void setRepository(MeterRecordRepository repository) {
        this.repository = repository;
    }

    public void read(MeterRecordData meterRecordData){
        MeterRecordPO newRecord = new MeterRecordPO();
        newRecord.setRecorder(reader);
        newRecord.setMeterType(meterRecordData.getMeterType());
        newRecord.setRecordNumber(meterRecordData.getRecordNumber());
        newRecord.setRecordDate(new Timestamp(System.currentTimeMillis()));
        repository.add(newRecord);
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String recoder) {
        this.reader = recoder;
    }
}
