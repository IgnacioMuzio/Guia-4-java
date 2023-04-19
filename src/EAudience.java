public enum EAudience {

    G("G"),PG("PG"),PG_13("PG-13"),R("R"),NC_17("NC-17"),UNRATED("UNRATED");

    private String name;
    EAudience(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
