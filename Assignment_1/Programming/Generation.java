package Programming;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Generation {

    private int size;

    public Generation(int size) {
        this.size = size;

        String[] dates = generateDates();
        String[] slots = generateSlots();
        String[] medicares = generateMedicares();

        PrintWriter outFile = null;

        try {
            outFile = new PrintWriter(new FileOutputStream("Reservations.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        for (int i = 0; i < size; i++) {
            outFile.println(dates[i] + " " + slots[i] + " " + medicares[i]);
        }
        outFile.close();

    }

    public String[] generateDates() {
        String[] dates = new String[size];

        for (int i = 0; i < size; i++) {
            int year = ThreadLocalRandom.current().nextInt(2015, 2030);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 31);

            String monthString;
            String dayString;

            if (month < 10) {
                monthString = "0" + month;
            } else {
                monthString = "" + month;
            }

            if (day < 10) {
                dayString = "0" + day;
            } else {
                dayString = "" + day;
            }
            dates[i] = year + "-" + monthString + "-" + dayString;
        }

        return dates;
    }

    public String[] generateSlots() {
        String[] slots = new String[size];

        for (int i = 0; i < size; i++) {
            int slot = ThreadLocalRandom.current().nextInt(1, 100);
            if (slot < 10) {
                slots[i] = " " + slot;
            } else {
                slots[i] = "" + slot;
            }
        }
        return slots;
    }

    public String[] generateMedicares() {
        String[] medicares = new String[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String medicare = random.ints(97, 123).limit(3)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString().toUpperCase();
            medicare = medicare + ThreadLocalRandom.current().nextInt(10, 99);
            medicares[i] = medicare;
        }

        return medicares;
    }
}