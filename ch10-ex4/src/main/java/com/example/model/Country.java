package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Country {

    private String name;
    private int population;

    public Country make(String name, int population){
        Country c = new Country();

        c.setName(name);
        c.setPopulation(population);
        return c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
