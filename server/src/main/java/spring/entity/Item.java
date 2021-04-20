package spring.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // https://www.objectdb.com/api/java/jpa/Entity
@Table(name = "items", schema = "store") // https://www.objectdb.com/api/java/jpa/Table
public class Item {
    private static final Logger LOGGER = LogManager.getLogger(Item.class);

    @Id// https://www.objectdb.com/api/java/jpa/Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long uuid;

    @Column(length = 50, nullable = false, unique = false) // https://www.objectdb.com/api/java/jpa/Column
    private String name;

    @Column(length = 512, nullable = false, unique = false)
    @Lob // https://www.objectdb.com/api/java/jpa/Lob
    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 12, scale = 2)
    private double price;

    public Item() {
        this.name = null;
        this.description = null;
        this.quantity = 0;
        this.price = 0;
    }

    public Item(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
