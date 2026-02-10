package com.gastromind.api.domain.models;

public class User {

    String id;
    String name;
    String email;
    String password;
    HouseHold houseHold_id;

    public User(String id, String name, String email, String password, HouseHold houseHold_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.houseHold_id = houseHold_id;
    }

    public User(String id) {
        this.id = id;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HouseHold getHouseHold_id() {
        return houseHold_id;
    }

    public void setHouseHold_id(HouseHold houseHold_id) {
        this.houseHold_id = houseHold_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}