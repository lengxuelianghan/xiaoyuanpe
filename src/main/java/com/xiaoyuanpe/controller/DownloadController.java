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

    @RequestMapping(value = "/downloadFile/{type}")
    public void downloadExcelModel(@PathVariable String type, HttpServletResponse response) throws IOException {
        String fileName = "";
        String newFileName= null;
        switch (type) {
            case "student":
                fileName = getUploadPath() + "/学生模板" + ".xls";
                newFileName = "学生模板.xls";
                break;
            case "class":
                fileName = getUploadPath() + "/班级模板" + ".xls";
                newFileName = "班级模板.xls";
                break;
            case "college":
                fileName = getUploadPath() + "/学院模板" + ".xls";
                newFileName = "学院模板.xls";
                break;
            case "standard":
                fileName = getUploadPath() + "/模板" + ".xls";
                newFileName = "模板.xls";
                break;
        }
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[4096];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        int offset = 0;
        while (inputStream.read(buffer, offset, buffer.length) > -1) {
            bufferedOutputStream.write(buffer,0,buffer.length);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
