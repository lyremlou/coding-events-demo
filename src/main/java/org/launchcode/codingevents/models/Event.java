package org.launchcode.codingevents.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {


    private int id;
    private static int nextId = 1;
    @NotBlank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max = 500, message = "Description too long.")
    private String description;
    @NotBlank(message = "Location is required.")
    @NotNull
    @Size(min = 3, max = 50)
    private String location;

    @Positive(message = "Number of attendees must be at least one.")
    private int numAttendees;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Future
    private Date dateOfEvent;

    @AssertTrue(message = "Registration required, field must be true.")
    private boolean mustRegister = true;
    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    private EventType type;



    public Event(String name, String description, String location, int numAttendees, Date dateOfEvent, boolean mustRegister, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.location = location;
        this.numAttendees = numAttendees;
        this.dateOfEvent = dateOfEvent;
        this.mustRegister = mustRegister;
        this.contactEmail = contactEmail;
        this.type = type;

    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
