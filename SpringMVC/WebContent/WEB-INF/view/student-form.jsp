<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Enrollment Form</title>
</head>
<body>
	<h2>Student Enrollment Form</h2>
	<br>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br>
		<br>
		Last Name: <form:input path="lastName" />
		<br>
		<br>
		Country:
		<form:select path="country">
		<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
		Favorite Languages:
		 <form:radiobutton path="favoriteLanguage" value="Java" />Java 
		 <form:radiobutton path="favoriteLanguage" value="C#" />C# 
		 <form:radiobutton path="favoriteLanguage" value="Python" />Python 
		 <form:radiobutton path="favoriteLanguage" value="Ruby" />Ruby 
		<br>
		<br>
		Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>