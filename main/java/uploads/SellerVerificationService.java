package uploads;

import com.marketplace.model.SellerVerification;
import com.marketplace.repository.SellerVerificationRepository;
import org.springframework.stereotype.Service;

@Service
public class SellerVerificationService {

    private final SellerVerificationRepository repo;

    public SellerVerificationService(
            SellerVerificationRepository repo) {

        this.repo = repo;
    }

    public SellerVerification save(
            SellerVerification verification) {

        return repo.save(verification);
    }
}