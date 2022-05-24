package Programming;

public class Reservations {
    private Date[] dates;
    private int[] slots;
    private String[] medicares;

    public Reservations(int n) {
        this.dates = new Date[n];
        this.slots = new int[n];
        this.medicares = new String[n];
    }

    public void arr(Date[] dates, int[] slots, String[] medicares) {
        this.dates = dates;
        this.slots = slots;
        this.medicares = medicares;
    }

    public Date[] getDates() {
        return dates;
    }

    public int[] getSlots() {
        return slots;
    }

    public String[] getMedicares() {
        return medicares;
    }
}
