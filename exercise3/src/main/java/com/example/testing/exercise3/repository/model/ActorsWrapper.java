package com.example.testing.exercise3.repository.model;

import java.util.List;

public class ActorsWrapper {

    private Number page;
    private List<Actor> results;
    private Number total_pages;
    private Number total_results;

    public ActorsWrapper(List<Actor> results) {
        this.results = results;
    }

    public List<Actor> getResults() {
        return results;
    }

    public Number getPage() {
        return this.page;
    }

    public void setPage(Number page) {
        this.page = page;
    }

    public Number getTotal_results() {
        return this.total_results;
    }

    public void setTotal_results(Number total_results) {
        this.total_results = total_results;
    }

    public Number getTotal_pages() {
        return this.total_pages;
    }

    public void setTotal_pages(Number total_pages) {
        this.total_pages = total_pages;
    }
}
