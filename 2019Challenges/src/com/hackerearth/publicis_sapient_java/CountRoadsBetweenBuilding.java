package com.hackerearth.publicis_sapient_java;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
/**
 * Build road between A[j] and A[i] if A[j] = A[i]^2 where i != j and 1<=i,j<=10^5
 * @author Manish
 *
 */
public class CountRoadsBetweenBuilding {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long arr[] = new long[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextLong();
		sc.close();
		long out = solve(arr, N);
		System.out.println(out);
	}
	public static long solve(long[] arr, long N){
		long ans = 0l;
		long power = 0l;
		long sqrt = 0l;
		Map<Long,Long> keeper = new HashMap<Long,Long>();
		for(int i=0;i<arr.length;i++){
			power = arr[i]*arr[i];
			sqrt = sqrt(Math.sqrt(arr[i]));
			if(keeper.containsKey(power)){
				ans += keeper.get(power);
			}
			if(sqrt != -1 && keeper.containsKey(sqrt)){
				ans += keeper.get(sqrt);
			}
			if(keeper.containsKey(arr[i])){
				keeper.put(arr[i],keeper.get(arr[i])+1l);
			}else{
				keeper.put(arr[i],1l);
			}
		}
		return ans;
	}
	public static long sqrt(double sqrt){
		long ans = -1l;
		String strSqrt = sqrt+"";
		return Long.parseLong(strSqrt.split("\\.")[1]) == 0l ? Long.parseLong(strSqrt.split("\\.")[0]) : ans;
	}
}
