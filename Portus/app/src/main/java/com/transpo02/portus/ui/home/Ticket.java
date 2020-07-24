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
    
    // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    public Ticket(){
    }
    //Constructor
    public Ticket(String ticketnum, String fname, String lname, String dept, String time, int door,
                  String gate, boolean carryOn, boolean cargo,int passengers){
        this.ticketnum=ticketnum;
        this.fname=fname;
        this.lname=lname;
        this.dept=dept;
        this.time=time;
        this.door=door;
        this.gate=gate;
        this.carryOn=carryOn;
        this.cargo=cargo;
        this.passengers=passengers;
    }
}
