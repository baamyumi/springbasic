package springbasic.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //다른 곳에서 생성할 수 없도록 private 생성자
    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
