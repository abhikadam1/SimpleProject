package com.example.SimpleProject.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private double price;
    // --- New created_on field ---

    /**
     * Maps to TIMESTAMP(0) WITHOUT TIME ZONE in PostgreSQL.
     * @CreationTimestamp ensures the field is set automatically on save.
     */
    @CreationTimestamp
    @Column(
            name = "created_on",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // 👈 NEW LINE
    private LocalDateTime createdOn;

//    // --- NEW METHOD TO FIX PRECISION ---
//    @PrePersist
//    protected void onCreate() {
//        // Truncate the LocalDateTime value to seconds precision
//        this.createdOn = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
//    }

//    public Product(String name, double price, int quantity) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }

}
