import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSV {

    // 1. Attributes/ Data members /Fields
    private ArrayList<SinhVien> listSV; // = new ArrayList<SinhVien>()

    // Hàm getter và setter
    public ArrayList<SinhVien> getListSV() {
        return listSV;
    }

    public void setListSV(ArrayList<SinhVien> listSV) {
        this.listSV = listSV;
    }

    // Hàm khởi tạo
    public DanhSachSV() {
        // this.listSV = new ArrayList<SinhVien>();
        setDefault();
    }

    private void setDefault() {
        this.listSV = new ArrayList<SinhVien>();
        // code here
        // code here
    }

    // Hàm input, output
    public void NhapDS(Scanner sc) {
        for (SinhVien sv : this.listSV) {
            sv.NhapMoi();
        }
    }

    public void ThemSV(SinhVien sv) {
        this.listSV.add(sv);
    }

    public void XuatThongTinSV() {
        System.out.println("Nhập mã số sinh viên cần xuất: ");
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        // Tìm sinh viên target
        for (SinhVien sv : this.listSV){
            if (target.equals(sv.getMaSV())){
                sv.XuatThongTinDayDu();
            }
        }
    }

    public void XuatDanhSachSV() {
        System.out.println("===== DANH SÁCH SINH VIÊN CỦA TRƯỜNG ========");
        for (SinhVien sv : this.listSV) {
            sv.XuatThongTinRutGon();
        }
        System.out.println("=============================================");
    }

    // Hàm quản lý (hiệu chỉnh và xóa)
    public void HieuChinh() {
        System.out.println("Nhập mã số sinh viên cần hiệu chỉnh: ");
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        // Tìm sinh viên target
        for (SinhVien sv : this.listSV){
            if (target.equals(sv.getMaSV())){
                sv.HieuChinh();
            }
        }
    }

    public void XoaSV() {
        System.out.println("Nhập mã số sinh viên cần xóa: ");
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        // Tìm sinh viên target
        for (SinhVien sv : this.listSV){
            if (target.equals(sv.getMaSV())){
                System.out.println("Xác nhận xóa sinh viên này ?");
                System.out.println("Nhập 'Y' để xóa, nhập 'N' để bỏ qua: ");
                String delete = sc.nextLine().toUpperCase();
                if (delete.equals("Y")) {
                    this.listSV.remove(sv);
                }
            }
        }
    }
}

