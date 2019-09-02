package codes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;

public class DifferenceDate {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String date = in.next();
        out.println(dayOfYear(date));
    }

    public int dayOfYear(String date) {
        long difference = 0;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date beforeDate = dateFormat.parse(date.substring(0, 4)+ "-01-01");
            Date dateAfter = dateFormat.parse(date);
            difference = dateAfter.getTime() - beforeDate.getTime();

        }catch( Exception e){
            e.printStackTrace();
        }
        return (int)( Math.ceil((difference/(1000*60*60*24))) + 1 );

    }
}
