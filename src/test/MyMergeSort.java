package test;
import javax.naming.spi.DirStateFactory.Result;

/**
 * 归并排序练习
 * @author wangk
 *
 */
public class MyMergeSort {

	public static void main(String[] args) {
		MyMergeSort m = new MyMergeSort();
		int count = 200;
		System.out.println("随机数数量:"+count);
		int a[] = new int[count];
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random()*10);
			builder.append(a[i]);
			builder.append(" ");
		}
	//	System.out.println(builder.toString());
		long startTime = System.currentTimeMillis();
		m.mergeSort(a, a.length);
		long endTime = System.currentTimeMillis();
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append("result:");
		for (int i = 0; i < a.length; i++) {
			resultBuilder.append(a[i]);
			resultBuilder.append(" ");
		}
		System.out.println(resultBuilder.toString());
		long calcTime = endTime-startTime;
		System.out.println("合并排序算法花费时间:"+calcTime+"毫秒");
	}
	
	private int[] mergeSortArray(int a[],int first,int mid,int last,int[] temp) {
		int i = first;
		int j = mid+1;
		int k = 0;
		int m = mid;
		int n = last;
		
		while(i <= m && j <= n) {
			if(a[i] >= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		while(i<=m)
			temp[k++] = a[i++];
		while(j<=n)
			temp[k++] = a[j++];
		for (int l = 0; l < k; l++) {
			a[l+first] = temp[l];
		}
		return a;
	}
	
	private int[] mergeSortRecursion(int a[],int first,int last,int[] temp) {
		if(first < last) {
			int mid = (first + last)/2;
			mergeSortRecursion(a, first, mid, temp); // left
			mergeSortRecursion(a, mid+1, last, temp); // right
			mergeSortArray(a, first, mid, last, temp);
		}
		return a;
	}
	
	public int[] mergeSort(int a[] ,int n) {
		int temp[] = new int[n];
		mergeSortRecursion(a, 0, n-1, temp);
		return a;
	}
}
