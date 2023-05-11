package com.spring.security.jwtbasic.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JobResponse {
    private String id;
    private String type;
    private String url;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String how_to_apply;
    private String company_logo;
    private String description;
}
