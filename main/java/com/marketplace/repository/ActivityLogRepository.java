package com.marketplace.repository;

import com.marketplace.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository
        extends JpaRepository<ActivityLog, Long> {
}