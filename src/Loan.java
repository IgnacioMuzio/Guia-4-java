import java.io.Serial;
import java.time.LocalDate;


public class Loan {

    //region Atributos
    private Movie movie;
    private Client client;
    private LocalDate loanDay;

    private LocalDate returnDay;

    private boolean returned;

    private int id;

    private static Integer cantLoans = 0;

    //endregion

    //region Constructores

    public Loan(Movie movie, Client client, LocalDate returnDay) {
        this.movie = movie;
        this.client = client;
        this.loanDay = LocalDate.now();
        this.returnDay = returnDay;
        this.returned = false;
        this.id = cantLoans;
        cantLoans++;
    }


    //endregion

    //region Getters,Setters, toString

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getLoanDay() {
        return loanDay;
    }

    public void setLoanDay(LocalDate loanDay) {
        this.loanDay = loanDay;
    }

    public LocalDate getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(LocalDate returnDay) {
        this.returnDay = returnDay;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "movie=" + movie.getTitle() +
                ", client=" + client.getName() +
                ", loanDay=" + loanDay +
                ", returnDay=" + returnDay +
                ", returned=" + returned +
                ", id=" + id +
                '}';
    }

    //endregion

}
