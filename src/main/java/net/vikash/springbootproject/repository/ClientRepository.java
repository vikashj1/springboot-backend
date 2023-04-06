package net.vikash.springbootproject.repository;

import net.vikash.springbootproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
