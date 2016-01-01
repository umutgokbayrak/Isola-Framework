<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;background-color:#fbfbfb;">
	<ext:body runOnLoad="true">
		var evaluateResult = function(form, action) {
			var result = action.result.success;
			if (result)
				location.href = action.result.data.url;
		}
	
		<ext:formPanel url="../validateLogin.servlet" id="loginForm" renderTo="loginFormDiv" 
			width="350" height="135" border="true" bodyBorder="true" frame="true"
			bodyStyle="padding:10px;" style="margin-left:100px;margin-top:100px;" 
			title="Lütfen Bilgilerinizi Giriniz..." isAjaxForm="true" waitingTitle="Baðlanýyor"
			waitingText="Lütfen bekleyiniz..." onActionComplete="evaluateResult">
			<ext:hidden name="error" />
			<ext:textField name="username" allowBlank="false" regex="^[a-zA-Z]+$" regexText="Sadece harf giriniz." 
				msgTarget="side" fieldLabel="Kullanýcý Adý" />
			<ext:passwordField name="password" allowBlank="false" regex="^[a-zA-Z]+$" regexText="Sadece harf giriniz." 
				msgTarget="side" fieldLabel="Þifre" />
			<ext:button type="submit" text="Giriþ" />
		</ext:formPanel>
		
	</ext:body>
	<div id="loginFormDiv"></div>
</body>
</html>
