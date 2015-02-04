<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.List"%>
 <%@page import="java.util.ArrayList"%>
 
 <%@ page import="com.schlik.golfscoretracker.dao"%>
 <%@ page import="com.schlik.golfscoretracker.Model.Hole"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hole</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<meta charset="utf-8">
</head>
<body>
<%
dao my_dao = dao.INSTANCE;


List<Hole> holes = new ArrayList<Hole>();          
holes = my_dao.listHoles("Ramblewood");

    
%>
	<div style="width: 100%;">
		<div class="line"></div>
		<div class="topLine">
			<div style="float: left;">
				<img src="images/todo.png" />
			</div>
			<div style="float: left;" class="headline">Pubs</div>
			<div style="float: right;"></div>
		</div>
	</div>

	<div style="clear: both;"></div>
	You have a total number of
	<%= holes.size() %>
	Todos.

	<table>
		<tr>
			<th>Course Color</th>
			<th>Hole #</th>
			<th>Blue  Tee Distance</th>
			<th>White Tee Distance</th>
			<th>Red   Tee Distance</th>
			<th>Par   </th>
			<th>Men's Handicap   </th>
			<th>Women's Handicap   </th>
		</tr>

		<% for (Hole hole : holes ) {%>
		<tr>
			<td><%=hole.getmCourseColor()%></td>
			<td><%=hole.getmHoleNumber()%></td>
			<td><%=hole.getmBlueTeeDistance()%></td>
			<td><%=hole.getmWhiteTeeDistance()%></td>
			<td><%=hole.getmRedTeeDistance()%></td>
			<td><%=hole.getmParValue()%></td>
			<td><%=hole.getmMensHandicap()%></td>
			<td><%=hole.getmWomensHandicap()%></td>
						
		</tr>
				<%}
%>
	</table>
	
		<div class="main">

		<div class="headline">Add Hole</div>

		<form action="/update" method="post" accept-charset="utf-8">
			<table>
				<tr>
					<td><label for="summary">Course Color</label></td>
					<td><input type="text" name="color" id="color" size="10" value="Red" /></td>
				</tr>
				<tr>
					<td><label for="holeNum">Hole #</label></td>
					<td><input type="text" name="holeNum" id="holeNum" size="10" value="1"/></td>
				</tr>
				<tr>
					<td><label for="blueDist">Blue Distance</label></td>
					<td><input type="text" name="blueDist" id="blueDist" size="10" value="380" /></td>
				</tr>
				<tr>
					<td><label for="whiteDist">White Distance</label></td>
					<td><input type="text" name="whiteDist" id="whiteDist" size="10" value="375" /></td>
				</tr>
				<tr>
					<td><label for="redDist">Red Distance</label></td>
					<td><input type="text" name="redDist" id="redDist" size="10" value="291" /></td>
				</tr>
				<tr>
					<td><label for="parVal">Par Value</label></td>
					<td><input type="text" name="parVal" id="parVal" size="10" value="4" /></td>
				</tr>
				<tr>
					<td><label for="menHcp">Men's Handicap</label></td>
					<td><input type="text" name="menHcp" id="menHcp" size="10" value="4" /></td>
				</tr>
				<tr>
					<td><label for="womenHcp">Women's Handicap</label></td>
					<td><input type="text" name="womenHcp" id="womenHcp" size="10" value="6" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Create" /></td>
				</tr>
			</table>
		</form>
	</div>
		
</body>
</html>