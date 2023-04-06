package net.vikash.springbootproject.repository;

import net.vikash.springbootproject.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<InsurancePolicy,Long> {
}
