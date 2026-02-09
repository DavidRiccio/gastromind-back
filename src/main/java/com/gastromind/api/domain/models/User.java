package es.gastromind.domain.models;

public class User {

    String id;
    String text;
    String email;
    String password;
    HouseHold houseHold_id;

    /**
     * Constructor con todos los parametros
     * 
     * @param id       id del usuario
     * @param text     descripcion del usuario
     * @param email    email del usuario
     * @param password contraseña del usuario
     */
    public User(String id, String text, String email, String password) {
        this.id = id;
        this.text = text;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor con id
     * 
     * @param id id del usuario
     */
    public User(String id) {
        this.id = id;
    }

    /**
     * Constructor vacio
     */
    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
