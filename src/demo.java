import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class demo {
    public String toString(){
        return "hello world";
    }
    public static void main(String[] args){
        Properties prop=new Properties();
        try{
            InputStream in=new BufferedInputStream(new
                    FileInputStream("src/resource.properties"));
            prop.load(in);
            try {
                Class clz=Class.forName(prop.getProperty("classname"));
                demo object= (demo)clz.getDeclaredConstructor().newInstance();
                System.out.println(object);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}