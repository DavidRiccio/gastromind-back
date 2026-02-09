package com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="household")
public class householdEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    private String name;
    private int members_count;


    public householdEntity() {
    }


    public householdEntity(String id) {
        this.id = id;
    }

    public householdEntity(String id, String name, int members_count) {
        this.id = id;
        this.name = name;
        this.members_count = members_count;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMembers_count() {
        return this.members_count;
    }

    public void setMembers_count(int members_count) {
        this.members_count = members_count;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof householdEntity)) {
            return false;
        }
        householdEntity householdEntity = (householdEntity) o;
        return Objects.equals(id, householdEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
