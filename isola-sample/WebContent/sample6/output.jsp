<h1>Output Jsp</h1>
<%
java.util.Enumeration en = request.getParameterNames();
while (en.hasMoreElements()) {
	String name = (String)en.nextElement();
	String val = request.getParameter(name);
	out.print(name + ":" + val + "<br/>");
	System.out.println(request.getParameter(name));
}
%>
