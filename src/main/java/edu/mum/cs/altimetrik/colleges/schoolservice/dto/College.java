package edu.mum.cs.altimetrik.colleges.schoolservice.dto;

public class College {
    Long id;
    String schoolName;
    Integer schoolSize;

    public College() {
    }

    public College(Long id, String schoolName, Integer schoolSize) {
        this.id = id;
        this.schoolName = schoolName;
        this.schoolSize = schoolSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolSize() {
        return schoolSize;
    }

    public void setSchoolSize(Integer schoolSize) {
        this.schoolSize = schoolSize;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", schoolSize='" + schoolSize + '\'' +
                '}';
    }
}

