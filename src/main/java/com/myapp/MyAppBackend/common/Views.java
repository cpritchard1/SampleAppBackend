package com.myapp.MyAppBackend.common;

/**
 * View class for use by Jackson
 */
public class Views {

    private Views() {
        // empty constructor so it can be private
    }

    public interface Any {
    }

    public interface All extends Any {
    }

    public interface Dropdown extends Any {
    }
}
