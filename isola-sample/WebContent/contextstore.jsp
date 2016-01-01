<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %>
<%@page import="java.util.List"%>
<%@page import="isola.samples.SampleItem"%>
<%@page import="java.util.ArrayList"%>
<%	List<SampleItem> items = new ArrayList<SampleItem>();

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<ext:init/>
	</head>
	<body>
		<ext:body runOnLoad="true">
			// sampleitem'in iki attribute'u var name ve value. storeMapping'deki name degiskenleri bu
			// attribute'lardir. 
			var store = <ext:contextStore httpAttribute="items" httpScope="request">
				<ext:storeMapping name="name" />
				<ext:storeMapping name="value" />
			</ext:contextStore>

			<ext:gridPanel storeId="store" renderTo="myDiv" width="600" height="200" frame="true" border="true" bodyBorder="true" forceFit="true" style="margin:30px;" title="ContextStore Sample" collapsible="true">
				<ext:gridColumn dataIndex="name" header="Name" />
				<ext:gridColumn dataIndex="value" header="Value" /> 
			</ext:gridPanel>
		</ext:body>
		<div id="myDiv"></div>
	</body>
</html>
