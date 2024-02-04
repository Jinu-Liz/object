package ex.books.chapter_11.composite.playlist;

/**
 * Playlist의 경우, 합성으로 변경하더라도 가수별 노래 목록을 유지하기 위해
 * Playlist와 PersonalPlaylist를 함께 수정해야하는 문제가 해결되지는 않지만,
 * Playlist의 내부 구현을 변경하더라도 파급효과를 최대한 PersonalPlaylist 내부로 캡슐화할 수 있기 때문에
 * 상속보다 합성을 사용하는 것이 좋다.
 */
public class PersonalPlaylist {

  private Playlist playlist = new Playlist();

  public void append(Song song) {
    playlist.append(song);
  }

  public void remove(Song song) {
    playlist.getTracks().remove(song);
    playlist.getSinger().remove(song.getSinger());
  }

}
