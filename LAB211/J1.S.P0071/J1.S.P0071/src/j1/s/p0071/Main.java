 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

/**
 *
 * @author Duc Anh
 */
public class Main {

    public static void main(String[] args) {

        Validation validator = new Validation();
        Manager mn = new Manager();
        while (true) {
            show();
            int option = validator.getInt("Enter option: ", "Please enter only digit", 1, 4);
            switch (option) {
                case 1:
                    mn.addTask();
                    break;
                case 2:
                    mn.deleteTask();
                    break;
                case 3:
                    mn.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

    private static void show() {
        System.out.println("===========Task program===========\n"
                + "1. Add Task\n"
                + "2. Delete Task\n"
                + "3. Display Task\n"
                + "4. Exit");
    }

}
