package com.xiaoyuanpe.pojo;

public class ScorePerWeek {
    private String clazz;
    private float score;

    public ScorePerWeek(String clazz, float score){
        this.clazz = clazz;
        this.score = score;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
