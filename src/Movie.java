import java.time.LocalDate;

public class Movie implements Comparable<Movie>{

    //region Atributos
    private String title;
    private String releaseDate;

    private String duration;

    private String audienceRating;

    private String genre;

    private String country;

    private String description;

    private int stock;

    private int loans;

    //endregion

    //region Constructor

    public Movie() {
    }

    public Movie(String title, String releaseDate, String duration, String audienceRating, String genre, String country, String description, int stock) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.audienceRating = audienceRating;
        this.genre = genre;
        this.country = country;
        this.description = description;
        this.stock = stock;
        this.loans = 0;
    }

    //endregion

    //region Getters,Setters,toString

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLoans() {
        return loans;
    }

    public void setLoans(int loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", audienceRating='" + audienceRating + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", loans=" + loans +
                '}';
    }

    public boolean loanMovie() {
        boolean flag = false;

        if (stock > 0) {
            stock--;
            loans++;
            flag = true;
        }
        return flag;
    }

    public void returnMovie(){
        stock++;
    }

    @Override
    public int compareTo(Movie movie) {
        int i;
        if(this.loans<movie.getLoans() || movie==null)
            i=1;
        else if (this.loans==movie.getLoans())
            i=0;
        else
            i=-1;
        return i;
    }


    //endregion
}
