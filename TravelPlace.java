
package projectds;


public abstract class TravelPlace {

    private int placeID;
    private String city;
    private String country;
    private String region;
    private String info;
    private double price;
    private static int counter = 0;

    public TravelPlace(String city, String country, String region, String info, double price) {
        this.placeID = ++counter;
        this.city = city;
        this.country = country;
        this.region = region;
        this.info = info;
        this.price = price;
    }


    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int id) {
        this.placeID = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCount() {
        return counter;
    }

    public static void setCount(int count) {
        TravelPlace.counter = count;
    }

    // سيطبّقه الساب كلاس
    public abstract String getType();

    @Override
    public String toString() {
        return
            "\n------ Travel Place Information ------\n" +
            "Place ID      : " + placeID + "\n" +
            "City          : " + city + "\n" +
            "Country       : " + country + "\n" +
            "Region        : " + region + "\n" +
            "Type          : " + getType() + "\n" +
            "Description   : " + info + "\n" +
            "Flight Price  : SR " + price + "\n" +
            "--------------------------------------\n";
    }
}
