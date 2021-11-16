package fhi0.DIDR.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "performance")
public class NetworkPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;
    private String name;
    private String location;
    private String ratePerformance;
    private String ticketId;
    private String imgUrl;

    private Long userId;

    public NetworkPerformance() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
