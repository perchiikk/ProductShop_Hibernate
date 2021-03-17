package model.sql;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer count;

    @Column
    private boolean alco;

    @Column
    private String name;

    @Column
    private Integer price;

    @OneToMany(mappedBy = "product", orphanRemoval=true)
    private Set<ListOfOrder> listOfOrders;

    public Products() {
    }

    public Products(Integer count, boolean alco, String name, Integer price) {
        this.count = count;
        this.alco = alco;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isAlco() {
        return alco;
    }

    public void setAlco(boolean alco) {
        this.alco = alco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<ListOfOrder> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(Set<ListOfOrder> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }
}
