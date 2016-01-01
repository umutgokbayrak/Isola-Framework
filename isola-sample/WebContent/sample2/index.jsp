<%@page contentType="text/html; charset=iso-8859-9" pageEncoding="iso-8859-9"%>
<%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/extjs" prefix="ext" %><%@ taglib uri="http://www.turkcell.com.tr/taglibs/jsp/js" prefix="js" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<ext:init lang="tr"/>
</head>
<body style="overflow:auto;padding:10px;">
	<h2 style="color:red;font-size:18px;font-weight:bold;padding-bottom:10px;">Ziyaretçi Defterim</h2>

	<c:forEach items="${entries}" var="entry">
		<div style="background-color:#f8f8f8;padding:5px;">
			Kimden: ${entry.fromName}<br/>
			Başlık: ${entry.subject}
			<br/>
			${entry.entryBody}
			<br/>
			<hr size="1" />
		</div>
	</c:forEach>
	<h2 style="color:#a2a2a2;font-size:14px;font-weight:bold;padding-bottom:10px;">Yeni bir mesaj yazın</h2>
	<div id="entryEditDiv"></div>
	<ext:body runOnLoad="true">
		<ext:formPanel url="/isola/entry.servlet" id="myForm" renderTo="entryEditDiv" width="608" height="380" buttonAlign="right">
			<ext:textField name="entryFrom" allowBlank="false" fieldLabel="İsminiz" width="300" />
			<ext:textField name="entrySubject" allowBlank="false" fieldLabel="Başlık" width="300" />
			<ext:htmlEditor hideLabel="true" name="entryContent" width="600" height="280" />
			<ext:button type="submit" text="Mesajı Kaydet" ></ext:button>
		</ext:formPanel>
	</ext:body>
</body>
</html>
