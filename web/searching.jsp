<%-- 
    Document   : index
    Created on : Oct 17, 2022, 4:19:20 PM
    Author     : Chold
--%>
<%@include file="headfooter/header.jsp" %>

<div id="content-left" >

    <h3>CATEGORY</h3>

    <ul>

        <c:forEach items="${listcate}" var="cate"> 
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

<div id="content-right" style="margin: 0 10px 0 0">

    <div class="path">${category.getCategoryName()}</div>
    <div style="   display: grid;
         grid-template-columns: auto auto auto;
         justify-items: start;">
        <c:forEach items="${list}" var="pro"> 
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


</div>

<%@include file="/headfooter/footer.jsp" %>
