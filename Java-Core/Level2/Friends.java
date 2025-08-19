package Level2;

import java.util.Scanner;

public class Friends {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input ages
        System.out.print("Enter age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter age of Anthony: ");
        int ageAnthony = sc.nextInt();

        // Input heights
        System.out.print("Enter height of Amar: ");
        int hAmar = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        int hAkbar = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        int hAnthony = sc.nextInt();

        // Youngest
        if (ageAmar < ageAkbar && ageAmar < ageAnthony)
            System.out.println("Youngest: Amar");
        else if (ageAkbar < ageAnthony)
            System.out.println("Youngest: Akbar");
        else
            System.out.println("Youngest: Anthony");

        // Tallest
        if (hAmar > hAkbar && hAmar > hAnthony)
            System.out.println("Tallest: Amar");
        else if (hAkbar > hAnthony)
            System.out.println("Tallest: Akbar");
        else
            System.out.println("Tallest: Anthony");
    }
}
