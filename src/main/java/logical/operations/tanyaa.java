package logical.operations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class tanyaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<Integer,Integer> ctr = new HashMap<Integer,Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		int val = 0;
		for(int i=0;i<n;i++){
			ar[i] = sc.nextInt();
			if(ctr.get(ar[i])!=null){
				val = ctr.get(ar[i]);
				ctr.replace(ar[i], val, val+1);
			}
			else{
				ctr.put(ar[i], 1);
			}
		}
		Iterator<Map.Entry<Integer,Integer>> itr = ctr.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> ent = itr.next();
				
			
			int x = ctr.get(ent.getKey());
			if(x>=n/2){
				System.out.println(x);
			}
		}

	}

}
