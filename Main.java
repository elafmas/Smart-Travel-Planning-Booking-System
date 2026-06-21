package projectds;

import java.util.Scanner;

public class Main {

    static SinglyLinkedList<TravelPlace> places = new SinglyLinkedList<>();
    static SinglyLinkedList<Hotel> hotels = new SinglyLinkedList<>();
    static LLQueue<Reservation> reservationQueue = new LLQueue<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        fillSampleData();
        printWelcomeBanner();

        int option = 0;

        do {
            printMenu();
            option = input.nextInt();
            System.out.println();

            switch (option) {

                case 1:
                    searchPlaceByCity();
                    break;

                case 2:
                    displayAllPlaces();
                    break;

                case 3:
                    displayBusinessPlaces();
                    break;

                case 4:
                    countPlacesByCountry();
                    break;

                case 5:
                    viewAllHotels();
                    break;

                case 6:
                    displayMostExpensiveHotel();
                    break;

                case 7:
                    createNewReservation();
                    break;

                case 8:
                    viewReservationQueue();
                    break;

                case 9:
                    displayNextReservation();
                    break;

                case 10:
                    findReservationByID();
                    break;

                case 11:
                    processNextReservation();
                    break;

                case 12:
                    calculateTotalRevenue();
                    break;

                case 13:
                    displayAverageNights();
                    break;

                case 14:
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

            System.out.println();

        } while (option != 14);
    }

    // --------------------------------------------------
    // WELCOME
    // --------------------------------------------------
    public static void printWelcomeBanner() {

        System.out.println("\n==============================================");
        System.out.println("                 WELCOME TO                   ");
        System.out.println("           SMART TRAVEL SYSTEM                ");
        System.out.println("==============================================\n");

    }

    // --------------------------------------------------
    // MENU
    // --------------------------------------------------
    public static void printMenu() {

        System.out.println("\n==============================================");
        System.out.println("            SMART TRAVEL BOOKING MENU          ");
        System.out.println("==============================================");

        System.out.println("  [1]  Search Travel Place by City");
        System.out.println("  [2]  Display All Travel Places");
        System.out.println("  [3]  Display Business Places Only");
        System.out.println("  [4]  Count Places by Country");

        System.out.println("----------------------------------------------");

        System.out.println("  [5]  View All Hotels");
        System.out.println("  [6]  Show Most Expensive Hotel");

        System.out.println("----------------------------------------------");

        System.out.println("  [7]  Create New Reservation");
        System.out.println("  [8]  View Reservation Queue");
        System.out.println("  [9]  Display Next Reservation");
        System.out.println("  [10] Find Reservation by Record");
        System.out.println("  [11] Process Next Reservation");
        System.out.println("  [12] Calculate Total Revenue");
        System.out.println("  [13] Average Nights per Reservation");

        System.out.println("----------------------------------------------");

        System.out.println("  [14] Exit");
        System.out.println("==============================================");
        System.out.print("Enter your choice: ");
    }

    // --------------------------------------------------
    // CASE 1 — Search by City
    // --------------------------------------------------
    public static void searchPlaceByCity() {
        input.nextLine();
        System.out.print("Enter city name: ");
        String cityName = input.nextLine();

        TravelPlace place = places.findCityDestination(cityName);

        if (place == null) {
            System.out.println("No travel place found.");
        } else {
            System.out.println(place);
        }
    }

    // --------------------------------------------------
    // CASE 2 — Show all places
    // --------------------------------------------------
    public static void displayAllPlaces() {
        if (places.isEmpty()) {
            System.out.println("No travel places available.");
        } else {
            places.printList();
        }
    }

    // --------------------------------------------------
    // CASE 3 — Business Places
    // --------------------------------------------------
    public static void displayBusinessPlaces() {
        SinglyLinkedList<TravelPlace> list = places.businessList();
        if (list.isEmpty()) {
            System.out.println("No business places found.");
        } else {
            list.printList();
        }
    }

    // --------------------------------------------------
    // CASE 4 — Count country
    // --------------------------------------------------
    public static void countPlacesByCountry() {
        input.nextLine();
        System.out.print("Enter country name: ");
        String country = input.nextLine();

        int count = places.countByCountry(country);
        System.out.println("Places in " + country + ": " + count);
    }

    // --------------------------------------------------
    // CASE 5 — Hotels
    // --------------------------------------------------
    public static void viewAllHotels() {
        hotels.printList();
    }

    // --------------------------------------------------
    // CASE 6 — Expensive Hotel
    // --------------------------------------------------
    public static void displayMostExpensiveHotel() {
        Hotel h = hotels.mostExpensiveHotel();
        if (h == null) {
            System.out.println("No hotels available.");
        } else {
            System.out.println("Most expensive hotel:\n" + h);
        }
    }

    // Helper — Get hotel by ID
    public static Hotel getHotelByID(int id) {
        SinglyLinkedList.Node<Hotel> current = hotels.head;
        while (current != null) {
            if (current.getElement().getHotelID() == id) {
                return current.getElement();
            }
            current = current.getNext();
        }
        return null;
    }

