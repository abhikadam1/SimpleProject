package com.example.SimpleProject.Service;
import com.example.SimpleProject.Model.Product;
import com.example.SimpleProject.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
    public class ExcelService {

    @Autowired
    private ProductRepository productRepository;

    public ByteArrayInputStream generateExcel() throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");

        // Header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Header Row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Name", "Price"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Sample data
        Object[][] data = {
                {1, "Laptop", 45000},
                {2, "Mouse", 500},
                {3, "Keyboard", 1200}
        };

        int rowIndex = 1;

        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowIndex++);
            for (int col = 0; col < rowData.length; col++) {
                row.createCell(col).setCellValue(String.valueOf(rowData[col]));
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateExcelFronDB() {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Products");

            // HEADER style
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Create Header Row
            Row header = sheet.createRow(0);
            String[] columns = {"ID", "Name", "Use", "Price"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Fetch data from DB
            List<Product> employees = productRepository.findAll();

            int rowIndex = 1;
            for (Product emp : employees) {
                Row row = sheet.createRow(rowIndex);
                row.createCell(0).setCellValue(emp.getProductId());
                row.createCell(1).setCellValue(emp.getProductName());
                row.createCell(2).setCellValue("This is use of product " + rowIndex++);
                row.createCell(3).setCellValue(emp.getPrice());
            }

//            // Auto size columns
//            for (int i = 0; i < 4; i++) {
//                sheet.autoSizeColumn(i);
//            }

            // Writing to output stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Error while creating Excel: " + e.getMessage());
        }
    }
}
