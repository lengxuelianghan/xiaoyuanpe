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

    @RequestMapping(value = "/downloadExcelModel/{type}")
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
        /// 测试前端选择另存为路径
//        response.setContentType("application/force-download");
//        response.addHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("utf-8"),"iso-8859-1"));
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buffer = new byte[4096];
        int read = bis.read(buffer);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        int offset = 0;
        while (read > -1) {
            bos.write(buffer,0,buffer.length);
            bos.flush();
            read = bis.read(buffer);
        }
        bis.close();
        bos.close();
//
////        response.setContentType("application/force-download");
//        byte[] buff = new byte[1024];
//        BufferedInputStream bis = null;
//        OutputStream outputStream = null;
//        FileInputStream inputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            File file = new File(fileName);
//            inputStream = new FileInputStream(file);
//            bis = new BufferedInputStream(inputStream);
//            int read = bis.read(buff);
//
//            while (read != -1) {
//                outputStream.write(buff, 0, buff.length);
//                outputStream.flush();
//                read = bis.read(buff);
//            }
//
////            resultBean.setCode(0);
//        }catch (IOException  e){
//            e.printStackTrace();
////            resultBean.setCode(1);
////            resultBean.setMsg("下载失败");
//        }
//        finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (bis!=null){
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return resultBean;
    }
}
