```java
public abstract class Animal {
    protected int age;
    public void eat() {
        System.out.println("Animal is eating")
    }
    public abstract String getName()
}

public class Swan extends Animal {
    public String getName() {
        return "Swan"
    }
}
```

Interfaces

```java
public abstract interface CanBurrow {
    public static final int MINIMUM_DEPTH = 2;
    public abstract int getMaximumDepth();
}
```

```java
public class FieldMouse implements CanBurrow {
    public int getMaximumDepth() { // signature matches interface method
        return 10;
    }
}
```

Metody domyślne w interfejsach to są konkretne metody których implementacje musimy dostarczyć w interfejsie

```java
public abstract interface IsWarmBlooded {
    public abstract boolean hasScales();
    public default double getTemperature() {
        return 10.0;
    }
}
```

Kazda klasa która implementuje IsWarmBlooded moze uzyc jej metody lub ją nadpisać

Wyrazenia Lambda

```java
public class Animal {
    private String name;
    private double height;
    private double weight;
    private double length;

    public Animal(String name, double height, double weight, double length) {
        this.name = name;
        this.height = height;
        this.weight = weigth;
        this.length = length;
    }

    public double getHeight() {return height}
    public double getWeight() {return weight}
    public double getLength() {return length}
    public String toString() {
        return "Animal name:" + name + ",height:" + height + ", weight:" + weight + ", length:" + length;
    }
}
```

```java
public class MasaiMara {
    private ArrayList<Animal> natureReserve;
    public MasaiMara() {
        natureReserve = new ArrayList<>();
    }

    public void populateReserve(){
        natureReserve.add(new Animal("Lion",110,150,210));
        //dodanie innych zwierzat
    }
}
```

```java
public ArrayList<Animal> getAnimalsHigher(double height) {
    ArrayList<Animal> animals = new ArrayList<>();
    for (Animal animal: natureReserve) {
        if (animal.getHeight() > height) animals.add(animal);
    }
    return animals;
}

public ArrayList<Animal> getAnimalsHigherAndLonger(double height, double length) {
    ArrayList<Animal> animals = new ArrayList<>();
    for (Animal animal : natureReserve) {
        if (animal.getHeight() > height && animal.getLength() > length) animals.add(animal)
    }
    return animals
}
```

```java
java.util.function //wazne w którym pakiecie

public interface Predicate<T> {
    boolean test(T t); //metoda test
}
```

```java
public class MasaiMara {
    private ArrayList<Animal> natureReserve;
    public MasaiMara() { natureReserve = new ArrayList<>(); }
    public void populateReserve()

    public ArrayList<Animal> getAnimals(Predicate<Animal> check) {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal : natureReserve) {
            if (check.test(animal)) animals.add(animal)
        }
        return animals;
    }
}
```

Przekazanie tego predykatu jest to implementacja dynamiczna metody test predykatu.

funkcja lambda

```java
(Animal a) -> {return a.getHeight(); }

//short version
a -> a.getHeight();
```

Data i czas

```java
LodalDate // just date
LocalTime // just time
LocalDateTime // date and time

// none have timezones

class Period

Period annually = Period.ofYears

class Duration
```

pass by value / przekazywanie przez wartość

```java
public static void main(String[] args) {
    String name = "Webby";
    speak(name);
    System.out.println(name) // Webby
}

public static void speak(String name) {
    name = "Sparky"; //niezalezne zmienne
}
```

Przeciązanie metod pojawia sie gdy mamy pare metod o tej samej nazwie i roznych typach

```java
public void fly(int numMiles) {
    System.out.println("int")
}

public void fly(short numFeet {
    System.out.println("short")
})
```

Wywołanie fly((short) 1) printuje short;

autoboxing

for glide(1, 2)

kolejność:
exact match by type public String glide(int i, int k) ->
larger primitive type public String glide(long i, long k) ->
Autoboxed type public String glide(Integer i, Integer k) ->
Varargs public String glide(int... nums)

W przypadku typów referencyjnych zawsze mozemy skorzystać z wyzszych typów w hierarchii dziedziczenia (z klasy nadrzędnej)
