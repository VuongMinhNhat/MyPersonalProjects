/***********************************************
 * Mô tả chương trình
 * Chương trình quản lý sinh viên với 5 chức năng chính:
 *   1. Thêm sinh viên mới.
 *   2. Hiệu chỉnh thông tin và nhập điểm sinh viên.
 *   3. Xóa sinh viên.
 *   4. Xem thông tin một sinh viên.
 *   5. Xuất danh sách toàn bộ sinh viên.
 * Thông tin sinh viên sau khi nhập liệu được lưu trữ vào một danh sách sinh viên
 * Vì lí do bảo mật điểm sinh viên, khi Thêm sinh viên mới (1) chỉ được nhập thông tin cá nhân và
 *      không cho phép nhập điểm sinh viên cùng lúc.
 * Để nhập điểm sinh viên bắt buộc phải sử dụng chức năng Hiệu chỉnh thông tin và nhập điểm sinh viên (2).
 *************************************************/

import java.util.Scanner;

public class QuanLySV {
    public static void main(String[] args) {
        System.out.println("Chương trình quản lý sinh viên".toUpperCase());
        System.out.println("================= Homepage =================");
        DanhSachSV ds = new DanhSachSV();
        select(ds);
    }

    public static void menu(){
        System.out.println("Chọn tác vụ theo dưới đây: ");
        System.out.println("1. Thêm sinh viên mới. ");
        System.out.println("2. Hiệu chỉnh thông tin và nhập điểm sinh viên. ");
        System.out.println("3. Xóa thông tin một sinh viên. ");
        System.out.println("4. Xem thông tin một sinh viên. ");
        System.out.println("5. Xuất danh sách toàn bộ sinh viên. ");
        System.out.println("0. Kết thúc chương trình. ");
        System.out.println("---------------------------------- ");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void select(DanhSachSV ds){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int mode;
        do {
            menu();
            mode = sc.nextInt();
            switch (mode){
                case 1: {   //Thêm SV mới
                    SinhVien sv = new SinhVien();
                    sv.NhapMoi();
                    ds.ThemSV(sv);
                    break;
                }
                case 2: {    //Hiệu chỉnh thông tin SV
                    ds.HieuChinh();
                    break;
                }
                case 3: {    //Xóa thông tin một sinh viên
                    ds.XoaSV();
                    break;
                }
                case 4: {    //Xuất thông tin một sinh viên
                    ds.XuatThongTinSV();
                    break;
                }
                case 5: {    //Xuất danh sách sinh viên
                    ds.XuatDanhSachSV();
                    break;
                }
                case 0: {    //Thoát ra, kết thúc chương trình
                    System.out.println("============= Chương trình kết thúc ==============".toUpperCase());
                    flag = false;
                    break;
                }
            }
        } while (flag);
    }
}
