package family.dd.DDHomeKits.HomePage.domain.MeterReading.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeterRecordRepository {
    private MeterRecordMapper meterRecordMapper;

    public List<MeterRecordPO> findByMeterType(String meterType){
        return meterRecordMapper.findByMeterType(meterType);
    }

    public void add(MeterRecordPO meterRecordPO){
        meterRecordMapper.add(meterRecordPO);
    }
}
