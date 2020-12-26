package singleton.dao;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DaoFactoryImpl {
    private static DaoFactoryImpl instance = null;
    private DaoFactoryImpl(){}
    public static DaoFactoryImpl getInstance(){
        instance = new DaoFactoryImpl();
        return instance;
    }
    public StaffDao createStaffDao() throws IOException, ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties prop=new Properties();
         InputStream in=new BufferedInputStream(new
                 FileInputStream("resource.properties"));
        prop.load(in);

        Class clz = Class.forName(prop.getProperty("staffClass"));
//        Class clz = Class.forName("singleton.dao.MysqlStaffDao");
        StaffDao staffDao = (StaffDao) clz.getDeclaredConstructor().newInstance();
        return staffDao;
    }

    public ComputerDao createComputerDao() throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties prop=new Properties();
        InputStream in=new BufferedInputStream(new
                FileInputStream("E:\\OOADProject\\lab10\\src\\singleton\\dao\\resource.properties"));
        prop.load(in);

        Class clz = Class.forName(prop.getProperty("computerClass"));
        ComputerDao computerDao = (ComputerDao) clz.getDeclaredConstructor().newInstance();
        return computerDao;
    }
}
