package com.referal.referal.Referral;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository // This is required to mark it as a Spring-managed bean


public interface ReferralRepository extends MongoRepository<Referral, String> {
    List<Referral> findByEmail(String email); // Custom queries (if needed)
}


