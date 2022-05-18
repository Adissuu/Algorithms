
public class Driver {
    public static void main(String[] args) {

       
        Date rDate[] = { new Date("2014-01-23"), new Date("2002-01-23"), new Date("2005-12-06") };
        int rSlot[] = { 2, 1, 5};
        String rMedicare[] = { "EEE11", "YYY99", "A" };
        Date today = new Date("2022-05-17");

        rearrangeReservations(rDate, rSlot, rMedicare, today, rDate.length); 
        System.out.println(rDate[0].toString());

        }

    public static void rearrangeReservations(Date[] date, int[] slot, String[] medicare, Date today, int n) {
        
        for (int i = 0; i < n - 1; ++i) {
            if(n == 1) break;
            if ((date[i + 1].number < date[i].number)) {
                //bubble sort
                Date swap = date[i];
                date[i] = date[i + 1];
                date[i + 1] = swap;

                int swup = slot[i];
                slot[i] = slot[i + 1];
                slot[i + 1] = swup;

                String swop = medicare[i];
                medicare[i] = medicare[i + 1];
                medicare[i + 1] = swop; 
                //check slot
                if(date[i+i].number == date[i].number && slot[i+1] < slot[i]){
                    if(slot[i+1] < slot[i]){
                    swap = date[i];
                    date[i] = date[i + 1];
                    date[i + 1] = swap;
    
                    swup = slot[i];
                    slot[i] = slot[i + 1];
                    slot[i + 1] = swup;
    
                    swop = medicare[i];
                    medicare[i] = medicare[i + 1];
                    medicare[i + 1] = swop; 
                    }
                }         
            }
            rearrangeReservations(date, slot, medicare, today, n-1);
        }
        
        return;
    }

}
