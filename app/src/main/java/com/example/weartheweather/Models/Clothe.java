package com.example.weartheweather.Models;

public class Clothe {
    private String image;
    private Categorie categorie;

    public Clothe(String image, Categorie categorie){
        this.image = image;
        this.categorie = categorie;

    }

    public String getImage() {
        return image;
    }

    public Categorie getCategorie() {
        return categorie;
    }
}
