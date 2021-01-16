package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.units.ResultBean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }

    @GetMapping(value = "/downloadExcelModel")
    public ResultBean downloadExcelModel(HttpServletResponse response) throws UnsupportedEncodingException {
        ResultBean resultBean = new ResultBean();
        String fileName = getUploadPath()+"/模板"+".xls";
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"),"iso-8859-1"));

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
            int read = bis.read(buff);

            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
            resultBean.setCode(0);
        }catch (IOException  e){
            e.printStackTrace();
            resultBean.setCode(1);
            resultBean.setMsg("下载失败");
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
        }
        return resultBean;
    }
}
