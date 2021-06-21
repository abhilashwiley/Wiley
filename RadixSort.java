package com.radixsort;
//TC:  O((n+b) * log10(k)).

public class RadixSort {
	
	public void sort(int[] ar,int place,int n)
	{
		int[] temp=new int[10];
		int[] res=new int[n];
		for(int i=0;i<n;i++)
			temp[(ar[i]/place)%10]++;

		temp[0]-=1;
		for(int i=1;i<10;i++)
			temp[i]+=temp[i-1];
		

		for(int i=n-1;i>=0;i--)
		{
			res[temp[(ar[i]/place)%10]]=ar[i];
			temp[(ar[i]/place)%10]-=1;
		}
		
		for(int i=n-1;i>=0;i--)
			ar[i]=res[i];
		
	}
	public void radixSort(int[] ar, int n) {
		int max=Integer.MIN_VALUE;
		for (Integer i : ar)
			max = Math.max(max, i);
		int place=1;
		while(max>0)
		{
			sort(ar,place,n);
			place*=10;
			max/=10;
		}
	}

	public static void main(String[] args) {
		int a[] = { 7, 6, 101, 53, 99, 24343, 1, 15, 7 };
		int n = a.length;
		RadixSort rs = new RadixSort();
		rs.radixSort(a, n);
		for(Integer i:a)
			System.out.print(i+"|");
	}

}




