package ex.books.chapter_11.composite.playlist;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Playlist {

  private List<Song> tracks = new ArrayList<>();

  private Map<String, String> singer = new HashMap<>();

  public void append(Song song) {
    tracks.add(song);
    singer.put(song.getSinger(), song.getTitle());
  }

}
