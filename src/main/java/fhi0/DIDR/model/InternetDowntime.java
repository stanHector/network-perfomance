package fhi0.DIDR.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "downtimes")
@Data
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


}