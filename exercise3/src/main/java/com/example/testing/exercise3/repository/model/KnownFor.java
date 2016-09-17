package com.example.testing.exercise3.repository.model;

public class KnownFor {

    private String adult;
    private String backdrop_path;
    private Number id;
    private String original_title;
    private String release_date;
    private String poster_path;
    private Number popularity;
    private String title;
    private Number vote_average;
    private Number vote_count;
    private String media_type;

    public String getAdult(){
        return adult;
    }

    public String getBackdropPath(){
        return backdrop_path;
    }

    public Number getId(){
        return id;
    }

    public String getOriginalTitle(){
        return original_title;
    }

    public String getReleaseDate(){
        return release_date;
    }

    public String getPosterPath(){
        return poster_path;
    }

    public Number getPopularity(){
        return popularity;
    }

    public Number getVoteAverage(){
        return vote_average;
    }

    public Number getVoteCount(){
        return vote_count;
    }

    private String getMediaType(){
        return media_type;
    }
}
