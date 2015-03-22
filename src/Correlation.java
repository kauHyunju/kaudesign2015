/*
 **************************************************************************
 *
 *   Applies correlation between two arrays, either of type double or int.
 *
 **************************************************************************
 */
import java.io.*;


public class Correlation {
	
	/*public static void main(String args[]){

		int test1[][] = new int[10][10];
		int test2[][] = new int[10][10];

		int r=test1.length;
		int c=test1[0].length;

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(j==1){
					test1[i][j]=5;
					test2[i][j]=1;
					continue;
				}
				if(j==2){
					test1[i][j]=2;
					test2[i][j]=3;
					continue;

				}
				else{ 
					test1[i][j]=0;
					test2[i][j]=4;
				}
			}
		}


		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(test1[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println();

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(test2[i][j]+" ");
			}
			System.out.println();
		}

		
		//test1, test2 가 이미지 파일임
		
		
		
		double ret1;
		ret1 = getCor(test1,test2,0);

		System.out.println("Result of correlation = " + ret1);

	}*/

	public double getCor(int[][] a, int[][] b){

		double corr = 0, mean1=0, mean2=0, mag1=0, mag2=0;
		int    nrows=0, ncols=0;
		int  size;
		
		ncols = a[0].length;
		nrows = a.length;

		size = ncols*nrows;

		for (int i=0; i<nrows; i++) {   // Compute mean
			for (int j=0; j<ncols; j++) {
				mean1 += a[i][j];
				mean2 += b[i][j];
			}
		}
		/*System.out.println(mean1);
		System.out.println(mean2);
*/
		mean1 /= size;
		mean2 /= size;

		for (int i=0; i<nrows; i++) {
			for (int j=0; j<ncols; j++) {
				a[i][j] -= mean1;
				b[i][j] -= mean2;
				mag1 += a[i][j] * a[i][j];
				mag2 += b[i][j] * b[i][j];
				corr += a[i][j] * b[i][j];
			}
		}
		
		corr /= Math.sqrt(mag1*mag2);
		
		/*}
		int suma=0,sumb=0;
		int suma2=0,sumb2=0;
		int psum=0;
		double top,bot,bota,botb;
		int n=a.length*a[0].length;
		int samecnt=0;

		for(int i=0;i<nrows;i++){
			for(int j=0;j<ncols;j++){
				if(a[i][j]==b[i][j]) samecnt++;
				suma+=a[i][j];
				sumb+=b[i][j];
				suma2+=a[i][j]*a[i][j];
				sumb2+=b[i][j]*b[i][j];
				psum+=a[i][j]*b[i][j];
			}
		}

		if(samecnt==size) System.out.println("same");

		top=psum-(suma*sumb)/n;
		bota=suma2 - (suma*suma)/n;
		botb=sumb2 - (sumb*sumb)/n;
		bot=bota*botb;

		System.out.println("n is "+n);
		System.out.println("suma is "+suma);
		System.out.println("sumb is "+sumb);
		System.out.println("suma2 is "+suma2);
		System.out.println("sumb2 is "+sumb2);
		System.out.println("psum is " +psum);
		System.out.println("top is "+top);
		System.out.println("bota is "+bota);
		System.out.println("botb is " + botb);
		System.out.println("bot is " +bot);

		if(top==0){
			System.out.println("top==0");
			return 0.0;
		}

		if(bot==0) {
			System.out.println("bot==0");
			return 0.0;
		}
		corr=top/bot;
		 */
		/*System.out.println(mag1);
		System.out.println(mag2);*/
		
		return corr;
	}

}