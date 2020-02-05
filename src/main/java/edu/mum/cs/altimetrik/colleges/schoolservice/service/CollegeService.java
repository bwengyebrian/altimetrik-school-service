package edu.mum.cs.altimetrik.colleges.schoolservice.service;

import edu.mum.cs.altimetrik.colleges.schoolservice.dto.College;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.SearchItem;

import java.util.List;

public interface CollegeService {
    College getCollegeFromJson();
    List<College> getColleges(SearchItem item);
    boolean isValidCollegeSearch(SearchItem item);
}
