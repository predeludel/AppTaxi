package model;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long idOrder;
    private Long stateOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(Long stateOrder) {
        this.stateOrder = stateOrder;
    }
}
