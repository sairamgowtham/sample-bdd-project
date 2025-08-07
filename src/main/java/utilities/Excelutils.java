package utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Excelutils {
    private String[][] data; // 2D array to store Excel data
    private String filePath;
    private String sheetName;

    public Excelutils(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;

        try (FileInputStream excelFile = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(excelFile)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new String[rows][cols];

            for (int r = 1; r < rows; r++) {
                Row row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < cols; c++) {
                        Cell cell = row.getCell(c);
                        data[r][c] = getCellValueAsString(cell);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] getData() {
        return data;
    }

    // Helper method to handle all cell types
    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    yield sdf.format(cell.getDateCellValue());
                } else {
                    double val = cell.getNumericCellValue();
                    yield (val % 1 == 0) ? String.valueOf((long) val) : String.valueOf(val);
                }
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK -> "";
            default -> "";
        };
    }


    /**
     * Writes a value to a specific cell in the Excel file.
     * @param row Row number (0-based)
     * @param col Column number (0-based)
     * @param value Value to write
     */
    public void writeCellData(int row, int col, String value) {
        try (FileInputStream excelFile = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(excelFile)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row targetRow = sheet.getRow(row);
            if (targetRow == null) {
                targetRow = sheet.createRow(row);
            }

            Cell targetCell = targetRow.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            targetCell.setCellValue(value);

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
    }

}
