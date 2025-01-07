package com.referal.referal.Referral;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Referral {

    @Id
    private String id; // Changed to String for MongoDB compatibility

    private String referralLink;

    private String referralProvider;

    private String email; // User email for login reference
}
