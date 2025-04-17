package info;

public class Location {
    private Float x; // Поле не может быть null
    private double y;
    private float z;

    public Location() {
    }

    private void validate() {
        if (x == null) {
            throw new IllegalArgumentException("Координата X не может быть null.");
        }
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
        validate();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
