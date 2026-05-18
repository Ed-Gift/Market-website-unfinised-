package com.marketplace.SERVICES;

import com.marketplace.model.ActivityLog;
import com.marketplace.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService {

    private final ActivityLogRepository repo;

    public ActivityLogService(ActivityLogRepository repo) {
        this.repo = repo;
    }

    public void log(Long userId, String action) {

        ActivityLog log = new ActivityLog();

        log.setUserId(userId);
        log.setAction(action);

        repo.save(log);
    }
}