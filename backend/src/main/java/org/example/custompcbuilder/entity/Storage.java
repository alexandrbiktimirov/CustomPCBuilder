package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "storage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Storage{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "model_name", nullable = false)
    protected String modelName;

    @Column(name = "brand", nullable = false)
    protected String brand;

    @Column(name = "price", nullable = false)
    protected BigDecimal price;

    @Column(name = "quantity", nullable = false)
    protected int quantity;

    @ElementCollection
    @CollectionTable(name = "storage_images", joinColumns = @JoinColumn(name = "storage_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "storages")
    private List<Order> orders;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @Column(name = "capacity_gb", nullable = false)
    private int capacityGb;
}
