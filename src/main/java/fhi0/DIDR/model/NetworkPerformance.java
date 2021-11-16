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
    @Column(nullable = true, length = 64)
    private String image;

    @Transient
    public String getPhotosImagePath() {
        if (image == null){ return null;}

        return "/performance-photos/" + id + "/" + image;
    }

    private Long userId;

    public NetworkPerformance() {
    }

//    public NetworkPerformance(String date, String name, String location, String ratePerformance, String ticketId, Image performanceImage, Long userId) {
//        this.date = date;
//        this.name = name;
//        this.location = location;
//        this.ratePerformance = ratePerformance;
//        this.ticketId = ticketId;
//        this.performanceImage = performanceImage;
//        this.userId = userId;
//    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
