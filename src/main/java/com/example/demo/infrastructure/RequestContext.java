package com.example.demo.infrastructure;


import lombok.Data;

@Data
public class RequestContext {

    private String isoCode;

    public String getIsoCode() {
        return isoCode == null ? "en" : isoCode;
    }
}
