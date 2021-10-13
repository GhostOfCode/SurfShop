package com.demoshop.demoshop.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Column(name = "new_product")
    private Boolean newProduct;

    @Column(name = "hot_product")
    private Boolean hotProduct;

    private Double price;

    @Column(name = "old_price")
    private Double oldPrice;

    private String image;

    @Column(length = 65536)
    @Type(type = "text")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", newProduct=" + newProduct +
                ", hotProduct=" + hotProduct +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", productType=" + productType +
                '}';
    }
}
