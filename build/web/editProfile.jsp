<%@include file="headfooter/header.jsp" %>
<div id="content-left">
    <h3 style="font-weight: normal;">Welcome, <b>${cus.getContactName()} ${em.getTitleOfCourtesy()}${em.getFirstName()}</b></h3>
    <c:if test="${cus.getCustomerID() != null}">
        <h3>Account Customer</h3>
    </c:if>
    <c:if test="${em.getFirstName() != null}">
        <h3>Account Employee</h3>
    </c:if>
    <ul>
        <a href="${path}/account/profile"><li>Personal information</li></a>
    </ul>
    <h3>My order</h3>
    <ul>
        <a href="profile1.html"><li>All orders</li></a>
        <a href="#"><li>Canceled order</li></a>
    </ul>
</div>
<div id="content-right">
    <div class="path">Personal information</b></div>
    <div class="content-main">
        <form action="editProfile" method="post">
            <c:if test="${cus.getCustomerID() != null}">
                <div id="profile-content">
                    <div class="profile-content-col">
                        <div>Company name: <br/><input type="text" name="txtCompany" value="${cus.getCompanyName()}"/></div>
                        <div>Contact name: <br/><input type="text" name="txtContact" value="${cus.getContactName()}"/></div>
                        <div>

                            <a href="${path}/editProfile"><input type="submit" value="Save"/></a>

                        </div>
                    </div>
                    <div class="profile-content-col">
                        <div>Company title: <br/><input type="text" name="txtTitle" value="${cus.getContactTitle()}"/><b></b></div>
                        <div>Address: <br/><input type="text" name="txtAdd" value="${cus.getAddress()}"/></div>
                    </div>
                    <div class="profile-content-col">
                        <div>Email: <br/><b>${sessionScope["AccSession"].getEmail()}</b></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${em.getFirstName() != null}">
                <div id="profile-content">
                    <div class="profile-content-col">
                        <div>Last name: <br/><input type="text" name="txtLastName" value="${em.getLastName()}"/></div>
                        <div>First name: <br/><input type="text" name="txtFirtName" value="${em.getFirstName()}"/></div>
                        <div>

                            <a href="${path}/editProfile"><input type="submit" value="Save"/></a>

                        </div>
                    </div>
                    <div class="profile-content-col">
                        <div>Title: <br/><input type="text" name="txtTitle" value="${em.getTitle()}"/></div>
                        <div>Address: <br/><input type="text" name="txtAdd" value="${em.getAddress()}"/></div>
                        <div>Department: <br/>
                            <select name="DepartmentID">
                                <c:forEach items="${departList}" var="de">
                                    <c:if test="${de.getDepartmentID() == em.getDepartmentID()}">
                                        <option value="${de.getDepartmentID()}" selected>${de.getDepartmentName()}</option>
                                    </c:if>
                                    <c:if test="${de.getDepartmentID() != em.getDepartmentID()}">
                                        <option value="${de.getDepartmentID()}" >${de.getDepartmentName()}</option>
                                        </c:if>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="profile-content-col">
                        <div>DOB <br/><b>${em.getBirthDate()}</b></div>
                        <div>Hire from: <br/><b>${em.getHireDate()}</b></div>
                        <div>Email: <br/><b>${sessionScope["AccSession"].getEmail()}</b></div>
                    </div>
                </div>
            </c:if>
        </form>
    </div>
</div>

<%@include file="headfooter/footer.jsp" %>