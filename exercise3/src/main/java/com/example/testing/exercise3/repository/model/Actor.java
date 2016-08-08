package com.example.testing.exercise3.repository.model;

import java.util.List;

public class Actor {

    private String adult;
    private Number id;
    private List<KnownFor> known_for;
    private String name;
    private Number popularity;
    private String profile_path;
    private boolean isLoaded;

    public Actor(Number id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getAdult(){
        return adult;
    }

    public Number getId(){
        return id;
    }

    public List<KnownFor> getKnownFor(){
        return known_for;
    }

    public String getName(){
        return name;
    }

    public Number getPopularity(){
        return popularity;
    }

    public String getProfilePath(){
        return profile_path;
    }

    public void setIsLoaded(boolean isLoadedActor){
        this.isLoaded=isLoadedActor;
    }

    public Boolean getIsLoaded(){
        return isLoaded;
    }
}
