<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%	request.setAttribute("abc", null);%>
<html>	<head>		<ext:init lang="tr" cssPath="" jsPath=""/>		<script type="text/javascript" src="isola/engine.js"> </script>
		<js:script>            var dummyData = [['3m Co',71.72,0.02,0.03,'9/1 12:00am', 'Manufacturing'],            ['Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am', 'Manufacturing'],            ['Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am', 'Manufacturing'],            ['American Express Company',52.55,0.01,0.02,'9/1 12:00am', 'Finance'],            ['American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am', 'Services'],            ['AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am', 'Services'],            ['Boeing Co.',75.43,0.53,0.71,'9/1 12:00am', 'Manufacturing'],            ['Wal-Mart Stores, Inc.',45.45,0.73,1.63,'9/1 12:00am', 'Retail'],
            ['Walt Disney Company (The) (Holding Company)',29.89,0.24,0.81,'9/1 12:00am', 'Services']]; 
            <js:function name="hebelek" params="form, action">				var obj = Ext.util.JSON.decode(action.response.responseText); 				form.markInvalid(obj.errors);            </js:function>		</js:script>	</head>	<body>		<ext:body runOnLoad="true" storeSession="true">			var store = <ext:arrayStore data="dummyData" autoLoad="false">				<ext:storeMapping name="company" />				<ext:storeMapping name="price" />				<ext:storeMapping name="change" />
				<ext:storeMapping name="pctChange" />				<ext:storeMapping name="lastChange" />				<ext:storeMapping name="industry" />			</ext:arrayStore>			<ext:viewPort>				<ext:formPanel url="deneme.jsp" id="myForm" isAjaxForm="true" region="west" split="true" waitingText="Lutfen Bekleyiniz" waitingTitle="Baglanti Kuruluyor..." bodyStyle="padding:10px;" width="300"> 					<ext:fieldSet width="270" height="400">						<ext:radio fieldLabel="Hed�" name="rb" value="ad" checked="true" id="hedo" labelSeparator=":" width="130" />						<ext:radio fieldLabel="Hebe" name="rb" value="bb" checked="false" id="hebe" labelSeparator=":" width="130"/>						<ext:textField name="username" width="130" fieldLabel="Username" msgTarget="under" value="${abc}"/>						<ext:passwordField name="password" width="130" fieldLabel="Password" msgTarget="under" msgFx="slide" />						<ext:comboBox name="cmb1" hiddenId="cmb1H" hiddenName="cmb1H" width="130" storeId="store" displayField="company" valueField="industry" fieldLabel="Combo box" editable="false" minListWidth="270" />
						<ext:button type="submit" text="Submit"/>					</ext:fieldSet>				</ext:formPanel>				<ext:borderLayout region="center">					<ext:columnTree region="north" split="true" rootVisible="true" autoScroll="true" height="400" border="true">					      <ext:columnModel>					            <ext:gridColumn dataIndex="task" header="Task" width="350" />					            <ext:gridColumn dataIndex="duration" header="Duration" width="200" />					            <ext:gridColumn dataIndex="user" header="Assigned To" width="300" />					      </ext:columnModel>					      <ext:treeLoader url="isola/columntree.js" preloadChildren="true">					            <ext:httpParam name="method" value="getColumns"/>					      </ext:treeLoader>					      <ext:asyncTreeNode text="Tasks" expanded="true"/>					</ext:columnTree>					<ext:gridPanel id="myGrid" forceFit="true" storeId="store" enableHdMenu="false" enableColumnMove="false" title="Hebelek was here" region="center" split="true" iconCls="ico-grid" >						<ext:columnModel>							<ext:gridColumn dataIndex="company" header="Company" resizable="false" sortable="true" />							<ext:gridColumn dataIndex="price" header="Price" resizable="false" sortable="true" />							<ext:gridColumn dataIndex="change" header="Change" resizable="false" sortable="true" />							<ext:gridColumn dataIndex="pctChange" header="PctChange" resizable="false" sortable="true" />							<ext:gridColumn dataIndex="lastChange" header="Last Change" resizable="false" sortable="true" />							<ext:gridColumn dataIndex="industry" header="Industry" resizable="false" sortable="true" />						</ext:columnModel>						<ext:toolbar position="top">							<ext:toolbarButton text="Grid" iconCls="ico-grid"></ext:toolbarButton>							<ext:toolbarSeparator />							<ext:toolbarButton text="Search" iconCls="ico-search"></ext:toolbarButton>							<ext:toolbarFill/>						</ext:toolbar>						<ext:gridSearchPlugin mode="local" position="top" />						<ext:pagingToolbar position="bottom" pageSize="6" displayInfo="true" storeId="store"></ext:pagingToolbar>					</ext:gridPanel>				</ext:borderLayout>			</ext:viewPort>		</ext:body>	</body></html>
