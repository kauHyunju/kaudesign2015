import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Test {
	
   public static void main(String args[]){
	   
      BufferedImage bi1 = null;
      BufferedImage bi2 = null;
      String fname = "ea1.png";
      String fname2 = "ea2.png";
      ImageSet is = new ImageSet();

      try {
    	  
         bi1 = is.jpg2BufferedImg(fname);
         bi2 = is.jpg2BufferedImg(fname2);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         System.out.println("");
      }

      int w = bi1.getWidth();
      int h = bi1.getHeight();

      if(bi1.getWidth()!=bi2.getWidth() || bi1.getHeight()!=bi2.getHeight()) { 
    	  if(bi1.getWidth()==bi2.getHeight()||bi1.getHeight()==bi2.getWidth()) {}//회전한 사진
    	  else {
    		  System.out.println("user diff"); 
    		  System.exit(0);
    	  }
      }
      
      ArrayList<Color> a = new ArrayList<Color>();
      ArrayList<Color> b = new ArrayList<Color>();

      ArrayList<Color> asub = new ArrayList<Color>();
      ArrayList<Color> bsub = new ArrayList<Color>();
      
      System.out.println("w is "+w);
      System.out.println("h is "+h);

      Rgb rgb = new Rgb();
      Correlation c = new Correlation();

      try {
         a = rgb.rgbSet(bi1,w,h);
         b = rgb.rgbSet(bi2,w,h);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         System.out.println("rgb set error");
      }

      //a,b에 r,g,b로 셋팅
      
      Diff d = new Diff();
      
      asub = d.getDiff(a, h, w);
      bsub = d.getDiff(b, h, w); 
      //차이를 구한 ArrayList

      double corr, corg, corb;
      int ar[][], br[][], ag[][], bg[][], ab[][], bb[][] = new int[h][w];
      
      ar=rgb.rGet(asub, w, h);	//차이를 구한 ArrayList의 r로만 이루어진 2차원 행렬
      br=rgb.rGet(bsub, w, h);
      ag=rgb.gGet(asub, w, h);
      bg=rgb.gGet(bsub, w, h);
      ab=rgb.bGet(asub, w, h);
      bb=rgb.bGet(bsub, w, h);
      
      corr = c.getCor(ar, br);	//correlation
      corg = c.getCor(ag, bg);
      corb = c.getCor(ab, bb);
      
      System.out.printf("corr R: %f corr G: %f corr B: %f",corr,corg,corb);
      System.out.println();
      
   }
}