package com.myapp.MyAppBackend.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonView;

@SuppressWarnings("unused")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonDropdown {

    @JsonView(Views.Dropdown.class)
    private final String value;

    @JsonView(Views.Dropdown.class)
    private final String label;

    public JsonDropdown(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public JsonDropdown(Integer value, String label) {
        this(String.valueOf(value), label);
    }
    
    public JsonDropdown(Long value, String label) {
        this(String.valueOf(value), label);
    }
}
