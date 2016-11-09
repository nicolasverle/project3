import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by NVE-ZENIKA on 06/10/2016.
 */
public class JPEG2PNG {

    private static final String IMG_FOLDER = "c:/workspaces/nve-ci/formation-continuous-integration/Slides/ressources/images/";

    public static void main(String[] args) throws Exception {

        Files.walk(new File(IMG_FOLDER).toPath())
            .filter(f ->  f.getFileName().toString().endsWith(".jpg"))
            .forEach(img -> {
                try {
                    BufferedImage bufferedImage = ImageIO.read(img.toFile());
                    boolean converted = ImageIO.write(bufferedImage, "png", new File(IMG_FOLDER + img.getFileName().toString().replace("jpg", "png")));
                    if(converted) {
                        img.toFile().delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        );

    }

}
