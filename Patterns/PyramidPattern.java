class PyramidPattern{
    public static void main(String[] args) {
        // int n= 5;
        // char[][] patt = new char[n][2*n];

        // for(int i=0; i<n;i++){
        //     for(int j=0;j<n-i;j++){
        //         patt[i][j] = ' ';
        //     }
        //     for(int j=n-1;j>=n-i;j--){
        //         patt[i][j] = '*';
        //     }

            
        //     for(int k=n;k<=n+i;k++){
        //         patt[i][k] = '*';
        //     }
        //     for(int k=n+i+1;k<2*n;k++){
        //         patt[i][k] = ' ';
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2*n;j++){
        //         System.out.print( patt[i][j]);

        //     }
        //     System.out.println(" ");
        // }


        int n= 5;

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");  
            }

            for(int j=n-i-1;j<n+i;j++){
                System.out.print("*");  
            }

            System.out.println(" ");
        }
    }
}