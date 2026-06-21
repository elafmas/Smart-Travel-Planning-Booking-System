package projectds;

public class TouristPlace extends TravelPlace {

    private String mainAttractions;
    private boolean requiresVisa;

    public TouristPlace(String placeName, String country, String region, String details,
                        double baseCost, String mainAttractions, boolean requiresVisa) {

        super(placeName, country, region, details, baseCost);
        this.mainAttractions = mainAttractions;
        this.requiresVisa = requiresVisa;
    }

    public String getMainAttractions() {
        return mainAttractions;
    }

    public void setMainAttractions(String mainAttractions) {
        this.mainAttractions = mainAttractions;
    }

    public boolean isRequiresVisa() {
        return requiresVisa;
    }

    public void setRequiresVisa(boolean requiresVisa) {
        this.requiresVisa = requiresVisa;
    }

    @Override
    public String getType() {
        return "Tourist";
    }

    @Override
    public String toString() {
        return super.toString()
                + "Main Attractions : " + mainAttractions + "\n"
                + "Visa Required    : " + (requiresVisa ? "Yes" : "No") + "\n"
                + "-------------------------------------";
    }
}

