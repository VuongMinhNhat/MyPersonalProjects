import model.*;

import java.util.Scanner;

public class QuanLyNhanSu {
    public static void main(String[] args) {
        System.out.println("================= Chương trình quản lý nhân sự công ty ====================".toUpperCase());
        System.out.println("------------------------------ Homepage -----------------------------------");
        CongTy congTy = new CongTy();
        select(congTy);
    }

    public static void menu(){
        System.out.println("Chọn tác vụ theo dưới đây: ");
        System.out.println("1. Nhập thông tin công ty. ");
        System.out.println("2. Phân bổ nhân viên vào trưởng phòng. ");
        System.out.println("3. Thêm, xóa thông tin một nhân sự. ");
        System.out.println("4. Xuất ra thông tin toàn bộ người trong công ty. ");
        System.out.println("5. Tính và xuất tổng lương cho toàn công ty. ");
        System.out.println("6. Tìm nhân viên thường có lương cao nhất. ");
        System.out.println("7. Tìm Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất. ");
        System.out.println("8. Sắp xếp toàn bộ nhân viên theo thứ tự abc. ");
        System.out.println("9. Sắp xếp toàn bộ nhân viên theo thứ tự lương giảm dần. ");
        System.out.println("10. Tìm Giám đốc có số lượng cổ phần nhiều nhất");
        System.out.println("11. Tính và xuất Tổng thu nhập của từng giám đốc. ");
        System.out.println("0. Kết thúc chương trình. ");
        System.out.println("-------------------------------------------------------- ");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void select(CongTy congTy){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int mode;
        do {
            menu();
            mode = sc.nextInt();
            switch (mode){
                case 1: {   // Nhập thông tin công ty
                    System.out.println("1. Nhập thông tin công ty --------------------");
                    congTy.NhapThongTinCongTy();
                    congTy.XuatThongTinCongTy();
                    break;
                }
                case 2: {    // Phân bổ Nhân viên vào Trưởng phòng
                    System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng --------");
                    congTy.PhanBoNhanVien();
                    break;
                }
                case 3: {    //Thêm, xóa thông tin một nhân viên
                    System.out.println("3. Thêm, xóa thông tin một nhân sự ------------");
                    System.out.print("Nhập 1 để thêm nhân viên. Nhập 2 để xóa nhân viên: ");
                    int themXoa = sc.nextInt();
                    switch (themXoa){
                        case 1 : {
                            NhanVien nhanVienMoi = new NhanVien();
                            congTy.ThemNhanVien(nhanVienMoi);
                            break;
                        }
                        case 2 : congTy.XoaNhanVien(); break;
                    }
                    }
                    break;
                case 4: {    // Xuất ra thông tin toàn bộ người trong công ty
                    System.out.println("4. Xuất ra thông tin toàn bộ nhân viên trong công ty ----");
                    congTy.XuatToanBoNhanVien();
                    break;
                }
                case 5: {    // Tính và xuất tổng lương cho toàn công ty
                    System.out.println("5. Tính và xuất tổng lương cho toàn công ty -------");
                    System.out.println("Tổng lương của toàn công ty là: " + congTy.TinhTongLuongToanCongTy());
                    break;
                }
                case 6: {    // Tìm nhân viên thường có lương cao nhất
                    System.out.println("6. Tìm nhân viên thường có lương cao nhất ---------");
                    congTy.NhanVienThuongLuongCaoNhat();
                    break;
                }
                case 7: {    // Tìm trưởng phòng có số nhân viên dưới quyền nhiều nhất
                    System.out.println("7. Tìm trưởng phòng có số nhân viên dưới quyền nhiều nhất -----");
                    congTy.TruongPhongCoSoNhanVienNhieuNhat();
                    break;
                }
                case 8: {    // Sắp xếp nhân viên toàn công ty theo thứ tự bảng chữ cái
                    System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự bảng chữ cái -----");
                    congTy.SapXepNhanVienTheoTen();
                    break;
                }
                case 9: {    // Sắp xếp nhân viên toàn công ty theo lương
                    System.out.println("9. Sắp xếp nhân viên toàn công ty theo lương giảm dần -------");
                    congTy.SapXepNhanVienTheoLuong();
                    break;
                }
                case 10: {    // Tìm Giám đốc có số lượng cổ phiếu nhiều nhất
                    System.out.println("10. Tìm Giám đốc có số lượng cổ phiếu nhiều nhất ------------");
                    congTy.GiamDocCoNhieuCoPhieuNhat();
                    break;
                }
                case 11: {    // Tính và xuất tổng lương cho toàn công ty
                    System.out.println("11. Tính và xuất tổng lương cho toàn công ty -----------------");
                    congTy.TinhTongThuNhapTungGiamDoc();
                    break;
                }
                case 0: {    //Thoát ra, kết thúc chương trình
                    System.out.println("===================== Chương trình kết thúc ===================".toUpperCase());
                    flag = false;
                    break;
                }
            }
        } while (flag);
    }
}
