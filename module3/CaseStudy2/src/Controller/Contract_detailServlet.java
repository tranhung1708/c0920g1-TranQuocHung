package Controller;

import CaseStudy.Model.Attach_service.Attach_service;
import CaseStudy.Model.Attach_service.Attach_serviceRepository;
import CaseStudy.Model.Contract.Contract;
import CaseStudy.Model.Contract.ContractRepository;
import CaseStudy.Model.Contract_detail.Contract_Detail_Repository;
import CaseStudy.Model.Contract_detail.Contract_detail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Contract_detailServlet", urlPatterns = "/contract_detail")
public class Contract_detailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Contract_Detail_Repository contract_detail_repository;

    public void init() {
        contract_detail_repository = new Contract_Detail_Repository();
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
                    insertContract_detail(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateContract_detail(request,response);
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
                    showNewContract_detail(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditContract_detail(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteContract_detail(request,response);
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
                    listContract_detail(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void listContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Contract_detail> contract_detailList = contract_detail_repository.selectAllContract_detail();
        request.setAttribute("contract_detailList", contract_detailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Contract_detail/list.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showNewContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Contract> contractList = new ContractRepository().selectAllContract();
        List<Attach_service> attach_serviceList = new Attach_serviceRepository().selectAllAttachService();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attach_serviceList",attach_serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }
    public void showEditContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract_detail existingContract_detail = contract_detail_repository.selectContract_detail(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract_detail/edit.jsp");
        request.setAttribute("contract_detail", existingContract_detail);
        dispatcher.forward(request, response);
    }

    public void insertContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String contract_detail_id = request.getParameter("contract_detail_id");
        String contract_id = request.getParameter("contract_id");
        String attach_service = request.getParameter("attach_service");
        String quantity = request.getParameter("quantity");
        Contract_detail newContract_detail = new Contract_detail(contract_detail_id, contract_id, attach_service, quantity);
        contract_detail_repository.insertContract_detail(newContract_detail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }

    public void updateContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String contract_detail_id = request.getParameter("contract_detail_id");
        String contract_id = request.getParameter("contract_id");
        String attach_service_id = request.getParameter("attach_service_id");
        String quantity = request.getParameter("quantity");
        Contract_detail bookContract_detail = new Contract_detail(contract_detail_id, contract_id, attach_service_id, quantity);
        contract_detail_repository.updateContract(bookContract_detail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract_detail/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteContract_detail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,
            ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        contract_detail_repository.deleteContract(id);
        List<Contract_detail> contract_detailList = contract_detail_repository.selectAllContract_detail();
        request.setAttribute("contract_detailList", contract_detailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract_detail/list.jsp");
        dispatcher.forward(request, response);
    }
    public void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("searchName");
        List<Contract_detail> contract_detailList = contract_detail_repository.search(id);
        request.setAttribute("contract_detailList", contract_detailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Contract_detail/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
