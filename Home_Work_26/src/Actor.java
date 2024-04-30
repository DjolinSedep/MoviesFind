class Actor {
    private String fullName;
    private String role;



    @Override
    public String toString() {
        return "Actor{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }
}