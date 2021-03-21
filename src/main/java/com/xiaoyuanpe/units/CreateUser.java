package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.UserRoleService;
import com.xiaoyuanpe.services.UserService;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

public class CreateUser {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    public void createUser(){
        File filename = new File("C:/root.txt");
        if (!filename.exists()) {
            try {
                filename.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;
        StringBuffer buf = new StringBuffer();
        try {
            fis = new FileInputStream(filename);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String temp = "";
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<User> usersListAll = userService.findUsersListAll();
            if (usersListAll == null || usersListAll.size() == 0) {
                User user = new User();
                user.setIdentity("网站管理员");
                user.setUsername("管理员");
                user.setUnit("无");
                user.setUserNumber("root");
                user.setPassword("123456");
                user.setPhone("无");

                buf.append(usersListAll.size()+"\r\n");
                fos = new FileOutputStream(filename);
                pw = new PrintWriter(fos);
                pw.write(buf.toString().toCharArray());
                pw.flush();

                userService.addUser(user);
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(1);
                userRoleService.addUserRole(userRole);
            }
        }catch (Exception e){
            try {
                buf.append(e.getMessage()+"\r\n");
                fos = new FileOutputStream(filename);
                pw = new PrintWriter(fos);
                pw.write(buf.toString().toCharArray());
                pw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                fis.close();
                isr.close();
                br.close();
                fos.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
