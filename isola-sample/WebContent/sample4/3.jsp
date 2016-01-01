<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		<ext:panel layout="form" width="400" height="90" renderTo="myDiv" frame="true" border="true" bodyBorder="true">
			<ext:textField name="firstName" fieldLabel="Search String" width="190"/>
			<ext:button type="submit" text="Submit" />
		</ext:panel>
	</ext:body>
	<div id="myDiv"></div>
</body>
</html>
