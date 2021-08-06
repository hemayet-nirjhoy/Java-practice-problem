package geeksforgeeks;

import java.util.*;

public class NextGreaterElement {
	
	public static void naiveApproach(int a[]) {
		for(int i=0;i<a.length-1;i++) {
			int flag = 0;
			for(int j=i+1;j<a.length;j++) {
				if (a[i]<a[j]) {
					System.out.println(Integer.toString(a[i])+" | "+Integer.toString(a[j]));
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println(Integer.toString(a[i])+" | "+Integer.toString(-1));
			}
		}
		System.out.println(Integer.toString(a[a.length-1])+" | "+Integer.toString(-1));
	}
	
	public static int[] stack(int a[]) {
		int nge[] = new int[a.length];
		LinkedList<Integer> ge = new LinkedList<Integer>();
		for (int i=0;i<a.length-1;i++) {
			int current_element = a[i];
			int next_element = a[i+1];
			if(current_element>=next_element) {
				ge.push(i);
			}else {
				nge[i]=next_element;
				while(ge.size()>0) {
					int temp = ge.pop();
					if(next_element>=a[temp]) {
						nge[temp]=next_element;
					}else {
						ge.push(temp);
						break;
					}
				}
			}
			System.out.println("******iterative print********");
			System.out.println("Next Greater element array: "+Arrays.toString(nge));
			System.out.println("Stack: "+ge.toString());
		}
		while(ge.size()>0) {
			int temp = ge.pop();
			nge[temp]=-1;
		}
		nge[a.length-1]=-1;
		return nge;
 	}
	
	
	public static void main(String[] argc) {
		int a[] = {4, 5, 2, 25};
		int b[]= {13,7,6,12,10};
//		naiveApproach(a);
		
//		LinkedList<Integer> temp = new LinkedList<Integer>();
//		temp.push(10);
//		temp.push(20);
//		temp.pop();
//		System.out.println(temp);
		int nge[] = stack(b);
		System.out.println("Final solution of next greater elemnt: "+Arrays.toString(nge));
	
		
		
	}

}
 