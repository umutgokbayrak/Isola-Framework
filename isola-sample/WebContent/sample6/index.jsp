<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<ext:body runOnLoad="true">
		var colors = ['red', 'yellow', 'blue'];

		var showChecked = function(checkbox, checked) {
			$('outputDiv').innerHTML = checkbox.id + ' is checked: ' + checked;
		}
		<ext:formPanel url="output.jsp" id="myForm" renderTo="myDiv">
			<ext:fieldSet title="Test Checkboxes" height="70" width="400" layout="column">
				<ext:panel columnWidth=".25" layout="form" bodyStyle="padding-top:5px;">
					<ext:checkBox name="opt1" hideLabel="true" boxLabel="Option 1" value="Option 1" onCheck="showChecked"/>
				</ext:panel>
				<ext:panel columnWidth=".25" layout="form" bodyStyle="padding-top:5px;">
					<ext:checkBox name="opt2" hideLabel="true" boxLabel="Option 2" value="Option 2" onCheck="showChecked"/>
				</ext:panel>
				<ext:panel columnWidth=".25" layout="form" bodyStyle="padding-top:5px;">
					<ext:checkBox name="opt3" hideLabel="true" boxLabel="Option 3" value="Option 3" onCheck="showChecked"/>
				</ext:panel>
				<ext:panel columnWidth=".25" layout="form" buttonAlign="left">
					<ext:button type="submit" text="Submit" onClick="Ext.getCmp('myForm').submit();"/>
				</ext:panel>
			</ext:fieldSet>
		</ext:formPanel>
	</ext:body>
	<div id="myDiv"></div>
	<div id="outputDiv" style="font-size:12px;font-weight:bold;"></div>
</body>
</html>
