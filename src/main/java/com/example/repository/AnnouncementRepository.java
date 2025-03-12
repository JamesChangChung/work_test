package com.example.repository;

import com.example.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
