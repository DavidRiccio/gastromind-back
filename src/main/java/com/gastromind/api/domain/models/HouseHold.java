package es.gastromind.domain.models;

public class HouseHold {
    String id;
    String name;
    int members;

    /**
     * Constructor con todos los parametros
     * 
     * @param id      id de la casa
     * @param name    nombere de la casa
     * @param members miembros de la casa
     */
    public HouseHold(String id, String name, int members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    /**
     * Constructor con id
     * 
     * @param id id de la casa
     */
    public HouseHold(String id) {
        this.id = id;
    }

    /**
     * Constructor vacio
     */
    public HouseHold() {
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

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
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
        HouseHold other = (HouseHold) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
