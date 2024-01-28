package ex.books.chapter_10.playlist;

public class PersonalPlaylist extends Playlist {

  public void remove(Song song) {
    super.getTracks().remove(song);
  }
}
