package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ReadExcel;
import com.xiaoyuanpe.units.ReadExcelClass;
import com.xiaoyuanpe.units.ResultBean;
import com.xiaoyuanpe.units.Utils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public ResultBean ImportFile(@RequestParam Integer sId, @RequestParam Integer cId, @RequestParam Integer ccId,
                                 @RequestParam("excelFile")MultipartFile excelFile, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        String fileName = "";
        System.out.println(12321);
        String filepath = getUploadPath();
        try {
            if (excelFile != null){
                String filename=excelFile.getOriginalFilename();
                fileName = getFileName(filename);
//                File f = new File("C:\\Users\\Administrator\\Desktop"+"\\"+filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath + File.separator + fileName)));
                System.out.println(filepath + File.separator + fileName);
                //FileUtils.writeByteArrayToFile(f, excelFile.getBytes());
                out.write(excelFile.getBytes());
                out.flush();
            }
            ReadExcel readExcel = new ReadExcel();
            List<StudentInfo> studentInfos = readExcel.importExcel(filepath + File.separator + fileName);
            for (StudentInfo studentInfo : studentInfos) {
                System.out.println(studentInfo.getName()+","
                        +studentInfo.getNumber()+","+studentInfo.getPassword()+","+studentInfo.getPhone()
                        +","+studentInfo.getAge()+","+studentInfo.getSex()+","+1);
                User user1 = new User();
                user1.setIdentity("学生");
                user1.setAge(studentInfo.getAge());
                user1.setUserNumber(studentInfo.getNumber());
                user1.setPassword(studentInfo.getPassword());
                user1.setUsername(studentInfo.getName());
                user1.setSchoolId(sId);
                user1.setPhone(studentInfo.getPhone());
                user1.setSex(studentInfo.getSex());
                this.userService.addUser(user1);

                Student student = new Student();
                student.setSchoolId(sId);
                student.setCollegeId(cId);
                student.setClassesId(ccId);
                student.setTerm(studentInfo.getAge());
                student.setStudentName(studentInfo.getName());
                student.setStudentNumber(studentInfo.getNumber());
                student.setSex(studentInfo.getSex());
                this.studentService.addStudent(student);

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
                }
            }
            resultBean.setCode(0);
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
    public ResultBean ImportFileClass(@RequestParam("excelFile")MultipartFile excelFile){
        ResultBean resultBean = new ResultBean();
        String fileName = "";
        String filepath = getUploadPath();
        try {
            List<String> successList = new ArrayList<>();
            List<String> failList = new ArrayList<>();
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
            List<StudentInfo> studentInfos = readExcel.importExcel(filepath + File.separator + fileName);
            List<School> schools = this.schoolService.findSchoolAll();
            List<String> schoolName = new ArrayList<>();
            Map<String,Integer> stringIntegerMap = new HashMap<>();
            for (School school:schools){
                schoolName.add(school.getSchoolName());
                stringIntegerMap.put(school.getSchoolName(), school.getId());
            }
            List<College> colleges = this.collegeService.findCollegeAll();
            List<String> collegelName = new ArrayList<>();
            Map<String,Integer> stringIntegerMap1 = new HashMap<>();
            for (College college:colleges){
                collegelName.add(college.getCollegeName());
                stringIntegerMap1.put(college.getCollegeName(), college.getId());
            }
            for (StudentInfo studentInfo : studentInfos) {
                if (schoolName.contains(studentInfo.getSchool())){
                    if(collegelName.contains(studentInfo.getCollege())){
                        Classes classes = new Classes();
                        classes.setClassName(studentInfo.getClasses());
                        classes.setCollegeId(stringIntegerMap1.get(studentInfo.getCollege()));
                        classes.setSchoolId(stringIntegerMap.get(studentInfo.getSchool()));
                        this.classesService.addClasses(classes);
                        successList.add(studentInfo.getClasses());
                    }
                    else failList.add(studentInfo.getClasses());
                }
                else failList.add(studentInfo.getClasses());
            }
            resultBean.setData(failList);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("导入失败");
        }
        return resultBean;
    }

}
