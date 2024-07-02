import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("The programme is a Home offer manager. You can add offers. You can also print home offers filtered by various artibutes.");
        Scanner console = new Scanner(System.in);

        OfferList offerList = new OfferList();
        offerList.addStock();

        boolean running = true;
        while(running) {
            menu3();
            int chosenOption = console.nextInt();
            switch (chosenOption) {
                case 1 -> menuHouse(console, offerList, running);
                case 2 -> menuFlat(console, offerList, running);
                case 0 -> running = false;
            }
        }
    }
    public static void menu1() {
        System.out.println("1. Add house");
        System.out.println("2. Show viable houses");
        System.out.println("3. Show houses in a city bigger than a specific area");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menu2() {
        System.out.println("1. Add flat");
        System.out.println("2. Show viable flats");
        System.out.println("3. Show flats in a city cheaper than and on higher floor than a specific price and floor");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menu3() {
        System.out.println("1. Manage houses");
        System.out.println("2. Manage flats");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menuHouse(Scanner console, OfferList offerList, Boolean running) {
        menu1();
        int chosenOption = console.nextInt();
        switch (chosenOption) {
            case 1 -> addHouse(offerList, console);
            case 2 -> showViableHouses(offerList);
            case 3 -> showHousesInCityBiggerThan(offerList, console);
            case 0 -> running = false;
        }
    }

    public static void menuFlat(Scanner console, OfferList offerList, Boolean running) {
        menu2();
        int chosenOption = console.nextInt();
        switch (chosenOption) {
            case 1 -> addFlat(offerList, console);
            case 2 -> showViableFlats(offerList);
            case 3 -> showFlatsInCityCheaperThanAndHigherThan(offerList, console);
            case 0 -> running = false;
        }
    }

    public static void addHouse(OfferList offerList, Scanner console) {
        System.out.println("Enter street: ");
        String street = console.next();
        System.out.println("Enter home number: ");
        int homeNumber = console.nextInt();
        System.out.println("Enter city: ");
        String city = console.next();
        System.out.println("Enter zip code: ");
        String zipCode = console.next();
        System.out.println("Enter area: ");
        int area = console.nextInt();
        System.out.println("Enter price: ");
        int price = console.nextInt();
        System.out.println("Enter offer date (year, month, day) with enter after each: ");
        int year = console.nextInt();
        int month = console.nextInt();
        int day = console.nextInt();
        LocalDate givenDate = LocalDate.of(year, month, day);
        System.out.println("Enter plot area: ");
        int plotArea = console.nextInt();
        offerList.addHome(new House(street, homeNumber, city, zipCode, area, price, givenDate, plotArea));
    }

    public static void addFlat(OfferList offerList, Scanner console) {
        System.out.println("Enter street: ");
        String street = console.next();
        System.out.println("Enter home number: ");
        int homeNumber = console.nextInt();
        System.out.println("Enter city: ");
        String city = console.next();
        System.out.println("Enter zip code: ");
        String zipCode = console.next();
        System.out.println("Enter area: ");
        int area = console.nextInt();
        System.out.println("Enter price: ");
        int price = console.nextInt();
        System.out.println("Enter offer date (year, month, day) with enter after each: ");
        int year = console.nextInt();
        int month = console.nextInt();
        int day = console.nextInt();
        System.out.println("Enter flat number: ");
        int flatNumber = console.nextInt();
        System.out.println("Enter floor: ");
        int floor = console.nextInt();
        offerList.addHome(new Flat(street, homeNumber, city, zipCode, area, price, LocalDate.of(year, month, day), flatNumber, floor));
    }

    public static void showViableHouses(OfferList offerList) {
        LocalDate today = LocalDate.now();
        ArrayList<Home> offerListFiltered = offerList.filterHomeOffers(home -> home instanceof House && !home.offerDate.isBefore(today));
        for (Home home : offerListFiltered) {
            System.out.println(home.toString());
        }
    }

    public static void showViableFlats(OfferList offerList) {
        LocalDate today = LocalDate.now();
        ArrayList<Home> offerListFiltered = offerList.filterHomeOffers(home -> home instanceof Flat && !home.offerDate.isBefore(today));
        for (Home home : offerListFiltered) {
            System.out.println(home.toString());
        }
    }

    public static void showHousesInCityBiggerThan(OfferList offerList, Scanner console) {
        System.out.println("Enter city: ");
        String city = console.next();
        System.out.println("Enter area: ");
        int area = console.nextInt();
        ArrayList<Home> offerListFiltered = offerList.filterHomeOffers((home) -> home instanceof House && home.city.equals(city) && home.area >= area);
        for (Home home : offerListFiltered) {
            System.out.println(home.toString());
        }
    }

    public static void showFlatsInCityCheaperThanAndHigherThan(OfferList offerList, Scanner console) {
        System.out.println("Enter city: ");
        String city = console.next();
        System.out.println("Enter price: ");
        int price = console.nextInt();
        System.out.println("Enter floor: ");
        int floor = console.nextInt();
        ArrayList<Home> offerListFiltered = offerList.filterHomeOffers((home) -> home instanceof Flat && home.city.equals(city) && home.price >= price && ((Flat) home).getFloor() >= floor);
        for (Home home : offerListFiltered) {
            System.out.println(home.toString());
        }
    }
}