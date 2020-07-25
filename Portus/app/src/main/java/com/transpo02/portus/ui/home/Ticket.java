package com.example.portusnav.ui.home;

public class Ticket {
    String id;
    String fname;
    String lname;
    String deptCity;
    String deptTime;
    int door;
    String gate;
    boolean carryOn;
    boolean cargo;
    int passengers;
    
    // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    public Ticket(){
    }
    //Constructor
    public Ticket(String id, String fname, String lname, String deptCity, String deptTime, int door,
                  String gate, boolean carryOn, boolean cargo,int passengers){
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.deptCity=deptCity;
        this.deptTime=deptTime;
        this.door=door;
        this.gate=gate;
        this.carryOn=carryOn;
        this.cargo=cargo;
        this.passengers=passengers;
    }
}
