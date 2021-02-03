package Controller;

import Common.ValiDate;
import Model.BenhAnRepository;
import Model.BenhNhanRepository;
import Model.Benh_an;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/kiemtramodule3")
public class BenhAnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BenhAnRepository benhAnRepository;

    public void init() {
        benhAnRepository = new BenhAnRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertBenhAn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateBenhAn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":showNewForm(request,response);
                //show new form
                break;
            case "edit":
                try {
                    showEditBenhAn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //show edit
                break;
            case "delete":
                try {
                    deleteBenhAn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //delete
                break;
            case "search":
                try {
                    search(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //search
                break;
            default:
                try {
                    listBenhAn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //list
                break;
        }
    }

    public void listBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Benh_an> benh_anList = benhAnRepository.selectAllBenhAn();
        request.setAttribute("benh_anList", benh_anList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Benh_an> benh_anList = new BenhAnRepository().selectAllBenhAn();
        request.setAttribute("benh_anList",benh_anList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String ma_benh_an = request.getParameter("id");
        Benh_an existingBenhAn = benhAnRepository.selectBenhAn(ma_benh_an);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/edit.jsp");
        request.setAttribute("Benh_an", existingBenhAn);
        dispatcher.forward(request, response);
    }

    private void insertBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String ma_benh_an =request.getParameter("ma_benh_an");
        String ma_benh_nhan = request.getParameter("ma_benh_nhan");
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do_nhap_vien = request.getParameter("ly_do_nhap_vien");
        String messageID = null;
        String messageID1 = null;
        String messageBirthday = null;
        String messageNumberPhone = null;
        String messageIdCard = null;
        String messageEmail = null;
        Benh_an newBenhAn = new Benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien);
        Benh_an checkBenhAN = benhAnRepository.selectBenhAn(ma_benh_an);
        RequestDispatcher dispatcher;
        List<Benh_an> benh_anList = benhAnRepository.selectAllBenhAn();

        if (!ValiDate.checkMaBenhAN(ma_benh_an)) {
            messageID = "BA-XXXX";
        }else if (!ValiDate.checkMaBenhBN(ma_benh_nhan)){
            messageID1 ="BN-XXX";
        }
            else if (!ValiDate.checkBirthday(ngay_nhap_vien)){
            messageBirthday = "yyyy/mm/dd";
        }else if (!ValiDate.checkBirthday(ngay_ra_vien)){
            messageBirthday = "yyyy/mm/dd";
        } else if (checkBenhAN != null) {
            messageID = "The id you entered is identical";
        } else {
            benhAnRepository.insertBenhAn(newBenhAn);
            benh_anList = benhAnRepository.selectAllBenhAn();
        }
        request.setAttribute("messageID", messageID);
        request.setAttribute("messageID1", messageID1);
        request.setAttribute("messageBirthday", messageBirthday);
        request.setAttribute("messageNumberPhone",messageNumberPhone);
        request.setAttribute("messageIdCard",messageIdCard);
        request.setAttribute("messageEmail",messageEmail);
        request.setAttribute("benh_anList", benh_anList);
        dispatcher = request.getRequestDispatcher("View/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String ma_benh_an =request.getParameter("ma_benh_an");
        String ma_benh_nhan = request.getParameter("ma_benh_nhan");
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do_nhap_vien = request.getParameter("ly_do_nhap_vien");
        Benh_an bookBenhAn = new Benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien);
        benhAnRepository.updateBenhAn(bookBenhAn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String id = request.getParameter("id");
        benhAnRepository.deleteBenhAn(id);
        List<Benh_an> benh_anList = benhAnRepository.selectAllBenhAn();
        request.setAttribute("benh_anList", benh_anList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(request, response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("searchName");
        if (name == null | name.equals("")) {
            List<Benh_an> benh_anList = benhAnRepository.selectAllBenhAn();
            request.setAttribute("benh_anList", benh_anList);
        } else {
            List<Benh_an> benh_anList = benhAnRepository.search(name);
            request.setAttribute("benh_anList", benh_anList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(request, response);
    }
}
