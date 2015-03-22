/*
 **************************************************************************
 *
 *   Applies correlation between two arrays, either of type double or int.
 *
 **************************************************************************
 */
import java.io.*;


public class Correlation {

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
		
		return corr;
	}

}