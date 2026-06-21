
package projectds;
public class Hotel {

    private int hotelID;
    private String hotelName;
    private String cityName;
    private int stars;
    private double pricePerNight;
    private static int count = 0;

    public Hotel(String hotelName, String cityName, int stars, double pricePerNight) {
        this.hotelID = ++count;
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Hotel.count = count;
    }

   @Override
public String toString() {

    String starRating = "";
    for (int i = 0; i < stars; i++) {
        starRating += "*";
    }

    return
        "\n------ Hotel Information ------\n" +
        "ID              : " + hotelID + "\n" +
        "Name            : " + hotelName + "\n" +
        "City            : " + cityName + "\n" +
        "Rating          : " + starRating + " (" + stars + " stars)\n" +
        "Price/Night     : SR " + pricePerNight + "\n" +
        "--------------------------------\n";
}
}