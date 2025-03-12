package com.example.service;

import com.example.entity.Announcement;
import com.example.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Announcement getAnnouncementById(int id) {
        return announcementRepository.findById(id).orElse(null);
    }

    public void saveAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    public void deleteAnnouncement(int id) {
        announcementRepository.deleteById(id);
    }
}
