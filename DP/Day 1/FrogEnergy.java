class solution {
  public int energy(int n, int[] h) {
    int[] dp = new int[n];
    dp[0]= 0;
    dp[1]= Math.abs(h[0]-h[1]);
    for(int i=2;i<n;i++){
      int step1 = dp[i-1]+Math.abs(h[i]-h[i-1]);
      int step2 = dp[i-2]+Math.abs(h[i]-h[i-2]);
      dp[i] = Math.min(step1,step2);
    }
    return dp[n-1];
  }
}
