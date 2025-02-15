package com.artbylakshmi.controller;

import com.artbylakshmi.entity.Art;
import com.artbylakshmi.model.ArtDTO;
import com.artbylakshmi.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/art")
public class ArtDetails {

    @Autowired
    private ArtService artService;  // Assuming you have a service to handle the business logic

    @PostMapping("/addArt")
    public ResponseEntity<String> uploadArt(
            @RequestParam("name") String name,
            @RequestParam("price") BigDecimal price,
            @RequestParam(value = "artSize", required = false) String artSize,
            @RequestParam(value = "artDescription", required = false) String artDescription,
            @RequestParam("copyOrOriginal") String copyOrOriginal,
            @RequestParam("image") MultipartFile image) {

        try {
            // Convert the MultipartFile to byte array
            byte[] imageBytes = image.getBytes();

            // Create an Art object
            Art art = new Art();
            art.setName(name);
            art.setPrice(price);
            art.setArtSize(artSize);
            art.setArtDescription(artDescription);
            art.setCopyOrOriginal(copyOrOriginal);
            art.setUploadedAt(new Timestamp(System.currentTimeMillis()));  // Set the current timestamp
            art.setImage(imageBytes);  // Set the image data

            // Save the art (assumes service handles database interaction)
            artService.saveArt(art);

            return new ResponseEntity<>("Art uploaded successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading art: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/artList")
    public List<ArtDTO> getArtList() {
        // Fetch all art records from the database
        List<Art> arts = artService.fetchArtDetails();

        // Convert the Art entities to ArtDTOs
        return arts.stream()
                .map(art -> new ArtDTO(
                        art.getArtId(),
                        art.getName(),
                        art.getPrice(),
                        art.getArtSize(),
                        art.getArtDescription(),
                        art.getCopyOrOriginal(),
                        art.getUploadedAt().toLocalDateTime()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/image/{artId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer artId) {
        byte[] image = artService.fetchImage(artId);
        if (image != null) {
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg") // Assuming image format is JPEG
                    .body(image); // Return the image byte array in the response body
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if the image is not found
        }
    }
}
