import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Triplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Triplet{
		int a,b,c;
		Triplet(int a,int b,int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
	}
	List<Triplet> printTriplets(int[] data){
		int n=data.length;
		List<Triplet> res=new ArrayList<>();
		//HashMap<String,Integer> hs=new HashMap<>();
		HashSet <Integer> set=new HashSet<>();
		for(int i:data)set.add(i);
		//(Arrays.asList(data));
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(set.contains(data[i]+data[j])) {
					res.add(new Triplet(data[i],data[j],data[i]+data[j]));
				}
			}
		}
		return res;
		
	}

}
