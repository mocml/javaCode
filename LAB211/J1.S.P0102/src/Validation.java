
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 19/07/2021    1.0            Vanhv   
 */
/**
 *
 * @author vanhv
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

    Date getDate(String msg) {
        String regex = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}";
        while (true) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);

                System.out.print(msg);
                String input = sc.nextLine();
                if (input.matches(regex)) {

                    Date date = formatter.parse(input);
                    return date;
                } else {
                    System.err.println("Date not exist !!");
                }
            } catch (ParseException e) {
                System.err.println("Date not exist !!");
            }
        }
    }

    String getDayOfWeek(Date getDate) {

        String dayOfWeek = new SimpleDateFormat("EEEE").format(getDate);

        Calendar c = Calendar.getInstance();
        c.setTime(getDate);

        return dayOfWeek;
    }

}
