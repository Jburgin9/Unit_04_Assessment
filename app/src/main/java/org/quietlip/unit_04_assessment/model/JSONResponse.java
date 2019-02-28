package org.quietlip.unit_04_assessment.model;

import java.util.List;

public class JSONResponse {
    private String status;
    private List<Animals> message;

    public String getStatus() {
        return status;
    }

    public List<Animals> getMessage() {
        return message;
    }
}
