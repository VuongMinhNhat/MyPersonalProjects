package model;

import java.util.Scanner;

public class GiamDoc extends NhanVien {
    private double phanTramCoPhan = 1000;

//    public GiamDoc(){}

    public double getCoPhan() {
        return phanTramCoPhan;
    }

    public void setCoPhan(double phanTramCoPhan) {
        this.phanTramCoPhan = phanTramCoPhan;
    }

    public double TinhTongThuNhap(){
        double tongThuNhap = 0;
        return tongThuNhap;
    }

    @Override
    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin();
        while (this.phanTramCoPhan<0 || this.phanTramCoPhan>100) {  //Bắt người dùng nhập đúng từ 0-100
            System.out.println("Nhập số cổ phần (0% - 100%) của Giám đốc: ");
            this.phanTramCoPhan = sc.nextDouble();
        }
    }
}
