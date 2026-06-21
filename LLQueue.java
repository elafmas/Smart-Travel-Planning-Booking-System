package projectds;

public class LLQueue<E> {

    static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LLQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;
        } else {
            rear.setNext(newest);
        }
        rear = newest;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null;
        }
        return answer;
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int s = size();

        for (int i = 0; i < s; i++) {
            E ele = dequeue();
            System.out.println(ele);
            enqueue(ele);
        }
    }

    // Method 1: Display booking queue 
    public void viewBookingsQueue() {
        if (isEmpty()) {
            System.out.println("No reservations in the queue.");
        } else {
            int s = size();
            System.out.println("\n===== Reservation Queue =====");

            for (int i = 0; i < s; i++) {
                Reservation reservation = (Reservation) dequeue();

                System.out.println("#" + reservation.getBookingID()
                        + "  |  " + reservation.getCustomerName());

                enqueue((E) reservation);
            }

            System.out.println("================================\n");
        }
    }

    // Method 2: search reservation by ID in the queue
    public Reservation searchBookingByID(int bookingID) {
        int s = size();
        Reservation foundReservation = null;

        for (int i = 0; i < s; i++) {
            Reservation reservation = (Reservation) dequeue();
            if (reservation.getBookingID() == bookingID) {
                foundReservation = reservation;
            }
            enqueue((E) reservation);
        }

        return foundReservation;
    }

    // Method 3: Process next reservation 
    public void handleNextBooking() {
        if (isEmpty()) {
            System.out.println("No reservations to process.");
        } else {
            Reservation reservation = (Reservation) dequeue();
            System.out.println("Processing reservation...");
            System.out.println(reservation);
            reservation.confirmBooking();
            System.out.println("Reservation queue has been updated!");
        }
    }

    // Method 5: Calculate total revenue from all reservations in queue
    public double calculateTotalRevenue() {

        int s = size();
        double totalRevenue = 0.0;

        for (int i = 0; i < s; i++) {
            Reservation reservation = (Reservation) dequeue();
            totalRevenue += reservation.getTotalPrice();
            enqueue((E) reservation);
        }

        return totalRevenue;
    }

    public double averageNightsPerBooking() {
        double total = 0;
        int count = 0;
        Node<E> current = front;
        while (current != null) {
            if (current.getElement() instanceof Reservation) {
                Reservation r = (Reservation) current.getElement();
                total += r.getNumberOfNights();
                count++;
            }
            current = current.getNext();
        }
        return (count == 0) ? 0 : total / count;
    }

}
