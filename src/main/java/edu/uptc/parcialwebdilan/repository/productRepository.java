package edu.uptc.parcialwebdilan.repository;

import edu.uptc.parcialwebdilan.entityes.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Long > {
}
