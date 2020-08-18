package com.xiaoyuanpe.units;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.xiaoyuanpe.units.ResultBean.*;

/**
 * @Author: wan
 * @Date: Created in 16:07 2019/10/3
 * @Description:
 * @Modified By:
 */
@Component
public class CommonMethod {

    /**
     * @description:
     * @param: i 公共增、删、改方法
     * @return: ResultBean
     * @author: van
     * @time: 2020/1/13 10:24
     */
    public ResultBean<Void> changeRecord(int i) {
        try{
            int code = UNKNOWN_EXCEPTION;
            if (i > 0) {
                code = SUCCESS;
            }
            return new ResultBean<>(code, "success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean<>(UNKNOWN_EXCEPTION,"catch the Exception");
        }
    }

    /**
     * 获取系统当前时间
     *
     * @return Timestamp
     */
    public Timestamp getTime() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    /**
     * md5加yarn加密
     */
    public String MD5EncryptSalt(String password, String salt) {
        String hashAlgorithmName = "MD5";
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        int hashFrequency = 3;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, byteSource, hashFrequency);
        return simpleHash.toString();
    }

    /**
     * 得到中文首字母（中国 -> ZG）
     *
     * @param str 需要转化的中文字符串
     * @return 大写首字母缩写的字符串
     */
    public String getPinYinHeader(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString().toUpperCase();
    }

    /**
     * 随机生成字符串，用于生成初始用户名等
     */
    public String getRandomString(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String strOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(strOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(String.valueOf(random.nextInt(10)));
            }
        }
        val.insert(0, "jsd_");
        return val.toString();
    }

    public ResultBean<String> UploadImage(String fileName, String file, String path) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String imageFile = file.split(",")[1];
            System.out.println("图片开始上传!");
            byte[] bytes = decoder.decodeBuffer(imageFile);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256; // 调整异常数据
                }
            }
            String fPath = "C:\\jsdData\\image\\" + path;
            File fFile = new File(fPath);
            if (!fFile.exists()) {
                fFile.mkdirs();
            }
            String realPath = fPath + "\\" + fileName;
            // 生成图片
            OutputStream out = new FileOutputStream(realPath);
            out.write(bytes);
            out.flush();
            out.close();
            String contextPate = "\\image\\" + path + "\\" + fileName;
            return new ResultBean<>(contextPate, SUCCESS, "上传成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResultBean<>(UNKNOWN_EXCEPTION, "系统错误，请联系管理员!");
        }
    }

    /**
     * @description: 该方法用于上传文件
     * @param: picture 上传的图片
     * @param: s 文件存储路径
     * @return: ResultBean
     * @author: van
     * @time: 2020/1/11 22:56
     */
    public ResultBean<String> UploadImage(MultipartFile picture, HttpServletRequest request, String s) {
        try {
            //获取文件在服务器的储存位置
            String path = request.getSession().getServletContext().getRealPath(s);
            File realPath = new File(path);
            if (!realPath.exists() && !realPath.isDirectory()) {
                System.out.println("目录不存在，创建目录:" + realPath);
                if (!realPath.mkdir()) {
                    throw new Exception("创建目录失败! 请重试!");
                }
            }
            //获取原始文件名称(包含格式)
            String originalFileName = picture.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);
            if (originalFileName != null) {
                //获取文件类型，以最后一个`.`为标识
                String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                System.out.println("文件类型：" + type);
                //获取文件名称（不包含格式）
                String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

                //设置文件新名称: 当前时间+文件名称（不包含格式）
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String date = sdf.format(d);
                String fileName = date + name + "." + type;
                System.out.println("新文件名称：" + fileName);

                //在指定路径下创建一个文件
                File targetFile = new File(path, fileName);

                //将文件保存到服务器指定位置
                try {
                    picture.transferTo(targetFile);
                    System.out.println("上传成功");
                    //将文件在服务器的存储路径返回
                    return new ResultBean<>("/upload/" + fileName, 0, "success");
                } catch (IOException e) {
                    System.out.println("上传失败");
                    e.printStackTrace();
                    return new ResultBean<>(9, "上传失败");
                }
            } else {
                return new ResultBean<>(NULL_DATA_EXCEPTION, "上传文件异常，无扩展名");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean<>(UNKNOWN_EXCEPTION, "系统错误，请联系管理员!");
        }
    }
}
