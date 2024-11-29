package edu.uptc.parcialwebdilan.repository;

import edu.uptc.parcialwebdilan.entityes.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<customer, Long > {
}
