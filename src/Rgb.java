import java.awt.image.BufferedImage;
import java.util.ArrayList;

class Color{

   private int rgb[] = new int[3]; 

   public Color(int r, int g, int b){
      
      rgb[0]=r;
      rgb[1]=g;
      rgb[2]=b;       
   }

   public int getr(){ return rgb[0]; }
   public int getg(){ return rgb[1]; }
   public int getb(){ return rgb[2]; }

}//ArrayList가 될 애들

public class Rgb {

  
   public ArrayList<Color> rgbSet(BufferedImage b,int width, int height) throws Exception {
      // TODO Auto-generated method stub
      
       ArrayList<Color> arrTest = new ArrayList<Color>();

       for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
               int pixel = b.getRGB(j, i);

               int red = (pixel >> 16) & 0xff;
               int green = (pixel >> 8) & 0xff;
               int blue = (pixel) & 0xff;            
               //hexa연산을 통해 rgb구하기
               
               arrTest.add(new Color(red,green,blue));   
            }
       }
       return arrTest;   
   }
   
   public int[][] rGet(ArrayList<Color> a,int w, int h){
	   int ret[][]=new int[h][w];
	   
	   int idx=0;
	   
	   for(int i=0;i<h;i++){
		   for(int j=0;j<w;j++){
			   ret[i][j]=a.get(idx).getr();
			   idx++;
		   }
	   }	   
	   return ret; 
   }
   
   public int[][] gGet(ArrayList<Color> a,int w, int h){
	   int ret[][]=new int[h][w];
	   
	   int idx=0;
	   
	   for(int i=0;i<h;i++){
		   for(int j=0;j<w;j++){
			   ret[i][j]=a.get(idx).getg();
			   idx++;
		   }
	   }	   
	   return ret; 
   }
   
   public int[][] bGet(ArrayList<Color> a,int w, int h){
	   int ret[][]=new int[h][w];
	   
	   int idx=0;
	   
	   for(int i=0;i<h;i++){
		   for(int j=0;j<w;j++){
			   ret[i][j]=a.get(idx).getb();
			   idx++;
		   }
	   }	   
	   return ret; 
   }
   
}