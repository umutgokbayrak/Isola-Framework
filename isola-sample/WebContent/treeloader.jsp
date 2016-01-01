<%@ page contentType="text/html;charset=iso-8859-9" language="java" %>
<%
String node= request.getParameter("source");
String message = null;
message = "["+
"{\"text\":\"Þirket\",\"id\":\"sirket\",\"cls\":\"folder\"},"+
"{\"text\":\"Okul\",\"id\":\"okul\",\"cls\":\"folder\"},"+
"{\"text\":\"Genel\",\"id\":\"\\genel\",\"cls\":\"folder\"}]";
out.print(message);
%>
