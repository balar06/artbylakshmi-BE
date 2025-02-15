package com.artbylakshmi.service;

import com.artbylakshmi.entity.Art;
import com.artbylakshmi.entity.User;
import com.artbylakshmi.repo.ArtRepository;
import com.artbylakshmi.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtService {
    @Autowired
    private ArtRepository artRepository;


    // Method to save the art entity
    public void saveArt(Art art) {
        artRepository.save(art);  // Saves the art in the database
    }

    // Method to save the art entity
    public List<Art> fetchArtDetails() {
        List<Art> arts = artRepository.findAll();  // Saves the art in the database
        return arts;
    }

    public byte[] fetchImage(Integer artId) {
        Optional<Art> artOptional = artRepository.findById(artId);
        if (artOptional.isPresent() && artOptional.get().getImage() != null) {
            byte[] image = artOptional.get().getImage(); // Fetch the image byte array
           return image;
        } else {
            return null;
        }
    }

}
