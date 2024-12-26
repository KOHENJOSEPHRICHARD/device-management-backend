package com.phone.smart.Service;

import com.phone.smart.Model.Log;
import com.phone.smart.Repository.LogRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log createLog(String message, String createdBy, String logLevel) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Log log = new Log(message, createdBy, logLevel, timestamp);
        return (Log) logRepository.save(log);
    }
}
