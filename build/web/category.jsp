<%-- 
    Document   : index
    Created on : Oct 17, 2022, 4:19:20 PM
    Author     : Chold
--%>
<%@include file="headfooter/header.jsp" %>

<div id="content-left">
    <% 
        String id = request.getParameter("id");
        request.setAttribute("ID", id);
    %>
    <h3>CATEGORY</h3>
    <ul>
        <c:forEach items="${listCategory}" var="cate"> 

            <a href="${path}/category?id=${cate.getCategoryID()}">
                <li>${cate.getCategoryName()}</li>
            </a>
        </c:forEach>
    </ul>
    <form action="search" method="post">
        <div class="searchBox" >
            <input class="searchInput"type="text" name="txtSearch" placeholder="Search in ${category.getCategoryName()} category">
            <button class="searchButton" type="submit">
                <i class="material-icons">
                    S
                </i>
            </button>
        </div>
    </form>
</div>

<div id="content-right" style="margin: 0 10px 0 0">

    <div class="path">${category.getCategoryName()}</div>
    <div style="   display: grid;
         grid-template-columns: auto auto auto;
         justify-items: start;">
        <c:forEach items="${listProduct}" var="pro"> 
            <div style="border: 1px solid saddlebrown;
                 margin: 0px 10px;
                 padding: 0px 0px 10px 0;
                 text-align: center">
                <a href="${path}/detail?id=${pro.getProductID()}"><img style="width: 26rem; " src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="${path}/detail?id=${pro.getProductID()}">${pro.getProductName()}</a></div>
                <div class="price">${pro.getUnitPrice()}</div>
                <div><a href="${path}/detail?id=${pro.getProductID()}">Buy now</a></div>
            </div><!-- comment -->
        </c:forEach>
    </div>

    <div class="pagination" style="text-align:center;">
        <c:if test="${tag > 1}">
            <a href="${path}/category?id=${category.getCategoryID()}&index=${tag - 1}"><<</a>
        </c:if>
        <c:forEach begin="${1}" end="${page}" var="i">
            <c:choose>
                <c:when test = "${i == tag}">
                    <a class="active" href="${path}/category?id=${category.getCategoryID()}&index=${i}">${i}</a>
                </c:when>

                <c:otherwise>
                    <a href="${path}/category?id=${category.getCategoryID()}&index=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${tag < page}">
            <a href="${path}/category?id=${category.getCategoryID()}&index=${tag + 1}">>></a>
        </c:if>
    </div>

</div>


<%@include file="/headfooter/footer.jsp" %>
