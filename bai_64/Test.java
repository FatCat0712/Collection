import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Set<String> tickets = new HashSet<>();
        TicketBox ticketBox = new TicketBox(tickets);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("---- Lucky Wheel ----");
            System.out.println("How can we help u ?");
            System.out.println("1. Add tickets");
            System.out.println("2. Remove a ticket");
            System.out.println("3. Print all the tickets");
            System.out.println("4. Check a ticket");
            System.out.println("5. Clear the ticket box");
            System.out.println("6. Print the number of tickets");
            System.out.println("7. Get a ticket");
            System.out.println("8. Save tickets to a file");
            System.out.println("9. Get ticket from a file");
            System.out.println("0. Exit");
            System.out.println("---------------------");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("How many tickets: ");
                    int ticketNum = sc.nextInt();
                    sc.nextLine();
                    Random rd = new Random();
                    for(int i = 0; i < ticketNum; i++){
                        String ticketId = "00"+rd.nextInt(1,100);
                        if(!ticketBox.checkTicketExists(ticketId)){
                            ticketBox.addTicket(ticketId);
                        }

                    }
                    System.out.println("Created "+ ticketNum + " tickets");
                    break;
                case 2:
                    System.out.println("Enter the ticket ID");
                    String removeTicket = sc.nextLine();
                    ticketBox.removeTicket(removeTicket);
                    break;
                case 3:
                    ticketBox.printAllTickets();
                    break;
                case 4:
                    System.out.println("Enter the ticket ID");
                    String checkTicket = sc.nextLine();
                    System.out.println(ticketBox.checkTicketExists(checkTicket));
                    break;
                case 5:
                    ticketBox.clearTicketBox();
                    break;
                case 6:
                    System.out.println(ticketBox.numberOfTickets());
                    break;
                case 7:
                    System.out.println("Your ticket is: "+ ticketBox.getTicket());
                    break;
                case 8:
                    System.out.println("Enter file name: ");
                    String fileName = sc.nextLine();
                    ticketBox.saveTicketsToAFile(fileName);
                    break;
                case 9:
                    System.out.println("Enter file name: ");
                    String fileRead = sc.nextLine();
                    ticketBox.getTicketsFromFile(fileRead);
                    break;
                case 0:
                    flag = false;
                    System.out.println("Bye");
                    break;
            }
        }
    }
}
