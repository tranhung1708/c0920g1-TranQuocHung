package Controller;

import Model.Hoc_sinh;
import Model.Hoc_sinhRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletHoc_Sinh", urlPatterns = "/hoc_sinh")
public class ServletHoc_Sinh extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Hoc_sinhRepository hoc_sinhRepository;

    public void init() {
        hoc_sinhRepository = new Hoc_sinhRepository();
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
                    insertHoc_sinh(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateHoc_sinh(request, response);
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
            case "create":
                try {
                    showNewHocSinh(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditHoc_sinh(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteHoc_sinh(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    search(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                try {
                    listHoc_sinh(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void listHoc_sinh(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Hoc_sinh> hoc_sinhList = hoc_sinhRepository.selectAllHoc_sinh();
        request.setAttribute("hoc_sinhList", hoc_sinhList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/list.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showNewHocSinh(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Hoc_sinh> hoc_sinhList = new Hoc_sinhRepository().selectAllHoc_sinh();

        request.setAttribute("hoc_sinhList", hoc_sinhList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditHoc_sinh(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String id = request.getParameter("id");
        Hoc_sinh existingContract = hoc_sinhRepository.selectHoc_sinh(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/edit.jsp");
        request.setAttribute("hoc_sinh", existingContract);
        dispatcher.forward(request, response);
    }

    public void insertHoc_sinh(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        int ma_hoc_sinh = Integer.parseInt(request.getParameter("ma_hoc_sinh"));
        String ten_hoc_sinh = request.getParameter("ten_hoc_sinh");
        int lop = Integer.parseInt(request.getParameter("lop"));
        String ngay_sinh = request.getParameter("ngay_sinh");
        String dia_chi = request.getParameter("dia_chi");
        Hoc_sinh newHoc_sinh = new Hoc_sinh(ma_hoc_sinh, ten_hoc_sinh, lop, ngay_sinh, dia_chi);
        RequestDispatcher dispatcher;
        hoc_sinhRepository.insertEmployee(newHoc_sinh);
        List<Hoc_sinh> hoc_sinhList = hoc_sinhRepository.selectAllHoc_sinh();
        request.setAttribute("hoc_sinhList", hoc_sinhList);
        dispatcher = request.getRequestDispatcher("View/create.jsp");
        dispatcher.forward(request, response);
    }

    public void updateHoc_sinh(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        int ma_hoc_sinh = request.getIntHeader("ma_hoc_sinh");
        String ten_hoc_sinh = request.getParameter("ten_hoc_sinh");
        int lop = request.getIntHeader("lop");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String dia_chi = request.getParameter("dia_chi");
        Hoc_sinh bookHocSinh = new Hoc_sinh(ma_hoc_sinh, ten_hoc_sinh, lop, ngay_sinh, dia_chi);
        hoc_sinhRepository.updateEmployee(bookHocSinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteHoc_sinh(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,
            ServletException {
        String id = request.getParameter("id");
        hoc_sinhRepository.deleteHocSinh(id);
        List<Hoc_sinh> hoc_sinhList = hoc_sinhRepository.selectAllHoc_sinh();
        request.setAttribute("hoc_sinhList", hoc_sinhList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(request, response);
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("searchName");
        List<Hoc_sinh> hoc_sinhList = hoc_sinhRepository.search(id);
        request.setAttribute("hoc_sinhList", hoc_sinhList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
