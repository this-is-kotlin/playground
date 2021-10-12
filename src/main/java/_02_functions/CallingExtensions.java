package _02_functions;


public class CallingExtensions {

    public static void main(String[] args) {
        var word = "radar";
        var isPalindrome = ExtensionFunKt.isPalindrome(word);
        System.out.println("is " + word + " palindrome? " + isPalindrome);
    }

}