    // --------------------------------------------------
    // CASE 7 — Create Reservation
    // --------------------------------------------------
    public static void createNewReservation() {
        input.nextLine();
        System.out.print("Enter guest name: ");
        String guestName = input.nextLine();

        System.out.println("\nAvailable Travel Places:");
        places.printList();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        TravelPlace place = places.findCityDestination(city);
        if (place == null) {
            System.out.println("Invalid city.");
            return;
        }

        System.out.println("\nAvailable Hotels:");
        hotels.printList();

        System.out.print("Enter hotel ID: ");
        int hotelID = input.nextInt();
        Hotel hotel = getHotelByID(hotelID);

        if (hotel == null) {
            System.out.println("Invalid hotel ID.");
            return;
        }

        System.out.print("Enter number of nights: ");
        int nights = input.nextInt();

        Reservation r = new Reservation(guestName, place, hotel, nights);
        reservationQueue.enqueue(r);

        System.out.println("\nReservation created:");
        System.out.println(r);
    }

    // --------------------------------------------------
    // CASE 8 — View Queue
    // --------------------------------------------------
    public static void viewReservationQueue() {
        reservationQueue.viewBookingsQueue();
    }

    // --------------------------------------------------
    // CASE 9 — Next Reservation
    // --------------------------------------------------
    public static void displayNextReservation() {
        Reservation r = reservationQueue.first();
        if (r == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println(r);
        }
    }

    // --------------------------------------------------
    // CASE 10 — Search by record
    // --------------------------------------------------
    public static void findReservationByID() {
        System.out.print("Enter record number: ");
        int id = input.nextInt();

        Reservation r = reservationQueue.searchBookingByID(id);

        if (r == null) {
            System.out.println("No reservation found.");
        } else {
            System.out.println(r);
        }
    }

    // --------------------------------------------------
    // CASE 11 — Process next
    // --------------------------------------------------
    public static void processNextReservation() {
        reservationQueue.handleNextBooking();
    }

    // --------------------------------------------------
    // CASE 12 — Revenue
    // --------------------------------------------------
    public static void calculateTotalRevenue() {
        double revenue = reservationQueue.calculateTotalRevenue();
        System.out.println("Total revenue: SR " + revenue);
    }

    // --------------------------------------------------
    // CASE 13 — Avg nights
    // --------------------------------------------------
    public static void displayAverageNights() {
        double avg = reservationQueue.averageNightsPerBooking();
        System.out.println("Average nights per reservation: " + avg);
    }

    // --------------------------------------------------
    // SAMPLE DATA
    // --------------------------------------------------
  
    
	public static void fillSampleData() {

    // ================================
    //        TOURIST PLACES
    // ================================
    places.addLast(new TouristPlace(
            "Madrid", "Spain", "Europe",
            "Lively city known for plazas and museums.",
            1700.0,
            "Retiro Park, Gran Vía",
            false));

    places.addLast(new TouristPlace(
            "Rome", "Italy", "Europe",
            "Historic city with famous ancient landmarks.",
            2000.0,
            "Colosseum, Trevi Fountain",
            false));

    places.addLast(new TouristPlace(
            "Seoul", "South Korea", "Asia",
            "Modern city with shopping streets and palaces.",
            1900.0,
            "Myeongdong, Gyeongbokgung Palace",
            true));


    // ================================
    //        BUSINESS PLACES
    // ================================
    places.addLast(new BusinessPlace(
            "Berlin", "Germany", "Europe",
            "City known for conferences and business events.",
            2100.0,
            "Technology & Industry",
            true));

    places.addLast(new BusinessPlace(
            "Toronto", "Canada", "North America",
            "Major center for finance and services.",
            2300.0,
            "Finance & Services",
            true));

    places.addLast(new BusinessPlace(
            "Doha", "Qatar", "Middle East",
            "Growing city with many new projects.",
            1600.0,
            "Energy & Investment",
            true));


    // ================================
    //           HOTELS
    //   (ONE hotel per city)
    // ================================
    hotels.addLast(new Hotel("Madrid Central Hotel", "Madrid", 4, 420.0));
    hotels.addLast(new Hotel("Roma Grand Hotel", "Rome", 5, 580.0));
    hotels.addLast(new Hotel("Seoul City View Hotel", "Seoul", 5, 500.0));
    hotels.addLast(new Hotel("Berlin Business Hotel", "Berlin", 4, 450.0));
    hotels.addLast(new Hotel("Toronto Lakeside Hotel", "Toronto", 5, 610.0));
    hotels.addLast(new Hotel("Doha Skyline Hotel", "Doha", 5, 550.0));


    // ================================
    //        SAMPLE RESERVATIONS
    // ================================
    reservationQueue.enqueue(new Reservation(
            "Sara Mohammed",
            places.findCityDestination("Madrid"),
            getHotelByID(1),
            3));

    reservationQueue.enqueue(new Reservation(
            "Khalid Hassan",
            places.findCityDestination("Rome"),
            getHotelByID(2),
            4));

    reservationQueue.enqueue(new Reservation(
            "Lina Yousuf",
            places.findCityDestination("Doha"),
            getHotelByID(6),
            2));
}}