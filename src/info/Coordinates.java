package info;

public class Coordinates {
    private Integer x; // Значение поля должно быть больше -644, Поле не может быть null
    private int y; // Значение поля должно быть больше -695


    public Coordinates(){

    }


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException("Поле x не может быть null.");
        }
        if (x <= -644) {
            throw new IllegalArgumentException("Значение поля x должно быть больше -644.");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y <= -695) {
            throw new IllegalArgumentException("Значение поля y должно быть больше -695.");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}