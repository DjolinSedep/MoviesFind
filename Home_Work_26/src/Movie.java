import java.util.List;

class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Actor> cast;


    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}