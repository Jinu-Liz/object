package ex.books.chapter_10.playlist;

public class PersonalPlaylist extends Playlist {

  /**
   * 수정 내용이 정상 동작하려면 remove 메서드도 함께 수정해주어야한다.
   * 이는 자식 클래스가 부모 클래스의 메서드를 오버라이딩하거나 불필요한 인터페이스를
   * 상속받지 않았음에도 부모 클래스에 수정이 일어날 경우, 자식 클래스에도 수정이 일어나야 하는 경우를
   * 잘 보여준다.
   * 상속은 부모 클래스의 구현을 재사용한다는 전제를 따르기 때문에, 자식이 부모에 대해 속속들이 알도록 강요한다.
   * 따라서, 코드 재사용을 위한 상속은 부모/자식 간의 관계를 강하게 결합시키기 때문에
   * 함께 수정해야하는 상황이 빈번하게 발생할 수 밖에 없는 것이다.
   *
   * 클래스를 상속하면 결합도로 인해 자식 클래스와 부모 클래스의 구현을 영원히 변경하지 않거나,
   * 동시에 모두 변경하거나 둘 중 하나를 선택할 수 밖에 없다.
   */
  public void remove(Song song) {
    super.getTracks().remove(song);
    super.getSinger().remove(song.getSinger());
  }
}
