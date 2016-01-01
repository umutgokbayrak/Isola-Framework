<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		<ext:formPanel url="1.jsp" id="myForm" renderTo="myDiv" width="600">
			<ext:panel layout="column">
				<ext:panel columnWidth=".53" layout="form">
					<ext:textField name="firstName" fieldLabel="Ýsminiz" width="200"/>
				</ext:panel>
				<ext:panel columnWidth=".23" layout="form">
					<ext:textField name="middleName" hideLabel="true" />
				</ext:panel>
				<ext:panel columnWidth=".23" layout="form">
					<ext:textField name="surName" hideLabel="true"/>
				</ext:panel>
			</ext:panel>
			<ext:textField name="txt2" fieldLabel="Sample Text"/>
		</ext:formPanel>
	</ext:body>
	
	<div id="myDiv"></div>
</body>
</html>
