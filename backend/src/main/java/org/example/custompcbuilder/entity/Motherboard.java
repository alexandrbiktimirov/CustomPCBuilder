package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "motherboard")
public class Motherboard{

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
    @CollectionTable(name = "motherboard_images", joinColumns = @JoinColumn(name = "motherboard_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "motherboards")
    private List<Order> orders;

    @Column(name = "socket_type", nullable = false)
    private String socketType;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @Column(name = "supported_memory_type", nullable = false)
    private String supportedMemoryType;

    @OneToMany(mappedBy = "motherboard", fetch = FetchType.LAZY)
    private List<Build> builds;
}