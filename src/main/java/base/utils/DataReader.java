package base.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    XSSFWorkbook xssfWorkbook = null;
    XSSFSheet xssfSheet = null;
    XSSFRow xssfRows = null;
    XSSFCell xssfCell = null;

    FileOutputStream fio = null;
    int numberOfRows, numberOfCol, rowNum;

    /**
     * XSSF READER & WRITER METHODS (String)
     */

    // RETURNS ARRAY OF STRING ARRAYS (XSSF) - Excel sheet should have header row (this method will skip reading header row)
    public String[][] fileReaderArrayStringArraysXSSF(String path, String sheetName) throws IOException {
        String[][] data;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(fis);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        numberOfRows = xssfSheet.getLastRowNum();
        numberOfCol = xssfSheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            xssfRows = xssfSheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                xssfCell = xssfRows.getCell(j);
                String cellData = getCellValue(xssfCell);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    // RETURNS STRING ARRAY (XSSF)
    public String[] fileReaderStringXSSF(String path, String sheetName) throws IOException {
        String[] data;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(fis);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        numberOfRows = xssfSheet.getLastRowNum();

        data = new String[numberOfRows];

        for (int i = 1; i <= numberOfRows; i++) {
            xssfRows = xssfSheet.getRow(i);
            xssfCell = xssfRows.getCell(0);
            String cellData = getCellValue(xssfCell);
            data[i-1] = cellData;
        }
        return data;
    }

    // CREATES EXCEL WORKBOOK AND WRITES STRING VALUES INTO A SHEET (XSSF)
    public void writeBackStringXSSF(String value, String path) throws IOException {
        xssfWorkbook = new XSSFWorkbook();
        xssfSheet = xssfWorkbook.createSheet();
        xssfRows = xssfSheet.createRow(rowNum);
        xssfRows.setHeightInPoints(10);

        fio = new FileOutputStream(new File(path));
        xssfWorkbook.write(fio);
        for (int i = 0; i < xssfRows.getLastCellNum(); i++) {
            xssfRows.createCell(i);
            xssfCell.setCellValue(value);
        }
        fio.close();
        xssfWorkbook.close();
    }

    /**
     * XSSF READER & WRITER METHODS (Integer)
     */

    // RETURNS ARRAY OF INTEGER ARRAYS (XSSF)
    public int[][] fileReaderIntegerArrayXSSF(String path, String sheetName) throws IOException {
        int[][] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(fis);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        numberOfRows = xssfSheet.getLastRowNum();
        numberOfCol = xssfSheet.getRow(0).getLastCellNum();
        data = new int[numberOfRows + 1][numberOfCol + 1];

        for (int i = 0; i < data.length; i++) {
            xssfRows = xssfSheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                xssfCell = xssfRows.getCell(j);
                int cellData = (int) xssfCell.getNumericCellValue();
                data[i][j] = cellData;
            }
        }
        return data;
    }

    // RETURNS INTEGER ARRAY (XSSF)
    public int[] fileReaderIntegerXSSF(String path, String sheetName) throws IOException {
        int[] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(fis);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
        numberOfRows = xssfSheet.getLastRowNum();
        numberOfCol = xssfSheet.getRow(0).getLastCellNum();
        data = new int[numberOfRows + 1];

        for (int i = 0; i < data.length; i++) {
            xssfRows = xssfSheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                xssfCell = xssfRows.getCell(j);
                int cellData = (int) xssfCell.getNumericCellValue();
                data[i] = cellData;
            }
        }
        return data;
    }

    // CREATES EXCEL WORKBOOK AND WRITES INTEGER VALUES INTO A SHEET (XSSF)
    public void writeBackIntegerXSSF(int value, String path) throws IOException {
        xssfWorkbook = new XSSFWorkbook();
        xssfSheet = xssfWorkbook.createSheet();
        xssfRows = xssfSheet.createRow(rowNum);
        xssfRows.setHeightInPoints(10);

        fio = new FileOutputStream(new File(path));
        xssfWorkbook.write(fio);
        for (int i = 0; i < xssfRows.getLastCellNum(); i++) {
            xssfRows.createCell(i);
            xssfCell.setCellValue(value);
        }
        fio.close();
        xssfWorkbook.close();
    }



    // HELPER METHODS TO GET VALUES FROM INDIVIDUAL CELLS - CALLED WITHIN READER METHODS
    public String getCellValue(XSSFCell cell) {
        Object value;

        CellType dataType = cell.getCellType();
        switch (dataType) {
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            default:
                value = cell.getRawValue();
        }

        return value.toString();
    }









    private ArrayList<String> getList(By by, WebDriver driver) {
        List<WebElement> list = driver.findElements(by);
        System.out.println(list.size());
        ArrayList<String> linkList = new ArrayList<String>();
        for (int i = 0; i <= list.size() - 1; i++) {
            linkList.add(list.get(i).getText());
            System.out.println(list.get(i).getText() + " Added to linkList Array");
        }
        return linkList;
    }


//    public boolean checkListMatchesExcel(String sheetName, By by) {
//        ArrayList<String> leftLinks = getList(by);
//        excel.getData(sheetName);
//        int falseResult = 0;
//        Boolean result = null;
//
//        // outerloop:
//        for (int row = 0; row < excel.getData(sheetName).length; row++) {
//
//            for (int col = 0; col < excel.getData(sheetName)[row].length; col++) {
//
//                if (excel.getData(sheetName)[row][col].toString().equals(leftLinks.get(row))) {
//                    System.out.println(excel.getData(sheetName)[row][col].toString() + " from excel sheet is equal to " + leftLinks.get(row).toString());
//                    log.debug(excel.getData(sheetName)[row][col].toString() + " from excel sheet is equal to " + leftLinks.get(row).toString());
//                    result = true;
//
//                } else if (!excel.getData(sheetName)[row][col].toString().equals(leftLinks.get(row))) {
//                    System.out.println(excel.getData(sheetName)[row][col].toString() + " from excel sheet is NOT equal to " + leftLinks.get(row).toString());
//                    log.debug(excel.getData(sheetName)[row][col].toString() + " from excel sheet is NOT equal to " + leftLinks.get(row).toString());
//                    falseResult++;
//                    //break outerloop;
//                }
//            }
//
//        }
//        if(falseResult>0){
//            result = false;
//        }
//        return result;
//    }

}
