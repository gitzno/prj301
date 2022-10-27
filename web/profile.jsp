<%@include file="headfooter/header.jsp" %>
<div id="content-left">
    <h3 style="font-weight: normal;">Welcome,<b> ${cus.getContactName()} ${em.getTitleOfCourtesy()}${em.getFirstName()}</b></h3>
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
        <c:if test="${cus.getCustomerID() != null}">
            <div id="profile-content">
                <div class="profile-content-col">
                    <div>Company name: <br/><b>${cus.getCompanyName()}</b></div>
                    <div>Contact name: <br/><b>${cus.getContactName()}</b></div>
                    <div>

                        <a href="${path}/editProfile"><input type="submit" value="Edit"/></a>

                    </div>
                </div>
                <div class="profile-content-col">
                    <div>Company title: <br/><b>${cus.getContactTitle()}</b></div>
                    <div>Address: <br/><b>${cus.getAddress()}</b></div>
                </div>
                <div class="profile-content-col">
                    <div>Email: <br/><b>${sessionScope["AccSession"].getEmail()}</b></div>
                </div>
            </div>
        </c:if>
        <c:if test="${em.getFirstName() != null}">
            <div id="profile-content">
                <div class="profile-content-col">
                    <div>Last name: <br/><b>${em.getLastName()}</b></div>
                    <div>First name: <br/><b>${em.getFirstName()}</b></div>
                    <div>

                        <a href="${path}/editProfile"><input type="submit" value="Edit"/></a>

                    </div>
                </div>
                <div class="profile-content-col">
                    <div>Title: <br/><b>${em.getTitle()}</b></div>
                    <div>Address: <br/><b>${em.getAddress()}</b></div>
                    <div>Department: <br><b>${listDe.get(em.getDepartmentID() - 1).getDepartmentName()}</b></div>
                </div>
                <div class="profile-content-col">
                    <div>DOB <br/><b>${em.getBirthDate()}</b></div>
                    <div>Hire from: <br/><b>${em.getHireDate()}</b></div>
                    <div>Email: <br/><b>${sessionScope["AccSession"].getEmail()}</b></div>
                </div>
            </div>
        </c:if>
    </div>
</div>

<%@include file="headfooter/footer.jsp" %>