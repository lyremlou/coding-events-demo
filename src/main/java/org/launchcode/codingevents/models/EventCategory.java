package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class  EventCategory extends AbstractEntity{


    @Size(min=3, max=25, message="3 character minimum" )
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final
    List<Event> events = new ArrayList<>();

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

    public List<Event> getEvents() {
        return events;
    }
}
