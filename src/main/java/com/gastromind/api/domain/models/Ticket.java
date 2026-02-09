package es.gastromind.domain.models;

import java.time.LocalDate;

public class Ticket {
    String id;
    User user_id;
    Store store_id;
    float total_amount;
    LocalDate purchaseDate;

    /**
     * Constructor con todos los parametros
     * 
     * @param id           id del ticket
     * @param user_id      id del usuario
     * @param store_name   nombre de la tienda
     * @param total_amount precio total de la compra
     * @param purchaseDate fecha de la compra
     */
    public Ticket(String id, User user_id, String store_name, float total_amount, LocalDate purchaseDate) {
        this.id = id;
        this.user_id = user_id;
        this.store_name = store_name;
        this.total_amount = total_amount;
        this.purchaseDate = purchaseDate;
    }

    /**
     * Constructor con id
     * 
     * @param id id del ticket
     */
    public Ticket(String id) {
        this.id = id;
    }

    /**
     * Constructor vacio
     */
    public Ticket() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
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
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
