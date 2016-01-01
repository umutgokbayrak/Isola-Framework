<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<html>
<head>
	<title>Ajax Load Sample</title>
	<ext:init/>
</head>
<body>
<div id="header" style="font-size:18px;font-weight:bold;margin-bottom:20px;">Sample Header</div>
<div id="innerContent" style="width:600px;height:200px;background-color:#f8f8f8;overflow: auto;border:1px solid #d6d6d6;"></div>

<ext:body runOnLoad="true">
	Ext.get('innerContent').load({
		url: 'subpage.jsp',
		method: 'post',
		params: {
			param1: 'foo',
			param2: 'bar',
			param3: true
		},
		scripts: true
	});
</ext:body>
</body>

