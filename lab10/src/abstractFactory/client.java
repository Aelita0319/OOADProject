package abstractFactory;

import abstractFactory.bean.Computer;
import abstractFactory.bean.Staff;
import abstractFactory.dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class client {
    public static void main(String [] args){

//        StaffFactory staffFactory=new StaffFactory();
//        ComputerFactory computerFactory=new ComputerFactory();
//
//        StaffDao staffDao=staffFactory.createStaffDao(1);
//        ComputerDao computerDao=computerFactory.createComputerDao(1);

        FactoryProducer factoryProducer = new FactoryProducer();
        MysqlDaoFactory mysqlDaoFactory = factoryProducer.createMysqlDaoFactory();
        SqlServerDaoFactory sqlServerDaoFactory = factoryProducer.createSqlServerDaoFactory();

        StaffDao staffDao = mysqlDaoFactory.createStaffDao();
        ComputerDao computerDao = mysqlDaoFactory.createComputerDao();

        test(staffDao,computerDao);
    }

    public static void test(StaffDao mysqlStaffDao,ComputerDao mysqlComputerDao){
        Scanner input=new Scanner(System.in);
        int op=-1;
        do{
            try{
                op=input.nextInt();
                switch (op){
                    case 1:
                        mysqlStaffDao.insertStaff(new Staff());
                        break;
                    case 2:
                        mysqlStaffDao.updateStaff(1);
                        break;
                    case 3:
                        mysqlStaffDao.deleteStaff(1);
                        break;
                    case 4:
                        mysqlComputerDao.insertComputer(new Computer(1));
                        break;
                    case 5:
                        mysqlComputerDao.updateComputer(1);
                        break;
                    case 6:
                        mysqlComputerDao.deleteComputer(1);
                        break;

                }
            }catch(InputMismatchException e){
                System.out.println("Exception "+e);
            }
        }while(op!=0);
    }
//    public static void test(StaffDao staffDao, ComputerDao computerDao){
//        Scanner input=new Scanner(System.in);
//        int op=-1;
//        do{
//            try{
//                op=input.nextInt();
//                switch (op){
//                    case 1:
//                        staffDao.insertStaff(new Staff());
//                        break;
//                    case 2:
//                        staffDao.updateStaff(1);
//                        break;
//                    case 3:
//                        staffDao.deleteStaff(1);
//                        break;
//                    case 4:
//                        computerDao.insertComputer(new Computer(1));
//                        break;
//                    case 5:
//                        computerDao.updateComputer(1);
//                        break;
//                    case 6:
//                        computerDao.deleteComputer(1);
//                        break;
//
//                }
//            }catch(InputMismatchException e){
//                System.out.println("Exception "+e);
//            }
//        }while(op!=0);
//    }
}
