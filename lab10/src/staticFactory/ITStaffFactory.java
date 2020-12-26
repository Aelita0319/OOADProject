package staticFactory;

public class ITStaffFactory {
    public static ITManager createITManager(){
        return new ITManager();
    }
    public static Developer createDeveloper(){
        return new Developer();
    }
    public static Tester createTester(){
        return new Tester();
    }
}
