package com.springboot.web.model.dto.request;

import com.springboot.web.constants.DisclosureStatusType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequest {
    private String name;
    private DisclosureStatusType disclosureStatusType;
}
