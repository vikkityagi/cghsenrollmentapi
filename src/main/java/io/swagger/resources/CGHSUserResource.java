package io.swagger.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CGHSUserResource {

    @JsonProperty("id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
