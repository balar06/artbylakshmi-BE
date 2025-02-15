package com.artbylakshmi.repo;

import com.artbylakshmi.entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface ArtRepository extends JpaRepository<Art, Integer> {

    List<Art> findByStatusNot(String status);

}

