package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;  // ✅ Java 8 使用 Date 而非 Instant

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;   // ✅ Java 8 使用 Date

    private String author;

    // Getters and Setters
    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id;
    }
    private void setTitle(String title){
        this.title = title;
    }
    private String getTitle(){
        return title;
    }

    private void setContent(String content){
        this.content = content;
    }
    private String getContent(){
        return content;
    }

    private void setauthor(String author){
        this.author = author;
    }
    private String getAuthor(){
        return author;
    }

    public Date getPublishDate() {
        return publishDate; 
    }
    public void setPublishDate(Date publishDate) { 
        this.publishDate = publishDate; 
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
