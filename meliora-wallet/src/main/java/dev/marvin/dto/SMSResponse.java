package dev.marvin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SMSResponse {

    @JsonProperty("cost")
    private String cost;

    @JsonProperty("mnc")
    private String mnc;

    @JsonProperty("balance")
    private String balance;

    @JsonProperty("msgId")
    private String msgId;

    @JsonProperty("to")
    private String to;

    @JsonProperty("mcc")
    private String mcc;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("status")
    private String status;

    @JsonProperty("statusCode")
    private String statusCode;
}
