import java.io.IOException;
import java.io.ObjectInputStream;

public class ListenThread extends Thread {
    @Override public void run() {
        while(true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(Main.endpoint.getInputStream());
                int y = ois.readInt();
                int x = ois.readInt();

                System.out.println(y);
                System.out.println(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
