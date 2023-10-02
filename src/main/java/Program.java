import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        BufferedImage image = null;
        try {
            System.out.print("Укажите местоположение исходного изображения: ");
            String pathFile = scanner.nextLine();
            image = ImageIO.read(new File(pathFile));
        } catch (IOException ignored) {
        }
        assert image != null;
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString(text, image.getWidth() / 2, image.getHeight() / 5);

        try {
            ImageIO.write(image, "png", new File("modified_image.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}

