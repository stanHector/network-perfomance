package fhi0.DIDR.dto;

import lombok.Data;

@Data
public class TicketDto {
    private String day;
    private String date;
    private String name;
    private String location;
    private String numberOfServiceDeskTicketsRecieved;
    private String numberOfServiceDeskTicketsResolved;
    private String numberOfUsersOnTheNetwork;

}
