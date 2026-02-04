package model;

public class Package {
    private int id;
    private String description;
    private double weight;
    private int categoryId;

    public Package(int id, String description, double weight, int categoryId) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.categoryId = categoryId;
    }
}
