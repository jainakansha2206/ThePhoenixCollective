package com.thephoenixcollective.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailContact {

    @JsonProperty("FIELD1")
    private Long field1;

    @JsonProperty("A")
    private String a;

    @JsonProperty("B")
    private String b;

    @JsonProperty("C")
    private String C;

    @JsonProperty("D")
    private String d;

    @JsonProperty("E")
    private String e;

    @JsonProperty("F")
    private String f;


}
