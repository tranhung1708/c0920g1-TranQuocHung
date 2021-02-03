package CaseStudy.service;

import CaseStudy.common.FileUtils;
import CaseStudy.controllers.MainController;
import CaseStudy.model.*;
import CaseStudy.validate.Regex;

import java.util.*;

public class ServiceManager {
    public static final String FILE_VILLA = "src/CaseStudy/data/Villa.csv";
    public static final String FILE_HOUSE = "src/CaseStudy/data/House.csv";
    public static final String FILE_ROOM = "src/CaseStudy/data/Room.csv";
    public static final String FILE_CUSTOMER = "src/CaseStudy/data/Customer.csv";
    public static final String FILE_EMPLOYEE = "src/CaseStudy/data/Employee.csv";
    public static final String FILE_BOOKING = "src/CaseStudy/data/Booking.csv";
    public static final String COMMA = ",";
    public static ArrayList<Villa> villaArrayList = new ArrayList<>();
    public static ArrayList<Customer> customerArrayList = new ArrayList<>();
    public static ArrayList<House> houseArrayList = new ArrayList<>();
    public static ArrayList<Room> roomArrayList = new ArrayList<>();
    public static Queue<VeXemPhim> ticket = new ArrayDeque<>();
    public static Stack<NhanVien> nhanViens = new Stack<>();
    public static List<String> list = new ArrayList<>();
    public static String lineBooking = "";
    public static String lineCustomer = "";
    public static String lineVilla = "";
    public static String lineHouse = "";
    public static String lineRoom = "";
    public static int choose = 0;
    public static final Scanner scanner = new Scanner(System.in);
    public static String id;
    public static String tenDichVu;
    public static String dienTichSuDung;
    public static String chiPhiThue;
    public static String soLuongNguoiToiDa;
    public static String kieuThue;
    public static String soTang;
    public static String giaTien;
    public static String hoTen;
    public static String ngaySinh;
    public static String gioiTinh;
    public static String cmnd;
    public static String soDienThoai;
    public static String email;
    public static String loaiKhach;
    public static String tenDichVuDiKem;
    public static String line = null;

    public static void addNewServices() {
        do {
            System.out.println("Mời bạn nhập tên dịch vụ");
            tenDichVu = scanner.nextLine();
        } while (!Regex.IsTenDichVu(tenDichVu));
        do {
            System.out.println("Mời bạn nhập diện tích sử dụng");
            dienTichSuDung = scanner.nextLine();
        } while (!Regex.IsDienTichSuDung(dienTichSuDung));
        do {
            System.out.println("Mời bạn nhập chi phí thuê");
            chiPhiThue = scanner.nextLine();
        } while (!Regex.IsChiPhiThue(chiPhiThue));
        do {
            System.out.println("Mời bạn nhập số người ở");
            soLuongNguoiToiDa = scanner.nextLine();
        } while (!Regex.IsSoLuongNguoi(soLuongNguoiToiDa));
        do {
            System.out.println("Mời bạn nhập kiểu thuê");
            kieuThue = scanner.nextLine();
        } while (!Regex.IsKieuThue(kieuThue));
    }

    public static void addNewCustomer() {
        do {
            System.out.println("Mời bạn nhập tên : ");
            hoTen = scanner.nextLine();
        } while (!Regex.IsName(hoTen));
        do {
            System.out.println("Mời bạn nhập ngày sinh : ");
            ngaySinh = scanner.nextLine();
        } while (!Regex.IsNgaysinh(ngaySinh));
        do {
            System.out.println("Mời bạn nhập giới tính");
            gioiTinh = scanner.nextLine();
        } while (!Regex.IsGender(gioiTinh));
        do {
            System.out.println("Mời bạn nhập IdCard");
            cmnd = scanner.nextLine();
        } while (!Regex.IsIDCard(cmnd));
        do {
            System.out.println("Mời bạn nhập số điện thoại");
            soDienThoai = scanner.nextLine();
        } while (!Regex.IsNumberPhone(soDienThoai));
        do {
            System.out.println("Mời bạn nhập email");
            email = scanner.nextLine();
        } while (!Regex.IsEmail(email));
        do {
            System.out.println("Mời bạn nhập loại khách");
            loaiKhach = scanner.nextLine();
        } while (!Regex.IsLoaiKhach(loaiKhach));
        System.out.println("Mời bạn nhập địa chỉ");
        String diaChi = scanner.nextLine();

        line = hoTen + COMMA + ngaySinh + COMMA + gioiTinh + COMMA + cmnd + COMMA + soDienThoai + COMMA + email + COMMA + loaiKhach + COMMA + diaChi;
        FileUtils.writeFile(FILE_CUSTOMER, line, true);

    }

