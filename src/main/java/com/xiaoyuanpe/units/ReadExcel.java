package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.User;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel extends Application {
    Stage stage = new Stage();
    private final Desktop desktop = Desktop.getDesktop();
    private int num = 0;

    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        //System.out.println(file.toString());
        if (file != null) {
            try {
                String pathpre = System.getProperty("user.dir");
                File file1 = new File(pathpre+"\\原文件"+"\\台账信息.xls");
                if(file1.exists()){
                    System.out.println(file1.toString());
                    file1.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //openFile(file);
            this.num=1;
        }
        else {
            this.num=0;
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS", "*.xls"),
                new FileChooser.ExtensionFilter("XLSX", "*.xlsx")
        );
    }
    public List<User> openFile(File file) {
        List<User> UserList = new ArrayList<>();
        Workbook wb = this.getExcel(file.toString());
        try {

            //UserList = ExcelUtil.importExcel(wb);
        } catch (Exception e) {
            UserList = null;
            e.printStackTrace();
        }
        return UserList;
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

    public void show() throws Exception {
        start(stage);
    }
    public static void main(String[] args){
        launch(args);
    }

}
