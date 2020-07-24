package com.example.portusnav.ui.home;

public class Ticket {
    String ticketnum;
    String fname;
    String lname;
    String dept;
    String time;
    int door;
    String gate;
    boolean carryOn;
    boolean cargo;
    int passengers;

    public void Ticket(String ticket, String first, String last, String city, String when, int entry, String fgate, boolean carry, boolean storage, int group){
        ticketnum=ticket;
        fname=first;
        lname=last;
        dept=city;
        time=when;
        door=entry;
        gate=fgate;
        carry=carryOn;
        storage=cargo;
        passengers=group;
    }
    public String getfName(){
        return fname;
    }
    public String getlName(){
        return lname;
    }
    public String getCity(){
        return dept;
    }
    public String getTime(){
        return time;
    }

}
