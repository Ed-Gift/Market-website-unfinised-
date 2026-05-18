package com.marketplace.service;

import com.marketplace.model.User;
import com.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepo;

    public AdminService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User approveSeller(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow();

        if(user.getRole().name().equals("SELLER")){
            user.setApproved(true);
        }

        return userRepo.save(user);
    }
}