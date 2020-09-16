package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.StudentInfo;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilClass {
    public static List<StudentInfo> importExcel(Workbook wb) throws SQLException, ParseException {

        StudentInfo studentInfo;

        List<StudentInfo> BOM = new ArrayList<>();
        if (wb instanceof HSSFWorkbook) {
            Sheet sheet = wb.getSheetAt(0);

            Integer totalRows = sheet.getPhysicalNumberOfRows(); // 获取工作表中行数
            System.out.println(totalRows);
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                Integer totalCells = sheet.getRow(0).getPhysicalNumberOfCells(); // 得到当前行的所有单元格
                for (int j = 0; j < totalRows; j++) {
                    if (j==0){
                      continue;
                    }
                    else {
                        if (sheet.getRow(j)==null){
                            continue;
                        }
                        StudentInfo studentInfo1 = new StudentInfo();
                        studentInfo1.setSchool(ExcelUtilClass.getCell(sheet.getRow(j).getCell(0)));
                        studentInfo1.setCollege(ExcelUtilClass.getCell(sheet.getRow(j).getCell(1)));
                        studentInfo1.setClasses(ExcelUtilClass.getCell(sheet.getRow(j).getCell(2)));
                        BOM.add(studentInfo1);
                    }
                }
            }
        } else if (wb instanceof XSSFWorkbook) {
            XSSFWorkbook xs = (XSSFWorkbook) wb;
            for (int s = 0; s < xs.getNumberOfSheets(); s++) {
                XSSFSheet sheet = xs.getSheetAt(s);
                int lastRowNum = sheet.getLastRowNum();
                //System.out.println("当前页:" + xs.getSheetName(s));
                for (int i = 1; i < lastRowNum+1; i++) {
                    //System.out.println(lastRowNum);
                    XSSFRow row = sheet.getRow(i);
                    studentInfo = new StudentInfo();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        switch (cell.getColumnIndex()) {
                            case 0:
                                studentInfo.setSchool(cell.toString());
                                break;
                            case 1:
                                studentInfo.setCollege(cell.toString());
                                break;
                            case 2:
                                studentInfo.setClasses(cell.toString());
                                break;
                            default:
                                // TODO 数据格式有误
                                break;
                        }
                    }
                    BOM.add(studentInfo);
                }
                break;
            }
        }
        return BOM;
    }
    public static String getCellValue(Cell cell) {
        String value = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case FORMULA:
                    // cell.getCellFormula();
                    try {
                        String value1 = String.valueOf(cell.getNumericCellValue());
                        value =  String.format("%.2f", Double.valueOf(value1));
                    } catch (IllegalStateException e) {
                        value = String.valueOf(cell.getRichStringCellValue());
                    }
                    break;
                case NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    value = String.valueOf(cell.getRichStringCellValue());
                    break;
            }
        }

        return value;
    }
    public static String getCell(Cell cell) {
        String cellValue = null;
        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
        cellValue = hSSFDataFormatter.formatCellValue(cell); // 使用EXCEL原来格式的方式取得值
        return cellValue;
    }
}