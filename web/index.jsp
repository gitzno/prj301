<%-- 
    Document   : index
    Created on : Oct 17, 2022, 4:19:20 PM
    Author     : Chold
--%>
<%@include file="headfooter/header.jsp" %>
<c:if test="${session.getAttribute('AccSession') != null}">
    <div>check xem co session chua</div>
</c:if>
<div id="content-left" >

    <h3>CATEGORY </h3>

    <ul>

        <c:forEach items="${list}" var="cate"> 
            <a href="${path}/category?id=${cate.getCategoryID()}">
                <li>${cate.getCategoryName()}</li>
            </a>
        </c:forEach>


    </ul>
    <form action="search" method="post">
        <div class="searchBox" >
            <input class="searchInput" type="text" name="txtSearch" placeholder="Search in all products">
            <button class="searchButton" type="submit">
                <i class="material-icons">
                    S
                </i>
            </button>
        </div>
    </form>
</div>
<div id="content-right">
    <div class="path">Hot</b></div>
    <div class="content-main">
        <c:forEach items="${listHot}" var="pro"> 
            <div class="product">
                <a href="${path}/detail?id=${pro.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="${path}/detail?id=${pro.getProductID()}">${pro.getProductName()}</a></div>
                <div class="price">${pro.getUnitPrice()}</div>
                <div><a href="${path}/detail?id=${pro.getProductID()}">Buy now</a></div>
            </div><!-- comment -->
        </c:forEach>
    </div>

    <div class="path">Best Sale</b></div>
    <div class="content-main">
        <c:forEach items="${listSale}" var="proSale"> 
            <div class="product">
                <a href="${path}/detail?id=${proSale.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="${path}/detail?id=${proSale.getProductID()}">${proSale.getProductName()}</a></div>
                <div class="price">${proSale.getUnitPrice()} <div style="color: red; font-size: 22px;"></div></div>
                <div><a href="${path}/detail?id=${proSale.getProductID()}">Buy now</a></div>
            </div>
        </c:forEach>
    </div>
    <div class="path">New Product</b></div>
    <div class="content-main">
        <c:forEach items="${listNew}" var="proNew"> 
            <div class="product">
                <a href="${path}/detail?id=${proNew.getProductID()}"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="${path}/detail?id=${proNew.getProductID()}">${proNew.getProductName()}</a></div>
                <div class="price">${proNew.getUnitPrice()}</div>
                <div><a href="${path}/detail?id=${proNew.getProductID()}">Buy now</a></div>
            </div><!-- comment -->
        </c:forEach>
    </div>
</div>

<%@include file="/headfooter/footer.jsp" %>
