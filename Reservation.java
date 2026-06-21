package projectds;

public class Reservation implements Reservable {

    private int reservationID;
    private String clientName;
    private TravelPlace tripDestination;
    private Hotel stayHotel;
    private int nightsCount;
    private double totalCost;
    private String state;
    private static int seq = 100;

    public Reservation(String clientName, TravelPlace tripDestination, Hotel stayHotel, int nightsCount) {
        this.reservationID = ++seq;
        this.clientName = clientName;
        this.tripDestination = tripDestination;
        this.stayHotel = stayHotel;
        this.nightsCount = nightsCount;
        this.totalCost = calculateTotalPrice();
        this.state = "Pending";
    }

    private double calculateTotalPrice() {
        double flight = tripDestination.getPrice();                     
        double stay = stayHotel.getPricePerNight() * nightsCount;
        return flight + stay;
    }

    @Override
    public void confirmBooking() {
        this.state = "Confirmed";
        System.out.println("Reservation #" + reservationID + " has been confirmed!");
    }

    @Override
    public void cancelBooking() {
        this.state = "Cancelled";
        System.out.println("Reservation #" + reservationID + " has been cancelled!");
    }

    public int getBookingID() {
        return reservationID;
    }

    public void setBookingID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerName() {
        return clientName;
    }

    public void setCustomerName(String clientName) {
        this.clientName = clientName;
    }

    public TravelPlace getDestination() {
        return tripDestination;
    }

    public void setDestination(TravelPlace tripDestination) {
        this.tripDestination = tripDestination;
        this.totalCost = calculateTotalPrice();
    }

    public Hotel getHotel() {
        return stayHotel;
    }

    public void setHotel(Hotel stayHotel) {
        this.stayHotel = stayHotel;
        this.totalCost = calculateTotalPrice();
    }

    public int getNumberOfNights() {
        return nightsCount;
    }

    public void setNumberOfNights(int nightsCount) {
        this.nightsCount = nightsCount;
        this.totalCost = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalCost;
    }

    public String getStatus() {
        return state;
    }

    public void setStatus(String state) {
        this.state = state;
    }

    public static int getCount() {
        return seq;
    }

    public static void setCount(int seq) {
        Reservation.seq = seq;
    }

    @Override
    public String toString() {
        return "\n----------- Reservation Details -----------n"
                + "• Reservation ID : " + reservationID + "\n"
                + "• Client         : " + clientName + "\n"
                + "• Destination    : " + tripDestination.getCity() 
                                       + ", " + tripDestination.getCountry() + "\n"
                + "• Hotel          : " + stayHotel.getHotelName() 
                                       + " [" + stayHotel.getStars() + "⭐]\n"
                + "• Nights         : " + nightsCount + "\n"
                + "• Flight Cost    : SR " + tripDestination.getPrice() + "\n"
                + "• Stay Cost      : SR " + (stayHotel.getPricePerNight() * nightsCount) + "\n"
                + "• Total Cost     : SR " + totalCost + "\n"
                + "• Status         : " + state + "\n"
                + "-------------------------------------------------\n";
    }
}
