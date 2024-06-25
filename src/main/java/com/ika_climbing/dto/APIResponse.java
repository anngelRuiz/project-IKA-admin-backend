package com.ika_climbing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ika_climbing.exceptions.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {

    private String status;
    private List<ErrorResponse> errors;
    private T results;

}
