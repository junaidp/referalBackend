package com.referal.referal.Referral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReferralService {
    @Autowired
    private ReferralRepository referralRepository;

    public Referral saveReferral(Referral referral) {
        return referralRepository.save(referral);
    }

    public List<Referral> getAllReferrals() {
        return referralRepository.findAll();
    }
    public List<Referral> getReferralsByUser(String email) {
        return referralRepository.findByEmail(email);
    }


}
