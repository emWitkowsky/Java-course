import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {
    private ArrayList<Home> offers;

    public OfferList() {
        offers = new ArrayList<>();
    }

    public void addHome(Home home) {
        this.offers.add(home);
    }

    public void addStock() {
        this.addHome(new House("Kwiatowa", 1, "Gdansk", "80-100", 100, 100000, LocalDate.of(2023, 11, 7), 100));
        this.addHome(new House("Lipowa", 2, "Olsztyn", "85-100", 120, 120000, LocalDate.of(2022, 5, 6), 110));
        this.addHome(new House("Brzozowa", 3, "Gdansk", "90-000", 140, 140000, LocalDate.of(2025, 3, 4), 120));
        this.addHome(new House("Nowa", 4, "Warszawa", "95-293", 160, 160000, LocalDate.of(2025, 12, 8), 200));
        this.addHome(new House("Stara", 5, "Warszawa", "10-123", 180, 180000, LocalDate.of(2027, 8, 2), 210));

        this.addHome(new Flat("Ogrodowa", 6, "Gdansk", "70-123", 110, 800000, LocalDate.of(2020, 7, 1), 150, 8));
        this.addHome(new Flat("Lesna", 7, "Warszawa", "75-842", 111, 1060000, LocalDate.of(2019, 6, 2), 160, 5));
        this.addHome(new Flat("Morska", 8, "Gdansk", "80-241", 90, 700000, LocalDate.of(2028, 5, 3), 170, 10));
        this.addHome(new Flat("Słoneczna", 9, "Gdansk", "85-123", 34, 1170000, LocalDate.of(2027, 4, 4), 180, 14));
        this.addHome(new Flat("Zielona", 10, "Gdansk", "90-482", 70, 190000, LocalDate.of(2026, 3, 5), 190, 11));
        this.addHome(new Flat("Jesienna", 11, "Olsztyn", "95-294", 97, 1210000, LocalDate.of(2025, 2, 6), 200, 4));
        this.addHome(new Flat("Sucharskiego", 6, "Olsztyn", "10-239", 104, 430000, LocalDate.of(2024, 1, 7), 210, 1));
    }

    public ArrayList<Home> filterHomeOffers(Predicate<Home> predicate) {
        ArrayList<Home> filteredHomes = new ArrayList<>();

        for (Home home : offers)
            if (predicate.test(home)) {
                filteredHomes.add(home);
            }
        return filteredHomes;
    }

}
