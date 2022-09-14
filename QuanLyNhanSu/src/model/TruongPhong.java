package model;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NhanVien {
    //public int soNhanVienQuanLy = 0;

    //public List<NhanVien> danhSachNhanVienQuanLy = new ArrayList<>();

//    public TruongPhong(){}

//    public int getSoNhanVienQuanLy() {
//        return soNhanVienQuanLy;
//    }
//
//    public void setSoNhanVienQuanLy(int soNhanVienQuanLy) {
//        this.soNhanVienQuanLy = soNhanVienQuanLy;
//    }
//
//    public List<NhanVien> getDanhSachNhanVienQuanLy() {
//        return danhSachNhanVienQuanLy;
//    }
//
//    public void setDanhSachNhanVienQuanLy(List<NhanVien> danhSachNhanVienQuanLy) {
//        this.danhSachNhanVienQuanLy = danhSachNhanVienQuanLy;
//    }

    @Override
    public double TinhLuong() {
        double luongThang = this.soNgayLV*this.luongNgay + 100*this.soNhanVienQuanLy;
        return luongThang;
    }

}
