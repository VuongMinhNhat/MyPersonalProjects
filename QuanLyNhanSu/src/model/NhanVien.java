package model;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class NhanVien {
    protected String maSo;
    protected String hoTen;
    protected String soDT;
    protected String chucVu;
    protected int soNgayLV;
    protected double luongNgay;

    protected NhanVien truongPhongQuanLy;  //dùng riêng cho nhân viên thường có trưởng phòng

    protected int soNhanVienQuanLy;  //dùng riêng cho trưởng phòng

    protected List<NhanVien> danhSachNhanVienQuanLy = new ArrayList<>();  //dùng riêng cho trưởng phòng

    protected double phanTramCoPhan;   //dùng riêng cho giám đốc
    public NhanVien(){

    }

    public NhanVien(String hoTen, String maSo, String chucVu, int soNgayLV, double luongNgay){
        this.hoTen = hoTen;
        this.maSo = maSo;
        this.chucVu = chucVu;
        this.soNgayLV = soNgayLV;
        this.luongNgay = luongNgay;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        switch (this.chucVu) {
            case "Nhân viên thường" : this.maSo = "NV" + maSo; break;
            case "Trưởng phòng" : this.maSo = "TP" + maSo; break;
            case "Giám đốc" : this.maSo = "GD" + maSo; break;
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getChucVu() { return chucVu; }

    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    public int getSoNgayLV() {
        return soNgayLV;
    }

    public void setSoNgayLV(int soNgayLV) {
        this.soNgayLV = soNgayLV;
    }

    public double getLuongNgay() {
        return luongNgay;
    }

    public void setLuongNgay(double luongNgay) {
        this.luongNgay = luongNgay;
    }

    public NhanVien getTruongPhongQuanLy() {
        return truongPhongQuanLy;
    }

    public void setTruongPhongQuanLy(NhanVien truongPhongQuanLy) {
        this.truongPhongQuanLy = truongPhongQuanLy;
    }

    //Dùng riêng cho trưởng phòng --------------------------------------------
    public int getSoNhanVienQuanLy() {
        return soNhanVienQuanLy;
    }

    public void setSoNhanVienQuanLy(int soNhanVienQuanLy) {
        this.soNhanVienQuanLy = soNhanVienQuanLy;
    }

    public List<NhanVien> getDanhSachNhanVienQuanLy() {
        return danhSachNhanVienQuanLy;
    }

    public void setDanhSachNhanVienQuanLy(List<NhanVien> danhSachNhanVienQuanLy) {
        this.danhSachNhanVienQuanLy = danhSachNhanVienQuanLy;
    }
    // ----------------------------------------------------------------------------

    // Dùng riêng cho giám đốc ----------------------------------------------------

    public double getPhanTramCoPhan() {
        return phanTramCoPhan;
    }

    public void setPhanTramCoPhan(double phanTramCoPhan) {
        this.phanTramCoPhan = phanTramCoPhan;
    }

    public double TinhTongThuNhap(double doanhThu, double tongLuong){
        double tongThuNhap;
        if (this.chucVu.equals("Giám đốc")){
            tongThuNhap = this.TinhLuong() + (doanhThu - tongLuong)*this.phanTramCoPhan/100;
        } else {tongThuNhap = this.TinhLuong();}
        return tongThuNhap;
    }

    // ------------------------------------------------------------------------------

    public void NhapThongTin(){
        Scanner sc = new Scanner(System.in);
        // Phần hiển thị lên user interface
        System.out.println("Nhập họ và tên nhân viên: ");
        this.hoTen = sc.nextLine();
        System.out.println("Nhập mã số nhân viên: ");
        this.maSo = sc.nextLine();

        System.out.println("Các chức vụ trong công ty: ");
        System.out.println("1. Nhân viên thường");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Giám đốc");
        System.out.print("-> Nhập số tương ứng với chức vụ của nhân viên: ");
        Scanner sc1 = new Scanner(System.in);
        int position = sc1.nextInt();
        switch (position){
            case 1 : {this.chucVu = "Nhân viên thường"; this.maSo = "NV"+this.maSo; break;}
            case 2 : {this.chucVu = "Trưởng phòng"; this.maSo = "TP"+this.maSo; break;}
            case 3 : {this.chucVu = "Giám đốc"; this.maSo = "GD"+this.maSo; break;}
        }

        System.out.println("Nhập số điện thoại của nhân viên: ");
        this.soDT = sc.nextLine();
        System.out.println("Nhập số ngày làm việc của nhân viên: ");
        this.soNgayLV = sc.nextInt();

        switch (this.getChucVu()){        //Cập nhật lương ngày theo chức vụ
            case "Nhân viên thường" : {this.luongNgay = 100; break;}
            case "Trưởng phòng" : {this.luongNgay = 200; break;}
            case "Giám đốc" : {this.luongNgay = 300; break;}
        }

        System.out.println("Thông tin nhân viên đã lưu: ");
        this.XuatThongTin();
    }

    public void XuatThongTin(){
        System.out.println("Họ và tên: " + this.hoTen);
        System.out.println("Mã số nhân viên: " + this.maSo);
        System.out.println("Chức vụ: " + this.chucVu);
        System.out.println("Số điện thoại: " + this.soDT);
        System.out.println("Lương một ngày: " + this.luongNgay);
        System.out.println("Số ngày làm việc: " + this.soNgayLV + " ngày");
        System.out.println("Lương tháng: " + this.TinhLuong());
        System.out.println("----------------------------------------------------------");
    }

    public double TinhLuong(){
        double luongThang = this.soNgayLV*this.luongNgay;
        return luongThang;
    }

    public int CapNhatSoNhanVien() {
        if(this.getChucVu().equals("Trưởng phòng")) {
            this.soNhanVienQuanLy += 1;
        }
        return this.soNhanVienQuanLy;
    }

    public List CapNhanDanhSachNhanVienQuanLy(NhanVien nhanVien) {
        if(this.getChucVu().equals("Trưởng phòng")) {
            this.danhSachNhanVienQuanLy.add(nhanVien);

        }
        return this.danhSachNhanVienQuanLy;
    }
}
