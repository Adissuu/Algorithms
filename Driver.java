public class Driver {
    public static void main(String[] args) {

        Date rDate[] = { new Date("2021-11-25"), new Date("2022-03-08"), new Date("2021-12-02"), new Date("2022-02-01"),
                new Date("2021-12-02"), new Date("2021-12-03"), new Date("2022-01-25"), new Date("2022-01-14"),
                new Date("2022-02-01"), new Date("2022-02-01") };
        int rSlot[] = { 25, 10, 7, 15, 3, 40, 36, 11, 10, 15 };
        String rMedicare[] = { "EEE11", "YYY99", "A", "A", "A", "A", "A", "A", "a", "a" };
        Date today = new Date("2022-01-01");

        System.out.println(rearrangeReservations(rDate, rSlot, rMedicare, today, rDate.length));
        for (int i = 0; i < rDate.length; i++)
            System.out.println(rDate[i].toString());

        // displayReservations(rDate, rSlot, rMedicare, 6);
    }

    // Methods
    public static int rearrangeReservations(Date[] date, int[] slot, String[] medicare, Date today, int n) {
        Date tDate[] = new Date[date.length];
        int tSlot[] = new int[date.length];
        String tMedicare[] = new String[date.length];
        int active = 0;
        boolean done = false;

        if (n == 1)
            done = true;
        for (int i = 0; i < n - 1; ++i) {
            if ((date[i + 1].number < date[i].number)
                    || ((date[i + 1].number == date[i].number) && (slot[i + 1] < slot[i]))) {
                // bubble sort
                Date swap = date[i];
                date[i] = date[i + 1];
                date[i + 1] = swap;

                int swup = slot[i];
                slot[i] = slot[i + 1];
                slot[i + 1] = swup;

                String swop = medicare[i];
                medicare[i] = medicare[i + 1];
                medicare[i + 1] = swop;
            }
        }
        if (done != true)
          active = rearrangeReservations(date, slot, medicare, today, n - 1);
        if (done == true) {
            for (int j = 0; j < date.length; j++) {
                tDate[j] = date[j];
                tSlot[j] = slot[j];
                tMedicare[j] = medicare[j];
            }
            int left = 0;
            int right = date.length - 1;
            for (int i = 0; i < tDate.length; i++) {
                if (tDate[i].number > today.number) {
                    date[left] = tDate[i];
                    slot[left] = tSlot[i];
                    medicare[left] = tMedicare[i];
                    active++;
                    left++;
                } else {
                    date[right] = tDate[i];
                    slot[right] = tSlot[i];
                    medicare[right] = tMedicare[i];
                    right--;
                }
            }
        }

        return active;
    }

    // Method
    public static void displayReservations(Date[] date, int[] slot, String[] medicare, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(date[i].toString() + "\t" + slot[i] + "\t" + medicare[i]);
        }
    }
}
