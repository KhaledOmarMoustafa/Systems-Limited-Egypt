package org.example;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadAndWriteData  {
    static File file = new File("C:\\Users\\khaled\\Downloads\\SystemsLimitedEgypt\\New Microsoft Excel Worksheet.xlsx");
    static XSSFWorkbook xssfWorkbook;
    static XSSFSheet xssfSheet;
    static int numberOfRows;
    static int numberOfColumns;
    static String[][] array;
    static XSSFRow xssfRow;
    static int i;
    static int a;
    public void writeData(String checkStatus, int givenCellNumber) throws IOException {

        // Open the Excel file
        FileInputStream fileInputStream = new FileInputStream(file);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheetAt(0);

        // Get the last row number
        int lastRowNum = xssfSheet.getLastRowNum();

        // Get the row and if it doesn't exist then we  create it
        Row row = xssfSheet.getRow(lastRowNum);
        if (row == null || row.getRowNum() == 0) {

            // If the row is null or its row index is 0, create or adjust it
            row = xssfSheet.createRow(1); // Create row 1 (row index starts at 0)
        }

        // Get or create the cell in the specified column
        Cell cell = row.getCell(givenCellNumber);
        if (cell == null) {
            cell = row.createCell(givenCellNumber);
        }

        // Set the cell value
        cell.setCellValue(checkStatus);


        // Write changes back to the Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public String[][] readData() throws IOException, InvalidFormatException {
        // Open the Excel file
        xssfWorkbook = new XSSFWorkbook(file);
        xssfSheet = xssfWorkbook.getSheetAt(0);

        //count the rows and columns
        numberOfRows = xssfSheet.getPhysicalNumberOfRows();
        numberOfColumns = xssfSheet.getRow(0).getLastCellNum();

        //here we are assigning the number of row -1 (execlude the header) and the number of columns to an array of string
        array = new String[numberOfRows - 1][numberOfColumns];

        for (i = 1; i < numberOfRows; i++) {
            xssfRow = xssfSheet.getRow(i);

            // Check if the row is null
            if (xssfRow == null) {
                continue;
            }

            for (a = 0; a < numberOfColumns; a++) {
                Cell cell = xssfRow.getCell(a);

                // Check if the cell is null
                if (cell == null) {
                    array[i - 1][a] = ""; // Assign default value for empty cells
                } else {
                    array[i - 1][a] = cell.toString(); // Convert cell value to String
                }
            }
        }
        return array;
    }}
