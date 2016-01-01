<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Grid With Row Expander Sample</title>
	<ext:init/>
	<ext:body runOnLoad="true">
		Ext.grid.dummyData = [
		    ['3m Co',71.72,0.02,0.03,'9/1 12:00am', 'Manufacturing'],
		    ['Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am', 'Manufacturing'],
		    ['Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am', 'Manufacturing'],
		    ['American Express Company',52.55,0.01,0.02,'9/1 12:00am', 'Finance'],
		    ['American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am', 'Services'],
		    ['AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am', 'Services'],
		    ['Boeing Co.',75.43,0.53,0.71,'9/1 12:00am', 'Manufacturing'],
		    ['Caterpillar Inc.',67.27,0.92,1.39,'9/1 12:00am', 'Services'],
		    ['Citigroup, Inc.',49.37,0.02,0.04,'9/1 12:00am', 'Finance'],
		    ['E.I. du Pont de Nemours and Company',40.48,0.51,1.28,'9/1 12:00am', 'Manufacturing'],
		    ['Exxon Mobil Corp',68.1,-0.43,-0.64,'9/1 12:00am', 'Manufacturing'],
		    ['General Electric Company',34.14,-0.08,-0.23,'9/1 12:00am', 'Manufacturing'],
		    ['General Motors Corporation',30.27,1.09,3.74,'9/1 12:00am', 'Automotive'],
		    ['Hewlett-Packard Co.',36.53,-0.03,-0.08,'9/1 12:00am', 'Computer'],
		    ['Honeywell Intl Inc',38.77,0.05,0.13,'9/1 12:00am', 'Manufacturing'],
		    ['Intel Corporation',19.88,0.31,1.58,'9/1 12:00am', 'Computer'],
		    ['International Business Machines',81.41,0.44,0.54,'9/1 12:00am', 'Computer'],
		    ['Johnson & Johnson',64.72,0.06,0.09,'9/1 12:00am', 'Medical'],
		    ['JP Morgan & Chase & Co',45.73,0.07,0.15,'9/1 12:00am', 'Finance'],
		    ['McDonald\'s Corporation',36.76,0.86,2.40,'9/1 12:00am', 'Food'],
		    ['Merck & Co., Inc.',40.96,0.41,1.01,'9/1 12:00am', 'Medical'],
		    ['Microsoft Corporation',25.84,0.14,0.54,'9/1 12:00am', 'Computer'],
		    ['Pfizer Inc',27.96,0.4,1.45,'9/1 12:00am', 'Services', 'Medical'],
		    ['The Coca-Cola Company',45.07,0.26,0.58,'9/1 12:00am', 'Food'],
		    ['The Home Depot, Inc.',34.64,0.35,1.02,'9/1 12:00am', 'Retail'],
		    ['The Procter & Gamble Company',61.91,0.01,0.02,'9/1 12:00am', 'Manufacturing'],
		    ['United Technologies Corporation',63.26,0.55,0.88,'9/1 12:00am', 'Computer'],
		    ['Verizon Communications',35.57,0.39,1.11,'9/1 12:00am', 'Services'],
		    ['Wal-Mart Stores, Inc.',45.45,0.73,1.63,'9/1 12:00am', 'Retail'],
		    ['Walt Disney Company (The) (Holding Company)',29.89,0.24,0.81,'9/1 12:00am', 'Services']
		];

		// add in some dummy descriptions
		for(var i = 0; i < Ext.grid.dummyData.length; i++){
		    Ext.grid.dummyData[i].push('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.<br/><br/>Aliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit.');
		}
		var expander = <ext:rowExpander>
			<p><b>Company:</b> {company}</p><br>
			<p><b>Summary:</b> {desc}</p>
		</ext:rowExpander>

		<ext:gridPanel id="myGridHell" renderTo="renderMe" forceFit="true" width="600" height="300" collapsible="true" animCollapse="false" title="Expander Rows, Collapse and Force Fit" iconCls="ico-grid">
			<ext:arrayStore data="Ext.grid.dummyData" autoLoad="true">
				<ext:storeMapping name="company"/>
				<ext:storeMapping name="price" type="float"/>
				<ext:storeMapping name="change" type="float"/>
				<ext:storeMapping name="pctChange" type="float"/>
				<ext:storeMapping name="lastChange" type="date" dateFormat="n/j h:ia"/>
				<ext:storeMapping name="industry"/>
				<ext:storeMapping name="desc"/>
			</ext:arrayStore>
			<ext:columnModel rowExpander="expander">
				<ext:gridColumn dataIndex="company" header="Company" width="40" sortable="true" />
				<ext:gridColumn dataIndex="price" header="Price" width="20" sortable="true" renderer="Ext.util.Format.usMoney"/>
				<ext:gridColumn dataIndex="change" header="Change" width="20" sortable="true" />
				<ext:gridColumn dataIndex="pctChange" header="% Change" width="20" sortable="true" />
				<ext:gridColumn dataIndex="lastChange" header="Last Updated" width="20" renderer="Ext.util.Format.dateRenderer('m/d/Y')" />
			</ext:columnModel>
		</ext:gridPanel>
	</ext:body>
</head>
<body>
<div id="renderMe"></div>
</html>
