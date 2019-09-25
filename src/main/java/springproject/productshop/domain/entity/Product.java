package springproject.productshop.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {
    @Column
    private String name;

    @Column
    private BigDecimal price;

    @ManyToMany(targetEntity = Category.class, mappedBy = "products", cascade = CascadeType.ALL)
    private Set<Category> categories;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    public Product() {
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
