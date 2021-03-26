package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.units.ResultBean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/download")
public class DownloadController {

    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/download/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }

    @ResponseBody
    @GetMapping(value = "/downloadExcelModel/{num}")
    public void downloadExcelModel(@PathVariable Integer num, HttpServletResponse response) throws UnsupportedEncodingException {
        String fileName = null;
        String newFileName= null;
        if (num==1) {
            fileName = getUploadPath() + "/学生模板" + ".xls";
            newFileName = "学生模板.xls";
        }
        else if(num==2) {
            fileName = getUploadPath() + "/班级模板" + ".xlsx";
            newFileName = "班级模板.xlsx";
        }
        else if(num==3) {
            fileName = getUploadPath() + "/学院模板" + ".xlsx";
            newFileName = "学院模板.xlsx";
        }
        else {
            fileName = getUploadPath() + "/模板" + ".xlsx";
            newFileName = "模板.xlsx";
        }

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("utf-8"),"iso-8859-1"));

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            outputStream = response.getOutputStream();
            inputStream = new FileInputStream(new File(fileName));
            bis = new BufferedInputStream(inputStream);
            response.setHeader("Content-Length", String.valueOf(inputStream.available()));
            int read = bis.read(buff);

            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
//            resultBean.setCode(0);
        }catch (IOException  e){
            e.printStackTrace();
//            resultBean.setCode(1);
//            resultBean.setMsg("下载失败");
        }
        finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        return resultBean;
    }
}
