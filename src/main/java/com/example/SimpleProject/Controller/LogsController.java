package com.example.SimpleProject.Controller;

import com.example.SimpleProject.Model.Log;
import com.example.SimpleProject.Service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogsController {

    private final LogService logService;

    public LogsController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public List<Log> getLogs() {
        System.out.println("/logs");
        return logService.getAllLogs();
    }

    @PostMapping("/log")
    public int insertLog(@RequestBody Log log) {
        System.out.println("/PostMapping log");
        return logService.insertLog(log.getMessage());
    }
}
