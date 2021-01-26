package family.dd.DDHomeKits.HomePage.domain.MeterReading;

import family.dd.DDHomeKits.HomePage.domain.MeterReading.entity.MeterReader;
import family.dd.DDHomeKits.HomePage.domain.MeterReading.entity.MeterRecordData;
import family.dd.DDHomeKits.HomePage.domain.MeterReading.repository.MeterRecordPO;
import family.dd.DDHomeKits.HomePage.domain.MeterReading.repository.MeterRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterRecord {
    private MeterReader meterReader;
    private MeterRecordRepository repository;

    @Autowired
    public void setMeterReader(MeterReader meterReader) {
        this.meterReader = meterReader;
    }

    public MeterReader getMeterReader() {
        return meterReader;
    }

    public void readMeter(double number, String meterType) {
        MeterRecordData data = new MeterRecordData();
        data.setMeterType(meterType);
        data.setRecordNumber(number);
        meterReader.read(data);
    }

    public List<MeterRecordPO> singleTypeRecords(String meterType){
        return repository.findByMeterType(meterType);
    }
}
