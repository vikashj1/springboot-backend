package net.vikash.springbootproject.repository;

import net.vikash.springbootproject.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
