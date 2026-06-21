package projectds;

public class SinglyLinkedList<E> {

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

        public void setElement(E e) {
            element = e;
        }

    }

    public Node<E> head;
    public Node<E> tail;
    private int size;

    public SinglyLinkedList() {

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
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> n = new Node<>(e, null);
        if (isEmpty()) {
            head = n;
        } else {
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            E answer = tail.getElement();
            if (size() == 1) {
                head = tail = null;
            } else {
                Node t1 = head;
                Node t2 = null;
                while (t1.getNext() != null) {
                    t2 = t1;
                    t1 = t1.getNext();
                }
                t2.setNext(null);
                tail = t2;
            }
            size--;
            return answer;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node<E> current = head;
        while (current != null) {
            System.out.println(current.element);
            System.out.println("");
            current = current.getNext();
        }
    }

    // Search for place by city name (TravelPlace)
    public TravelPlace findCityDestination(String cityName) {
        Node<E> current = head;
        while (current != null) {
            if (current.element instanceof TravelPlace) {
                TravelPlace place = (TravelPlace) current.element;
                if (place.getCity().equalsIgnoreCase(cityName)) {
                    return place;
                }
            }
            current = current.getNext();
        }
        return null;
    }

    // Get all business places as a new list
    public SinglyLinkedList<TravelPlace> businessList() {
        SinglyLinkedList<TravelPlace> businessList = new SinglyLinkedList<>();

        Node<E> current = head;

        while (current != null) {
            if (current.element instanceof BusinessPlace) {
                BusinessPlace businessPlace = (BusinessPlace) current.element;
                businessList.addLast(businessPlace);
            }
            current = current.getNext();
        }

        return businessList;
    }

    // Count places by country
    public int countByCountry(String country) {
        Node<E> current = head;
        int count = 0;

        while (current != null) {
            if (current.element instanceof TravelPlace) {
                TravelPlace place = (TravelPlace) current.element;
                if (place.getCountry().equalsIgnoreCase(country)) {
                    count++;
                }
            }
            current = current.getNext();
        }

        return count;
    }

    public Hotel mostExpensiveHotel() {
        Node<E> current = head;
        Hotel most = null;

        while (current != null) {
            if (current.getElement() instanceof Hotel) {
                Hotel h = (Hotel) current.getElement();
                if (most == null || h.getPricePerNight() > most.getPricePerNight()) {
                    most = h;
                }
            }
            current = current.getNext();
        }

        return most;
    }

}