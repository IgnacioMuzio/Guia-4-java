public class Client {

    //region Atributos
    private String name;
    private String number;

    private String adress;

    //endregion

    //region Constructores

    public Client() {
    }

    public Client(String name, String number, String adress) {
        this.name = name;
        this.number = number;
        this.adress = adress;
    }

    //endregion

    //region Getters,Setters,toString

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    //endregion

}
