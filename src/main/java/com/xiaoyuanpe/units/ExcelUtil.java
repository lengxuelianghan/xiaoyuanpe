package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.Student;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {
    public static List<Student> importExcel(Workbook wb) throws SQLException, ParseException {

        Student student;

        List<Student> BOM = new ArrayList<>();
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

                        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
                        String cell = ExcelUtil.getCell(sheet.getRow(j).getCell(7));
                        String [] strs = cell.split("/");
                        String da = strs[0]+"-"+strs[1]+"-"+strs[2]+" 00:00:00";
                        Date birthday = formatter.parse(da);
                        System.out.println( formatter.format(birthday));

                        Student student1 = new Student(0,0,0,
                                ExcelUtil.getCell(sheet.getRow(j).getCell(5)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(3)),1,
                                ExcelUtil.getCell(sheet.getRow(j).getCell(6)),new Date(),birthday,
                                Integer.parseInt(ExcelUtil.getCell(sheet.getRow(j).getCell(0))),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(4)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(10)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(8)),"",
                                ExcelUtil.getCell(sheet.getRow(j).getCell(9)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(2)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(1)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(11)),
                                ExcelUtil.getCell(sheet.getRow(j).getCell(12)));
                        BOM.add(student1);
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
                    student = new Student();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        switch (cell.getColumnIndex()) {
                            case 0:
                                student.setGradeNumber(Integer.parseInt(cell.toString()));
                                break;
                            case 1:
                                student.setClassNumber(cell.toString());
                                break;
                            case 2:
                                student.setClassesName(cell.toString());
                                break;
                            case 3:
                                student.setStudentNumber(cell.toString());
                                student.setTerm(1);
                                student.setSchoolId(0);
                                student.setStartYear(new Date());
                                student.setCollegeId(0);
                                student.setClassesId(0);
                                break;
                            case 4:
                                student.setNationalCode(cell.toString());
                                break;
                            case 5:
                                student.setStudentName(cell.toString());
                                break;
                            case 6:
                                student.setSex(cell.toString());
                                break;
                            case 7:
                                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
                                String cell1 = cell.toString();
                                Date birthday = formatter.parse(cell1.replace("/","-"));
                                student.setBirthday(birthday);
                                break;
                            case 8:
                                student.setAddress(cell.toString());
                                break;
                            case 9:
                                student.setCollegeName(cell.toString());
                                break;
                            case 10:
                                student.setIdCard(cell.toString());
                                break;
                            case 11:
                                student.setPhone(cell.toString());
                                break;
                            case 12:
                                student.setEmail(cell.toString());
                                break;
                            default:
                                // TODO 数据格式有误
                                break;
                        }
                    }
                    //materiel.setMateriel_type(sheet.getSheetName());
                    BOM.add(student);
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
