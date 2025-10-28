import java.util.*;

public class Binary_Strings_Without_Consecutive_Ones {
    public static void main(String[] args) {
        int n =3;
        List<String> binaryList = new ArrayList<>();
        binary_strings(n, "", binaryList);
        System.out.println(binaryList);
    }

    public static void binary_strings(int n, String curr, List<String> res){
        if(curr.length()==n){
            res.add(curr);
            return;
        }

        binary_strings(n, curr + "0", res);

        // (short-circuting condition after || will be verified only when 1st condition fails . Intially string is empty)]
        
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!='1'){
            binary_strings(n, curr + "1", res);
        }
    }
}
