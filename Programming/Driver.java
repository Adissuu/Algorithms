package Programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner reader;
        int size = 10000;
        new Generation(size);
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Make a choice for the program: \n1. RearrangeReservations\n2. DisplayReservations\n3. DisplayPastReservationsIncreasingOrder\n4. DisplayPastReservationsDecreasingOrder\n\nYour choice is: ");
        int choice = scan.nextInt();
        // We will read the file
        try {
            File file = new File("Reservations.txt");
            reader = new Scanner(file);
            Date[] rDate = new Date[size];
            int[] rSlot = new int[size];
            String[] rMedicare = new String[size];
            String tempDate;
            // while loop
            for (int i = 0; i < size; i++) {
                tempDate = reader.next();
                rDate[i] = new Date(tempDate);
                rSlot[i] = reader.nextInt();
                rMedicare[i] = reader.next();

            }
            reader.close();
            Date today = new Date("2022-01-01");

            switch (choice) {
                case 1:
                    Timer timer = new Timer("RearrangeReservations");
                    timer.start();
                    System.out.println("Number of active reservations: " +

                            rearrangeReservations(rDate, rSlot, rMedicare, today, rDate.length));
                    timer.stop();
                    break;

                case 2:
                    Timer timer2 = new Timer("DisplayReservations");
                    timer2.start();
                    displayReservations(rDate, rSlot, rMedicare,
                            rearrangeReservations(rDate, rSlot, rMedicare, today, rDate.length));
                    timer2.stop();
                    break;

                case 3:
                    Timer timer3 = new Timer("DisplayReservations");
                    timer3.start();
                    displayPastReservationsIncreasingOrder(rDate, rSlot, rMedicare,
                            (rDate.length - rearrangeReservations(rDate, rSlot, rMedicare, today,
                                    rDate.length)));
                    timer3.stop();
                    break;

                case 4:
                    Timer timer4 = new Timer("DisplayReservations");
                    timer4.start();
                    displayPastReservationsDecreasingOrder(rDate, rSlot, rMedicare,
                            (rDate.length - rearrangeReservations(rDate, rSlot, rMedicare, today,
                                    rDate.length)));
                    timer4.stop();
                    break;
                default:
                    System.out.println("Wrong input. Bye");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Did not work");
        }
        scan.close();
    }

    // This is not the main
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
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        for (int i = 0; i < date.length; i++) {
            outputStream.println(date[i] + " " + slot[i] + " " + medicare[i]);
        }
        outputStream.close();

        return active;
    }

    // Method
    public static void displayReservations(Date[] date, int[] slot, String[] medicare, int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(date[i].toString() + "\t" + slot[i] + "\t" + medicare[i]);
        }
    }

    public static void displayPastReservationsIncreasingOrder(Date[] date, int[] slot, String[] medicare, int n) {
        for (int i = date.length - 1; i > n + 1; i--) {
            System.out.println(date[i].toString() + "\t" + slot[i] + "\t" + medicare[i]);
        }
    }

    public static void displayPastReservationsDecreasingOrder(Date[] date, int[] slot, String[] medicare, int n) {
        for (int i = date.length - n; i < date.length; i++) {
            System.out.println(date[i].toString() + "\t" + slot[i] + "\t" + medicare[i]);
        }
    }

}
