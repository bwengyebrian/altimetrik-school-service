package edu.mum.cs.altimetrik.colleges.schoolservice.dto;

public class SearchItem {
    int zipCode;
    String distance;
    int year;
    String predominantDegrees;
    int pageSize;

    public SearchItem() {
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPredominantDegrees() {
        return predominantDegrees;
    }

    public void setPredominantDegrees(String predominantDegrees) {
        this.predominantDegrees = predominantDegrees;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "zipCode=" + zipCode +
                ", distance='" + distance + '\'' +
                ", year=" + year +
                ", predominantDegrees='" + predominantDegrees + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}
