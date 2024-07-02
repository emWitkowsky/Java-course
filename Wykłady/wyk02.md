```java
public class Phone {
    private String number;

    public Phone(String number) {
        this.number = number
    }
}
```

m

```java
public class Mouse {
    static int maxLength = 5 // <-- zmienna klasy / zmienna globalna myszy
    private int length; // zmienna instancji
    public void grow(int inches) {
        if (length < maxLength) {
            int newSize = length + inches; // zmienna lokalna
            length = newSize;
        }
    }
}
```

Garbage collector

```java
public class Scope {
    public static void main(String[] args) {
        String one, two;
        one = new String("a");
        two = new String("b");
        one = two
        String three = one
        one = null
    }
}
```
