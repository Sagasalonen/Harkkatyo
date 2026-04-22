package com.example.harkkatyo;

import android.util.Log;

import java.util.ArrayList;

public class LutemonStorage {
        private static LutemonStorage instance;
        private ArrayList<Lutemon> lutemons;

        public ArrayList<Lutemon> deadLutemons;
        private LutemonStorage(){
            lutemons = new ArrayList<>();
            deadLutemons = new ArrayList<>();
        }
        public static LutemonStorage getInstance() {
            if(instance == null) {
                instance = new LutemonStorage();
            }
            return instance;
        }
        public ArrayList<Lutemon> getLutemons() {
            return lutemons;
        }
        public void addLutemon(Lutemon lutemon) {
            lutemons.add(lutemon);
        }
        public void deleteLutemon(Lutemon lutemon) {
            lutemons.remove(lutemon);
        }
        public void addDeadLutemon(Lutemon lutemon) {
            deadLutemons.add(lutemon);
        }
        public ArrayList<Lutemon> getDeadLutemons() {
        return deadLutemons;
    }
    }



