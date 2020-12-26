package abstractFactory.dao;

public interface DaoFactory {
    public StaffDao createStaffDao();
    public ComputerDao createComputerDao();
}
