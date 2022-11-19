import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static boolean isHost = false;
    public static Socket endpoint;
    public static ServerSocket self;
    public static Image xIcon;
    public static Image oIcon;
    static {
        try {
            xIcon = ImageIO.read(new File("res/X.png"));
            oIcon = ImageIO.read(new File("res/O.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to host or connect? H/C");
        String response = input.nextLine();

        if(response.equalsIgnoreCase("H")) {
            isHost  = true;
            self = new ServerSocket(25565);
            endpoint = self.accept(); // Actual client
        } else if(response.equalsIgnoreCase("C")) {
            isHost = false;
            System.out.println("Who would you like to connect to?");
            String address = input.nextLine();
            endpoint = new  Socket(address,25565); // Server
        } else  {
            System.exit(0);
        }

        new Window().init();
    }
}