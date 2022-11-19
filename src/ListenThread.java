import java.io.IOException;
import java.io.ObjectInputStream;

public class ListenThread extends Thread {
    @Override public void run() {
        System.out.println("Initial run");
        while(true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(Main.endpoint.getInputStream());
                System.out.println("Listening");
                int y = ois.readInt();
                int x = ois.readInt();

                System.out.println("Hello, world!");
                System.out.println(y);
                System.out.println(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
