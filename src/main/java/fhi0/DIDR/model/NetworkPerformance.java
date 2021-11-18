package fhi0.DIDR.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "performance")
@Data
public class NetworkPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String name;
    private String location;
    private String ratePerformance;
    private String ticketId;
    private byte[] imgUrl;
    private Long userId;

}
