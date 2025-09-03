
public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false;
    }

    public void bookTicket(String seatNumber, double price) {
        if (isBooked) {
            System.out.println(" Ticket already booked. House Full!");
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println(" Ticket booked for " + movieName);
            System.out.println("Seat: " + seatNumber + ", Price: " + price);
        }
    }

    public void displayTicket() {
        if (isBooked) {
            System.out.println(" Ticket Details");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println(" Ticket not booked yet!");
        }
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket("Dragon");

        t1.displayTicket();
        t1.bookTicket("A10", 120.0);
        t1.bookTicket("B10", 120.0); 
        t1.displayTicket();
    }
}