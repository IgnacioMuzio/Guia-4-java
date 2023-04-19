public enum EGenre {


    ACCION("Accion"),AVENTURA("Aventura"),COMEDIA("Comedia"),DRAMA("Drama"),HORROR("Horror"),DOCUMENTAL("Documental");
    private String name;

    private EGenre(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


}
