package com.example.SimpleProject.Service;

import com.example.SimpleProject.Dao.LogDAO;
import com.example.SimpleProject.Model.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogDAO logDAO;

    public LogService(LogDAO logDAO) {
        this.logDAO = logDAO;
    }

    public int insertLog(String message) {
        return logDAO.insertLog(message);
    }

    public List<Log> getAllLogs() {
        return logDAO.getAllLogs();
    }
}

