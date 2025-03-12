package com.example.controller;

import com.example.entity.Announcement;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public String listAnnouncements(Model model) {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        model.addAttribute("announcements", announcements);
        return "announcement-list";
    }

    @GetMapping("/new")
    public String newAnnouncementForm(Model model) {
        model.addAttribute("announcements", new Announcement());
        return "announcement-form";
    }

    @PostMapping("/save")
    public String saveAnnouncement(@ModelAttribute Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
        return "redirect:/announcements";
    }

    @GetMapping("/edit/{id}")
    public String editAnnouncement(@PathVariable int id, Model model) {
        model.addAttribute("announcements", announcementService.getAnnouncementById(id));
        return "announcement-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnnouncement(@PathVariable int id) {
        announcementService.deleteAnnouncement(id);
        return "redirect:/announcements";
    }
}