    public static void addNewVilla() {
        do {
            System.out.println("Mời bạn nhập id : ");
            id = scanner.nextLine();
        } while (!Regex.IsIdVilla(id));
        addNewServices();
        System.out.println("Nhập tiêu chuẩn phòng");
        String tieuChuanPhong = scanner.nextLine();
        System.out.println("Nhập mô tả tiện nghi khác");
        String moTaTienNghiKhac = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi");
        String dienTichHoBoi = scanner.nextLine();
        do {
            System.out.println("Mời bạn nhập số tầng");
            soTang = scanner.nextLine();
        } while (!Regex.IsSoTang(soTang));
        line = id + COMMA + tenDichVu + COMMA + dienTichSuDung + COMMA + chiPhiThue + COMMA + soLuongNguoiToiDa + COMMA + kieuThue + COMMA + tieuChuanPhong + COMMA + moTaTienNghiKhac + COMMA + dienTichHoBoi + COMMA + soTang;
        FileUtils.writeFile(FILE_VILLA, line, true);
    }

    public static void addNewHouse() {
        //int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        do {
            System.out.println("Mời bạn nhập id :");
            id = scanner.nextLine();
        } while (!Regex.IsIdHouse(id));
        addNewServices();
        System.out.println("Nhập tiêu chuẩn phòng");
        String tieuChuanPhong = scanner.nextLine();
        System.out.println("Mô tả tiện nghi khác");
        String moTaTienNghi = scanner.nextLine();
        do {
            System.out.println("Mời bạn nhập số tầng");
            soTang = scanner.nextLine();
        } while (!Regex.IsSoTang(soTang));
        line = id + COMMA + tenDichVu + COMMA + dienTichSuDung + COMMA + chiPhiThue + COMMA + soLuongNguoiToiDa + COMMA + kieuThue + COMMA + tieuChuanPhong + COMMA + moTaTienNghi + COMMA + soTang;
        FileUtils.writeFile(FILE_HOUSE, line, true);
    }

    public static void addNewRoom() {
        do {
            System.out.println("Mời bạn nhập id :");
            id = scanner.nextLine();
        } while (!Regex.IsIdRoom(id));
        addNewServices();
        do {
            System.out.println("Mời nhập dịch vụ đi kèm");
            tenDichVuDiKem = scanner.nextLine();
        } while (!Regex.IsDichVuDiKem(tenDichVuDiKem));
        System.out.println("Nhập đơn vị");
        String donVi = scanner.nextLine();
        do {
            System.out.println("Mời bạn nhập chi phí thuê");
            giaTien = scanner.nextLine();
        } while (!Regex.IsGiaTien(giaTien));
        line = id + COMMA + tenDichVu + COMMA + dienTichSuDung + COMMA + chiPhiThue + COMMA + soLuongNguoiToiDa + COMMA + kieuThue + COMMA + tenDichVuDiKem + COMMA + donVi + COMMA + giaTien;
        FileUtils.writeFile(FILE_ROOM, line, true);
    }

    public static void showVilla() {
        List<String> villaList = FileUtils.read(FILE_VILLA);
        for (String villa1 : villaList) {
            System.out.println(villa1);
        }
    }

    public static void showHouse() {
        List<String> stringList = FileUtils.read(FILE_HOUSE);
        for (String house1 : stringList) {
            System.out.println(house1);
        }
    }

    public static void showRoom() {
        List<String> roomList = FileUtils.read(FILE_ROOM);
        for (String room1 : roomList) {
            System.out.println(room1);
        }
    }

    public static void ShowInformationOfCustomer() {
        List<String> customerList = FileUtils.read(FILE_CUSTOMER);
        List<Customer> customerList1 = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            String[] arrayCustomer = customerList.get(i).split(",");
            String hoTen = arrayCustomer[0];
            String ngaySinh = arrayCustomer[1];
            String gioiTinh = arrayCustomer[2];
            String cmnd = arrayCustomer[3];
            String soDienThoai = arrayCustomer[4];
            String email = arrayCustomer[5];
            String loaiKhach = arrayCustomer[6];
            String diaChi = arrayCustomer[7];
            Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, loaiKhach, diaChi);
            customerList1.add(customer);
        }
        Collections.sort(customerList1, new Comparator());
        for (Customer customer : customerList1) {
            System.out.println(customer);
        }
    }

    public static void ShowAllNameVillaNotDuplicate() {
        List<String> showInformationVilla = FileUtils.read(FILE_VILLA);
        List<Villa> villaList = new ArrayList<>();
        for (int i = 0; i < showInformationVilla.size(); i++) {
            String[] arrayListVilla = showInformationVilla.get(i).split(",");
            String id = arrayListVilla[0];
            String tenDichVu = arrayListVilla[1];
            String dienTichSuDung = arrayListVilla[2];
            String chiPhiThue = arrayListVilla[3];
            String soLuongNguoiToiDa = arrayListVilla[4];
            String kieuThue = arrayListVilla[5];
            String tieuChuanPhong = arrayListVilla[6];
            String moTaTienNghiKhac = arrayListVilla[7];
            String dienTichHoBoi = arrayListVilla[8];
            String soTang = arrayListVilla[9];
            Villa villa = new Villa(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);
            villaList.add(villa);
        }
        TreeSet<Villa> villaTreeSet = new TreeSet<>(villaList);
        for (Villa villa : villaTreeSet) {
            System.out.println(villa);
        }
    }

    public static void ShowAllNameHouseNotDuplicate() {
        List<String> showInFormationHouse = FileUtils.read(FILE_HOUSE);
        List<House> houseList = new ArrayList<>();
        for (int i = 0; i < showInFormationHouse.size(); i++) {
            String[] arrayHouse = showInFormationHouse.get(i).split(",");
            String id = arrayHouse[0];
            String tenDichVu = arrayHouse[1];
            String dienTichSuDung = arrayHouse[2];
            String chiPhiThue = arrayHouse[3];
            String soLuongNguoiToiDa = arrayHouse[4];
            String kieuThue = arrayHouse[5];
            String tieuChuanPhong = arrayHouse[6];
            String moTaTienNghiKhac = arrayHouse[7];
            String soTang = arrayHouse[8];
            House house = new House(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, soTang);
            houseList.add(house);
        }

        TreeSet<House> houseTreeSet = new TreeSet<>(houseList);
        for (House house : houseTreeSet) {
            System.out.println(house);
        }
    }

    public static void ShowAllRoomNotDuplicate() {
        List<String> showInFormation = FileUtils.read(FILE_ROOM);
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < showInFormation.size(); i++) {
            String[] arrayRoom = showInFormation.get(i).split(",");
            String id = arrayRoom[0];
            String tenDichVu = arrayRoom[1];
            String dienTichSuDung = arrayRoom[2];
            String chiPhiThue = arrayRoom[3];
            String soLuongNguoiToiDa = arrayRoom[4];
            String kieuThue = arrayRoom[5];
            String tenDichVuDiKem = arrayRoom[6];
            String donVi = arrayRoom[7];
            String giaTien = arrayRoom[8];
            Room room = new Room(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tenDichVuDiKem, donVi, giaTien);
            roomList.add(room);
        }
        TreeSet<Room> roomTreeSet = new TreeSet<>(roomList);
        for (Room room : roomTreeSet) {
            System.out.println(room);
        }
    }

    public static void showEmployee() {
        List<String> stringList = FileUtils.read(FILE_EMPLOYEE);
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] employeeString = stringList.get(i).split(",");
            String name = employeeString[0];
            String birthday = employeeString[1];
            String diaChi = employeeString[2];
            Employee employee = new Employee(name, birthday, diaChi);
            employeeList.add(employee);
        }
        Map<Integer, Employee> employeeMap = new TreeMap<>();
        int j = 0;
        for (Employee employee : employeeList) {
            employeeMap.put(j, employee);
            j++;
        }
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

    }

    public static void addNewBooking() {
        List<String> customerList = FileUtils.read(FILE_CUSTOMER);
        List<Customer> customerList1 = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            String[] arrayBooking = customerList.get(i).split(",");
            String hoten = arrayBooking[0];
            String ngaySinh = arrayBooking[1];
            String gioiTinh = arrayBooking[2];
            String cmnd = arrayBooking[3];
            String soDienThoai = arrayBooking[4];
            String email = arrayBooking[5];
            String loaiKhach = arrayBooking[6];
            String diaChi = arrayBooking[7];
            Customer customer = new Customer(hoten, ngaySinh, gioiTinh, cmnd, soDienThoai, email, loaiKhach, diaChi);
            customerList1.add(customer);
        }
        int i = 0;
        System.out.println("Danh sách customer : ");
        for (String customer : customerList) {
            System.out.println(i + "." + customer);
            i++;
        }
        System.out.println("Nhập vị trí muốn lấy ra ");
        int j = scanner.nextInt();
        lineCustomer = customerList.get(j);
        System.out.println(lineCustomer);
        do {
            System.out.println("1.Booking Villa");
            System.out.println("2.Booking House");
            System.out.println("3.Booking Room");
            System.out.println("4.Back to menu");
            System.out.println("5.Exit");
            System.out.println("Chọn dịch vụ : ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    bookingVilla();
                    break;
                case 2:
                    bookingHouse();
                    break;
                case 3:
                    bookingRoom();
                    break;
                case 4:
                    MainController.menu();
                    break;
                case 5:
                    System.exit(5);
            }
        } while (true);
    }

    public static void bookingVilla() {
        List<String> villaList = FileUtils.read(FILE_VILLA);
        List<Villa> villaList1 = new ArrayList<>();
        for (int i = 0; i < villaList.size(); i++) {
            String[] arrayListVilla = villaList.get(i).split(",");
            String id = arrayListVilla[0];
            String tenDichVu = arrayListVilla[1];
            String dienTichSuDung = arrayListVilla[2];
            String chiPhiThue = arrayListVilla[3];
            String soLuongNguoiToiDa = arrayListVilla[4];
            String kieuThue = arrayListVilla[5];
            String tieuChuanPhong = arrayListVilla[6];
            String moTaTienNghiKhac = arrayListVilla[7];
            String dienTichHoBoi = arrayListVilla[8];
            String soTang = arrayListVilla[9];
            Villa villa = new Villa(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);
            villaList1.add(villa);
        }
        int i = 0;
        TreeSet<Villa> villaTreeSet = new TreeSet<>(villaList1);
        for (Villa villa : villaTreeSet) {
            System.out.println(i + COMMA + villa);
            i++;
        }
        System.out.println("Nhập vị trí j muốn lấy ra :");
        int j = scanner.nextInt();
        lineVilla = villaList.get(j);
        lineBooking = lineCustomer + " , " + lineVilla;
        System.out.println(lineBooking);
        FileUtils.writeFile(FILE_BOOKING, lineBooking, true);
    }

    public static void bookingHouse() {
        List<String> houseList = FileUtils.read(FILE_HOUSE);
        List<House> houseList1 = new ArrayList<>();
        for (int i = 0; i < houseList.size(); i++) {
            String[] arrayHouse = houseList.get(i).split(",");
            String id = arrayHouse[0];
            String tenDichVu = arrayHouse[1];
            String dienTichSuDung = arrayHouse[2];
            String chiPhiThue = arrayHouse[3];
            String soLuongNguoiToiDa = arrayHouse[4];
            String kieuThue = arrayHouse[5];
            String tieuChuanPhong = arrayHouse[6];
            String moTaTienNghiKhac = arrayHouse[7];
            String soTang = arrayHouse[8];
            House house = new House(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, soTang);
            houseList1.add(house);
        }
        int i = 0;
        TreeSet<House> houseTreeSet = new TreeSet<>(houseList1);
        for (House house : houseTreeSet) {
            System.out.println(i + COMMA + house);
            i++;
        }

        System.out.println("Nhập vị trí j muốn lấy ra :");
        int j = scanner.nextInt();
        lineVilla = houseList.get(j);
        lineBooking = lineCustomer + " , " + lineHouse;
        System.out.println(lineBooking);
        FileUtils.writeFile(FILE_BOOKING, lineBooking, true);
    }

    public static void bookingRoom() {
        List<String> roomList = FileUtils.read(FILE_ROOM);
        List<Room> roomList1 = new ArrayList<>();
        for (int i = 0; i < roomList.size(); i++) {
            String[] arrayRoom = roomList.get(i).split(",");
            String id = arrayRoom[0];
            String tenDichVu = arrayRoom[1];
            String dienTichSuDung = arrayRoom[2];
            String chiPhiThue = arrayRoom[3];
            String soLuongNguoiToiDa = arrayRoom[4];
            String kieuThue = arrayRoom[5];
            String tenDichVuDiKem = arrayRoom[6];
            String donVi = arrayRoom[7];
            String giaTien = arrayRoom[8];
            Room room = new Room(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tenDichVuDiKem, donVi, giaTien);
            roomList1.add(room);
        }
        int i = 0;
        TreeSet<Room> roomTreeSet = new TreeSet<>(roomList1);
        for (Room room : roomTreeSet) {
            System.out.println(i + COMMA + room);
            i++;
        }

        System.out.println("Nhập vị trí j muốn lấy ra :");
        int j = scanner.nextInt();
        lineRoom = roomList.get(j);
        lineBooking = lineCustomer + " , " + lineRoom;
        System.out.println(lineBooking);
        FileUtils.writeFile(FILE_BOOKING, lineBooking, true);
    }


    public static void deleteCustomer() {
        list = FileUtils.read(FILE_CUSTOMER);
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] customer1 = list.get(i).split(",");
            String hoTen = customer1[0];
            String ngaySinh = customer1[1];
            String gioiTinh = customer1[2];
            String cmnd = customer1[3];
            String soDienThoai = customer1[4];
            String email = customer1[5];
            String loaiKhach = customer1[6];
            String diaChi = customer1[7];
            Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, loaiKhach, diaChi);
            customerList.add(customer);
        }
        System.out.println("Nhập tên cần xóa : ");
        String hoTenXoa = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getHoTen().equals(hoTenXoa)) {
                customerList.remove(i);
                i--;
            }
        }
        System.out.println("thanh cong");
        List<String> stringList2 = new ArrayList<>();
        String tempString = "";
        for (Customer customer : customerList) {
            tempString = customer.getHoTen() + COMMA + customer.getNgaySinh() + COMMA + customer.getGioiTinh() + COMMA + customer.getDiaChi() + COMMA + customer.getSoDienThoai() +
                    COMMA + customer.getLoaiKhach() + COMMA + customer.getEmail() + COMMA + customer.getCmnd();
            stringList2.add(tempString);
        }
        String temp = "";
        for (String s : stringList2) {
            if (temp.equals("")) {
                temp += s;
            } else {
                temp += "\n" + s;
            }

        }
        FileUtils.writeFile(FILE_CUSTOMER, temp, false);
    }

    public static void searchCustomer() {
        list = FileUtils.read(FILE_CUSTOMER);
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] customer1 = list.get(i).split(",");
            String hoTen = customer1[0];
            String ngaySinh = customer1[1];
            String gioiTinh = customer1[2];
            String cmnd = customer1[3];
            String soDienThoai = customer1[4];
            String email = customer1[5];
            String loaiKhach = customer1[6];
            String diaChi = customer1[7];
            Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, loaiKhach, diaChi);
            customerList.add(customer);
        }
        System.out.println("Nhập tên cần tìm : ");
        String hoTenTim = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getHoTen().contains(hoTenTim)) {
                System.out.println(customerList.get(i));
            }
        }
    }

    public static void editCustomer() {
        List<String> stringList = FileUtils.read(FILE_CUSTOMER);
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayCustomer = stringList.get(i).split(",");
            String hoTen = arrayCustomer[0];
            String ngaySinh = arrayCustomer[1];
            String gioiTinh = arrayCustomer[2];
            String cmnd = arrayCustomer[3];
            String soDienThoai = arrayCustomer[4];
            String email = arrayCustomer[5];
            String loaiKhach = arrayCustomer[6];
            String diaChi = arrayCustomer[7];
            Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, loaiKhach, diaChi);
            customerList.add(customer);
        }
        System.out.println("Nhập customer cần sửa : ");
        String customerEdit = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getHoTen().equals(customerEdit)) {
                System.out.println("Customer cần sửa là: ");
                String valueEdit = scanner.nextLine();
                customerList.get(i).setHoTen(valueEdit);
                System.out.println(customerList.get(i).getHoTen());
                break;
            } else {
                System.out.println("Tên bạn nhập không có trong danh sách customer");
                break;
            }
        }
        List<String> stringList1 = new ArrayList<>();
        String tempString = "";
        for (Customer customer : customerList) {
            tempString = customer.getHoTen() + COMMA + customer.getNgaySinh() + COMMA + customer.getCmnd() + COMMA + customer.getEmail() + COMMA + customer.getGioiTinh() + COMMA + customer.getSoDienThoai() + COMMA + customer.getDiaChi() + COMMA + customer.getLoaiKhach();
            stringList1.add(tempString);
        }
        String tempString1 = "";
        for (String s : stringList1) {
            if (tempString1.equals("")) {
                tempString1 += s;
            } else {
                tempString1 += "\n" + s;
            }
        }
        FileUtils.writeFile1(FILE_CUSTOMER, tempString1, true);
    }

    public static void furamaVideo() {
        System.out.println("Mời bạn nhập tên : ");
        String hoTen = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi");
        String tuoi = scanner.nextLine();
        System.out.println("Mời bạn nhập số ghế");
        String soGhe = scanner.nextLine();
        System.out.println("Mời bạn nhập giá vé : ");
        String giaVe = scanner.nextLine();
        VeXemPhim veXemPhim = new VeXemPhim(hoTen, tuoi, soGhe, giaVe);
        ticket.add(veXemPhim);
        for (VeXemPhim veXemPhim1 : ticket) {
            System.out.println(veXemPhim1);
        }
        System.out.println("Những người mua vé");
        int a = ticket.size();
        for (int i = 0; i < a; i++) {
            VeXemPhim show = ticket.poll();
            System.out.println(show);
        }
    }

    public static void furamaNhanVien() {
        System.out.println("Mời bạn nhập mã nhân viên");
        String maNhanVien = scanner.nextLine();
        System.out.println("Mời bạn nhập tên");
        String tenNhanVien = scanner.nextLine();
        System.out.println("Mời bạn nhập bộ phận làm việc trong furama");
        String boPhanLamViec = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại");
        String soDienThoai = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String diaChi = scanner.nextLine();
        NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, boPhanLamViec, soDienThoai, diaChi);
        nhanViens.add(nhanVien);
        for (NhanVien nhanVien1 : nhanViens) {
            System.out.println(nhanVien1);
        }
        System.out.println("Hồ sơ nhân viên");
        int a = nhanViens.size();
        for (int i = 0; i < a; i++) {
            NhanVien show = nhanViens.pop();
            System.out.println(show);
        }
    }
}