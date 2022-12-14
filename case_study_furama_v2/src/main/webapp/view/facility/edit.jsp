<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Facility</title>
    <link rel="stylesheet" href="../../bootstrap-5.1.3-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../css/facility_case.css">

</head>
<body class="edit-background">
<div class="row header">
    <div class="col-lg-2">
        <img class="icon" id="logo" src="image/zyro-image%20(2).png" height="100" width="60"/>
    </div>

    <div class="col-lg-8">
        <div class="row">
            <div class="col-lg-8 text-center top">
                <p>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-geo-alt"
                         viewBox="0 0 16 16">
                        <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z"/>
                        <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                    </svg>
                    103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam
                </p>
            </div>

            <div class="col-lg-4 text-center top">
                <p>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-telephone-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                    </svg>
                    84-236-3847 333/888
                </p>
            </div>
        </div>
    </div>

    <div class="col-lg-2 text-end top">
        <p class="login">Trần Tấn Công</p>
    </div>
</div>
<div>
<h1 class="text-center text-danger">CHỈNH SỬA DỊCH VỤ</h1>
<c:if test="${mess != null}">
    <p style="color: brown; margin-left: 215px">${mess}</p>
</c:if>
<div class="row margin-create-edit-facility">
<form method="post">
<c:if test="${facility.getFacilityTypeId() == 1}">
    <div class="mb-3">
        <label class="form-label">Loại Dịch Vụ</label>
        <select name="facility-type">
            <c:forEach var="facilityType" items="${facilityTypeList}">
                <option value="${facilityType.getId()}"
                        <c:if test="${facilityType.getId() == facility.getFacilityTypeId()}">selected</c:if>>${facilityType.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên Dịch Vụ</label> <br>
        <input type="text" name="name" value="${facility.getName()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Diện Tích Sử Dụng</label>
        <input type="text" name="area" value="${facility.getArea()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Chi Phí Thuê</label>
        <input type="text" name="cost" value="${facility.getCost()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Số Lượng Người Tối Đa</label>
        <input type="text" name="max-people" value="${facility.getMaxPeople()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Kiểu Thuê</label>
        <select name="rent-type">
            <c:forEach var="rentType" items="${rentTypeList}">
                <option value="${rentType.getId()}"
                        <c:if test="${rentType.getId() == facility.getRentTypeId()}">selected</c:if>>${rentType.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Tiêu Chuẩn Phòng</label>
        <input type="text" name="standard-room" value="${facility.getStandardRoom()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Mô Tả Tiện Nghi Khác</label>
        <input type="text" name="description-other-convenience" value="${facility.getDescriptionOtherConvenience()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Diện Tích Hồ Bơi</label>
        <input type="text" name="pool-area" value="${facility.getPoolArea()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Số Tầng</label>
        <input type="text" name="number-of-floors" value="${facility.getNumbersOfFloors()}" class="form-control">
    </div>
</c:if>
<c:if test="${facility.getFacilityTypeId() == 2}">
    <div class="mb-3">
        <label class="form-label">Loại Dịch Vụ</label>
        <select name="facility-type">
            <c:forEach var="facilityType" items="${facilityTypeList}">
                <option value="${facilityType.getId()}"
                        <c:if test="${facilityType.getId() == facility.getFacilityTypeId()}">selected</c:if>>${facilityType.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên Dịch Vụ</label> <br>
        <input type="text" name="name" value="${facility.getName()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Diện Tích Sử Dụng</label>
        <input type="text" name="area" value="${facility.getArea()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Chi Phí Thuê</label>
        <input type="text" name="cost" value="${facility.getCost()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Số Lượng Người Tối Đa</label>
        <input type="text" name="max-people" value="${facility.getMaxPeople()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Kiểu Thuê</label>
        <select name="rent-type">
            <c:forEach var="rentType" items="${rentTypeList}">
                <option value="${rentType.getId()}"
                        <c:if test="${rentType.getId() == facility.getRentTypeId()}">selected</c:if>>${rentType.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Tiêu Chuẩn Phòng</label>
        <input type="text" name="standard-room" value="${facility.getStandardRoom()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Mô Tả Tiện Nghi Khác</label>
        <input type="text" name="description-other-convenience" value="${facility.getDescriptionOtherConvenience()}" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Số Tầng</label>
        <input type="text" name="number-of-floors" value="${facility.getNumbersOfFloors()}" class="form-control">
    </div>
</c:if>
    <c:if test="${facility.getFacilityTypeId() == 3}">
        <div class="mb-3">
            <label class="form-label">Loại Dịch Vụ</label>
            <select name="facility-type">
                <c:forEach var="facilityType" items="${facilityTypeList}">
                    <option value="${facilityType.getId()}"
                            <c:if test="${facilityType.getId() == facility.getFacilityTypeId()}">selected</c:if>>${facilityType.getName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên Dịch Vụ</label> <br>
            <input type="text" name="name" value="${facility.getName()}" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Diện Tích Sử Dụng</label>
            <input type="text" name="area" value="${facility.getArea()}" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Chi Phí Thuê</label>
            <input type="text" name="cost" value="${facility.getCost()}" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Số Lượng Người Tối Đa</label>
            <input type="text" name="max-people" value="${facility.getMaxPeople()}" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Kiểu Thuê</label>
            <select name="rent-type">
                <c:forEach var="rentType" items="${rentTypeList}">
                    <option value="${rentType.getId()}"
                            <c:if test="${rentType.getId() == facility.getRentTypeId()}">selected</c:if>>${rentType.getName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Dịch Vụ Miễn Phí Đi Kèm</label>
            <input type="text" name="facility_free" value="${facility.getFacilityFree()}" class="form-control">
        </div>
    </c:if>
    <a class="btn btn-secondary" href="/facility" role="button">Hủy</a>
    <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
    </div>
    </div>
    <div class="row text-lg-center fs-4 btn-secondary footer">
    <p>©2022 Furama Resort Danang</p>
    </div>
    <script src="../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
    </body>
    </html>
