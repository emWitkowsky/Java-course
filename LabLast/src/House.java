import java.time.LocalDate;

public final class House extends Home {
    private int plotArea;

    public House(String street, int homeNumber, String city, String zipCode, int area, int price, LocalDate offerDate, int plotArea) {
        super(street, homeNumber, city, zipCode, area, price, offerDate);
        this.plotArea = plotArea;
    }

    @Override
    public String toString() {
        return "House" + '\n' +
                "street: " + street + '\n' +
                "homeNumber: " + homeNumber + '\n' +
                "city: " + city + '\'' + '\n' +
                "zipCode: " + zipCode + '\n' +
                "area: " + area + '\n' +
                "price: " + price + '\n' +
                "offerDate: " + offerDate + '\n' +
                "plotArea: " + plotArea + '\n';
    }

}
