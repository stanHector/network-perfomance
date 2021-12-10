package fhi0.DIDR.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String date;
    private String name;
    private String location;
    private String numberOfServiceDeskTicketsRecieved;
    private String numberOfServiceDeskTicketsResolved;
    private String numberOfUsersOnTheNetwork;

    private Long userId;


}
