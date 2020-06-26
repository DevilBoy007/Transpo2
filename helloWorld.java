import java.util.Scanner;
import java.util.IO;

public class Main{
  public static void main(String[] args){
    Scanner cin = new Scanner(System.in);
    char user=' ';
    String ticket=" ";
    System.out.println("Hello World! Let's fix the airports");
    welcome();
    user=cin.nextChar();
    if(user=='x'){System.out.println("Enter your ticket number: ");}
    ticket = cin.nextLine();
    System.out.print("You entered: " + ticket);
  }
}

public static welcome(){
  System.out.println("(x)\tEnter Ticket Number");
  //System.out.println("(x)\t second menu option");
}
