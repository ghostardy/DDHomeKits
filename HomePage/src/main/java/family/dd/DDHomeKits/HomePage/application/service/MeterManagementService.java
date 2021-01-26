package family.dd.DDHomeKits.HomePage.application.service;

import com.google.gson.Gson;
import family.dd.DDHomeKits.HomePage.domain.MeterReading.MeterRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static family.dd.DDHomeKits.HomePage.infrastructure.util.CommonUtil.isEmptyString;
import static family.dd.DDHomeKits.HomePage.infrastructure.util.CommonUtil.isNull;

@Service
public class MeterManagementService {
    private MeterRecord meterRecord;
    private Gson gson;

    @Autowired
    public void setMeterRecord(MeterRecord meterRecord) {
        this.meterRecord = meterRecord;
    }

    @PostMapping("/MeterReading/readMeter")
    public String readMeter(HttpSession session, @RequestParam(name = "number") String number, @RequestParam(name = "meterType") String meterType) {
        final String SESSION_ATTRIBUTE_USERNAME = "username";
        if (isNull(session.getAttribute(SESSION_ATTRIBUTE_USERNAME))) {
            return "Need Login";
        }else if (isEmptyString(number) || isEmptyString(meterType)) {
            return "Failed";
        } else{
            loadReader((String)session.getAttribute(SESSION_ATTRIBUTE_USERNAME));
            meterRecord.readMeter(Double.parseDouble(number), meterType);
            return "Success";
        }
    }

    @GetMapping("/MeterReading/getRecords")
    public String singleTypeRecords(String meterType) {
        if (isEmptyString(meterType)) {
            return "Wrong parameters";
        }else {
            return gson.toJson(meterRecord.singleTypeRecords(meterType));
        }
    }

    private void loadReader(String reader) {
        meterRecord.getMeterReader().setReader(reader);
    }
}
