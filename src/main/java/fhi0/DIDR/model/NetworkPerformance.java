package fhi0.DIDR.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "performance")
@Data
public class NetworkPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String name;
    private String location;
    private String ratePerformance;
    private String ticketId;
    private byte[] imageFile;
//    private String imageFile;
    private Long userId;

}
