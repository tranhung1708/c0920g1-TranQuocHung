package CaseStudy.controllers;

import CaseStudy.service.ServiceManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static String choose = "0";
    public static String choose1 = "0";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            choose = "0";
            System.out.println("Menu");
            System.out.println("1.Add New Services");
            System.out.println("2.Show Services");
            System.out.println("3.Other functions");
            System.out.println("4.Add New Customer");
            System.out.println("5.Show Information of Customer");
            System.out.println("6.Add New Booking");
            System.out.println("7.Show Information of Employee");
            System.out.println("8.FuramaVideo");
            System.out.println("9.FuramaNhanVien");
            System.out.println("10.Exit");
            System.out.println("Nhập Lựa Chọn Của Bạn");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addNewService();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    System.out.println("1.Xóa customer");
                    System.out.println("2.Sửa customer");
                    System.out.println("3.Tìm customer");
                    choose1 = scanner.nextLine();
                    switch (choose1) {
                        case "1":
                            ServiceManager.deleteCustomer();
                            break;
                        case "2":
                            ServiceManager.editCustomer();
                            break;
                        case "3":
                            ServiceManager.searchCustomer();
                    }
                    break;
                case "4":
                    ServiceManager.addNewCustomer();
                    break;
                case "5":
                    ServiceManager.ShowInformationOfCustomer();
                    break;
                case "6":
                    ServiceManager.addNewBooking();
                    break;
                case "7":
                    ServiceManager.showEmployee();
                    break;
                case "8":
                    ServiceManager.furamaVideo();
                    break;
                case "9":
                    ServiceManager.furamaNhanVien();
                    break;
                case "10":
                    System.exit(10);
                default:
                    menu();
            }
        } while (true);

    }

    public static void addNewService() {
        do {
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to menu");
            System.out.println("5.Exit");
            System.out.println("Nhập Lựa Chọn Của Bạn");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    ServiceManager.addNewVilla();
                    break;
                case "2":
                    ServiceManager.addNewHouse();
                    break;
                case "3":
                    ServiceManager.addNewRoom();
                    break;
                case "4":
                    menu();
                    break;
                case "5":
                    System.exit(5);
            }
        } while (true);
    }

    public static void showServices() {
        do {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Show All Name Villa Not Duplicate");
            System.out.println("5.Show All Name House Not Duplicate");
            System.out.println("6.Show All Room Not Duplicate");
            System.out.println("7.Back to menu");
            System.out.println("8.Exit");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    ServiceManager.showVilla();
                    break;
                case "2":
                    ServiceManager.showHouse();
                    break;
                case "3":
                    ServiceManager.showRoom();
                    break;
                case "4":
                    ServiceManager.ShowAllNameVillaNotDuplicate();
                    break;
                case "5":
                    ServiceManager.ShowAllNameHouseNotDuplicate();
                    break;
                case "6":
                    ServiceManager.ShowAllRoomNotDuplicate();
                    break;
                case "7":
                    menu();
                    break;
                case "8":
                    System.exit(8);
            }
        } while (true);
    }
}
