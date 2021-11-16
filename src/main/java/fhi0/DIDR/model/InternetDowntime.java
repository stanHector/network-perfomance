package fhi0.DIDR.model;

import javax.persistence.*;

@Entity
@Table(name = "downtimes")
public class InternetDowntime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String name;
    private String location;
    private String link;
    private double duration;
    private double totalDurationInHours;
    private String imgUrl;

    private Long userId;

    public InternetDowntime() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getTotalDurationInHours() {
        return totalDurationInHours;
    }

    public void setTotalDurationInHours(double totalDurationInHours) {
        this.totalDurationInHours = totalDurationInHours;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}