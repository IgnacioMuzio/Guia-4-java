import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class VideoStore {

    //region Colecciones
    private ArrayList<Movie> moviesList;

    private ArrayList<Client> clientsList;

    private ArrayList<Loan> loansList;


    //endregion

    //region Constructor

    public VideoStore() {
        this.moviesList = new ArrayList<>();
        this.clientsList = new ArrayList<>();
        this.loansList = new ArrayList<>();
    }

    //endregion


    //region Metodos para gestionar dichas colecciones
    public void addMovie(Movie newMovie) {
        moviesList.add(newMovie);
    }

    public void addClient(Client newClient) {
        clientsList.add(newClient);
    }

    public Movie searchMovie(String titleS) {
        boolean flag = false;
        int i = 0;
        Movie searched = null;

        while (i < moviesList.size() && flag == false) {
            if (moviesList.get(i).getTitle().equals(titleS)) {
                searched = moviesList.get(i);
                flag = true;
            } else i++;
        }
        return searched;
    }

    public boolean checkStock(String titleS) {
        boolean flag = false;
        Movie check = searchMovie(titleS);

        if (check != null && check.getStock() > 0) {
            flag = true;
        }

        return flag;
    }

    public Client searchClient(String name) {
        boolean flag = false;
        int i = 0;
        Client searched = null;

        while (i < clientsList.size() && flag == false) {
            if (clientsList.get(i).getName().equals(name)) {
                searched = clientsList.get(i);
                flag = true;
            } else i++;

        }
        return searched;
    }

    public void addLoan(Loan loan) {
        loansList.add(loan);
        searchMovie(loan.getMovie().getTitle()).loanMovie();
    }

    public Loan getLoanById(int id) {
        boolean flag = false;
        int i = 0;
        Loan searched = null;

        while (i < loansList.size() && flag == false) {
            if (loansList.get(i).getId() == id) {
                searched = loansList.get(i);
                flag = true;
            } else i++;

        }
        return searched;
    }

    public String getLoansByClient(String name) {
        String list = "";

        for (Loan loan : loansList) {
            if (loan.getClient().getName().equals(name)) {
                list += loan.toString();
            }
        }
        return list;
    }

    public boolean returnLoanById(int id) {
        Loan returned = getLoanById(id);
        if(returned!=null){
            returned.setReturned(true);
            searchMovie(returned.getMovie().getTitle()).returnMovie();
        }
        return (returned!=null);
    }

    public String getMovies() {
        return "VideoStore{" +
                "moviesList=" + moviesList+
                '}';
    }

    public String getMovie(String titleS) {
        String movieString;
        if (searchMovie(titleS) != null) {
            movieString = searchMovie(titleS).toString();
        } else movieString = "NO SE ENCONTRÓ LA PELICULA";
        return movieString;
    }



    public String getClients() {
        return "VideoStore{" +
                "clientsList=" + clientsList +
                '}';
    }

    public String getClient(String nameS) {
        String clientString;
        if (searchClient(nameS) != null) {
            clientString = searchClient(nameS).toString();
        } else clientString = "NO SE ENCONTRÓ EL CLIENTE";
        return clientString;
    }

    public String getActiveLoansByClient(String name){
        String list="";

        for(Loan loan:loansList){
            if(loan.getClient().getName().equals(name) && !loan.isReturned()){
                list+=loan.toString();
            }
        }
        return list;
    }

    public String getLast10ByClient(String name){
        String list = "";
        if (searchClient(name) != null) {
            int i = loansList.size()-1 ;
            int j = 0;
            while (i >=0 && j < 10) {
                if (loansList.get(i).getClient().getName().equals(name)) {
                    j++;
                    list += loansList.get(i).toString();
                }
                i--;
            }

        }return list;}

    public String getLoansForToday(){
        String list="";
        for(Loan loan : loansList){
            if(loan.getReturnDay().equals(LocalDate.now())){
                list+=loan.toString();
            }
        }
        return list;
    }

    public String getLoans() {
        return "VideoStore{" +
                "loansList=" + clientsList +
                '}';
    }

    public String getActiveLoans() {
        String list = "";

        for (Loan loan : loansList) {
            if (!loan.isReturned()) {//si no se devolvio retorna falso,
                list += loan.toString();
            }// entonces ponemos el ! para que lo pase a true y asi cumple la condicion
        }
        return list;
    }

    public String getMostPopularMovies(){
        String list="";
        Collections.sort(moviesList);
        if(moviesList.size()<=3){
            list=moviesList.toString();
        }else {
            for(int i=0;i<3;i++){
                list+=moviesList.get(i).toString();
            }
        }
        return list;
    }

    public String getMostPopularByGenre(String genre){
        ArrayList<Movie> mostPopular = new ArrayList<>();
        String list;
        for (Movie movie : moviesList){
            if(movie.getGenre().equals(genre)){
                mostPopular.add(movie);
            }
        }
        Collections.sort(mostPopular);
        list = mostPopular.toString();
        return list;
    }
    //endregion
}




