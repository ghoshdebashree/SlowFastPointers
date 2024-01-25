import java.util.HashMap;
import java.util.HashSet;

public class HappyNumbers {

    public static void main(String[] args){
        int num = 19;
        System.out.println("Check whether the number is a Happy Number or not");
        if (checkHappy(num)) {
            System.out.println(num + " is a happy number.");
        } else {
            System.out.println(num + " is not a happy number.");
        }
    }

    private static boolean checkHappy(int num) {
//        HashSet<Integer> set = new HashSet<>();     //COMMON APPROACH
//        while(num != 1 && !set.contains(num)){
//            set.add(num);
//            num = genNextNum(num);
//        }
//        return num == 1;
            int slow = num;
            int fast = genNextNum(num);             //SLOW , FAST POINTER APPROACH
            while(slow != 1 && fast != slow){
                slow = genNextNum(slow);
                fast = genNextNum(genNextNum(fast));
        }
            return fast == 1;
    }

    private static int genNextNum(int num) {
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit * digit;
            num = num /10;
        }
        return  sum;
    }
}
