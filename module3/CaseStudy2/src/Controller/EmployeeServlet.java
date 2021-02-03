package Controller;

import CaseStudy.Common.ValiDate;
import CaseStudy.Model.Division.Division;
import CaseStudy.Model.Division.DivisionRepository;
import CaseStudy.Model.Education_degree.EducationRepository;
import CaseStudy.Model.Education_degree.Education_degree;
import CaseStudy.Model.Employee.Employee;
import CaseStudy.Model.Employee.EmployeeRepository;
import CaseStudy.Model.Position.Position;
import CaseStudy.Model.Position.PositionRepository;
import CaseStudy.Model.User.User;
import CaseStudy.Model.User.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeRepository employeeRepository;

    public void init() {
        employeeRepository = new EmployeeRepository();
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
                    insertEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateEmployee(request, response);
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
                showNewForm(request, response);
                break;
            case "edit":
                try {
                    showEditEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
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
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Employee> employeeList = employeeRepository.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = new PositionRepository().selectAllPosition();
        List<Division> divisionList = new DivisionRepository().selectDivisionList();
        List<Education_degree> education_degreeList = new EducationRepository().selectAllEducation();
        List<User> userList = new UserRepository().selectAllUser();
        request.setAttribute("positionList",positionList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("education_degreeList",education_degreeList);
        request.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Employee/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Employee existingEmployee = employeeRepository.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String employee_id = request.getParameter("employee_id");
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_salary = request.getParameter("employee_salary");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        String position_id = request.getParameter("position_id");
        String education_degree_id = request.getParameter("education_degree_id");
        String division_id = request.getParameter("division_id");
        String username = request.getParameter("username");
        String messageBirthday = null;
        String messageId = null;
        String messageEmail = null;
        String messagePhone = null;
        String messageIdCard = null;
        Employee newEmployee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary
                , employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username);
        Employee checkEmployee = employeeRepository.selectEmployee(employee_id);
        RequestDispatcher dispatcher;
        List<Employee> employeeList = employeeRepository.selectAllEmployee();
        if (!ValiDate.checkBirthday(employee_birthday)){
            messageBirthday = "yyyy/mm/dd";
        }else if (!ValiDate.checkEmail(employee_email)){
            messageEmail  = "xxx@xxx.com";
        }else if (!ValiDate.checkNumberPhone(employee_phone)){
            messagePhone = "84xxxxxxxxx";
        }else if (!ValiDate.checkIdCard(employee_id_card)){
            messageIdCard = "xxxxxxxxx";
        } else if (checkEmployee != null){
            messageId = "You have entered the same";
        }else {
            employeeRepository.insertEmployee(newEmployee);
            employeeList = employeeRepository.selectAllEmployee();
        }
        request.setAttribute("messageBirthday", messageBirthday);
        request.setAttribute("messageId", messageId);
        request.setAttribute("messageEmail", messageEmail);
        request.setAttribute("messagePhone", messagePhone);
        request.setAttribute("messageIdCard", messageIdCard);
        request.setAttribute("employeeList",employeeList);
        dispatcher = request.getRequestDispatcher("view/Employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String employee_id = request.getParameter("employee_id");
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_salary = request.getParameter("employee_salary");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        String position_id = request.getParameter("position_id");
        String education_degree_id = request.getParameter("education_degree_id");
        String division_id = request.getParameter("division_id");
        String username = request.getParameter("username");
        Employee bookEmployee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary
                , employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username);
        employeeRepository.updateEmployee(bookEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        employeeRepository.deleteEmployee(id);

        List<Employee> employeeList = employeeRepository.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("searchName");
        if (id == null | id.equals("")) {
            List<Employee> employeeList = employeeRepository.selectAllEmployee();
            request.setAttribute("employeeList", employeeList);
        } else {
            List<Employee> employeeList = employeeRepository.search(id);
            request.setAttribute("employeeList", employeeList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
