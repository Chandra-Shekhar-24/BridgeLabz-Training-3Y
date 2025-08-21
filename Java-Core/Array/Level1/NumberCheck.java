import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Enter number " + (i+1));
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                if(nums[i]%2==0){
                      System.out.println("The number " + nums[i] +" is positive" + " and even");
                }
                else{
                    System.out.println("The number " + nums[i] +" is positive" + " and odd");
                }
            }
            else if(nums[i]<0){
                System.out.println("The number " + nums[i] +" is negative");
            }
            else{
                System.out.println("The number " + nums[i] +" is zero");
            }
        }

            if(nums[0]>nums[n-1]){
                System.out.println("The number " + nums[0] + " is greater than " + nums[n-1]);
            }
            else if(nums[0]<nums[nums.length-1]){
                System.out.println("The number " + nums[0] + " is less than " + nums[n-1]);
            }
            else{
             System.out.println("The number " + nums[0] + " is equal to " + nums[n-1]);   
            }
        
    }
}
