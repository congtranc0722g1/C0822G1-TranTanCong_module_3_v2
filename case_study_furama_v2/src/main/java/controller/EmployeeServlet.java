package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionService;
import service.impl.EducationDegreeService;
import service.impl.EmployeeService;
import service.impl.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IPositionService positionService = new PositionService();
    private IEducationDegreeService educationDegreeService = new EducationDegreeService();
    private IDivisionService divisionService = new DivisionService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = employeeService.delete(id);
        String mess = "Xoa khong thanh cong";
        if (check){
            mess = "Xoa thanh cong";
        }
        try {
            response.sendRedirect("/employee?mess=" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("birthday"));
        String idCard = request.getParameter("id-card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone-number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education-degree"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);
        boolean check = employeeService.edit(employee);
        String mess = "Chinh sua khong thanh cong";
        if (check){
            mess = "Chinh sua thanh cong";
        }

        try {
            response.sendRedirect("/employee?mess=" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("birthday"));
        String idCard = request.getParameter("id-card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone-number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education-degree"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(name, dateOfBirth, idCard, salary, phone, email, address,positionId, educationDegreeId, divisionId);
        boolean check = employeeService.add(employee);
        String mess = "Them moi khong thanh cong";
        if (check) {
            mess = "Them moi thanh cong";
        }
//        request.setAttribute("mess", mess);
//        try {
//            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            response.sendRedirect("/employee?mess=" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormcreate(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String divisionName = request.getParameter("division");
        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("divisionName", divisionName);
        List<Employee> employeeList = employeeService.search(name, address, divisionName);
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.showAll();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.showAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = divisionService.showAll();
        request.setAttribute("divisionList", divisionList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormcreate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.showAll();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.showAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = divisionService.showAll();
        request.setAttribute("divisionList", divisionList);
        List<Employee> employeeList = employeeService.showAll();
        request.setAttribute("employeeList", employeeList);
        String mess = request.getParameter("mess");
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
