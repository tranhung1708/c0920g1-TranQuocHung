package Controller;

import CaseStudy.Common.ValiDate;
import CaseStudy.Model.Customer.Customer;
import CaseStudy.Model.Customer.CustomerRepository;
import CaseStudy.Model.Customer_type.CustomerType;
import CaseStudy.Model.Customer_type.CustomerTypeRepository;
import CaseStudy.Model.Employee.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerRepository customerDao;

    public void init() {
        customerDao = new CustomerRepository();
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
                    insertCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
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
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "search":
                    search(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    public void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Customer> customerList = customerDao.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = new CustomerTypeRepository().selectAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Customer existingCustomer = customerDao.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String customer_id = request.getParameter("customer_id");
        String customer_type_id = request.getParameter("customer_type_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        String messageID = null;
        String messageBirthday = null;
        String messageNumberPhone = null;
        String messageIdCard = null;
        String messageEmail = null;
        Customer newCustomer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender
                , customer_id_card, customer_phone, customer_email, customer_address);
        Customer checkCustomer = customerDao.selectCustomer(customer_id);
        RequestDispatcher dispatcher;
        List<Customer> customerList = customerDao.selectAllCustomer();

        if (!ValiDate.checkCustomer(customer_id)) {
            messageID = "KH-XXXX";
        } else if (!ValiDate.checkBirthday(customer_birthday)) {
            messageBirthday = "yyyy-mm-dd";
        }else if (!ValiDate.checkNumberPhone(customer_phone)){
            messageNumberPhone = "84xxxxxxxxx";
        }else if (!ValiDate.checkIdCard(customer_id_card)){
            messageIdCard = "xxxxxxxxx";
        }else if (!ValiDate.checkEmail(customer_email)){
            messageEmail = "xxx@xxx.xxx";
        } else if (checkCustomer != null) {
            messageID = "The id you entered is identical";
        } else {
           customerDao.insertCustomer(newCustomer);
            customerList = customerDao.selectAllCustomer();
        }
        request.setAttribute("messageID", messageID);
        request.setAttribute("messageBirthday", messageBirthday);
        request.setAttribute("messageNumberPhone",messageNumberPhone);
        request.setAttribute("messageIdCard",messageIdCard);
        request.setAttribute("messageEmail",messageEmail);
        request.setAttribute("customerList", customerList);
        dispatcher = request.getRequestDispatcher("view/Customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String customer_id = request.getParameter("customer_id");
        String customer_type_id = request.getParameter("customer_type_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        Customer bookCustomer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender
                , customer_id_card, customer_phone, customer_email, customer_address);
        customerDao.updateCustomer(bookCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        String id = request.getParameter("id");
        customerDao.deleteCustomer(id);
        List<Customer> customerList = customerDao.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("searchName");
        if (name == null | name.equals("")) {
            List<Customer> customerList = customerDao.selectAllCustomer();
            request.setAttribute("customerList", customerList);
        } else {
            List<Customer> customerList = customerDao.search(name);
            request.setAttribute("customerList", customerList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
