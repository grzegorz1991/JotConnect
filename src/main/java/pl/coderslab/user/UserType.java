package pl.coderslab.user;



public enum UserType {
    ADMIN("Admin"),
    USER("User"),
    MASTER_ADMIN("Master Admin"),
    GUEST("Guest");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}