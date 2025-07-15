import java.util.*;

public class PascalsTriangle {

    /* Outer loop starts from index =1 , i.e is why we use outer(i-2) to get previous row elements 
     T.c = O(n^2), S.C = O(n^2)
    */


    public List<List<Integer>> printTriangle(int numRows) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner;
        for(int i=1;i<=numRows;i++)
        {
            inner = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1)
                    inner.add(1);
                else
                    inner.add(outer.get(i-2).get(j-1)+ outer.get(i-2).get(j));
            }
            outer.add(inner);
        }
        return outer;
        
    }

    /* In this method every row is independent of previous row, where as time and space complexities are same as above */


    public List<List<Integer>> printTriangleUsingNthrowStrategy(int numRows) {
        List<List<Integer>> outer = new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            int ele =1;
            List<Integer> row = new ArrayList<>();
            row.add(1);
        
            for(int j=1;j<=i;j++){
                ele = ele * (i-j+1) / j;
                row.add(ele);
            }

            outer.add(row);
        }
        return outer;
        
    }




    /* Print rth element in nth row of pascals triangle , it is like finding (n-1) c (r-1) = (n-1)! / (r! * (n-1)!) 
        T.C = O(r) , S.C = O(1)
    */

    public void printRthElement(int n, int r){
        int res =0;
        for(int i=0;i<n;i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        System.out.println(res);
    }


    /* Print nth row of pascals triangle T.C = O(n), S.C = O(1) for printing , O(n) for storing */


    public List<Integer> printNthRow(int n){
        int ele =1;
        List<Integer> li = new ArrayList<>();
        li.add(1);
        
        for(int i=1;i<=n;i++){
            ele = ele * (n-i+1) / i;
            li.add(ele);
        }

        return li;
    }


}


