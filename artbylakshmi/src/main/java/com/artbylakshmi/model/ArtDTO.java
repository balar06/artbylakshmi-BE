package com.artbylakshmi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ArtDTO {
    private Integer artId;
    private String name;
    private BigDecimal price;
    private String artSize;
    private String artDescription;
    private String copyOrOriginal;
    private LocalDateTime uploadedAt;

    // Constructor
    public ArtDTO(Integer artId, String name, BigDecimal price, String artSize, String artDescription, String copyOrOriginal, LocalDateTime uploadedAt) {
        this.artId = artId;
        this.name = name;
        this.price = price;
        this.artSize = artSize;
        this.artDescription = artDescription;
        this.copyOrOriginal = copyOrOriginal;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
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

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}

