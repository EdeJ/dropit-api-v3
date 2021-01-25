package nl.saxofoonleren.dropit.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "demo")
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demoId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private String fileName;
    private String songTitle;
    private String artist;

    public Demo() {
    }

    public Long getId() {
        return demoId;
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
        UUID uuid=UUID.randomUUID();
        this.fileName = uuid + "-" + fileName.toLowerCase().replace(' ', '-');
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

    @Override
    public String toString() {
        return "Demo{" +
                "demoId=" + demoId +
                ", user=" + user +
                ", fileName='" + fileName + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
