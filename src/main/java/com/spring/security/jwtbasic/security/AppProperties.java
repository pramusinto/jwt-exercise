package com.spring.security.jwtbasic.security;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class AppProperties {

    @Value("${url.job.all}")
    private String findAllJobs;

    @Value("${url.job.positions}")
    private String findJobPositions;

}
