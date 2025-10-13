package br.com.senai.group1.appproject.appproject.models;

public class CharacterModel {
    private String name;
    private String imageUri;

    public CharacterModel(String name, String imageUri) {
        this.name = name;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public String getImageUri() {
        return imageUri;
    }
}
