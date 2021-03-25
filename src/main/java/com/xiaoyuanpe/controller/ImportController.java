package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ReadExcel;
import com.xiaoyuanpe.units.ReadExcelClass;
import com.xiaoyuanpe.units.ReadExcelCollege;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/importFile")
public class ImportController  {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ClassesService classesService;

    private List<Map> mapCollege(Integer schoolId){
        List<Map> mapList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        List<College> collegeAll = this.collegeService.findCollegeBySchool(schoolId);
        Map<Integer, Integer> map1 = new HashMap<>();
        for (College college:collegeAll){
            map.put(college.getCollegeName().trim(),college.getId());
            map1.put(college.getId(),college.getSchoolId());
        }
        mapList.add(map);
        mapList.add(map1);
        return mapList;
    }

    private Map<String,Integer> mapClass(){
        Map<String,Integer> map = new HashMap<>();
        List<Classes> classes = this.classesService.findClassesAll();
        for (Classes classes1:classes){
            map.put(classes1.getClassName(),classes1.getId());
        }
        return map;
    }
    //导入学生
    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public ResultBean ImportFile(@RequestParam("excelFile")MultipartFile excelFile, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        String fileName = "";
        String filepath = getUploadPath();
        try {
            if (excelFile != null){
                String filename=excelFile.getOriginalFilename();
                fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath + File.separator + fileName)));
                out.write(excelFile.getBytes());
                out.flush();
            }
            List<Map> mapList = this.mapCollege(user.getSchoolId());
            Map<String, Integer> mapCollege = mapList.get(0);

            Map<String, Integer> mapClasses = this.mapClass();
            ReadExcel readExcel = new ReadExcel();
            List<User> users = new ArrayList<>();
            int j=0;
            boolean flag = true;
            List<Student> studentInfos = readExcel.importExcel(filepath + File.separator + fileName);
            System.out.println("读取文件结束"+(studentInfos==null?"0":studentInfos.size()));
            for (Student studentInfo : studentInfos) {
                j++;
                resultBean.setData(studentInfo.getStudentName()+","
                        +studentInfo.getStudentNumber());
                User user1 = new User();
                user1.setIdentity("学生");
                user1.setUserNumber(studentInfo.getStudentNumber());
                user1.setPassword(studentInfo.getStudentNumber());
                user1.setUsername(studentInfo.getStudentName());
                user1.setSchoolId(user.getSchoolId());
                user1.setPhone(studentInfo.getPhone());
                user1.setSex(studentInfo.getSex());
                user1.setPhone(studentInfo.getPhone());
                user1.setEmail(studentInfo.getEmail());
                users.add(user1);
                //this.userService.addUser(user1);
                resultBean.setData("User结束");

                studentInfo.setSchoolId(user.getSchoolId());
                if (mapCollege.containsKey(studentInfo.getCollegeName()))
                    studentInfo.setCollegeId(mapCollege.get(studentInfo.getCollegeName()));
                else {
                    resultBean.setCode(1);
                    flag = false;
                    resultBean.setMsg("第"+j+"条数据,"+studentInfo.getCollegeName()+"错误");
                    break;
                }
                if (mapClasses.containsKey(studentInfo.getClassesName()))
                    studentInfo.setClassesId(mapClasses.get(studentInfo.getClassesName()));
                else {
                    resultBean.setCode(1);
                    flag = false;
                    resultBean.setMsg("第"+j+"条数据,"+studentInfo.getClassesName()+"错误");
                    break;
                }
                resultBean.setData("Student结束");
            }
            if (flag){
                this.studentService.addBatch(studentInfos);
                this.userService.addBatch(users);
                List<Semester> semesters = new ArrayList<>();
                for (Student student: studentInfos){
                    Semester semester = new Semester();
                    semester.setSudentId(student.getId());
                    semester.setClassesId(student.getClassesId());
                    semester.setScore(0);
                    semester.setExerciseTime(0);
                    semester.setCollegeId(student.getCollegeId());
                    semester.setSchoolId(student.getSchoolId());
                    int i = 0;
                    for (i = 0; i < 8; i++) {
                        semester.setTerm(i + 1);
                        this.semesterService.addSemester(semester);
                        semesters.add(semester);
                    }
                }
                resultBean.setData("semesters结束");
                this.semesterService.addBatch(semesters);
                resultBean.setCode(0);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("导入失败");
        }
        return resultBean;
    }

    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }

    /**
     * 获取当前系统路径
     */
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

    @RequestMapping(value = "/ImportFileClass", method = RequestMethod.POST)
    public ResultBean ImportFileClass(@RequestParam("excelFile")MultipartFile excelFile, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        String fileName = "";
        String filepath = getUploadPath();
        try {
            if (excelFile != null){
                String filename=excelFile.getOriginalFilename();
                fileName = "class_"+getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath + File.separator + fileName)));
                System.out.println(filepath + File.separator + fileName);
                out.write(excelFile.getBytes());
                out.flush();
            }
            ReadExcelClass readExcel = new ReadExcelClass();
            List<Classes> classesList = readExcel.importExcel(filepath + File.separator + fileName);
            Map<String,Integer> mapColleges = mapCollege(user.getSchoolId()).get(0);
            boolean flag =true;

            int j=0;
            for (Classes classes : classesList) {
                j++;
                if(mapColleges.containsKey(classes.getCollegeName().trim())){
                    classes.setCollegeId(mapColleges.get(classes.getCollegeName().trim()));
                    classes.setSchoolId(user.getSchoolId());
                }
                else {
                    flag = false;
                    resultBean.setCode(1);
                    resultBean.setMsg("第"+j+"条数据的学院名称有误"+classes.getCollegeName());
                    break;
                }
            }
            if (flag) {
                this.classesService.addBatch(classesList);
                resultBean.setCode(0);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("导入失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/ImportFileCollege", method = RequestMethod.POST)
    public ResultBean ImportFileCollege(@RequestParam("excelFile")MultipartFile excelFile, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        String fileName = "";
        String filepath = getUploadPath();
        try {
            if (excelFile != null){
                String filename=excelFile.getOriginalFilename();
                fileName = "college_"+getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath + File.separator + fileName)));
                System.out.println(filepath + File.separator + fileName);
                out.write(excelFile.getBytes());
                out.flush();
                out.close();
            }
            ReadExcelCollege readExcel = new ReadExcelCollege();
            List<College> collegeList = readExcel.importExcel(filepath + File.separator + fileName);
            boolean flag =true;
            List<College> colleges = this.collegeService.findCollegeBySchool(user.getSchoolId());
            Set<String> collegeName = new HashSet<>();
            for (College college:colleges){
                collegeName.add(college.getCollegeName());
            }

            int j=0;
            for (College college : collegeList) {
                j++;
                if(!collegeName.contains(college.getCollegeName())){
                    college.setSchoolId(user.getSchoolId());
                }
                else {
                    flag = false;
                    resultBean.setCode(1);
                    resultBean.setMsg("第"+j+"条数据的学院名称重复");
                    break;
                }
            }
            if (flag) {
                this.collegeService.addBatch(collegeList);
                resultBean.setCode(0);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("导入失败"+e.getMessage());
        }
        return resultBean;
    }
}