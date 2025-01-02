public class CoinChangeMaxNumberOfWays{

public static void main(String [] args){

int coin [] = {1,2,3,4};	//	choices are available {1,1,1,2} { 1,1,3}, its a knapsack pattern , 0-1/unbounded
int sum = 5;
int n=coin.length;
//	find number of ways to get 5
//	Same item allowed Multiple time so its UNBOUNDED 
//	Recall subset sum problem
//	count of subset , Number of ways =====>		ADDITION (+)

int t[] [] = new int[n+1][sum+1];	//	addition means t of type int
//	INITIALIZATION
for(int i=0; i<n+1; i++){
	for(int j=0; j<sum+1; j++){
		if(i==0)	t[i][j] = 0;	//	0 at first row 
		if(j==0)	t[i][j] = 1; //	1 at first column
	}
}

System.out.println(maxNumberOfWays(coin,t,sum));	//	

}

public static int maxNumberOfWays(int coin [] , int t[][] , int sum){

	int n=coin.length;
	for(int i=1; i<n+1; i++){
		for(int j=1; j<sum+1; j++){
			if(coin[i-1] <= j){
			t[i][j]	 = t[i-1][j] + t[i][j-coin[i-1]];	//	UNBOUNDED , INCLUDED can come again so array size will be n , + add # of ways	, INCLUDED + EXCLUDED both will be counted
			}
			else{
			t[i][j]	 = t[i-1][j];
			}
		}
	}
return t[n][sum];
}





}