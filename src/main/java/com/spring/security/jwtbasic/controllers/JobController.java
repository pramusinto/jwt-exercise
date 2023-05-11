package com.spring.security.jwtbasic.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.spring.security.jwtbasic.Util.RestTemplateUtil;
import com.spring.security.jwtbasic.payload.request.JobRequest;
import com.spring.security.jwtbasic.payload.response.JobResponse;
import com.spring.security.jwtbasic.security.AppProperties;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/job")
public class JobController {

    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    private final Gson gson;

    @GetMapping("/list")
    public ResponseEntity<JobResponse[]> getListJob(){
        final String urlFindAllJobs = appProperties.getFindAllJobs();
        String body = RestTemplateUtil.getResponseFromUrl(restTemplate, urlFindAllJobs);
        return ResponseEntity.ok(gson.fromJson(body, JobResponse[].class));
    }

    @GetMapping("/position")
    public ResponseEntity<JobResponse> getPosition(JobRequest request){
        final String urlFindJobPositions = appProperties.getFindJobPositions();
        String body = RestTemplateUtil.getResponseFromUrl(restTemplate, urlFindJobPositions+request.getId());
        return ResponseEntity.ok(gson.fromJson(body, JobResponse.class));
    }
}
