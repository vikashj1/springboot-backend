package net.vikash.springbootproject.controller;

import net.vikash.springbootproject.exception.ResourceNotFoundException;
import net.vikash.springbootproject.model.InsurancePolicy;
import net.vikash.springbootproject.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PoliciesController {
    @Autowired
    private PolicyRepository policyRepository;
    // Fetch all insurance policies.
    @GetMapping("/policies")
    public List<InsurancePolicy> getAllPolicies(){
        return policyRepository.findAll();
    }
    //  Create a new insurance policy
    @PostMapping("/policies")
    public InsurancePolicy createPolicy(@RequestBody InsurancePolicy insurancePolicy){
        return policyRepository.save(insurancePolicy);
    }
    // Fetch a specific insurance policy by ID.
    @GetMapping("/policies/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long id){
        InsurancePolicy insurancePolicy = policyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Policy doesn't exist with the given ID  : "+ id));
        return ResponseEntity.ok(insurancePolicy);
    }
    // Update an insurance policy
    @PutMapping("/policies/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policyDetails){
        InsurancePolicy insurancePolicy = policyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        insurancePolicy.setPolicyNumber(policyDetails.getPolicyNumber());
        insurancePolicy.setPolicyType(policyDetails.getPolicyType());
        insurancePolicy.setCoverageAmount(policyDetails.getCoverageAmount());
        insurancePolicy.setPremium(policyDetails.getPremium());
        insurancePolicy.setStartDate(policyDetails.getStartDate());
        insurancePolicy.setEndDate(policyDetails.getEndDate());

        InsurancePolicy updatedPolicy = policyRepository.save(insurancePolicy);
        return ResponseEntity.ok(updatedPolicy);
    }
    // Delete an insurance policy
    @DeleteMapping("/policies/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePolicy(@PathVariable Long id){
        InsurancePolicy insurancePolicy = policyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        policyRepository.delete(insurancePolicy);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
