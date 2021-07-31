<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer Confirmation</title>
	</head>
	
	<body>
		
		The customer is confirmed: ${customer.firstName} ${customer.lastName}

		<br><br>
		
		The customer has ${customer.freePasses} free passes
		
		<br><br>
		
		The postal code: ${customer.postalCode}
		
		<br><br>
		
		The course code: ${customer.courseCode}
	</body>
</html>