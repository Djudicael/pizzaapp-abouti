<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<body>
<%Date dateDuJour = new Date();
DateFormat df = new SimpleDateFormat("HH:mm:ss");
String dateFormate= df.format(dateDuJour);
%>
<h1><%= dateFormate  %></h1>
<h2>Hello World!</h2>
</body>
</html>
