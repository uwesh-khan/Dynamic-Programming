public class CountNoOfSubsetWithGivenDifference{

public static int sumArray(int arr []){
	int sum=0;
	for(int i=0; i<arr.length; i++){
		sum += arr[i];
	}
return sum;
}

public static void main(String [] args){
//	INPUT
int arr [] = {1,1,2,3};
int diff = 1;
int n=arr.length;
int sum = sumArray(arr);

//	s1 - s2 = diff
//	s1 + s2 = sum =>	2 s1 = diff + sum	
int s1 = (diff + sum)/2;
//	Need to find the count of subset sum of s1(sum of subset 1)	by subsetSum method,	got by two equations

//	Initialization 

int t[][] = new int[n+1][sum+1];

for(int i=0; i<n+1; i++){
	for(int j=0; j<sum+1; j++){
		if(i==0)	t[i][j]=0;	//	if length 6 , sum can be zero
		if(j==0)	t[i][j]=1;
	}
}

System.out.println(subsetSum(arr,t,s1));	//	it will be equal to the count of the no subset with a five given difference


}

public static int subsetSum(int arr[] , int t [] [] , int sum){
	int n = arr.length;
	for(int i=1; i<n+1; i++){
		for(int j=1; j<sum+1; j++){
			if(arr[i-1] <= j){
				t[i][j]=t[i-1][j]	+ 	t[i-1][j-arr[i-1]];	//	EXCLUDE + INCLUDE
			}
			else{
				t[i][j] = t[i-1][j];
			}
		}
	}
return t[n][sum];
}



}