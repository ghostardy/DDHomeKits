package family.dd.DDHomeKits.HomePage.domain.MeterReading.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MeterRecordMapper {
    @Select("Select recordId, " +
            "recordNumber, " +
            "meterType, " +
            "recorder, " +
            "recordDate " +
            "from MeterRecordData " +
            "where meterType=#{meterType}")
    List<MeterRecordPO> findByMeterType(String meterType);

    @Insert("Insert into MeterRecordData(recordNumber," +
            "meterType," +
            "recorder," +
            "recordDate) values(#{recordNumber}," +
            "#{meterType}," +
            "#{recorder}," +
            "#{recordDate})")
    void add(MeterRecordPO meterRecordPO);
}
