import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Driver {
    public static void main(String[] args) {

        LocalDate rDate[] = { LocalDate.parse("2014-02-14"), LocalDate.parse("2002-01-23") };
        int rSlot[] = { 1, 2 };
        String rMedicare[] = { "EEE11", "YYY99" };

    }

    public int rearrangeReservations(LocalDate[] date, int[] slot, String[] medicare) {
        LocalDate today = LocalDate.now();
        int counter = 0;
        for (int i = 0; i < date.length; i++) {

        }
        return counter;
    }

    public static void sort(LocalDate[] date_arr, int[] slot_arr, String[] medi_arr) {
        LocalDate today = LocalDate.now();
        // Try to make old reservation last and new first
        for (int i = 0; i < (date_arr.length) - 1; ++i) {

            if (date_arr[i].compareTo(today) < 1) {

            }
        }
    }

}
