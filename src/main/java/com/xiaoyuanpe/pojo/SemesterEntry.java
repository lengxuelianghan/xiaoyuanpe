package com.xiaoyuanpe.pojo;

public class SemesterEntry{
    private Integer id;

    private String collegeId;

    private Integer score;

    private String name;

    public SemesterEntry() {
    }

    public SemesterEntry(Integer id, String collegeId, Integer score, String name) {
        this.id = id;
        this.collegeId = collegeId;
        this.score = score;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Object o) {
//        SemesterEntry p = (SemesterEntry)o;
//        if(p.score>this.score){
//            return 1;
//        }
//        else if(p.score<this.score){
//            return -1;
//        }
//        return 0;
//    }
}
