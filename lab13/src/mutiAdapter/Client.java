package mutiAdapter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<StaffModel> list = new ArrayList<StaffModel>();
        FileOperateInterfaceV1 fileOperator1 = new FileOperate();
        ManageStaffInterface manageStaff = new ManageStaff();
        FileOperateInterfaceV2 fileOperator2 = new Adapter(fileOperator1, manageStaff);
        System.out.println("Please select operation: "+ "1.readFile 2.listFile 3.writeFileByName 4.writeFileByPeopleId " +
                "5.addStaff 6.removeStaff");
        int op = 0;
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1:
                        list = fileOperator2.readAllStaff();
                        break;
                    case 2:
                        fileOperator2.listAllStaff(list);
                        break;
                    case 3:
                        fileOperator2.writeByName(list);
                        break;
                    case 4:
                        fileOperator2.addNewStaff(list);
                        break;
                    case 5:
                        fileOperator2.removeStaffByName(list);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception:" + e);
                input.nextLine();
            }
        } while (op != 0);
        input.close();

    }
}
