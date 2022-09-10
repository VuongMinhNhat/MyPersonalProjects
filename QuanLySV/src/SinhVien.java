import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SinhVien {
    private String hoTen;
    private String maSV;
    private String ngaySinh;
    private String noiSinh;
    private List<String> dsMonHoc = new ArrayList<>();
    private List<Integer> dsTinChi = new ArrayList<>();
    private List<Double> dsDiem = new ArrayList<>();
    private double diemTB;
    private String xepLoai;

    // Hàm khởi tạo
    public SinhVien(){

    }

    public SinhVien(String hoTen, String maSV, String ngaySinh, String noiSinh){
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
    }

    // Hàm getter và Setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public List<String> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(List<String> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public List<Integer> getDsTinChi() {
        return dsTinChi;
    }

    public void setDsTinChi(List<Integer> dsTinChi) {
        this.dsTinChi = dsTinChi;
    }

    public List<Double> getDsDiem() {
        return dsDiem;
    }

    public void setDsDiem(List<Double> dsDiem) {
        this.dsDiem = dsDiem;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    // Hàm nhập mới SV
    public void NhapMoi(){
        Scanner sc = new Scanner(System.in);
        // Phần hiển thị lên user interface
        System.out.println("Nhập họ và tên sinh viên: ");
        this.hoTen = sc.nextLine();
        System.out.println("Nhập mã số sinh viên: ");
        this.maSV = sc.nextLine();
        System.out.println("Nhập ngày sinh của sinh viên: ");
        this.ngaySinh = sc.nextLine();
        System.out.println("Nhập nơi sinh của sinh viên: ");
        this.noiSinh = sc.nextLine();
        System.out.println("Thông tin sinh viên đã lưu. \n");
    }

    public void HieuChinh(){
        String flagThongTin = "Y";
        String flagNhapDiem = "Y";
        String flagSuaDiem = "Y";
        Scanner sc = new Scanner(System.in);
        // Phần hiển thị lên user interface
        System.out.println("----------- Phần thông tin cá nhân ------------");
        System.out.println("Nhập 'Y' để chỉnh sửa thông tin cá nhân, nhập 'N' để thoát phần này ");
        flagThongTin = sc.nextLine().toUpperCase();
        if (flagThongTin.equals("Y")) {
            System.out.println("Nhập lại mã số sinh viên (có thể chỉnh sửa nếu cần thiết): ");
            this.maSV = sc.nextLine();
            System.out.println("Nhập họ và tên sinh viên: ");
            this.hoTen = sc.nextLine();
            System.out.println("Nhập ngày sinh của sinh viên: ");
            this.ngaySinh = sc.nextLine();
            System.out.println("Nhập nơi sinh của sinh viên: ");
            this.noiSinh = sc.nextLine();
        }

        System.out.println("------- Phần nhập điểm môn học mới -------- ");
        System.out.println("Nhập 'Y' để tiếp tục, nhập 'N' để thoát phần này. ");
        flagNhapDiem = sc.next().toUpperCase();
        while (flagNhapDiem.equals("Y")) {
            System.out.println("------- Phần nhập điểm môn học mới -------- ");
            this.NhapDiemMon();
            System.out.println("Nhập 'Y' để tiếp tục, nhập 'N' để thoát phần này. ");
            flagNhapDiem = sc.next().toUpperCase();
        }

        System.out.println("------- Phần sửa điểm môn học -------- ");
        System.out.println("Nhập 'Y' để tiếp tục, nhập 'N' để thoát phần này. ");
        flagSuaDiem = sc.next().toUpperCase();
        while (flagSuaDiem.equals("Y")) {
            System.out.println("------- Phần sửa điểm môn học -------- ");
            this.SuaDiemMon();
            System.out.println("Nhập 'Y' để tiếp tục, nhập 'N' để thoát phần này. ");
            flagSuaDiem = sc.next().toUpperCase();
        }
    }

    public void NhapDiemMon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên môn học: ");
        dsMonHoc.add(sc.nextLine());
        System.out.println("Nhập số tín chỉ: ");
        dsTinChi.add(sc.nextInt());
        System.out.println("Nhập điểm môn học: ");
        dsDiem.add(sc.nextDouble());
    }

    public void SuaDiemMon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên môn học: ");
        String target = sc.nextLine();
        if (!dsMonHoc.contains(target)){
            System.out.println("Môn học không tồn tại. Vui lòng thử lại.");
        } else {       // Có tồn tại sinh viên trong danh sách thì tìm sinh viên đó và sửa
            System.out.println("Nhập tên môn học cần sửa: ");
            int targetIndex = dsMonHoc.indexOf(target);
            dsMonHoc.set(targetIndex,sc.nextLine());
            System.out.println("Nhập số tín chỉ môn học cần sửa: ");
            dsTinChi.set(targetIndex,sc.nextInt());
            System.out.println("Nhập điểm môn học cần sửa: ");
            dsDiem.set(targetIndex,sc.nextDouble());
        }
    }

    public void XuatThongTinDayDu(){
        //Phần xử lý ngầm, không hiển thị
        this.diemTB = this.TinhDiemTrungBinh();
        this.xepLoai = this.XepLoai(this.diemTB);
        //Phần hiển thị ra user interface
        System.out.println("Họ và tên sinh viên: " + this.hoTen);
        System.out.println("Mã sinh viên: " + this.maSV);
        System.out.println("Ngày sinh: " + this.ngaySinh);
        System.out.println("Nơi sinh: " + this.noiSinh);
        System.out.println("Điểm trung bình tích lũy: " + this.diemTB);
        System.out.println("Xếp loại: " + this.xepLoai);
        System.out.println("\n------- BẢNG ĐIỂM SINH VIÊN --------");
        System.out.println("Môn học \t Số tín chỉ \t Điểm trung bình môn");
        for (int i=0; i<dsMonHoc.size();i++){
            System.out.println(dsMonHoc.get(i) + "\t" + dsTinChi.get(i) + "\t" + dsDiem.get(i));
        }
    }

    public void XuatThongTinRutGon(){
        this.diemTB = this.TinhDiemTrungBinh();
        this.xepLoai = this.XepLoai(this.diemTB);
        System.out.println(this.maSV+"\t"+this.hoTen+"\t"+this.ngaySinh+"\t"+this.noiSinh+"\t"+this.diemTB+"\t"+xepLoai);

    }

    public double TinhDiemTrungBinh(){
        int tongTC = 0;
        double tongDiem = 0;
        for (int i=0; i<dsMonHoc.size(); i++){
            tongDiem += dsDiem.get(i)*dsTinChi.get(i);
            tongTC += dsTinChi.get(i);
        }
        double diemTB = tongDiem/tongTC;
        return diemTB;
    }

    public String XepLoai(double diemTB) {
        if (diemTB >= 9) {
            this.xepLoai = "Xuất sắc";
        } else if (diemTB < 9 && diemTB >= 8) {
            this.xepLoai = "Giỏi";
        } else if (diemTB < 8 && diemTB >= 6.5) {
            this.xepLoai = "Khá";
        } else if (diemTB < 6.5 && diemTB >= 5) {
            this.xepLoai = "Trung bình";
        } else if (diemTB < 5) {
            this.xepLoai = "Yếu";
        }
        return xepLoai;
    }
}
