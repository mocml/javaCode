
import java.util.Date;

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
public class Main {

    public static void main(String[] args) {
        Validation v = new Validation();
        while (true) {
            Date date = v.getDate("Enter Date : ");
            System.out.println("Day of Week : " + v.getDayOfWeek(date)+"\n");
        }
    }
}
