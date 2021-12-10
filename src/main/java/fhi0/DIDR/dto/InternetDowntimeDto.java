package fhi0.DIDR.dto;

import lombok.Data;

@Data
public class InternetDowntimeDto {
    private String date;
    private String name;
    private String day;
    private String location;
    private String link;
    private double duration;

}