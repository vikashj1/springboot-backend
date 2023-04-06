package net.vikash.springbootproject.controller;

import net.vikash.springbootproject.exception.ResourceNotFoundException;
import net.vikash.springbootproject.model.Claim;
import net.vikash.springbootproject.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ClaimsController {
    @Autowired
    private ClaimRepository claimRepository;
    //  Fetch all claims.
    @GetMapping("/claims")
    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }
    // Create a new claim.
    @PostMapping("/claims")
    public Claim createClaim(@RequestBody Claim claim){
        return claimRepository.save(claim);
    }
    // Fetch a specific claim by ID.
    @GetMapping("/claims/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id){
        Claim claim = claimRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Claim doesn't exist with the given ID  : "+ id));
        return ResponseEntity.ok(claim);
    }
    // Update a claim's information.
    @PutMapping("/claims/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claimDetails){
        Claim claim = claimRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        claim.setClaimNumber(claimDetails.getClaimNumber());
        claim.setDescription(claimDetails.getDescription());
        claim.setClaimStatus(claimDetails.getClaimStatus());
        claim.setClaimDate(claimDetails.getClaimDate());

        Claim updatedClaim = claimRepository.save(claim);
        return ResponseEntity.ok(updatedClaim);
    }
    // Delete a claim.
    @DeleteMapping("/claims/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteClaim(@PathVariable Long id){
        Claim claim = claimRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        claimRepository.delete(claim);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
