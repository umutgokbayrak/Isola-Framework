<%@ page contentType="text/html;charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<html>
<head>      
      <ext:init/>
</head>
<body>      
 <ext:body runOnLoad="true">
        var navHandler = function(direction){
        	var wizard = Ext.getCmp('wizard');
        	if (wizard != null) {
                var lay = wizard.getLayout();
                var i = lay.activeItem.id.split('card-')[1];
                var next = parseInt(i) + direction;
                lay.setActiveItem(next);
                Ext.getCmp('move-prev').setDisabled(next==0);
                Ext.getCmp('move-next').setDisabled(next==2);
        	}
        };
        <ext:panel id="wizard" layout="card" renderTo="hebelek" title="Example Wizard" 
activeItem="0" bodyStyle="padding:15px" border="true" width="700" height="500">
                <ext:toolbar position="bottom">
                        <ext:toolbarButton id="move-prev" text="Back" 
onClick="navHandler(-1);" disabled="true" />
                        <ext:toolbarFill/>
                        <ext:toolbarButton id="move-next" text="Next" 
onClick="navHandler(1);" />
                </ext:toolbar>
                <ext:panel id="card-0" border="false">
                        <h1>Welcome to the Wizard!</h1><p>Step 1 of 3</p>
                </ext:panel>
                <ext:panel id="card-1" border="false">
                        <h1>Second Step</h1><p>Step 2 of 3</p>
                </ext:panel>
                <ext:panel id="card-2" border="false">
                        <h1>Congratulations!</h1><p>Step 3 of 3 - Complete</p>
                </ext:panel>
        </ext:panel>
 </ext:body>
 <div id="hebelek"></div>
 </body>
 </html>
