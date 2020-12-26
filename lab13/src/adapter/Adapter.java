package adapter;

import java.util.Comparator;
import java.util.List;

public class Adapter implements FileOperateInterfaceV2 {
    private FileOperateInterfaceV1 adaptee1;

    public Adapter(FileOperateInterfaceV1 fileOperate) {
        this.adaptee1 = fileOperate;
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
    public void writeByPeopleId(List<StaffModel> list) {
        adaptee1.writeStaffFile(list);
    }


    @Override
    public void writeByRoom(List<StaffModel> list) {
        list.sort(Comparator.comparing(StaffModel::getRoom));
        adaptee1.writeStaffFile(list);
    }
}
