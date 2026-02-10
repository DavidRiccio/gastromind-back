package com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.entities;

import com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.enums.ApplianceType;

import jakarta.persistence.*;

@Entity
@Table(name = "household_appliances")
public class HouseholdApllianceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ApplianceType appliance;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private HouseholdEntity household;

    public HouseholdApllianceEntity() {
    }

    public HouseholdApllianceEntity(Integer id) {
        this.id = id;
    }

    public HouseholdApllianceEntity(Integer id, ApplianceType appliance, HouseholdEntity household) {
        this.id = id;
        this.appliance = appliance;
        this.household = household;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplianceType getAppliance() {
        return appliance;
    }

    public void setAppliance(ApplianceType appliance) {
        this.appliance = appliance;
    }

    public HouseholdEntity getHousehold() {
        return household;
    }

    public void setHousehold(HouseholdEntity household) {
        this.household = household;
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
        HouseholdApllianceEntity other = (HouseholdApllianceEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
