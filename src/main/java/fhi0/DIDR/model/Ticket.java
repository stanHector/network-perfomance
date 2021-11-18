package fhi0.DIDR.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;
    private String name;
    private String location;
    private String numberOfServiceDeskTicketsRecieved;
    private String numberOfServiceDeskTicketsResolved;
    private String numberOfUsersOnTheNetwork;

    private Long userId;


}
