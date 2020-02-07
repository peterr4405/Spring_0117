package com.web.beans;


public class javaExam {
    
    private Integer id;
    private Integer score;
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "javaExam{" + "id=" + id + ", score=" + score + ", student=" + student + '}';
    }
    
    
    
    
}
