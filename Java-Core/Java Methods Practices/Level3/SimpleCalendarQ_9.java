public class SimpleCalendarQ_9 {

    public static int getStartDay(int y, int m) {
        if (m < 3) { m += 12; y--; }
        return (y + y/4 - y/100 + y/400 + (13 * m + 1) / 5) % 7;
    }

    public static int getDaysInMonth(int y, int m) {
        return switch (m) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) ? 29 : 28;
            default -> 31;
        };
    }

    public static void printCalendar(int y, int m) {
        String[] months = { "", "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December" };
        System.out.printf("     %s %d\n", months[m], y);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int start = getStartDay(y, m);
        int days = getDaysInMonth(y, m);

        for (int i = 0; i < start; i++) System.out.print("   ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            if ((d + start) % 7 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        int year = 2005, month = 7;
        printCalendar(year, month);
    }
}
