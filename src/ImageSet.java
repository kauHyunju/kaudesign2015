import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageSet {

    public BufferedImage jpg2BufferedImg(String fname){
   
          File file1 = new File(fname);
          BufferedImage bi1 = null;
		try {
			bi1 = ImageIO.read(file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			System.exit(0);
		}
          
           return bi1;
       }
    
}