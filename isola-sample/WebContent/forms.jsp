<%@page contentType="text/html; charset=utf-8" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<ext:init lang="tr"/>
		<script type="text/javascript" src="isola/engine.js" ></script>
		<script type="text/javascript" src="isola/forms.js" ></script>		<script type="text/javascript">  		var fieldCheck = function () {  			var chk = document.getElementsByName('hebelek-checkbox');  			chk[0].checked = !chk[0].checked;  		}  		  		var selectComboItem = function(obj, e) {  			var character = String.fromCharCode(e.getCharCode());  			// sadece ilk harfe gore ilk bulunani getiriyoruz. Eger kelime arama ve   			// ilk bulunandan daha ileri ozellik isteniyorsa kodlanmasi gerekir.   			var store = Ext.getCmp('myComboCmb').store;  			for (var i=0;i<store.getTotalCount();i++) {  				var name = store.getAt(i).get('name');  				if (name.indexOf(character) == 0) {  					Ext.getCmp('myComboCmb').selectByValue(store.getAt(i).get('value'));  				}  			}  		}		</script>
	</head>
	<body style="overflow:auto">
		<ext:body runOnLoad="true">
			var jsonStore = <ext:jsonStore id="imageStore" url="servlet/JsonSampleServlet" root="result">
				<ext:storeMapping name="name"/>
				<ext:storeMapping name="value"/>
	  		</ext:jsonStore>
			<ext:formPanel url="output.servlet" id="frm1" renderTo="formDiv" isAjaxForm="false" width="650" buttonAlign="right" style="margin:30px;">
				<ext:fieldSet id="hebelek" title="Deneme" width="640" autoHeight="true" checkboxToggle="true">					<ext:dateTime hiddenFormat="y-m-d H:i" name="dtime" width="200" fieldLabel="Date Time Test" allowBlank="false" />
					<ext:hidden name="hdn1" value="1234" />
					<ext:checkBox name="chk1" value="1 Selected" fieldLabel="Ali Gel"/>
					<ext:checkBox name="chk2" value="2 Selected" fieldLabel="Veli Gel"/>
					<ext:checkBox name="chk3" value="3 Selected" fieldLabel="Deli Gel"/>
					<ext:textField name="txt1" regex="53[0-9]{8}" value="" fieldLabel="Deneme" maxLength="10" msgTarget="under" />
					<ext:comboBox name="myComboCmb" storeId="jsonStore" valueField="value" displayField="name" fieldLabel="Combo Test" hiddenName="myCombo" hiddenId="myCombo" allowBlank="false" editable="false"/>
					<ext:button type="button" text="Toggle" onClick="fieldCheck"/>
					<ext:button type="submit" text="Submit" onClick="Ext.getCmp('frm1').submit();"></ext:button>
					<ext:cycleButton>
						<ext:menuCheckItem text="Test 1" handler="alert('test1 clicked');"/>
						<ext:menuCheckItem checked="true" text="Test 2" handler="alert('test2 clicked');"/>
					</ext:cycleButton>
					<ext:dateField name="dt1" fieldLabel="Sample Date"/>
					<ext:numberField name="number1" fieldLabel="Number Test" />
					<ext:htmlEditor name="htmlEditor1" width="600" height="200"/>
					<ext:passwordField name="pass1" fieldLabel="Password Test"/>
					
					<ext:radioGroup name="group1" horizontal="true" fieldLabel="Radio Group 1">
						<ext:radio name="rb1" value="1" boxLabel="Option 1"/>
						<ext:radio name="rb1" value="2" boxLabel="Option 2"/>
						<ext:radio name="rb1" value="3" boxLabel="Option 3"/>
						<ext:radio name="rb1" value="4" boxLabel="Option 4"/>
					</ext:radioGroup>

					<ext:splitButton text="Split Button" handler="alert('this is the handler');">
						<ext:menu>
							<ext:menuTextItem text="Text Item" handler="alert('yes');"/>
							<ext:menuCheckItem text="Check Item" checked="true"/>
							<ext:menuSeparator/>
							<ext:menuItem text="Submenu">
								<ext:menu>
									<ext:menuTextItem text="Test Submenu 1"/>
									<ext:menuTextItem text="Test Submenu 2"/>
								</ext:menu>
							</ext:menuItem>
							<ext:menuColorItem />
						</ext:menu>
						<ext:menuTextItem />
					</ext:splitButton>
					
					<ext:textArea name="textArea1" width="400" height="150" fieldLabel="TextArea Sample" />
					
					<ext:textField name="txt2" width="200" fieldLabel="TextField Sample"/>
					
					<ext:timeField name="time1" width="130" fieldLabel="Time"/>
				</ext:fieldSet>
			</ext:formPanel>
		</ext:body>
		<div id="formDiv"></div>
	</body>
</html>
