package my.home.spring.mvc;

public enum Department {
    IT ("Information Technologies"),
    SALES ("Sales"),
    HR ("HR");
    private final String displayName;

    private Department(String s){
        this.displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }
}
