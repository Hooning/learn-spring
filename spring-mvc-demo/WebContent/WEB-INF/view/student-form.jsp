<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName" />
			
			<br/><br/>
			
			Last Name: <form:input path="lastName" />
						
			<br/><br/>
			
			Country: 
			
			<form:select path="country">
			
				<%-- <form:option value="Brazil" label="Brazil" />
				<form:option value="Korea" label="Korea" />
				<form:option value="Germany" label="Germany" />
				<form:option value="France" label="France" /> --%>
				<form:options items="${student.countryOptions}" />
			
			</form:select> 	
			
			<br/><br/>
			
			Favorite Language:
			
			<%-- <form:radiobutton path="favoriteLanguage" value="Java" /> Java 
			<form:radiobutton path="favoriteLanguage" value="Python" /> Python 
			<form:radiobutton path="favoriteLanguage" value="Javascript" /> Javascript 
			<form:radiobutton path="favoriteLanguage" value="C#" /> C# --%> 
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />
			
			<br/><br/>
			
			Operating Systems:
			
			<form:checkbox path="operatingSystems" value="Linux"/> Linux
			<form:checkbox path="operatingSystems" value="MacOS"/> Mac OS
			<form:checkbox path="operatingSystems" value="Windows"/> Windows
			
			<br/><br/>
			
			<input type="submit" value="Submit">
			

		</form:form>
	</body>
</html>