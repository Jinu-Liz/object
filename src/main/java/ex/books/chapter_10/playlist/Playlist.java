package ex.books.chapter_10.playlist;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

  @Getter
  private List<Song> tracks = new ArrayList<>();

  public void append(Song song) {
    getTracks().add(song);
  }

}
