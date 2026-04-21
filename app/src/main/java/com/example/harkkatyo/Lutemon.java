package com.example.harkkatyo;

public class Lutemon {
    public String name;
    public String color;
    public int defences;
    public int attacks;
    public int experiencePoints;
    public int lives;
    public String location;

    public Lutemon(String name, String color, int defences, int attacks, int experiencePoints, int lives) {
        this.name = name;
        this.color = color;
        this.defences = defences;
        this.attacks = attacks;
        this.experiencePoints = experiencePoints;
        this.lives = lives;
        this.location= "home";
    }
}