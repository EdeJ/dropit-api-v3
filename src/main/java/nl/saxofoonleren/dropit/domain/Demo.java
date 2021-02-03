package nl.saxofoonleren.dropit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "demo")
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;
    private String fileName;
    private String songTitle;
    private String artist;

    @OneToOne(mappedBy = "demo", cascade = CascadeType.ALL)
    private Comment comment;

    public Demo() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", user=" + user +
                ", fileName='" + fileName + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", comment=" + comment +
                '}';
    }
}
