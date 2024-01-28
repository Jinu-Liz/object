package ex.books.chapter_10.playlist;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Playlist {

  private List<Song> tracks = new ArrayList<>();

  // 요구 사항이 변경되어, 가수별 노래의 제목도 함께 관리해야 하게 됨.
  private Map<String, String> singer = new HashMap<>();

  public void append(Song song) {
    tracks.add(song);
    singer.put(song.getSinger(), song.getTitle());
  }

}
