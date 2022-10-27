<%@include file="headfooter/header.jsp" %>

<div id="form">
    <div id="form-title">
        
        <span><a href="" style="color: black;">SIGN IN</a></span>
        <span><a href="signup.jsp" style="color: red;">SIGN UP</a></span>
    </div>
    <div id="form-content">
        
            <span class="msg-error">${msg}</span><br/>
        
        <form method="post">
            <label>Email<span style="color: red;">*</span></label><br/>
            <input type="text" name="txtEmail"/><br/>
            <span class="msg-error">${msgEmail}</span><br/>
            <label>Password<span style="color: red;">*</span></label><br/>
            <input type="password" name="txtPass"/><br/>
            <span class="msg-error">${msgPass}</span><br/>
            <div><a href="forgot.html">Forgot password?</a></div>
            <input type="submit" value="SIGN IN"/><br/>
            
            <input type="button" value="FACEBOOK LOGIN" style="background-color: #3b5998;"/><br/>
            <input type="button" value="ZALO LOGIN" style="background-color: #009dff;margin-bottom: 30px;"/>
        </form>
    </div>
</div>

<%@include file="headfooter/footer.jsp" %>