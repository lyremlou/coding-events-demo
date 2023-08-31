package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class EventCategory extends AbstractEntity{


    @Size(min=3, max=25, message="3 character minimum" )
    private String name;

    public EventCategory(int id, String name) {
        this.name = name;
    }

    public EventCategory() {}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
