package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CongTy {
    public String tenCongTy;
    public String maSoThue;
    public double doanhThuThang;
    public ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

    public ArrayList<NhanVien> danhSachGiamDoc = new ArrayList<>();

    public CongTy(){

    }
    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    public ArrayList<NhanVien> getListNV() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public ArrayList<NhanVien> getDanhSachGiamDoc() {
        return danhSachGiamDoc;
    }

    public void setDanhSachGiamDoc(ArrayList<NhanVien> danhSachGiamDoc) {
        this.danhSachGiamDoc = danhSachGiamDoc;
    }

    public void NhapThongTinCongTy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên công ty: ");
        this.tenCongTy = sc.nextLine();
        System.out.println("Nhập mã số thuế: ");
        this.maSoThue = sc.nextLine();
    }

    public void XuatThongTinCongTy(){
        System.out.println("Tên Công ty: " + this.tenCongTy);
        System.out.println("Mã số thuế: " + this.maSoThue);
    }

    public void PhanBoNhanVien(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã số Nhân viên (không cần nhập 2 ký tự NV): ");
        String targetNV = "NV"+scanner.nextLine();
        boolean existNV = false;
        boolean existTP = false;
        NhanVien nhanVienTarget = new NhanVien();
        NhanVien truongPhongTarget = new NhanVien();
        for (NhanVien nhanVien : this.danhSachNhanVien){   // Tìm nhân viên
            if (targetNV.equals(nhanVien.maSo)){
                existNV = true;
                System.out.println("Nhập mã số trưởng phòng quản lý Nhân viên này (không cần nhập 2 ký tự TP): ");
                String targetTP = "TP"+scanner.nextLine();
                for (NhanVien nhanVien1 : this.danhSachNhanVien){    // Tìm trưởng phòng
                    if (targetTP.equals(nhanVien1.maSo)){
                        existTP = true;
                        nhanVienTarget = nhanVien;
                        truongPhongTarget = nhanVien1;   // lưu tạm để xử lý
                    }
                }
                if (existTP){
                    truongPhongTarget.CapNhatSoNhanVien();
                    truongPhongTarget.CapNhanDanhSachNhanVienQuanLy(nhanVienTarget);
                    nhanVienTarget.setTruongPhongQuanLy(truongPhongTarget);
                    System.out.println("Đã cập nhật nhân viên "+nhanVienTarget.hoTen+" thuộc quản lý của trưởng phòng "+truongPhongTarget.hoTen);
                    System.out.printf("Trưởng phòng này hiện có: %d nhân viên \n", truongPhongTarget.getSoNhanVienQuanLy());
                } else System.out.println("Không tìm thấy trưởng phòng. Vui lòng thử lại.");
            }
        }
        if (!existNV){
            System.out.println("Không tìm thấy nhân viên. Vui lòng thử lại.");
        }
        //scanner.close();
    }

    public void ThemNhanVien(NhanVien nhanVienMoi){
        Scanner scanner = new Scanner(System.in);
        nhanVienMoi.NhapThongTin();
        //Không cho nhập trùng mã số nhân viên giữa các nhân viên có cùng chức vụ
        for(NhanVien nhanVien: this.danhSachNhanVien){
            if((nhanVien.getMaSo()).equals(nhanVienMoi.getMaSo())){
                System.out.println("Mã số nhân viên bị trùng lặp với nhân viên khác. Vui lòng nhập mã số khác.");
                System.out.println("Nhập mã số mới cho nhân viên này: ");
                nhanVienMoi.setMaSo(scanner.nextLine());
            }
        }
        this.danhSachNhanVien.add(nhanVienMoi);
        //scanner.close();
    }

    public void XoaNhanVien() {
        System.out.println("Nhập mã số nhân viên cần xóa: ");
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        boolean exist = false;           //flag: tồn tại nhân viên có mã số đó ?
        boolean dlt = false;
        NhanVien nhanVienTarget = new NhanVien();

        // Tìm nhân viên viên target
        for (NhanVien nhanVien : this.danhSachNhanVien){  // Dò tìm nhân viên trong danh sách
            if (nhanVien.getMaSo().contains(target)){       // Tìm được nhân viên đó
                exist = true;
                System.out.println("Xác nhận xóa nhân viên này ?");
                System.out.println("Nhập 'Y' để xóa, nhập 'N' để bỏ qua: ");
                String deleteConfirm = scanner.nextLine().toUpperCase();
                if (deleteConfirm.equals("Y")) {
                    dlt = true;
                    nhanVienTarget = nhanVien;
                }
            }
        }
        if(dlt){
            this.danhSachNhanVien.remove(nhanVienTarget);
        }
        if (!exist){      //Sau khi tìm hết danh sách vẫn không tìm được nhân viên thì báo lỗi
            System.out.println("Không tìm thấy nhân viên.Vui lòng thử lại.");
        }
        //scanner.close();
    }

    public void XuatToanBoNhanVien(){
        for (NhanVien nhanVien : this.danhSachNhanVien){
            nhanVien.XuatThongTin();
        }

    }

    public double TinhTongLuongToanCongTy(){
        double tongLuong = 0;
        for(NhanVien nhanVien : this.danhSachNhanVien){
            tongLuong += nhanVien.TinhLuong();
            System.out.println(nhanVien.hoTen+", mã số: "+nhanVien.maSo+" có lương là: "+nhanVien.TinhLuong());
        }
        return tongLuong;
    }

    public void NhanVienThuongLuongCaoNhat(){
        double luongCaoNhat = 0;
        System.out.println("Nhân viên thường có lương cao nhất là: ");
        for (NhanVien nhanVien : danhSachNhanVien){     // Tìm mức lương cao nhất
            if(nhanVien.chucVu.equals("Nhân viên thường")) {
                if (nhanVien.TinhLuong() >= luongCaoNhat) {
                    luongCaoNhat = nhanVien.TinhLuong();
                }
            }
        }
        for (NhanVien nhanVien : danhSachNhanVien){     // Tìm các nhân viên có cùng mức lương cao nhất
            if(nhanVien.chucVu.equals("Nhân viên thường")) {
                if (nhanVien.TinhLuong() == luongCaoNhat) {
                    nhanVien.XuatThongTin();
                }
            }
        }
    }

    public void TruongPhongCoSoNhanVienNhieuNhat(){
        int soNhanVienQuanLyMax = 0;
        for (NhanVien nhanVien : danhSachNhanVien){
            if (nhanVien.getChucVu().equals("Trưởng phòng")){
                if (nhanVien.getSoNhanVienQuanLy() > soNhanVienQuanLyMax){
                    soNhanVienQuanLyMax = nhanVien.getSoNhanVienQuanLy();
                }
            }
        }
        System.out.printf("Các trưởng phòng có cùng số nhân viên dưới quyền nhiều nhất (%d) là: \n", soNhanVienQuanLyMax);
        for (NhanVien nhanVien : danhSachNhanVien){
            if (nhanVien.getChucVu().equals("Trưởng phòng")){
                if (nhanVien.getSoNhanVienQuanLy() == soNhanVienQuanLyMax){
                    System.out.println(" - " + nhanVien.getHoTen());
                }
            }
        }
    }

    public void SapXepNhanVienTheoTen(){
        ArrayList<String> danhSachTen = new ArrayList<>();
        ArrayList<NhanVien> temp = new ArrayList<>();
        for (NhanVien nhanVien : this.danhSachNhanVien){
            danhSachTen.add(nhanVien.getHoTen());
        }
        Collections.sort(danhSachTen);     // Dùng method sort của collections class để sort Array List kiểu <String>
        for (String hoTen : danhSachTen){
            for (NhanVien nhanVien : this.danhSachNhanVien){
                if (hoTen.equals(nhanVien.getHoTen())){
                    temp.add(nhanVien);
                }
            }
        }
        this.danhSachNhanVien = temp;
        System.out.println("Danh sách nhân viên đã sắp xếp theo tên: ");
        for (NhanVien nhanVien : this.danhSachNhanVien){
            System.out.println("- " + nhanVien.getHoTen());
        }
    }

    public void SapXepNhanVienTheoLuong(){
       this.danhSachNhanVien.sort((o1, o2) -> (int) (o2.TinhLuong() - o1.TinhLuong()));
        System.out.println("Danh sách nhân viên đã sắp xếp theo thứ tự lương giảm dần: ");
        for (NhanVien nhanVien : this.danhSachNhanVien){
            System.out.println("- " + nhanVien.getHoTen() + " , lương = " + nhanVien.TinhLuong());
        }
    }

    public void GiamDocCoNhieuCoPhieuNhat(){
        Scanner scanner = new Scanner(System.in);
        double coPhanMax = 0;
        for (NhanVien nhanVien : this.danhSachNhanVien){
            if(nhanVien.getChucVu().equals("Giám đốc")){
                nhanVien.setPhanTramCoPhan(1000);
                System.out.println("Giám đốc: " + nhanVien.getHoTen());
                //Bắt người dùng nhập đúng từ 0-100
                while (nhanVien.getPhanTramCoPhan()<0 || nhanVien.getPhanTramCoPhan()>100) {
                    System.out.println("Nhập số cổ phần (0% - 100%) của Giám đốc: ");
                    nhanVien.setPhanTramCoPhan(scanner.nextDouble());
                }
                this.danhSachGiamDoc.add(nhanVien);
            }
        }
        for (NhanVien nhanVien : danhSachGiamDoc){
            if(nhanVien.getPhanTramCoPhan() > coPhanMax){
                coPhanMax = nhanVien.getPhanTramCoPhan();
            }
        }
        System.out.printf("Các Giám đốc có cùng số cổ phần lớn nhất %f phần trăm là: \n",coPhanMax);
        for (NhanVien nhanVien : danhSachGiamDoc){
            if(nhanVien.getPhanTramCoPhan() == coPhanMax){
                System.out.println(nhanVien.getHoTen());
            }
        }
    }

    public void TinhTongThuNhapTungGiamDoc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập doanh thu của công ty: ");
        double doanhThu = scanner.nextDouble();
        double tongLuong = this.TinhTongLuongToanCongTy();
        for(NhanVien gd : this.danhSachGiamDoc){
            if (gd.chucVu.equals("Giám đốc")){
                System.out.println(gd.hoTen + ", thu nhập: " + gd.TinhTongThuNhap(doanhThu,tongLuong));
            }
        }
    }
}
