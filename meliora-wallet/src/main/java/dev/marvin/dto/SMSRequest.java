package dev.marvin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SMSRequest {
    @Builder.Default
    @JsonProperty("from")
    private String from = "TIARACONECT";

    @JsonProperty("to")
    private String to;

    @JsonProperty("message")
    private String message;
}
