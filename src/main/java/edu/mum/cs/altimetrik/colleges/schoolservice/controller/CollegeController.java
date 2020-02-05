package edu.mum.cs.altimetrik.colleges.schoolservice.controller;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.College;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.SearchItem;
import edu.mum.cs.altimetrik.colleges.schoolservice.feign.CollegesFeign;
import edu.mum.cs.altimetrik.colleges.schoolservice.service.CollegeService;
import edu.mum.cs.altimetrik.colleges.schoolservice.utils.GovApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegesFeign collegesFeign;

    @Autowired
    CollegeService collegeService;


    @ApiOperation(value = "search colleges", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/search")
        ResponseEntity<?> searchCollege(@RequestBody SearchItem item){
        System.out.println(item);
        item.setPageSize(10);
        if(!collegeService.isValidCollegeSearch(item)){
            return new ResponseEntity<>("bad request",HttpStatus.BAD_REQUEST);
        }
        List<College> colleges = collegeService.getColleges(item);
        return new ResponseEntity<>(colleges, HttpStatus.OK);
        }

}
