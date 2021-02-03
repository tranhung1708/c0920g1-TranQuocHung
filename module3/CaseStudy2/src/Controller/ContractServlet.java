package Controller;

import CaseStudy.Common.ValiDate;
import CaseStudy.Model.Attach_service.Attach_service;
import CaseStudy.Model.Attach_service.Attach_serviceRepository;
import CaseStudy.Model.Contract.Contract;
import CaseStudy.Model.Contract.ContractRepository;
import CaseStudy.Model.Contract_detail.Contract_Detail_Repository;
import CaseStudy.Model.Contract_detail.Contract_detail;
import CaseStudy.Model.Customer.Customer;
import CaseStudy.Model.Customer.CustomerRepository;
import CaseStudy.Model.Employee.Employee;
import CaseStudy.Model.Employee.EmployeeRepository;
import CaseStudy.Model.Service.Service;
import CaseStudy.Model.Service.ServiceRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContractRepository contractRepository;

    public void init() {
        contractRepository = new ContractRepository();
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
                    insertContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateContract(request, response);
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
                    showNewContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    search(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                try {
                    listContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Contract> contractList = contractRepository.selectAllContract();
        request.setAttribute("contractList", contractList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Contract/list.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showNewContract(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Employee> employeeList = new EmployeeRepository().selectAllEmployee();
        List<Customer> customerList = new CustomerRepository().selectAllCustomer();
        List<Service> serviceList = new ServiceRepository().selectAllService();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditContract(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String id = request.getParameter("id");
        Contract existingContract = contractRepository.selectContract(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract/edit.jsp");
        request.setAttribute("contract", existingContract);
        dispatcher.forward(request, response);
    }

    public void insertContract(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String contract_id = request.getParameter("contract_id");
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        String contract_deposit = request.getParameter("contract_deposit");
        String contract_total_money = request.getParameter("contract_total_money");
        String employee_id = request.getParameter("employee_id");
        String customer_id = request.getParameter("customer_id");
        String service_id = request.getParameter("service_id");
        String messageDate1 = null;
        String messageDate2 = null;
        String messageId = null;
        String messageIdCustomer = null;
        String messageIdService = null;
        String messageMoney = null;
        Contract newContract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                employee_id, customer_id, service_id);
        Contract checkContract = contractRepository.selectContract(contract_id);
        RequestDispatcher dispatcher;
        List<Contract> contractList = contractRepository.selectAllContract();
        if (!ValiDate.checkDate(contract_start_date)){
            messageDate1 = "yyyy/mm/dd";
        }else if (!ValiDate.checkDate(contract_end_date)){
            messageDate2 = "yyyy/mm/dd";
        }else if (!ValiDate.checkPeople(contract_total_money)){
            messageMoney = "xxxxxxxxxx";
        }else if (!ValiDate.checkCustomer(customer_id)){
            messageIdCustomer = "KH-XXXX";
        }else if (!ValiDate.checkIdService(service_id)){
            messageIdService = "DV-XXXX";
        }
        else if (checkContract != null){
            messageId = "You have entered the same";
        }else {
            contractRepository.insertContract(newContract);
            contractList = contractRepository.selectAllContract();
        }
        request.setAttribute("messageDate1",messageDate1);
        request.setAttribute("messageDate2",messageDate2);
        request.setAttribute("messageId",messageId);
        request.setAttribute("messageMoney",messageMoney);
        request.setAttribute("messageIdCustomer",messageIdCustomer);
        request.setAttribute("messageIdService",messageIdService);
        request.setAttribute("contractList" ,contractList);
        dispatcher = request.getRequestDispatcher("view/Contract/create.jsp");
        dispatcher.forward(request, response);
    }

    public void updateContract(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String contract_id = request.getParameter("contract_id");
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        String contract_deposit = request.getParameter("contract_deposit");
        String contract_total_money = request.getParameter("contract_total_money");
        String employee_id = request.getParameter("employee_id");
        String customer_id = request.getParameter("customer_id");
        String service_id = request.getParameter("service_id");
        Contract bookContract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                employee_id, customer_id, service_id);
        contractRepository.updateContract(bookContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,
            ServletException {
        String id = request.getParameter("id");
        contractRepository.deleteContract(id);
        List<Contract> contractList = contractRepository.selectAllContract();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Contract/list.jsp");
        dispatcher.forward(request, response);
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("searchName");
        List<Contract> contractList = contractRepository.search(id);
        request.setAttribute("contractList", contractList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Contract/list.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showCustomerService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractRepository.selectAllContract();
        List<Customer> customerList = new CustomerRepository().selectAllCustomer();
        List<Contract_detail> contract_detailList = new Contract_Detail_Repository().selectAllContract_detail();
        request.setAttribute("customerList", customerList);
        request.setAttribute("contractList", contractList);
        request.setAttribute("contract_detailList", contract_detailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Contract/list.jsp");
        requestDispatcher.forward(request, response);

    }
}
