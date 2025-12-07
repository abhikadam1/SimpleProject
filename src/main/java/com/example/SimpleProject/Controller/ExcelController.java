package com.example.SimpleProject.Controller;
import com.example.SimpleProject.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/download_excel")
    public ResponseEntity<InputStreamResource> downloadExcel() {

        try {
//            ByteArrayInputStream stream = excelService.generateExcel();
            InputStreamResource file = new InputStreamResource(excelService.generateExcel());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=products.xlsx")
                    .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//                    .body(new InputStreamResource(stream));
                    .body(file);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/download_excel_from_db")
    public ResponseEntity<InputStreamResource> downloadExcelFromDB() {

        InputStreamResource file = new InputStreamResource(excelService.generateExcelFronDB());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=products.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}

