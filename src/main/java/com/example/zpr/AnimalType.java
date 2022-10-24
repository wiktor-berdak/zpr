package com.example.zpr;

public enum AnimalType {
    ELEPHANT(20), LION(11), RABBIT(4);

    final int karmaUnits;

    AnimalType(int karmaUnits) {
        this.karmaUnits = karmaUnits;
    }

    public int getKarmaUnits(){
        return karmaUnits;
    }
}
