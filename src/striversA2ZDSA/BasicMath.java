package striversA2ZDSA;

public class BasicMath {
    public void digitCount(int n) {
        int cnt = (int) (Math.log10(n) + 1);
        System.out.println(cnt);
    }
    public void reverseDigits(int n) {
        int result = 0;
        while(n != 0) {
            result = result * 10 + (n%10);
            n  = (int) n/10;
        }
        System.out.println(result);
    }
    public void isPalindrome(int n) {
        int revNum = 0;
        int dup = n;
        while (n > 0) {
            revNum = (revNum * 10) + n % 10;
            n = n / 10;
        }
        System.out.print("The number is palindrome : ");
        System.out.print(dup == revNum);
    }
}
