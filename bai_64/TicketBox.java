import java.io.*;
import java.util.Random;
import java.util.Set;

public class TicketBox implements Serializable {
    private Set<String> ticketBox;

    public TicketBox(Set<String> ticketBox) {
        this.ticketBox = ticketBox;
    }

    public void addTicket(String ticket){
        if(!ticket.isEmpty()){
            this.ticketBox.add(ticket);
        }
    }

    public void removeTicket(String ticket){
        if(!ticket.isEmpty()){
            this.ticketBox.remove(ticket);
        }
    }

    public boolean checkTicketExists(String ticket){
        return this.ticketBox.contains(ticket);
    }

    public void clearTicketBox(){
        this.ticketBox.clear();
    }

    public int numberOfTickets(){
        return this.ticketBox.size();
    }

    public String getTicket(){
        Random rd = new Random();
        int ticket = rd.nextInt(this.ticketBox.size());
        return this.ticketBox.toArray()[ticket].toString();
    }
    public String printAllTickets(){
        return this.ticketBox.toString();
    }

    public void saveTicketsToAFile(String file) throws IOException{
        File f = new File(file);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(String e: ticketBox){
                oos.writeObject(e);
            }
            oos.flush();
            oos.close();

        }
        catch (IOException e){
           throw new IOException();
        }
    }

    public void getTicketsFromFile(String file) throws IOException {
        File f = new File(file);
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(fis.available() > 0){
                String s = (String)ois.readObject();
                ticketBox.add(s);
            }
        }catch (IOException | ClassNotFoundException e) {
            throw new IOException();
        }
    }

}
