<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>


<head>

	<title>Customer Registration Form</title>
	
	<style>
		.error{
			color: red;
		}
	</style>
	
	
</head>



<body>

	<form:form action="processForm" modelAttribute="customer">
		
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name(*): <form:input path="lastName" />
		
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>
		
		Free passes: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		
		<!-- per l'errore in caso di input invalido sul Free passes
			abbiamo un messaggio di errore personalizzato, dichiarato
			in un file con estensione "properties" nella cartella "resources"
			in src. Di default il sistema darà il messaggio dell'eccezione.
			Bisogna anche specificare nel file xml dove si trova il messaggio. -->
		
		<br><br>
		
		Postal code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		
		<br><br>
		
		Course code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		
		<br><br>
		
		
		<input type="submit" value="Submit" />
		
	</form:form>
	
	

</body>

</html>