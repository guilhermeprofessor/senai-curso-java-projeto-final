package br.com.senai.group1.appproject.appproject.models;

public class ResolutionModel {
    private String name = "";
    private double width = 0;
    private double height = 0;

    public ResolutionModel(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
