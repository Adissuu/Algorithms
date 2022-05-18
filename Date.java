public class  Date {
    int number;

    public Date(String s){
        String arr[] = s.split("-");
        this.number = Integer.parseInt(arr[0]+arr[1]+arr[2]);
    }

    public String toString(){
        String date = ""+number;
        date = date.substring(0,4) + "-" + date.substring(4,6)+"-"+date.substring(6,8);
        return date;
    }
}
