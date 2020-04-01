package com.platzi.jobsearch.model.entities;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class JobPosition {
    private String id;
    private String type;
    private String url;
    @SerializedName(value = "created_at")
    private String createAt;
    private String company;
    @SerializedName(value = "company_url")
    private String companyUrl;
    private String title;
    private String location;
    private String description;
    @SerializedName(value = "company_logo")
    private String companyLogo;
}
