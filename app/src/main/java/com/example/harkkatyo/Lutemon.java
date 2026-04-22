package com.example.harkkatyo;

public class Lutemon {
    public String name;
    public String color;
    public int defences;
    public int attacks;
    public int experiencePoints;
    public int health;
    public String location;

    public Lutemon(String name, String color, int defences, int attacks, int experiencePoints, int health) {
        this.name = name;
        this.color = color;
        this.defences = defences;
        this.attacks = attacks;
        this.experiencePoints = experiencePoints;
        this.health = health;
        this.location= "home";
    }
    public void attack(Lutemon target){
        int damage = this.attacks-target.defences;
        target.health= target.health-damage;
    }
}