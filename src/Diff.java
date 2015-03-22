import java.util.ArrayList;


public class Diff {

	public ArrayList<Color> getDiff(ArrayList<Color> t,int h,int w){

		ArrayList<Color> temp = new ArrayList<Color>();
		
		for(int i=0;i<h*w;i++){
			int rtemp=0,gtemp=0,btemp=0;

			if(i%w == w-1) {
				rtemp=256;
				gtemp=256;
				btemp=256;
			}
			else {
				rtemp=t.get(i+1).getr()-t.get(i).getr();
				gtemp=t.get(i+1).getg()-t.get(i).getg();
				btemp=t.get(i+1).getb()-t.get(i).getb();
			}
			temp.add(new Color(rtemp,gtemp,btemp));
		}
		
		return temp;
	}
}