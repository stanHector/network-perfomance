package fhi0.DIDR.dto;

public class TicketDto {
    private String day;
    private String date;
    private String name;
    private String location;
    private String numberOfServiceDeskTicketsRecieved;
    private String numberOfServiceDeskTicketsResolved;
    private String numberOfUsersOnTheNetwork;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
}
