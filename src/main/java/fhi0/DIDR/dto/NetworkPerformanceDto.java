package fhi0.DIDR.dto;
import lombok.Data;

import java.io.Serializable;

@Data
public class NetworkPerformanceDto {
    private String date;
    private String name;
    private String location;
    private String ratePerformance;
    private String ticketId;
    private String imageFile;
}
