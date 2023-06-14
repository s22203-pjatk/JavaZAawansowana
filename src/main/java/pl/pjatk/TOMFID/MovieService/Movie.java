package pl.pjatk.TOMFID.MovieService;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private boolean is_available;

    public Movie() {
    }

    public Movie(String name, Category category, boolean isAvailable) {
        this.name = name;
        this.category = category;
        is_available = isAvailable;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", is_available=" + is_available +
                '}';
    }
}
