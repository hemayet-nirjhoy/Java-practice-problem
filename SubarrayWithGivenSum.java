package geeksforgeeks;

public class SubarrayWithGivenSum {
	
	public int subArraySum(int arr[], int n, int sum) {
		int curr_sum, i, j;
		for(i=0;i<n;i++) {
			curr_sum = arr[i];
			for (j=i+1;j<=n;j++) {
				if(curr_sum==sum) {
					int p = j-1;
					System.out.println("Sum found between indexes "+i+" and "+ p);
					return 1;
				}
				if(curr_sum>sum || j==n) 
					break;
				curr_sum = curr_sum + arr[j];
			}
		}
		System.out.println("No Subarray found");
		return 0;
		
	}
	
	public int effSubArraySum(int arr[], int n, int sum) {
		int l=0, curr_sum = 0, i, start=0;
		curr_sum = arr[0];
		for(i =1; i <=n;i++) {
			while(curr_sum>sum && start<i-1) {
				curr_sum = curr_sum -arr[start];
				start++;
			}
			if(curr_sum==sum) {
				System.out.println("Sum found from "+ start +" to "+ (i-1));
				return 1;
			}
			if(i<n)
				curr_sum = curr_sum+arr[i];
		}
		System.out.println("No Subarray found!");
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarrayWithGivenSum arraysum = new SubarrayWithGivenSum();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
//		arr[] = {1,4,20,3,10,5};
		int n = arr.length;
		int sum = 23;
//		sum = 33;
		arraysum.subArraySum(arr, n, sum);
		arraysum.effSubArraySum(arr, n, sum);
	}

}
