package nl.saxofoonleren.dropit.domain;

import javax.persistence.*;

@Entity
@Table(name = "demo")
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String songTitle;
    private String artist;

    public Demo(String fileName, String songTitle, String artist) {
        this.fileName = fileName;
        this.songTitle = songTitle;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
