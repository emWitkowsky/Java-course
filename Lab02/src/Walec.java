import java.text.DecimalFormat;

public class Walec {
    private int radius;
    private int height;

    public Walec(int initialRadius, int initialHeight) {
        this.radius = initialRadius > 0 ? initialRadius : this.radius;
        this.height = initialHeight > 0 ? initialHeight : this.height;
    }

    public Walec() {};

    public void setRadius(int newRadius) {
        this.radius = newRadius > 0 ? newRadius : this.radius;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight > 0 ? newHeight : this.height;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getHeight() {
        return this.height;
    }

    public double areaOfBase() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double areaOfSide() {
        return 2 * Math.PI * this.radius * this.height;
    }

    public double areaOfTotal() {
        return 2 * areaOfBase() + areaOfSide();
    }

    public double capacity() {
        return areaOfBase() * this.height;
    }
}
