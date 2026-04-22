package com.example.harkkatyo;

public class Lutemon {
    public String name;
    public String color;
    public int defences;
    public int attacks;
    public int experiencePoints;
    public int health;
    public int ogHealth;
    public String location;

    public Lutemon(String name, String color, int defences, int attacks, int experiencePoints, int ogHealth) {
        this.name = name;
        this.color = color;
        this.defences = defences;
        this.attacks = attacks;
        this.experiencePoints = experiencePoints;
        this.ogHealth = ogHealth;
        this.location= "home";
        this.health = ogHealth;
    }
    public void attack(Lutemon target){
        int damage = this.attacks-target.defences;
        target.health= target.health-damage;
    }

    public void restoreHealth() {
        this.health = ogHealth;
    }
}