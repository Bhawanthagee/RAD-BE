package com.rad.radbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocSubmitTrack {
    private String id;
    private String title;
    private String submissionDate;
    private String officer;
    private String status;
    private String remarks;
    private String approvalDate;
}
