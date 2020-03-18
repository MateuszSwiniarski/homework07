package com.rodzyn.homework07.model;

public class Range {

    private String start;
    private String end;

    public Range() {
    }

    public Range(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
