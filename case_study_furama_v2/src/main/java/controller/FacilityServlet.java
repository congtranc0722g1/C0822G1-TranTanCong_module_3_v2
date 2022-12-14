package controller;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRentTypeService;
import service.impl.FacilityService;
import service.impl.FacilityTypeService;
import service.impl.RentTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facility"})
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IRentTypeService rentTypeService = new RentTypeService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();

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
                showListFacility(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        boolean check = facilityService.delete(id);
        String mess = "Xoa khong thanh cong";
        if (check) {
            mess = "Xoa thanh cong";
        }
//        request.setAttribute("mess", mess);
//        try {
//            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            response.sendRedirect("/facility?mess=" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("cost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("max-people"));
        Integer rentTypeId = Integer.parseInt(request.getParameter("rent-type"));
        Integer facilityTypeId = Integer.parseInt(request.getParameter("facility-type"));
        String standardRoom = request.getParameter("standard-room");
        String descriptionOtherConvenience = request.getParameter("description-other-convenience");
        Double poolArea;
        if (request.getParameter("pool-area") == null) {
            poolArea = null;
        } else {
            poolArea = Double.parseDouble(request.getParameter("pool-area"));
        }
        Integer numbersOfFloors;
        if (request.getParameter("number-of-floors") == null) {
            numbersOfFloors = null;
        } else {
            numbersOfFloors = Integer.parseInt(request.getParameter("number-of-floors"));
        }
        String facilityFree = request.getParameter("facility_free");
        Facility facility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numbersOfFloors, facilityFree);
        boolean check = facilityService.update(facility);
        String mess = " Chinh sua khong thanh cong";
        if (check) {
            mess = "Chinh sua thanh cong";
        }
        request.setAttribute("mess", mess);
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        Facility facility1 = facilityService.findById(id);
        request.setAttribute("facility", facility1);
//        try {
//            request.getRequestDispatcher("view/facility/edit.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            response.sendRedirect("/facility?mess=" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("cost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("max-people"));
        Integer rentTypeId = Integer.parseInt(request.getParameter("rent-type"));
        Integer facilityTypeId = Integer.parseInt(request.getParameter("facility-type"));
        String standardRoom = request.getParameter("standard-room");
        String descriptionOtherConvenience = request.getParameter("description-other-convenience");
        Double poolArea;
        if (request.getParameter("pool-area") == null) {
            poolArea = null;
        } else {
            poolArea = Double.parseDouble(request.getParameter("pool-area"));
        }
        Integer numbersOfFloors;
        if (request.getParameter("number-of-floors") == null) {
            numbersOfFloors = null;
        } else {
            numbersOfFloors = Integer.parseInt(request.getParameter("number-of-floors"));
        }
        String facilityFree = request.getParameter("facility_free");
        Facility facility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numbersOfFloors, facilityFree);
        boolean check = facilityService.add(facility);
        String mess = "Them moi khong thanh cong";
        if (check) {
            mess = "Them moi thanh cong";
        }
//        request.setAttribute("mess", mess);
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
//        try {
//            request.getRequestDispatcher("view/facility/create.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            response.sendRedirect("/facility?mess=" + mess);
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
            case "edit":
                showFormedit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListFacility(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String facilityTypeName = request.getParameter("facility-type-name");
        request.setAttribute("name", name);
        request.setAttribute("facilityTypeName", facilityTypeName);
        List<Facility> facilityList = facilityService.search(name, facilityTypeName);
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormedit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Facility facility = facilityService.findById(id);
        request.setAttribute("facility", facility);
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        try {
            request.getRequestDispatcher("view/facility/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormcreate(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        try {
            request.getRequestDispatcher("view/facility/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.findAll();
        request.setAttribute("facilityList", facilityList);
        String mess = request.getParameter("mess");
        request.setAttribute("mess",mess);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
