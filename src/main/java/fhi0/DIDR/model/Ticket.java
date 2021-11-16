package fhi0.DIDR.model;

import javax.persistence.*;

@Entity
@Table(name="tickets")
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

    public Ticket() {
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

    public String getNumberOfServiceDeskTicketsRecieved() {
        return numberOfServiceDeskTicketsRecieved;
    }

    public void setNumberOfServiceDeskTicketsRecieved(String numberOfServiceDeskTicketsRecieved) {
        this.numberOfServiceDeskTicketsRecieved = numberOfServiceDeskTicketsRecieved;
    }

    public String getNumberOfServiceDeskTicketsResolved() {
        return numberOfServiceDeskTicketsResolved;
    }

    public void setNumberOfServiceDeskTicketsResolved(String numberOfServiceDeskTicketsResolved) {
        this.numberOfServiceDeskTicketsResolved = numberOfServiceDeskTicketsResolved;
    }

    public String getNumberOfUsersOnTheNetwork() {
        return numberOfUsersOnTheNetwork;
    }

    public void setNumberOfUsersOnTheNetwork(String numberOfUsersOnTheNetwork) {
        this.numberOfUsersOnTheNetwork = numberOfUsersOnTheNetwork;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
