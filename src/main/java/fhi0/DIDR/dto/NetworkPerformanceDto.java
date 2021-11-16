package fhi0.DIDR.dto;

import org.springframework.web.multipart.MultipartFile;

public class NetworkPerformanceDto {
    private String date;
    private String name;
    private String location;
    private String ratePerformance;
    private String ticketId;
    private MultipartFile performanceImage;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRatePerformance() {
        return ratePerformance;
    }

    public void setRatePerformance(String ratePerformance) {
        this.ratePerformance = ratePerformance;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public MultipartFile getPerformanceImage() {
        return performanceImage;
    }

    public void setPerformanceImage(MultipartFile performanceImage) {
        this.performanceImage = performanceImage;
    }
}
