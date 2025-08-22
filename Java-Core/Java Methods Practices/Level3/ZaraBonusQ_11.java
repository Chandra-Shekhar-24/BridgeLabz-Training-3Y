import java.util.*;
public class ZaraBonusQ_11 {
    public static int[][] generateData(int n) {
        int[][] emp = new int[n][2];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            emp[i][0] = 10000 + r.nextInt(90000); 
            emp[i][1] = 1 + r.nextInt(10);        
        }
        return emp;
    }
    public static int[][] calculateBonus(int[][] emp) {
        int[][] res = new int[emp.length][4];
        for (int i = 0; i < emp.length; i++) {
            int bonus = (int)(emp[i][0] * (emp[i][1] > 5 ? 0.05 : 0.02));
            res[i][0] = emp[i][0]; res[i][1] = emp[i][1]; res[i][2] = bonus; res[i][3] = emp[i][0] + bonus;
        }
        return res;
    }
    public static void display(int[][] data) {
        int sumOld = 0, sumBonus = 0, sumNew = 0;
        System.out.printf("%-10s %-10s %-10s %-10s\n","OldSalary","Years","Bonus","NewSalary");
        for (int[] e : data) {
            System.out.printf("%-10d %-10d %-10d %-10d\n",e[0],e[1],e[2],e[3]);
            sumOld += e[0]; sumBonus += e[2]; sumNew += e[3];
        }
        System.out.println("---------------------------------------------");
        System.out.printf("%-10d %-10s %-10d %-10d\n",sumOld,"-",sumBonus,sumNew);
    }
    public static void main(String[] args) {
        display(calculateBonus(generateData(10)));
    }
}