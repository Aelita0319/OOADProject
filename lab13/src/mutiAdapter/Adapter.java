package mutiAdapter;

import java.util.Comparator;
import java.util.List;

public class Adapter implements FileOperateInterfaceV2{
    private FileOperateInterfaceV1 adaptee1;
    private ManageStaffInterface adaptee2;

    public Adapter(FileOperateInterfaceV1 adaptee1, ManageStaffInterface adaptee2) {
        this.adaptee1 = adaptee1;
        this.adaptee2 = adaptee2;
    }

    @Override
    public List<StaffModel> readAllStaff() {
        List<StaffModel> list = adaptee1.readStaffFile();
        return list;
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        adaptee1.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        list.sort(new Comparator<StaffModel>() {
            @Override
            public int compare(StaffModel o1, StaffModel o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        adaptee1.writeStaffFile(list);
    }

    @Override
    public void writeByRoom(List<StaffModel> list) {
        list.sort(new Comparator<StaffModel>() {
            @Override
            public int compare(StaffModel o1, StaffModel o2) {
                return o1.getRoom().compareTo(o2.getRoom());
            }
        });
        adaptee1.writeStaffFile(list);
    }

    @Override
    public void addNewStaff(List<StaffModel> list) {
        adaptee2.addingStaff(list);
    }

    @Override
    public void removeStaffByName(List<StaffModel> list) {
        adaptee2.removeStaff(list);
    }
}
