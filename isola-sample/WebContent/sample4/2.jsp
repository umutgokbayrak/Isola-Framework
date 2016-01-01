<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		<ext:formPanel url="1.jsp" id="myForm" renderTo="myDiv" width="370">
			<ext:panel layout="column">
				<ext:panel columnWidth=".80" layout="form" bodyStyle="padding-top:7px;">
					<ext:textField name="firstName" fieldLabel="Search String" width="190"/>
				</ext:panel>
				<ext:panel columnWidth=".20" layout="form" buttonAlign="left">
					<ext:button type="submit" text="Search"></ext:button>
				</ext:panel>
			</ext:panel>
			<ext:textField name="txt2" fieldLabel="Sample Text"/>
		</ext:formPanel>
	</ext:body>
	
	<div id="myDiv"></div>
</body>
</html>
