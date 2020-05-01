<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="os" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Form</title>
</head>
<body>
	The Student is confirmed: ${student.firstName} ${student.lastName}
	<br> 
	Country: ${student.country}
	<br>
	Favorite Language: ${student.favoriteLanguage}
	<br>
	Operating Systems:
	<ul>
		<os:forEach var="temp" items="${student.operatingSystems}">
		<li>${temp}</li>
		</os:forEach>
	</ul>
</body>
</html>