import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();

        //region hardcodeo
        Client cliente1 = new Client("Jorge","2232432424","Calle 123");
        Client cliente2 = new Client ("Marcos","223343432","Calle 234");
        Client cliente3 = new Client ("Nacho","223445433","Calle 678");
        Movie peli1= new Movie("Titanic", "2/5/1998","3:14",EAudience.G.getName(), EGenre.DRAMA.getName(),"EEUU","Un barco choca jej",10);
        Movie peli2= new Movie("Ted", "2/5/1998","3:14",EAudience.G.getName(), EGenre.COMEDIA.getName(),"EEUU","Un barco choca jej",10);
        Movie peli3= new Movie("Rapido y furioso", "2/5/1998","3:14",EAudience.G.getName(), EGenre.ACCION.getName(),"EEUU","Un barco choca jej",10);
        Movie peli4= new Movie("Harry potter 1", "2/5/1998","3:14",EAudience.G.getName(), EGenre.ACCION.getName(),"EEUU","Un barco choca jej",10);
        Movie peli5= new Movie("Harry potter 2", "2/5/1998","3:14",EAudience.G.getName(), EGenre.ACCION.getName(),"EEUU","Un barco choca jej",10);
        Movie peli6= new Movie("Titanic 2", "2/5/1998","3:14",EAudience.G.getName(), EGenre.DRAMA.getName(),"EEUU","Un barco choca de nuevo",10);
        Movie peli7= new Movie("Titanic 3", "2/5/1998","3:14",EAudience.G.getName(), EGenre.DRAMA.getName(),"EEUU","Un barco choca jej ahora es personal",10);
        Movie peli8= new Movie("Wall e", "2/5/1998","3:14",EAudience.G.getName(), EGenre.AVENTURA.getName(),"EEUU","Un barco choca jej ahora es personal",10);
        Movie peli9= new Movie("Smile", "2/5/1998","3:14",EAudience.G.getName(), EGenre.HORROR.getName(),"EEUU","malarda",10);
        Movie peli10= new Movie("Scream", "2/5/1998","3:14",EAudience.G.getName(), EGenre.HORROR.getName(),"EEUU","Un barco choca jej ahora es personal",10);
        Movie peli11= new Movie("Indiana Jones", "2/5/1998","3:14",EAudience.G.getName(), EGenre.AVENTURA.getName(),"EEUU","Un barco choca jej ahora es personal",10);
        Movie peli12= new Movie("La vida del pichicho", "2/5/1998","3:14",EAudience.G.getName(), EGenre.DOCUMENTAL.getName(),"EEUU","Un barco choca jej ahora es personal",10);

        videoStore.addClient(cliente1);videoStore.addClient(cliente2);videoStore.addClient(cliente3);
        videoStore.addMovie(peli1);videoStore.addMovie(peli2);videoStore.addMovie(peli3);videoStore.addMovie(peli4);videoStore.addMovie(peli5);videoStore.addMovie(peli6);videoStore.addMovie(peli7);videoStore.addMovie(peli8);videoStore.addMovie(peli9);videoStore.addMovie(peli10);videoStore.addMovie(peli11);videoStore.addMovie(peli12);
        //endregion

        menuGral(videoStore);
    }

    public static void menuGral(VideoStore video){
        int option;

        Consola.escribir("Wenas");
        do{
        Consola.escribir("-------------");
        Consola.escribir("1.Peliculas");
        Consola.escribir("2.Clientes");
        Consola.escribir("3.Alquileres");
        Consola.escribir("0.Salir");
        option=Consola.leerInt("Ingrese una opcion...");
        Consola.limpiar();
        }while (option>3 || option<0);

        switch (option){
            case 1: menuMovies(video);
                    break;
            case 2: menuClients(video);
                    break;
            case 3: menuLoans(video);
                    break;
            case 0: Consola.escribir("Cerrando");
                    break;}
    }

    //region Peliculas

    //region Menu peliculas
    public static void menuMovies(VideoStore video){
        int option;
        do{
        do{
            Consola.escribir("-------------");
            Consola.escribir("1.Agregar peli");
            Consola.escribir("2.Ver lista de pelis");
            Consola.escribir("3.Ver detalles de una peli");
            Consola.escribir("4.Titulos mas alquilados");
            Consola.escribir("5.Titulos mas alquilados por genero");
            Consola.escribir("0.Salir");
            option=Consola.leerInt("Ingrese una opcion...");
            Consola.limpiar();
        }while (option>5 || option<0);

        switch (option){
            case 1: ;
                agregarPeli(video);
                break;
            case 2: ;
                Consola.escribir(video.getMovies());
                break;
            case 3:;
                Consola.escribir(searchAMovie(video));
                break;
            case 4:;
                Consola.escribir(video.getMostPopularMovies());
                break;
            case 5:
                Consola.escribir(mostPopularByGenre(video));
                break;
            case 0: Consola.escribir("Volviendo al menu general");
                break;}}while(option!=0);
        menuGral(video);
    }
    //endregion

    //region case 1
    public static void agregarPeli(VideoStore video){
        Consola.escribir("Complete los datos de la pelicula que desea agregar");
        String title = Consola.leerString("Ingrese el titulo de la pelicula: ");
        if(video.getMovie(title)!=null){
            String date = Consola.leerString("Ingrese la fecha de lanzamiento: ");
            String duration = Consola.leerString("Ingrese la duracion de la pelicula: ");
            String audienceRating = pickAAudience();
            String genre = pickAGenre();
            String country = Consola.leerString("Ingrese el pais donde fue producida:");
            String description = Consola.leerString("Ingrese una breve descripcion de la pelicula: ");
            int stock = Consola.leerInt("Ingrese la cantidad inicial de copias con las que cuenta: ");
            Consola.limpiar();
            Movie newMovie = new Movie(title,date,duration,audienceRating,genre,country,description,stock);
            video.addMovie(newMovie);
            Consola.escribir("Pelicula agregada con exito...");
            menuMovies(video);
        }
    }

    public static String pickAAudience(){
        int option;
        List<EAudience> audiences= Arrays.asList(EAudience.values());
        do{
            Consola.escribir("Seleccione la audiencia: ");
            Consola.escribir("1.G");
            Consola.escribir("2.PG");
            Consola.escribir("3.PG-13");
            Consola.escribir("4.R");
            Consola.escribir("5.NC-17");
            Consola.escribir("6.UNRATED");
            option = Consola.leerInt("Ingrese la audiencia deseada: ");
            Consola.limpiar();
            if(option<0 || option >6){
                Consola.escribir("Ingrese una opcion valida...");
            }
        }while(option<0 || option >6);
        return audiences.get(option-1).getName();
    }

    public static String pickAGenre(){
        int option;
        List<EGenre> genres= Arrays.asList(EGenre.values());
        do{
            Consola.escribir("Seleccione la audiencia: ");
            Consola.escribir("1.ACCION");
            Consola.escribir("2.AVENTURA");
            Consola.escribir("3.COMEDIA");
            Consola.escribir("4.DRAMA");
            Consola.escribir("5.HORROR");
            Consola.escribir("6.DOCUMENTAL");
            option = Consola.leerInt("Ingrese el genero deseado: ");
            Consola.limpiar();
            if(option<0 || option >6){
                Consola.escribir("Ingrese una opcion valida...");
            }
        }while(option<0 || option >6);
        return genres.get(option-1).getName();
    }

    //endregion

    //region case 3

    public static String searchAMovie (VideoStore video){
        String salir="";
        String titleS;
        String movie="No se encontro...";
        do{
            titleS =Consola.leerString("Ingrese el titulo que desea buscar: ");
            if(video.searchMovie(titleS)!=null){
                movie=video.searchMovie(titleS).toString();
            }else{
                Consola.escribir("Pelicula no encontrada...");
                salir=Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return movie;
    }

    //endregion

    //region case 5

    public static String mostPopularByGenre(VideoStore video){
        String genre = pickAGenre();
        return video.getMostPopularByGenre(genre);
    }

    //endregion

    //endregion

    //region Clientes


    //region Menu clientes
    public static void menuClients(VideoStore video){
        int option;
        do{
            do{
                Consola.escribir("-------------");
                Consola.escribir("1.Agregar cliente");
                Consola.escribir("2.Ver lista de clientes");
                Consola.escribir("3.Ver detalles de un cliente");
                Consola.escribir("4.Ver ultimos 10 alquileres de un cliente");
                Consola.escribir("0.Salir");
                option=Consola.leerInt("Ingrese una opcion...");
                Consola.limpiar();
            }while (option>4 || option<0);

            switch (option){
                case 1: ;
                    addClient(video);
                    break;
                case 2: ;
                    Consola.escribir(video.getClients());
                    break;
                case 3:;
                    Consola.escribir(searchAClient(video));
                    break;
                case 4:;
                    Consola.escribir(getLast10byClient(video));
                    break;
                case 0: Consola.escribir("Volviendo al menu general");
                    break;}}while(option!=0);
        menuGral(video);
    }

    //endregion

    //region case 1

    public static void addClient(VideoStore video){
        String name = Consola.leerString("Ingrese el nombre completo del cliente.");
        String number = Consola.leerString("Ingrese el numero telefonico del cliente");
        String adress = Consola.leerString("Ingrese la direccion del cliente: ");
        Client cliente = new Client(name,number,adress);
        video.addClient(cliente);
    }
    //endregion

    //region case 3
    public static String searchAClient (VideoStore video){
        String salir="";
        String nameS;
        String client="No se encontro...";
        do{
            nameS = Consola.leerString("Ingrese el nombre del cliente que desea buscar: ");
            if(video.searchClient(nameS)!=null){
                client=video.searchClient(nameS).toString();
            }else{
                Consola.escribir("Cliente no encontrado...");
                salir=Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return client;
    }

    //endregion

    //region case 4

    public static String getLast10byClient(VideoStore video){
        String salir="";
        String nameS;
        String last10="No se encontro...";
        do{
            nameS = Consola.leerString("Ingrese el nombre del cliente que desea buscar: ");
            if(video.searchClient(nameS)!=null){
                last10 =video.getLast10ByClient(nameS);
            }else{
                Consola.escribir("Cliente no encontrado...");
                salir=Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return last10;
    }

    //endregion

    //endregion

    //region Alquileres

    //region MenuALquileres
    public static void menuLoans(VideoStore video){
        int option;
        do{
            do{
                Consola.escribir("-------------");
                Consola.escribir("1.Crear Alquiler");
                Consola.escribir("2.Ver alquileres vigentes");
                Consola.escribir("3.Ver alquileres que deberian devolverse hoy");
                Consola.escribir("4.Devolver alquiler.");
                Consola.escribir("0.Salir");
                option=Consola.leerInt("Ingrese una opcion...");
                Consola.limpiar();
            }while (option>5 || option<0);

            switch (option){
                case 1: ;
                    addLoan(video);
                    break;
                case 2: ;
                    Consola.escribir(video.getActiveLoans());
                    break;
                case 3:;
                    Consola.escribir(video.getLoansForToday());
                    break;
                case 4:
                    returnLoan(video);
                    break;
                case 0: Consola.escribir("Volviendo al menu general");
                    break;}}while(option!=0);
        menuGral(video);
    }
    //endregion

    //region case 1

    public static void addLoan(VideoStore video){
        Consola.escribir("Alquiler: ");
        Movie movie=null;
        Client client = null;
        int option = 0;
        int day,month,year;
        do{
            String titleS=Consola.leerString("Ingrese el titulo de la pelicula que desea alquilar");
            movie= video.searchMovie(titleS);
            if(movie==null){
                Consola.escribir("Pelicula no encontrada, intente de nuevo.");
            }else if(!video.checkStock(titleS)){
                Consola.escribir("La pelicula no cuenta con stock en este momento... Intente con otra...");
                movie=null;
            }
        }while(movie==null);

        do{
            String nameS = Consola.leerString("Ingrese el nombre del cliente que alquila: ");
            client = video.searchClient(nameS);
            if(client == null){

               do{
                   Consola.escribir("Cliente no encontrado...");
                   Consola.escribir("1.Intentar de nuevo.");
                   Consola.escribir("2.Agregar a la base.");
                   option = Consola.leerInt("Ingrese la opcion deseada: ");
                   Consola.limpiar();
                   if(option!=1 || option!=2){
                       Consola.escribir("Ingrese una opcion valida...");
                   }else if(option == 2){
                       client=addClient(video,nameS);
                       Consola.escribir("Cliente agregado con exito...");
                   }
               }while(option>2 || option<1);
            }
        }while(client == null);
        day=Consola.leerInt("Ingrese el dia a devolver...");
        month= Consola.leerInt("Ingrese el mes...");
        year = Consola.leerInt("Ingrese el año...");

        Loan loan = new Loan(movie,client, LocalDate.of(year,month,day));
        video.addLoan(loan);
    }

    public static Client addClient(VideoStore video, String name){
        String number = Consola.leerString("Ingrese el numero telefonico del cliente");
        String adress = Consola.leerString("Ingrese la direccion del cliente: ");
        Client cliente = new Client(name,number,adress);
        video.addClient(cliente);
        return cliente;
    }

    //endregion

    //region case 4
    public static void returnLoan(VideoStore video) {
        int option;
        do {
            Consola.escribir(video.getActiveLoans());
            option = Consola.leerInt("Ingrese el id del alquiler que desea devolver...");
        }while(!video.returnLoanById(option));
        if(video.getLoanById(option).isReturned()){
            Consola.escribir("Alquiler devuelvo con exito!");
        }
    }


    //endregion

    //endregion

}