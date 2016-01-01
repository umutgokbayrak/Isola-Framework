<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Panel Load Test</title>
	<ext:init/>
</head>
<body>
	<ext:body runOnLoad="true">
		var loadFrame = function() {
			Ext.get('inFrame').load({
				url: 'deneme.jsp',
				scripts: true,
				method: 'post',
				timeout: 60,
				text: 'Loading...'
				params: {
					param1: 'deneme',
					param2: 'denememe'
				}
			});
		}
		<ext:panel id="outFrame" renderTo="myDiv" width="600" height="250" border="true" bodyBorder="true" layout="fit">
			<ext:panel id="inFrame"></ext:panel>
			<ext:button type="button" text="Load Frame" onClick="loadFrame"/>
		</ext:panel>
	</ext:body>
	<div id="myDiv"></div>
</body>
