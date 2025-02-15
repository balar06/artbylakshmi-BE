package com.artbylakshmi.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "arts")  // Specify the table name
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "art_size")
    private String artSize;

    @Column(name = "art_description", columnDefinition = "TEXT")
    private String artDescription;

    @Column(name = "copy_or_original", nullable = false)
    private String copyOrOriginal;

    @Column(name = "uploaded_at", updatable = false, insertable = false)
    private Timestamp uploadedAt;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column
    private String status;

    // Getters and Setters
    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getArtSize() {
        return artSize;
    }

    public void setArtSize(String artSize) {
        this.artSize = artSize;
    }

    public String getArtDescription() {
        return artDescription;
    }

    public void setArtDescription(String artDescription) {
        this.artDescription = artDescription;
    }

    public String getCopyOrOriginal() {
        return copyOrOriginal;
    }

    public void setCopyOrOriginal(String copyOrOriginal) {
        this.copyOrOriginal = copyOrOriginal;
    }

    public Timestamp getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Timestamp uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

