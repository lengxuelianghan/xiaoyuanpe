package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.StudentInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelClass {
    private int num = 0;

    public List<StudentInfo> importExcel(String filePath) {
        File file = new File(filePath);
        if (file != null) {
            this.num=1;
            List<StudentInfo> studentInfos = openFile(file);
            return studentInfos;
        }
        else {
            this.num=0;
            return null;
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<StudentInfo> openFile(File file) {
        List<StudentInfo> studentInfos = new ArrayList<>();
        Workbook wb = this.getExcel(file.toString());
        try {
            studentInfos = ExcelUtilClass.importExcel(wb);
        } catch (SQLException | ParseException e) {
            studentInfos = null;
            e.printStackTrace();
        }
        return studentInfos;
    }
    public Workbook getExcel(String filePath){
        Workbook wb=null;
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在");
            wb=null;
        }
        else {
            String fileType = filePath.substring(filePath.lastIndexOf("."));//获得后缀名
            try {
                InputStream is = new FileInputStream(filePath);
                if(".xls".equals(fileType)){
                    wb = new HSSFWorkbook(is);
                    System.out.println(wb);
                }else if(".xlsx".equals(fileType)){
                    System.out.println(is.toString());
                    wb = new XSSFWorkbook(is);
                    System.out.println(wb);
                }else{
                    System.out.println("格式不正确");
                    wb=null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wb;
    }

}
