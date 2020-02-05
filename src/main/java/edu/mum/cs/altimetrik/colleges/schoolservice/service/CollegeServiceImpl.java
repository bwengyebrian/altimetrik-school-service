package edu.mum.cs.altimetrik.colleges.schoolservice.service;

import edu.mum.cs.altimetrik.colleges.schoolservice.dto.College;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.SearchItem;
import edu.mum.cs.altimetrik.colleges.schoolservice.feign.CollegesFeign;
import edu.mum.cs.altimetrik.colleges.schoolservice.utils.GovApi;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegesFeign collegesFeign;

    @Override
    public College getCollegeFromJson() {
        return null;
    }

    @Override
    public List<College> getColleges(SearchItem item) {

        int year = 2017;
        List<College> colleges = new ArrayList<>();

        String govApiUrl = GovApi.parseApiUrl(item);
        URI apiUrl = URI.create(govApiUrl);
        String collegesString = collegesFeign.getSchools(apiUrl).getBody();
        JSONObject jsonObject = new JSONObject(collegesString);
        JSONObject pageInfo = jsonObject.getJSONObject("metadata");
        int total = pageInfo.getInt("total");
        int perPage = pageInfo.getInt("per_page");
        int pages = total/perPage;
        for (int j = 1; j<= pages; j++) {
            String govApiUrl2 = GovApi.parseApiUrl(item,j);
            URI apiUrl2 = URI.create(govApiUrl);
            String collegesString2 = collegesFeign.getSchools(apiUrl).getBody();

            JSONArray collegesJson = jsonObject.getJSONArray("results");
            for (int i = 0; i < collegesJson.length(); i++) {
                JSONObject collegeJsonObj = collegesJson.getJSONObject(i);
                College college = new College();
                college.setId(collegeJsonObj.getLong("id"));
                college.setSchoolName(collegeJsonObj.getString("school.name"));
                college.setSchoolSize(collegeJsonObj.getInt(year + ".student.size"));
                colleges.add(college);
            }
        }
        return colleges;
    }

    @Override
    public boolean isValidCollegeSearch(SearchItem item) {
        return true;
    }


}
