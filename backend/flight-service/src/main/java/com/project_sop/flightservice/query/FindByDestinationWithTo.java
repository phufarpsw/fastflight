package com.project_sop.flightservice.query;

import lombok.Data;

@Data
public class FindByDestinationWithTo {
    private String from;
    private String to;
    private String dateFrom;
    private String dateTo;

    public FindByDestinationWithTo(String from, String to, String dateFrom, String dateTo) {
        this.from = from;
        this.to = to;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
