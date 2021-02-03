package Controller;

import CaseStudy.Common.ValiDate;
import CaseStudy.Model.Employee.Employee;
import CaseStudy.Model.Rent_type.Rent_type;
import CaseStudy.Model.Rent_type.Rent_typeRepository;
import CaseStudy.Model.Service.Service;
import CaseStudy.Model.Service.ServiceRepository;
import CaseStudy.Model.Service_type.Service_type;
import CaseStudy.Model.Service_type.Service_typeRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceRepository serviceDao;

    public void init() {
        serviceDao = new ServiceRepository();
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
                    insertService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateService(request, response);
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
                showNewService(request, response);
                break;
            case "edit":
                try {
                    showEditService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteService(request, response);
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
                    listService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void listService(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException, ServletException {
        List<Service> serviceList = serviceDao.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service_type> service_typeList = new Service_typeRepository().selectAllService_type();
        List<Rent_type> rent_typeList = new Rent_typeRepository().selectAllRent_type();
        request.setAttribute("service_typeList", service_typeList);
        request.setAttribute("rent_typeList",rent_typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Service existingService = serviceDao
                .selectService(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Service/edit.jsp");
        request.setAttribute("service", existingService);
        dispatcher.forward(request, response);
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String service_id = request.getParameter("service_id");
        String service_name = request.getParameter("service_name");
        String service_area = request.getParameter("service_area");
        String service_cost = request.getParameter("service_cost");
        String service_max_people = request.getParameter("service_max_people");
        String rent_type_id = request.getParameter("rent_type_id");
        String service_type_id = request.getParameter("service_type_id");
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors = request.getParameter("number_of_floors");
        String messageId = null;
        String messagePeople = null;
        String messageNumber = null;
        String messageCost = null;

        Service newService = new Service(service_id, service_name, service_area, service_cost, service_max_people,
                rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
        Service checkService = serviceDao.selectService(service_id);

        RequestDispatcher dispatcher;

        List<Service> serviceList = serviceDao.selectAllService();

        if (!ValiDate.checkIdService(service_id)) {
            messageId = "DV-xxxx";
        } else if (!ValiDate.checkPeople(service_max_people)) {
            messagePeople = "Please enter positive numbers";
        } else if (!ValiDate.checkNumberOfFloors(number_of_floors)) {
            messageNumber = "Please enter positive numbers";
        } else if (!ValiDate.checkServiceCost(service_cost)) {
            messageCost = "Please enter positive numbers";
        } else if (checkService != null) {
            messageId = "The id you entered is identical";
        } else {
            serviceDao.insertService(newService);
            serviceList = serviceDao.selectAllService();
        }
        request.setAttribute("messageId", messageId);
        request.setAttribute("messagePeople", messagePeople);
        request.setAttribute("messageNumber", messageNumber);
        request.setAttribute("messageCost", messageCost);
        request.setAttribute("serviceList", serviceList);
        dispatcher = request.getRequestDispatcher("view/Service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String service_id = request.getParameter("service_id");
        String service_name = request.getParameter("service_name");
        String service_area = request.getParameter("service_area");
        String service_cost = request.getParameter("service_cost");
        String service_max_people = request.getParameter("service_max_people");
        String rent_type_id = request.getParameter("rent_type_id");
        String service_type_id = request.getParameter("service_type_id");
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors = request.getParameter("number_of_floors");
        Service bookService = new Service(service_id, service_name, service_area, service_cost, service_max_people,
                rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
        serviceDao.updateService(bookService);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/Service/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        serviceDao.delete(id);

        List<Service> serviceList = serviceDao.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("searchName");
        if (id == null | id.equals("")) {
            List<Service> serviceList = serviceDao.selectAllService();
            request.setAttribute("serviceList", serviceList);
        } else {
            List<Service> serviceList = serviceDao.search(id);
            request.setAttribute("serviceList", serviceList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Service/list.jsp");
        dispatcher.forward(request, response);
    }
}
