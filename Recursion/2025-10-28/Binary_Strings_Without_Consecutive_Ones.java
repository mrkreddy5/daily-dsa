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

    // Below code is more efficient as strings are immutable wasting more space in above code

    public static void binary_strings_sb(int n, StringBuilder curr, List<String> res) {
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }

        // Always can add '0'
        curr.append('0');
        binary_strings_sb(n, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        // Add '1' only if last char is not '1'
        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            curr.append('1');
            binary_strings_sb(n, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
