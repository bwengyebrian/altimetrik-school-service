package edu.mum.cs.altimetrik.colleges.schoolservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "school-service",url = "http://temporaly")
public interface CollegesFeign {
    @GetMapping
    ResponseEntity<String> getSchools(URI uri);
}
