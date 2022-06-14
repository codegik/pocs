package com.codegik.poc.java17;

import java.time.DayOfWeek;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Switch {

    public String fill(Object o) {
        return switch (o) {
            case String s -> "filling with string";
            case Integer s -> "filling with integer";
            default -> "filling with anything else";
        };
    }

    public Boolean isWorkDay(DayOfWeek day) {
        return switch (day) {
            case SUNDAY, SATURDAY -> FALSE;
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> TRUE;
        };
    }
}
