/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Duc Anh
 */
public class Validation {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int number = Integer.parseInt(input.readLine());
                if (number < min || number > max) {
                    System.out.println(err);
                    continue;
                }
                return number;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }

    String getString(String msg, String err, String regex) {
        while (true) {
            try {
                String str;
                System.out.print(msg);
                str = input.readLine().toLowerCase().trim().replaceAll("\\s+", " ");
                if (str.matches(regex)) {
                    String[] temp = str.split(" ");
                    str = "";
                    for (int i = 0; i < temp.length; i++) {
                        str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                        if (i < temp.length - 1) {
                            str += " ";
                        }
                    }
                     return str;
                } else {
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    String getDate(String msg, String err
    ) {
        while (true) {
            try {
                Date date;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                System.out.print(msg);
                sdf.setLenient(false);
                date = sdf.parse(input.readLine());

                Date now = new Date();
                if (date.after(now)) {
                    System.out.println("Ngay ban nhap phai be hon ngay hien tai");
                    continue;
                }

                return sdf.format(date);
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    double getDoub(String msg, String err,
            double min, double max
    ) {
        while (true) {
            try {
                System.out.print(msg);
                double number = Double.parseDouble(input.readLine());
                if (number < min || number > max) {
                    System.out.println(err);
                    continue;
                }
                return number;
            } catch (Exception ex) {
                System.out.print(err);
            }
        }
    }

    public double getFrom() {
        while (true) {
            try {
                System.out.print("From: ");
                double number = Double.parseDouble(input.readLine());
                if (number >= 8.0 && number < 17.5) {
                    if (number % 0.5 == 0) {
                        return number;
                    }
                } else {
                    System.out.println("Enter a number in the range [8.0-17.0]!");
                }
            } catch (Exception e) {
                System.out.println("Invalid! Try again!");
            }
        }
    }

    public double getTo(double planFrom) {
        while (true) {
            try {
                System.out.print("To: ");
                double number = Double.parseDouble(input.readLine());
                if (number >= 8.0 && number <= 17.5) {
                    if (number % 0.5 == 0) {
                        if (number > planFrom) {
                            return number;
                        } else {
                            System.out.println("Plan from should be less than plan to!");
                        }
                    }
                } else {
                    System.out.println("Enter a number in the range [8.0-17.0]!");
                }
            } catch (Exception e) {
                System.out.println("Invalid! Try again!");
            }
        }
    }

}
