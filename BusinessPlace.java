package projectds;

public class BusinessPlace extends TravelPlace {

    private String industryField;
    private boolean hasConferenceHall;

    public BusinessPlace(String placeName, String country, String region, String details,
                         double baseCost, String industryField, boolean hasConferenceHall) {

        super(placeName, country, region, details, baseCost);
        this.industryField = industryField;
        this.hasConferenceHall = hasConferenceHall;
    }

    public String getIndustryField() {
        return industryField;
    }

    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    public boolean hasConferenceHall() {
        return hasConferenceHall;
    }

    public void setHasConferenceHall(boolean hasConferenceHall) {
        this.hasConferenceHall = hasConferenceHall;
    }
 
    @Override
    public String getType() {
        return "Business";
    }

    @Override
    public String toString() {
        return super.toString()
                + "Industry Field     : " + industryField + "\n"
                + "Conference Hall    : " + (hasConferenceHall ? "Available" : "Not Available") + "\n"
                + "-------------------------------------";
    }
}
