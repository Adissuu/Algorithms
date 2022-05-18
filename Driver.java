public class Driver {
    public static void main(String[] args) {

       
        Date rDate[] = { new Date("2021-11-25"), new Date("2022-03-08"), new Date("2021-12-02"), new Date("2022-02-01"), new Date("2021-12-02"), new Date("2021-12-03"), new Date("2022-01-25"), new Date("2022-01-14"), new Date("2022-02-01"), new Date("2022-01-01") };
        int rSlot[] = { 25, 10, 7, 15, 3, 40, 36, 11, 10, 15};
        String rMedicare[] = { "EEE11", "YYY99", "A","A","A","A","A","A", "a","a" };
        Date today = new Date("2022-01-01");
        
        rearrangeReservations(rDate, rSlot, rMedicare, today, rDate.length);
        for (int i = 0; i < rDate.length; i++)
            System.out.println(rDate[i].toString());
         }

    public static int rearrangeReservations(Date[] date, int[] slot, String[] medicare, Date today, int n) {
        
        for (int i = 0; i < n - 1; ++i) {
            if(n == 1) break;
            if ((date[i + 1].number < date[i].number) || ((date[i+1].number == date[i].number) && (slot[i+1] < slot[i]))) {
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
        }
        rearrangeReservations(date, slot, medicare, today, n-1);
    }
        Date tDate[] = new Date[date.length];
        int tSlot[] = new int[date.length];
        String tMedicare[] = new String[date.length];
        int left,right, active = 0;
        for (int i = 0;i < date.length;i++){
            left = 0;
            right = date.length-1;
            if (date[i].number > today.number){
                while (tDate[left] != null)
                    left++;
                tDate[left] = date[i];
                tSlot[left] = slot[i];
                tMedicare[left] = medicare[i];
                active++;
            }
            else{
                while (tDate[right] != null)
                    right--;
            
                tDate[right] = date[i];
                tSlot[right] = slot[i];
                tMedicare[right] = medicare[i];
            }
        }
        for (int i = 0;i < date.length;i++){
            date[i] = tDate[i];
            slot[i] = tSlot[i];
            medicare[i] = tMedicare[i];
         }
        return active;
    }

}
