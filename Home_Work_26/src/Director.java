class Director {
    private String directorName;

    @Override
    public String toString() {
        return "Director{" +
                "fullName='" + directorName + '\'' +
                '}';
    }

    public String getDirectorName() {
        return directorName;
    }
}
