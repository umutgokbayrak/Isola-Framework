<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		var submitAjaxForm = function() {
			Ext.getCmp('myForm1').submit();
		}
	
		<ext:formPanel url="deneme.jsp" id="myForm1" renderTo="myDiv" isAjaxForm="false">
			<ext:fieldSet title="Ajax Form" autoHeight="true" autoWidth="true">
				<ext:textField name="txt1" fieldLabel="Test"/>
				<ext:button type="submit" text="Submit" onClick="submitAjaxForm" />
			</ext:fieldSet>
		</ext:formPanel>
	</ext:body>
	
	<div id="myDiv"></div>
</body>
</html>
