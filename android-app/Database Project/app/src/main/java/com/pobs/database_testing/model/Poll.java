package com.pobs.database_testing.model;


public class Poll {


    private int id;
    private int col_a;
    private int col_b;
    private int col_c;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCol_a() {
        return col_a;
    }

    public void setCol_a(int col_a) {
        this.col_a = col_a;
    }

    public int getCol_b() {
        return col_b;
    }

    public void setCol_b(int col_b) {
        this.col_b = col_b;
    }

    public int getCol_c() {
        return col_c;
    }

    public void setCol_c(int col_c) {
        this.col_c = col_c;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", col_a=" + col_a +
                ", col_b=" + col_b +
                ", col_c=" + col_c +
                '}';
    }
}
