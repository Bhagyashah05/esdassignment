package com.bhagya.esdassignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductReq(
        @JsonProperty("name")
        String name,
        @JsonProperty("price")
        float price

) {
    }
