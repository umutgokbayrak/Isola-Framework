<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %>
<html>
<head>
<title>EditorGrid Sample</title>
<ext:init />
<!-- 
This JSP consumes a JSON such as: 
{
	"result":[{
			"dtSample":1249903104747,
			"id":0,
			"name":"name 0",
			"tsSample":1238156304747
		},{
			"dtSample":1248002304747,
			"id":1,
			"name":"name 1",
			"tsSample":1252754304747
		},{
			"dtSample":1236687504747,
			"id":2,
			"name":"name 2",
			"tsSample":1236514704747
		}
	]
}
-->
<ext:body runOnLoad="true">
	var dtFunct = function(v) {
		return new Date(v);
	}

	var commitDs = function() {
		Ext.getCmp('myGrid').getStore().commitChanges();
	}

	<ext:editorGridPanel id="myGrid" renderTo="grid1" width="700" height="200" border="true" bodyBorder="true" frame="true" forceFit="true" onAfterEdit="commitDs">
		<ext:jsonStore url="dateSample.json" root="result" autoLoad="true" method="get">
			<ext:storeMapping name="id"/>
			<ext:storeMapping name="name"/>
			<ext:storeMapping name="dtSample" convert="dtFunct" />
			<ext:storeMapping name="tsSample" convert="dtFunct" />
		</ext:jsonStore>
		<ext:columnModel>
			<ext:gridColumn dataIndex="id" header="ID"/>
			<ext:gridColumn dataIndex="name" header="Name"/>
			<ext:gridColumn dataIndex="dtSample" header="Date" renderer="Ext.util.Format.dateRenderer('d/m/Y')">
				<ext:dateField name="dt1" allowBlank="false"/>
			</ext:gridColumn>
			<ext:gridColumn dataIndex="tsSample" header="Timestamp" renderer="Ext.util.Format.dateRenderer('d/m/Y')">
				<ext:dateField name="ts1" allowBlank="true"/>
			</ext:gridColumn>
		</ext:columnModel>
	</ext:editorGridPanel>
</ext:body>
</head>
<body>
<div id="grid1"></div>
</body>
</html>
