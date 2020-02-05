package edu.mum.cs.altimetrik.colleges.schoolservice.utils;

import edu.mum.cs.altimetrik.colleges.schoolservice.dto.SearchItem;
import org.springframework.beans.factory.annotation.Value;

public class GovApi {
    @Value("${api.key}")
    static String apiKey;
    public static String parseApiUrl(String predominantDegrees, int year , int pageSize,int zipCode , String distance){
        String formattedZip = String.format("%05d", zipCode);
        String url = "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant="+ predominantDegrees +"&fields=id,school.name,"+ year +".student.size&per_page=" + pageSize+ "&zip="+ formattedZip +"&distance=" + distance + "&api_key=dr6fglRaiMGkPXFF3FPhDSYgLK3BsATh0nFY0ePZ";
        return  url;

    }

    public static String parseApiUrl(String predominantDegrees, int year , int pageSize,int page ,int zipCode , String distance){
        String formattedZip = String.format("%05d", zipCode);
        String url = "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant="+ predominantDegrees +"&fields=id,school.name,"+ year +".student.size&per_page=" + pageSize+ "&page="+ page+"&zip="+ formattedZip +"&distance=" + distance + "&api_key=dr6fglRaiMGkPXFF3FPhDSYgLK3BsATh0nFY0ePZ";
        return  url;

    }

    public static String parseApiUrl(SearchItem item){
        return parseApiUrl(item.getPredominantDegrees(),item.getYear() , item.getPageSize(),item.getZipCode() , item.getDistance());
    }
    public static String parseApiUrl(SearchItem item,int page){
        return parseApiUrl(item.getPredominantDegrees(),item.getYear() , item.getPageSize(),page,item.getZipCode() , item.getDistance());
    }
}
