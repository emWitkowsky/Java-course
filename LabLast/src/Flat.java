import java.time.LocalDate;

public final class Flat extends Home {
    private int flatNumber;
    private int floor;

    public Flat(String street, int homeNumber, String city, String zipCode, int area, int price, LocalDate offerDate, int flatNumber, int floor) {
        super(street, homeNumber, city, zipCode, area, price, offerDate);
        this.flatNumber = flatNumber;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Flat" + '\n' +
                "street: " + street + '\n' +
                "homeNumber: " + homeNumber + '\n' +
                "city: " + city + '\'' + '\n' +
                "zipCode: " + zipCode + '\n' +
                "area: " + area + '\n' +
                "price: " + price + '\n' +
                "offerDate: " + offerDate + '\n' +
                "flatNumber: " + flatNumber + '\n' +
                "floor: " + floor + '\n';
    }
}
