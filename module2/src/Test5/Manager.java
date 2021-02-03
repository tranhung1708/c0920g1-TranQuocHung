package Test5;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static final String FILE_CON_TRAI = "src/Test5/ConTrai.csv";
    public static final String FILE_CON_GAI = "src/Test5/ConGai.csv";
    public static String line;
    public static String choose = "0";
    public static final String COMMA = ",";
    public static Scanner scanner = new Scanner(System.in);
    public static String id;
    public static String ten;
    public static String tuoi;
    public static String diaChi;
    public static String capDo;
    public static String ngaySinh;

    public static void themConNuoi() {
        System.out.println("Mời bạn nhập id");
        id = scanner.nextLine();
        System.out.println("Mời bạn nhập tên");
        ten = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi");
        tuoi = scanner.nextLine();
        System.out.println("Mời bạn địa chỉ");
        diaChi = scanner.nextLine();
        System.out.println("Mời bạn nhập cấp độ");
        capDo = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày sinh");
        ngaySinh = scanner.nextLine();
    }

    public static void themConTrai() {
        themConNuoi();
        System.out.println("Mời bạn nhập việc làm");
        String viecLam = scanner.nextLine();
        System.out.println("Mời bạn nhập số vợ");
        String chong = scanner.nextLine();
        System.out.println("Mời bạn nhập số con");
        String con = scanner.nextLine();
        line = id + COMMA + ten + COMMA + tuoi + COMMA + diaChi + COMMA + capDo + COMMA + ngaySinh + COMMA + viecLam + COMMA
                + chong + COMMA + con;
        FileUtils.themSanPham(FILE_CON_TRAI, line, true);
    }

    public static void themConGai() {
        themConNuoi();
        System.out.println("Mời bạn nhập việc làm");
        String viecLam = scanner.nextLine();
        System.out.println("Mời bạn nhập số chồng");
        String vo = scanner.nextLine();
        System.out.println("Mời bạn nhập số con");
        String con = scanner.nextLine();
        line = id + COMMA + ten + COMMA + tuoi + COMMA + capDo + COMMA + diaChi + COMMA + ngaySinh + COMMA + viecLam + COMMA
                + vo + COMMA + con;
        FileUtils.themSanPham(FILE_CON_GAI, line, true);
    }

    public static void xoaConTrai() {
        boolean isExits = false;
        List<String> stringList = FileUtils.read(FILE_CON_TRAI);
        List<Trai> traiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Trai trai = new Trai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            traiList.add(trai);
        }
        System.out.println("Id bạn muốn xóa là  : ");
        String tenMuonXoa = scanner.nextLine();
        for (int j = 0; j < traiList.size(); j++) {
            if (traiList.get(j).getId().equals(tenMuonXoa)) {
                isExits = true;
                System.out.println("id Bạn nhập có trong danh sách bạn có muốn xóa không");
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < traiList.size(); i++) {
                            if (traiList.get(i).getId().equals(tenMuonXoa)) {
                                traiList.remove(i);
                                System.out.println("Bạn đã xóa thành công" + tenMuonXoa);
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (Trai trai : traiList) {
                            temp = trai.getId() + COMMA + trai.getTen() + COMMA + trai.getTuoi() + COMMA + trai.getNgaySinh() + COMMA
                                    + trai.getCapDo() + COMMA + trai.getDiaChi() + COMMA + trai.getChong() + COMMA + trai.getViecLam() + COMMA
                                    + trai.getCon();
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.xoaSanPham(FILE_CON_TRAI, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn nhập không có trong danh sách");
        }
    }

    public static void xoaConGai() {
        boolean isExits = false;
        List<String> stringList = FileUtils.read(FILE_CON_GAI);
        List<Gai> gaiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Gai gai = new Gai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            gaiList.add(gai);
        }
        System.out.println("Id của bạn muốn xóa là : ");
        String tenMuonXoa = scanner.nextLine();
        for (int j = 0; j < gaiList.size(); j++) {
            if (gaiList.get(j).getId().equals(tenMuonXoa)) {
                isExits = true;
                System.out.println("id Bạn nhập có trong danh sách bạn có muốn xóa không");
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < gaiList.size(); i++) {
                            if (gaiList.get(i).getId().equals(tenMuonXoa)) {
                                gaiList.remove(i);
                                System.out.println("Xóa thành công" + tenMuonXoa);
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (Gai gai : gaiList) {
                            temp = gai.getId() + COMMA + gai.getTen() + COMMA + gai.getTuoi() + COMMA + gai.getNgaySinh() + COMMA
                                    + gai.getCapDo() + COMMA + gai.getDiaChi() + COMMA + gai.getVo() + COMMA + gai.getViecLam() + COMMA
                                    + gai.getCon();
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.xoaSanPham(FILE_CON_GAI, temp1, false);
                        break;
                }
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn nhập không có trong danh sách");
        }
    }

    public static void suaIdTrai() {
        boolean isExits = false;
        List<String> stringList = FileUtils.read(FILE_CON_TRAI);
        List<Trai> traiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Trai trai = new Trai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            traiList.add(trai);
        }
        System.out.println("Id bạn muốn xóa là  : ");
        String tenMuonXoa = scanner.nextLine();
        for (int j = 0; j < traiList.size(); j++) {
            if (traiList.get(j).getId().equals(tenMuonXoa)) {
                isExits = true;
                System.out.println("id Bạn nhập có trong danh sách bạn có muốn xóa không");
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < traiList.size(); i++) {
                            if (traiList.get(i).getId().equals(tenMuonXoa)) {
                                System.out.println("Id cần sửa thành là : ");
                                String value = scanner.nextLine();
                                traiList.get(i).setId(value);
                                System.out.println("Bạn đã xóa thành công" + traiList.get(i).getId());
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (Trai trai : traiList) {
                            temp = trai.getId() + COMMA + trai.getTen() + COMMA + trai.getTuoi() + COMMA + trai.getNgaySinh() + COMMA
                                    + trai.getCapDo() + COMMA + trai.getDiaChi() + COMMA + trai.getChong() + COMMA + trai.getViecLam() + COMMA
                                    + trai.getCon();
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_CON_TRAI, temp1, true);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!isExits) {
            System.out.println("id bạn nhập không có trong danh sách");
        }
    }

    public static void suaIdGai() {
        boolean isExits = false;
        List<String> stringList = FileUtils.read(FILE_CON_GAI);
        List<Gai> gaiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Gai gai = new Gai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            gaiList.add(gai);
        }
        System.out.println("Id của bạn muốn xóa là : ");
        String tenMuonXoa = scanner.nextLine();
        for (int j = 0; j < gaiList.size(); j++) {
            if (gaiList.get(j).getId().equals(tenMuonXoa)) {
                isExits = true;
                System.out.println("id Bạn nhập có trong danh sách bạn có muốn xóa không");
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < gaiList.size(); i++) {
                            if (gaiList.get(i).getId().equals(tenMuonXoa)) {
                                System.out.println("Id bạn muốn sửa thành là :");
                                String value1 = scanner.nextLine();
                                gaiList.get(i).setId(value1);
                                System.out.println("Id bạn đã sửa là  " + gaiList.get(i).getId());
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (Gai gai : gaiList) {
                            temp = gai.getId() + COMMA + gai.getTen() + COMMA + gai.getTuoi() + COMMA + gai.getNgaySinh() + COMMA
                                    + gai.getCapDo() + COMMA + gai.getDiaChi() + COMMA + gai.getVo() + COMMA + gai.getViecLam() + COMMA
                                    + gai.getCon();
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_CON_GAI, temp1, true);
                        break;
                }
            }
        }
        if (!isExits) {
            System.out.println("id bạn nhập không có trong danh sách");
        }
    }

    public static void timIdTrai() {
        boolean check = false;
        List<String> stringList = FileUtils.read(FILE_CON_TRAI);
        List<Trai> traiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Trai trai = new Trai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            traiList.add(trai);
        }
        System.out.println("Id bạn muốn tìm là  : ");
        String idBanMuonTim = scanner.nextLine();
        for (int i = 0; i < traiList.size(); i++) {
            if (traiList.get(i).getId().contains(idBanMuonTim)) {
                check = true;
                System.out.println(traiList.get(i));
            }
        }
        if (!check) {
            System.out.println("Id bạn nhập không có trong danh sách");
        }
    }

    public static void timIdGai() {
        boolean check = false;
        List<String> stringList = FileUtils.read(FILE_CON_GAI);
        List<Gai> gaiList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            Gai gai = new Gai(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            gaiList.add(gai);
        }
        System.out.println("Id của bạn muốn tìm là : ");
        String idMuonTim = scanner.nextLine();
        for (int i = 0; i < gaiList.size(); i++) {
            if (gaiList.get(i).getId().contains(idMuonTim)) {
                check = true;
                System.out.println(gaiList.get(i));
            }
        }
        if (!check) {
            System.out.println("Id bạn nhập không có trong danh sách");
        }
    }

    public static void hienThiIdGai() {
        List<String> stringList = FileUtils.read(FILE_CON_TRAI) ;
            for (String s : stringList) {
                System.out.println(s);
            }
        }
        public static void hienThiIdTrai(){
        List<String> stringList = FileUtils.read(FILE_CON_TRAI);
        for (String s : stringList){
            System.out.println(s);
        }
        }
    }
