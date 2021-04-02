<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Importiamo il riferimento per i form tag -->
<html>

<body>


<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" /> <!-- andr� al getter -->

<br><br>

Last name: <form:input path="lastName" />

<br><br>

Country:

<form:select path="country"> <!-- submit chiamer� setCountry() -->

<!--  
	<form:option value="Brazil" label="Brazil"/>
	<form:option value="France" label="France"/>
	<form:option value="Italy" label="Italy"/>
	<form:option value="Spain" label="Spain"/>   -->
	
	<form:options items="${student.countryOptions}"/> <!-- chiamer� getCountryOptions -->
	
	
</form:select>

<br><br>

Favorite Language:

Java <form:radiobutton path="favoriteLanguage" value="Java"/> <!-- setFavoriteLanguage -->
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
C <form:radiobutton path="favoriteLanguage" value="C"/>

<br><br>

Operating system:

	<form:checkbox path="operatingSystem" value="MAC"/>MAC
	<form:checkbox path="operatingSystem" value="Windows "/>Windows
	<form:checkbox path="operatingSystem" value="Linux "/>Linux


<input type="submit" value="Submit"/>

</form:form>

</body>


</html>