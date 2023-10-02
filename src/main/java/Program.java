import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Program {
    public static void main(String[] args) {

        String[] arguments = new String[args.length];
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            arguments[i] = arg;

        }
        for(int i = 2; i < arguments.length; i++) {
            text.append(arguments[i]).append(" ");
        }
        String printedText = String.valueOf(text).replace("'", "");

        BufferedImage image = null;
        if (!arguments[0].equals("help") && arguments[1] == null) {
            System.out.println("Не выбрано исходное изображение");
        }
        if (!args[0].isEmpty() && arguments[0].equals("help")) {
            System.out.println("Доступные команды:");
            System.out.println("help - вызывает справку по командам программы");
            System.out.println("mem - указывается в качестве первого аргумента и запускает алгоритм печати текста на выбранном изображении");
            System.out.println(" ");
            System.out.println("Пример команды:  java -jar TextOnPic.jar mem ./image.png 'Текст'");

        }
        if (!args[0].isEmpty() && arguments[0].equals("mem")) {
            try {
                assert arguments[1] != null;
                image = ImageIO.read(new File(arguments[1]));
            } catch (IOException ignored) {
            }
            assert image != null;
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 50));
            g2d.drawString(printedText, image.getWidth() / 2, image.getHeight() / 5);

            try {
                ImageIO.write(image, "png", new File("modified_image.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            System.out.println("Не верно указан первый аргумент");
        }


    }

}

