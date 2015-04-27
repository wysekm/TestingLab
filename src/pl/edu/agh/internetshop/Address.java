package pl.edu.agh.internetshop;

public class Address {
    private final String name;
    private final String streetAndHomeNr;
    private final String code;
    private final String city;

    public Address(String name, String streetAndHomeNr, String code, String city) {
        this.name = name;
        this.streetAndHomeNr = streetAndHomeNr;
        this.code = code;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getStreetAndHomeNr() {
        return streetAndHomeNr;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }
}
