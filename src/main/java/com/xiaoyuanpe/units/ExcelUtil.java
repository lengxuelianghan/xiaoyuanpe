package com.xiaoyuanpe.units;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellType;
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
//    public static List<Ledger> importExcel(Workbook wb) throws SQLException, ParseException {
//
//        Ledger ledger;
//
//        List<Ledger> BOM = new ArrayList<>();
//        Report report = new Report();
//        if (wb instanceof HSSFWorkbook) {
//            Sheet sheet = wb.getSheetAt(0);
//
//            Integer totalRows = sheet.getPhysicalNumberOfRows(); // 获取工作表中行数
//            System.out.println(totalRows);
//            if (totalRows >= 1 && sheet.getRow(0) != null) {
//                Integer totalCells = sheet.getRow(0).getPhysicalNumberOfCells(); // 得到当前行的所有单元格
//                for (int j = 0; j < totalRows; j++) {
//                    if (j==0){
//                        for (int f = 0; f < totalCells; f++) {
//                            if (ExcelUtil.getCell(sheet.getRow(j).getCell(f))!=null &&
//                                    !ExcelUtil.getCell(sheet.getRow(j).getCell(f)).equals("")) {
//                                if (report.getPosLeft()==null||report.getPosLeft().equals("")){
//                                    report.setPosLeft(ExcelUtil.getCell(sheet.getRow(j).getCell(f)));
//                                }
//                                else if (report.getPosRight()==null||report.getPosRight().equals("")){
//                                    report.setPosRight(ExcelUtil.getCell(sheet.getRow(j).getCell(f)));
//                                }
//                                System.out.println(ExcelUtil.getCell(sheet.getRow(j).getCell(f)));
//                            }
//                            else {
//                                //System.out.println("122111222");
//                            }
//                        }
//                    }
//                    else if (j==1 || j==2){
//                        continue;
//                    }
//                    else {
//                        //System.out.println(sheet.getRow(j).getCell(1)+"-"+sheet.getRow(j).getCell(2));
//                        if (sheet.getRow(j)==null){
//                            continue;
//                        }
//                        if (ExcelUtil.getCell(sheet.getRow(j).getCell(2)).equals("")||
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(2))==null){
//                            continue;
//                        }
//                        float p1 = 0.0f;
//                        float p2 = 0.0f;
//                        if (getCellValue(sheet.getRow(j).getCell(15))!=null &&
//                                !getCellValue(sheet.getRow(j).getCell(15)).equals("")){
//                            p1 = Float.valueOf(getCellValue(sheet.getRow(j).getCell(15)));
//                        }
//                        if (getCellValue(sheet.getRow(j).getCell(16))!=null &&
//                                !getCellValue(sheet.getRow(j).getCell(16)).equals("")){
//                            //System.out.println(sheet.getRow(j).getCell(16)+"0000000");
//                            p2 = Float.valueOf(getCellValue(sheet.getRow(j).getCell(16)));
//                        }
//                        String d1_str = ExcelUtil.getCell(sheet.getRow(j).getCell(12));
//                        Date d1 = null;
//                        SimpleDateFormat sdf1 = null;
//                        String dstr1 = new String();
//                        if (d1_str.equals("不详")){
//                            SimpleDateFormat sdfs = null;
//                            sdfs = new SimpleDateFormat("yyyy-MM");
//                            d1 = sdfs.parse("100-1");
//                        }
//                        else if (!d1_str.equals("") && d1_str!=null){
//                            String[] s1 = d1_str.split("\\.");
//                            if (s1.length>2) {
//                                dstr1 = s1[0] + "-" + s1[1] + "-" + s1[2];
//                                sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//                            }
//                            else if (s1.length>1){
//                                dstr1 = s1[0] + "-" + s1[1];
//                                sdf1 = new SimpleDateFormat("yyyy-MM");
//                            }
//                            d1 = sdf1.parse(dstr1);
//                        }
//                        Date d2 = null;
//                        String d2_str = ExcelUtil.getCell(sheet.getRow(j).getCell(22));
//                        if (!d2_str.equals("") && d2_str!=null){
//                            String[] s2 = d2_str.split("\\.");
//                            String dstr2 = s2[0]+"-"+s2[1]+"-"+s2[2];
//                            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//                            d2= sdf2.parse(dstr2);
//                        }
//                        Date d3 = null;
//                        String d3_str = ExcelUtil.getCell(sheet.getRow(j).getCell(23));
//                        if (!d3_str.equals("") && d3_str!=null){
//                            String[] s3 = d3_str.split("\\.");
//                            String dstr3 = s3[0]+"-"+s3[1]+"-"+s3[2];
//                            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
//                            d3 = sdf3.parse(dstr3);
//                        }
//                        Ledger ledger2 = new Ledger(ExcelUtil.getCell(sheet.getRow(j).getCell(1)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(2)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(3)),
//                                Integer.valueOf((ExcelUtil.getCell(sheet.getRow(j).getCell(4)).equals("") ? "0" : ExcelUtil.getCell(sheet.getRow(j).getCell(4)))),
//                                Integer.valueOf((ExcelUtil.getCell(sheet.getRow(j).getCell(5)).equals("") ? "0" : ExcelUtil.getCell(sheet.getRow(j).getCell(5)))),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(6)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(7)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(8)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(9)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(10)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(11)),
//                                d1,
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(13)),
//                                Float.valueOf((ExcelUtil.getCell(sheet.getRow(j).getCell(14)).equals("") ? "0" : ExcelUtil.getCell(sheet.getRow(j).getCell(14)))),
//                                p1,
//                                p2,
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(17)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(18)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(19)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(20)),
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(21)),
//                                d2,
//                                d3,
//                                ExcelUtil.getCell(sheet.getRow(j).getCell(24)));
//                        ledger2.setPhone(ExcelUtil.getCell(sheet.getRow(j).getCell(25)));
//                        BOM.add(ledger2);
//                    }
//                }
//            }
//        } else if (wb instanceof XSSFWorkbook) {
//            XSSFWorkbook xs = (XSSFWorkbook) wb;
//            for (int s = 0; s < xs.getNumberOfSheets(); s++) {
//                XSSFSheet sheet = xs.getSheetAt(s);
//                int lastRowNum = sheet.getLastRowNum();
//                System.out.println("当前页:" + xs.getSheetName(s));
//                for (int i = 0; i < lastRowNum; i++) {
//                    System.out.println(lastRowNum);
//                    XSSFRow row = sheet.getRow(i);
//                    ledger = new Ledger();
//                    for (int j = 0; j < row.getLastCellNum(); j++) {
//                        XSSFCell cell = row.getCell(j);
//                        switch (cell.getColumnIndex()) {
//                            case 0:
//                                System.out.println(Integer.parseInt(cell.getRawValue()));
//                                //ledger.setId(Integer.parseInt(cell.getRawValue()));
//                                break;
//                            case 1:
//                                ledger.setCheckNumber(cell.toString());
//                                break;
//                            case 2:
//                                System.out.println();
//                                ledger.setInspectionUnit(cell.toString());
//                                break;
//                            case 3:
//                                ledger.setSafetyValveType(cell.toString());
//                                break;
//                            case 4:
//                                ledger.setNominalDiameter(Integer.valueOf(cell.getRawValue()));
//                                break;
//                            case 5:
//                                ledger.setRunnerDiameter(Integer.valueOf(cell.getRawValue()));
//                                break;
//                            case 6:
//                                ledger.setInstallationPosition(cell.toString());
//                                break;
//                            case 7:
//                                ledger.setMedium(cell.toString());
//                                break;
//                            case 8:
//                                ledger.setManufacturingUnit(cell.toString());
//                                break;
//                            case 9:
//                                ledger.setManufacturingLicenseNumber(cell.toString());
//                                break;
//                            case 10:
//                                ledger.setPressureLevelRange(cell.toString());
//                                break;
//                            case 11:
//                                ledger.setProductID(cell.toString());
//                                break;
//                            case 12:
//                                ledger.setDateManufacture(new Date());
//                                break;
//                            case 13:
//                                ledger.setDeviceName(cell.toString());
//                                break;
//                            case 14:
//                                ledger.setSettingPressure(Float.valueOf(cell.getRawValue()));
//                                break;
//                            case 15:
//                                ledger.setWorkingPressure(Float.valueOf(cell.getRawValue()));
//                                break;
//                            case 16:
//                                ledger.setSealTestPressure(Float.valueOf(cell.getRawValue()));
//                                break;
//                            case 17:
//                                ledger.setQualified(cell.toString());
//                                break;
//                            case 18:
//                                ledger.setUnqualified(cell.toString());
//                                break;
//                            case 19:
//                                ledger.setMaintenance(cell.toString());
//                                break;
//                            case 20:
//                                ledger.setSurveyor(cell.toString());
//                                break;
//                            case 21:
//                                ledger.setIssuer(cell.toString());
//                                break;
//                            case 22:
//                                ledger.setSafetyValveReceivingDate(new Date());
//                                break;
//                            case 23:
//                                ledger.setReportDate(new Date());
//                                break;
//                            case 24:
//                                ledger.setNote(cell.toString());
//                                break;
//
//                            default:
//                                // TODO 数据格式有误
//                                break;
//                        }
//                    }
//                    //materiel.setMateriel_type(sheet.getSheetName());
//                    BOM.add(ledger);
//                }
//                break;
//            }
//        }
//        return BOM;
//    }
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
