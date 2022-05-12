import java.time.LocalDate;

public class Driver {
    public static void main(String[] args) {

    LocalDate rDate[] = {LocalDate.parse("2014-02-14"), LocalDate.parse("2002-01-23") };
    int rSlot[] = {1, 2};
    String rMedicare[] = {"EEE11","YYY99"};
 
}
    


public int rearrangeReservations(LocalDate[] date, int[] slot, String[] medicare){
    LocalDate today = LocalDate.now();
    int counter = 0;
    for (int i = 0; i < date.length; i++){

    }
    return counter;
}
public static void bubbleSort(LocalDate [] date_arr, int [] slot_arr, String [] medi_arr){
        
    for (int i=0;i<(date_arr.length)-1;++i){
    
        for(int j=0;j<(date_arr.length)-i-1; ++j){
    
            if(date_arr[j+1].compareTo(date_arr[j]) < 1 ){
    
                LocalDate swap = date_arr[j];
                date_arr[j] = date_arr[j+1];
                date_arr[j+1] = swap;

                int swup = slot_arr[j];
                slot_arr[j] = slot_arr[j+1];
                slot_arr[j+1] = swup;

                String swop = medi_arr[j];
                medi_arr[j] = medi_arr[j+1];
                medi_arr[j+1] = swop;
            }
        }
    }
}

}
