class Actor {
    private String actorName;
    private String role;


    @Override
    public String toString() {
        return "Actor{" +
                "fullName='" + actorName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getActorName() {
        return actorName;
    }

    public String getRole() {
        return role;
    }
}