package product;

import info.*;

public class Person {
    private String name; // Поле не может быть null, Строка не может быть пустой
    private int weight; // Значение поля должно быть больше 0
    private EyeColor eyeColor; // Поле не может быть null
    private HairColor hairColor; // Поле может быть null
    private Country nationality; // Поле не может быть null
    private Location location; // Поле может быть null

    public Person(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 1) {
            throw new IllegalArgumentException("Вес должен быть больше 0.");
        }
        this.weight = weight;

    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;

    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }


}