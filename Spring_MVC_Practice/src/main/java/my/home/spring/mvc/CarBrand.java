package my.home.spring.mvc;

public enum CarBrand {
    BMW("BMW"),
    AUDI("Audi"),
    MERCEDES_BENZ("Mercedes-Benz");
    private final String displayName;

    private CarBrand(String s){
        this.displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }
}
