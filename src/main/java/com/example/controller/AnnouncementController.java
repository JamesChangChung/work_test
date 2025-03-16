package com.example.controller;

import com.example.entity.Announcement;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private static String UPLOAD_DIR = "uploads/";

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
        model.addAttribute("announcement", new Announcement());
        return "announcement-form";
    }

    @PostMapping("/save")
    public String saveAnnouncement(@ModelAttribute Announcement announcement,
                                   @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
                Files.write(path, bytes);
                announcement.setAttachment(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        announcementService.saveAnnouncement(announcement);
        return "redirect:/announcements";
    }

    @GetMapping("/edit/{id}")
    public String editAnnouncement(@PathVariable int id, Model model) {
        model.addAttribute("announcement", announcementService.getAnnouncementById(id));
        return "announcement-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnnouncement(@PathVariable int id) {
        announcementService.deleteAnnouncement(id);
        return "redirect:/announcements";
    }

    @GetMapping("/view/{id}")
    public String viewAnnouncement(@PathVariable int id, Model model) {
        Announcement announcement = announcementService.getAnnouncementById(id);
        model.addAttribute("announcement", announcement);
        return "announcement-view";
    }
}