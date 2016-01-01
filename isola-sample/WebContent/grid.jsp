<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Grid Sample</title>
	<ext:init/></head>
<body>	<script type="text/javascript">	var gridCellClick = function(grid, rowIndex, columnIndex, e) {		if (columnIndex == 0) {			var val = grid.getStore().getAt(rowIndex).get('checkEnable');			if (val) 				val = false			else 				val = true;						grid.getStore().getAt(rowIndex).set('checkEnable', val);		}	}		var buttonClicked = function(button) {		var store = Ext.getCmp('myGrid').getStore();		var count = store.getCount();				var checkedRows = [];		for (var i=0;i<count;i++) {			var checked = store.getAt(i).get('checkEnable');			if (checked) {				checkedRows[checkedRows.length] = i;			}		}		alert(checkedRows);	}	</script>
	<ext:body runOnLoad="true">
		var dummyData = [
		[true, '3m Co',71.72,0.02,0.03,'9/1 12:00am', 'Manufacturing'],
		[false, 'Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am', 'Manufacturing'],
		[true, 'Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am', 'Manufacturing'],
		[false, 'American Express Company',52.55,0.01,0.02,'9/1 12:00am', 'Finance'],
		[true, 'American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am', 'Services'],
		[false, 'AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am', 'Services'],
		[true, 'Boeing Co.',75.43,0.53,0.71,'9/1 12:00am', 'Manufacturing'],
		[true, 'Caterpillar Inc.',67.27,0.92,1.39,'9/1 12:00am', 'Services'],
		[false, 'Citigroup, Inc.',49.37,0.02,0.04,'9/1 12:00am', 'Finance'],
		[true, 'E.I. du Pont de Nemours and Company',40.48,0.51,1.28,'9/1 12:00am', 'Manufacturing'],
		[true, 'Exxon Mobil Corp',68.1,-0.43,-0.64,'9/1 12:00am', 'Manufacturing'],
		[true, 'General Electric Company',34.14,-0.08,-0.23,'9/1 12:00am', 'Manufacturing'],
		[true, 'Pfizer Inc',27.96,0.4,1.45,'9/1 12:00am', 'Services', 'Medical'],
		[false, 'The Coca-Cola Company',45.07,0.26,0.58,'9/1 12:00am', 'Food'],
		[true, 'The Home Depot, Inc.',34.64,0.35,1.02,'9/1 12:00am', 'Retail'],
		[true, 'The Procter & Gamble Company',61.91,0.01,0.02,'9/1 12:00am', 'Manufacturing'],
		[false, 'United Technologies Corporation',63.26,0.55,0.88,'9/1 12:00am', 'Computer'],
		[false, 'Verizon Communications',35.57,0.39,1.11,'9/1 12:00am', 'Services'],
		[true, 'Wal-Mart Stores, Inc.',45.45,0.73,1.63,'9/1 12:00am', 'Retail'],
		[true, 'Walt Disney Company (The) (Holding Company)',29.89,0.24,0.81,'9/1 12:00am', 'Services']
		];

		var store = <ext:arrayStore data="dummyData" autoLoad="true">
			<ext:storeMapping name="checkEnable" mapping="0" />
			<ext:storeMapping name="company" mapping="1" />
			<ext:storeMapping name="price" mapping="2" />
			<ext:storeMapping name="change" mapping="3" />
			<ext:storeMapping name="pctChange" mapping="4" />
			<ext:storeMapping name="lastChange" mapping="5" />
			<ext:storeMapping name="industry" mapping="6" />
		</ext:arrayStore>
		var denemeVar = 'ali';
		<ext:jsonStore url="deneme.jsp" root="result" timeout="44000" autoLoad="true">			<ext:httpParam name="deneme" value="denemeVar"/>			<ext:storeMapping name="11sd"/>		</ext:jsonStore>
		var checkBoxRenderer = function(value, cell, rec, rowIndex, colIndex, ds) {			if (value) {		    	return '<img class="checkbox" src="images/checked.gif">';			} else {		    	return '<img class="checkbox" src="images/unchecked.gif">';			}		};		<ext:gridPanel id="myGrid" renderTo="myGridDiv" width="700" height="400" frame="true" border="true" bodyBorder="true" storeId="store" forceFit="true" onCellClick="gridCellClick" enableHdMenu="true">			<ext:columnModel>				<ext:gridColumn dataIndex="checkEnable" renderer="checkBoxRenderer" header=" " width="10"/>				<ext:gridColumn dataIndex="company" header="Company"/>				<ext:gridColumn dataIndex="change" header="Change" />				<ext:gridColumn dataIndex="industry" header="Industry" sortable="true" resizable="true" />			</ext:columnModel>			<ext:button type="button" text="Click Me!" onClick="buttonClicked" />		</ext:gridPanel>			</ext:body>
	<div id="myGridDiv"></div>
</body>
