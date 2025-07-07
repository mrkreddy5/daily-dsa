public class NumberCrown {
    public static void main(String[] args) {
        int n =5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1 + " ");
            }

            for(int j=i+1;j<2*n-i-1;j++){
                System.out.print("  ");
            }

            for(int j=2*n-i-2;j<2*n-1;j++){
                System.out.print(2*n-j-1 + " ");
            }

            System.out.println(" ");
        } 
    }
}
