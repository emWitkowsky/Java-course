import java.time.LocalDate;

public abstract sealed class Home permits House, Flat {
    protected String street;
    protected int homeNumber;
    protected String city;
    protected String zipCode;
    protected int area;
    protected int price;
    protected LocalDate offerDate;

    public Home(String street, int homeNumber, String city, String zipCode, int area, int price, LocalDate offerDate) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.area = area;
        this.price = price;
        this.offerDate = offerDate;
    }
}
