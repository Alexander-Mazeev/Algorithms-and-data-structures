/*
 *       Created by Alexander on 22/04/2020
 */

package Lesson7.DOP;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static final String file = "CompanyIndicators.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        Workbook workbook = WorkbookFactory.create(new File(file));

        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.rowIterator();

        List<Company> company = new ArrayList<>();
        List<Do> doCompany = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // переберем столбцы текущей строки
            Iterator<Cell> cellIterator = row.cellIterator();

            int i = 0;
            int idDo = 1;
            int idCompany = 1;
            while (cellIterator.hasNext()) {



//                    for (int i = 0; i < sheet.getNumMergedRegions(); i++){
//                        CellRangeAddress region = sheet.getMergedRegion(i); //Region of merged cells
//
//                        int colIndex = region.getFirstColumn(); //number of columns merged
//                        int rowNum = region.getFirstRow();      //number of rows merged
//
//                        for (int j = region.getFirstRow(); j < region.getLastRow(); j++) {
//                           // Cell cell = row.getCell(2, j);
//
//                        }
//
//                        System.out.println(colIndex);
//                    }

                String nameCompany = null;

                CellRangeAddress region = sheet.getMergedRegion(i);

                for (int j = region.getFirstRow(); j < region.getLastRow(); j++) {
                    // Cell cell = row.getCell(2, j);

                    Row row1 = rowIterator.next();

                    Cell cell1 = row1.getCell(1);

                    doCompany.add(new Do (idDo, idCompany, row1.getCell(1).getStringCellValue(), row1.getCell(2).getNumericCellValue(), row1.getCell(3).getNumericCellValue()));

                    System.out.println(cell1);

                    idDo ++;

                    nameCompany = row1.getCell(0).getStringCellValue();

                }

                company.add(new Company(idCompany, nameCompany, doCompany));

//                Cell cell = cellIterator.next();
//                String cellValue = dataFormatter.formatCellValue(cell);
//                System.out.print(cellValue + "\t");
//                i++;

                idCompany ++;
            }

            System.out.println();

            for (Company list:company) {
                list.infoIndicators();
            }

        }

    }
}
