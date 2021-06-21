package com.quicksort;

public class QuickSort {
	
	public int partition(int a[],int l,int h){
		int p=a[l];
		int s=l,e=h;
		
		while(s<e) {
			System.out.println(s);
			while(a[s]<=p && s<h)
				s++;
			while(a[e]>p && e>=0)
				e--;
			if(s<e) {
				int temp=a[s];
				a[s]=a[e];
				a[e]=temp;
			}
		}
		int temp=a[l];
		a[l]=a[e];
		a[e]=temp;
		return e;
	}
	
	public void qSort(int a[],int l,int h) {
		if(l<h) {
			int p=partition(a,l,h);
			qSort(a,l,p-1);
			qSort(a, p+1, h);
		}
	}
	
	public static void main(String[] args) {
		QuickSort q=new QuickSort();
		int a[]= {7,6,10,5,9,2,1,15,7};
		int n=a.length;
		q.qSort(a,0,n-1);
		for(int i:a)
			System.out.print(i+" ");
	}
}
