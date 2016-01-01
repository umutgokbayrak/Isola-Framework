<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		<ext:formPanel url="output.jsp" width="600" height="200" id="myForm" renderTo="myDiv" isAjaxForm="false" frame="true">
			<ext:fieldSet layout="column" autoHeight="true" frame="true">
				<ext:fieldSet title="Grup 1" layout="column" columnWidth=".50" autoHeight="true" bodyStyle="padding:10px;">
					<ext:panel columnWidth=".40" layout="form">
						<ext:radio name="rb" value="test1" id="rb1" boxLabel="Deneme 1" hideLabel="true"/>
					</ext:panel>
					<ext:panel columnWidth=".60" layout="form">
						<ext:radio name="rb" value="test2" id="rb2" boxLabel="Deneme 2" hideLabel="true"/>
					</ext:panel>
				</ext:fieldSet>
				<ext:fieldSet title="Grup 2" layout="form" columnWidth=".50" autoHeight="true" bodyStyle="padding:10px;" style="margin-left:10px;">
					<ext:radio name="rb2" fieldLabel="Test 1" value="deneme1" id="rb3" boxLabel="Deneme 3" />
					<ext:radio name="rb2" fieldLabel="" labelSeparator="" value="deneme2" id="rb4" boxLabel="Deneme 4"/>
				</ext:fieldSet>
			</ext:fieldSet>
			<ext:button type="submit" text="Submit" onClick="Ext.getCmp('myForm').submit();"/>
		</ext:formPanel>
	</ext:body>
	<div id="myDiv"></div>
</body>
</html>
