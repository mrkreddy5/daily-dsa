import java.util.*;

public class sort_hashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        nums.put(2,5);
        nums.put(6,1);
        nums.put(4,1);
        nums.put(5,7);
        nums.put(1,8);

        numFreq(nums);

        HashMap<Character, Integer> charFreq = new HashMap<>();
        charFreq.put('C',5);
        charFreq.put('F',1);
        charFreq.put('K',1);
        charFreq.put('R',7);
        charFreq.put('B',8);

        chars(charFreq);

    }

    public static void numFreq(Map<Integer,Integer> nums){
        List<Map.Entry<Integer, Integer>> numsList = new ArrayList<>(nums.entrySet());
        numsList.sort((a,b)-> a.getKey().compareTo(b.getKey()));

        for(Map.Entry<Integer, Integer> kv : numsList){
            System.out.println(kv.getKey() + "," + kv.getValue());
        }
    }

    public static void chars(Map<Character, Integer> charFreq){
        List<Map.Entry<Character, Integer>> charList = new ArrayList<>(charFreq.entrySet());
        charList.sort((a,b)-> a.getValue().compareTo(b.getValue()));

        for(Map.Entry<Character, Integer> kv : charList){
            System.out.println(kv.getKey() + "," + kv.getValue());
        }
    }
}
