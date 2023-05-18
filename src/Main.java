import java.io.IOException;

class Main {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        try {
            mainService.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}