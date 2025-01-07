package com.referal.referal.Referral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/controller")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    @Autowired
    private ReferralRepository referralRepository; // Add @Autowired here to fix the issue

    @GetMapping("/getAllReferrals")
    public ResponseEntity<?> getAllReferrals() {
        try {
            List<Referral> referrals = referralService.getAllReferrals();
            return ResponseEntity.ok(referrals);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching referrals: " + e.getMessage());
        }
    }


    @PostMapping("/saveReferal")
    public ResponseEntity<?> saveReferral(@RequestBody Referral referral) {
        try {
            Referral savedReferral = referralService.saveReferral(referral);
            return ResponseEntity.ok("Saving referral: " + savedReferral);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving referral: " + e.getMessage());
        }
    }

    @GetMapping("/getReferralsByUser")
    public ResponseEntity<?> getReferralsByUser(@RequestParam String email) {
        try {
            List<Referral> referrals = referralService.getReferralsByUser(email);
            return ResponseEntity.ok(referrals);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching referrals: " + e.getMessage());
        }
    }

    @PutMapping("/updateReferral/{id}")
    public ResponseEntity<?> updateReferral(@PathVariable String id, @RequestBody Referral updatedReferral) {
        try {
            Referral referral = referralRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Referral not found"));
            referral.setReferralLink(updatedReferral.getReferralLink());
            referral.setReferralProvider(updatedReferral.getReferralProvider());
            referralRepository.save(referral);
            return ResponseEntity.ok("Referral updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating referral: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteReferral/{id}")
    public ResponseEntity<?> deleteReferral(@PathVariable String id) {
        try {
            referralRepository.deleteById(id);
            return ResponseEntity.ok("Referral deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting referral: " + e.getMessage());
        }
    }

}
