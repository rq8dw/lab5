package product;

import info.Coordinates;
import info.Difficulty;

import java.time.ZonedDateTime;

public class LabWork implements Comparable<LabWork> {
    private Long id; // Поле не может быть null, больше 0, уникальное, генерируется автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private ZonedDateTime creationDate; // Поле не может быть null, генерируется автоматически*/
    private float minimalPoint; // Значение поля должно быть больше 0
    private float maxPoint; // Значение поля должно быть больше 0
    private Difficulty difficulty; // Поле не может быть null */
    private Person author; // Поле может быть null



    public  LabWork(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public float getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(float minimalPoint) {
        this.minimalPoint = minimalPoint;

    }

    public float getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(float maxPoint) {
        this.maxPoint = maxPoint;

    }

   public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", maxPoint=" + maxPoint +
                ", difficulty=" + difficulty +
                ", author=" + author +
                '}';
    }

    @Override
    public int compareTo(LabWork other) {
        return Long.compare(this.id, other.id);
    }

}


