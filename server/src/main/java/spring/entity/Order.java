package spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "saved_orders", schema = "store")
public class Order {

    @Id
    @Column
    private String username;

    @Column
    private String items;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
