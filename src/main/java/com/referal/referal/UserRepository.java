package com.referal.referal;
import com.referal.referal.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


    @Repository
    public interface UserRepository extends MongoRepository<User, String> {
        // Custom queries (if any)
        Optional<User> findByEmail(String email);
    }
