<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cr�ation d'un client</title>
</head>
<body>
	<form:form method="POST" commandName="client" action="creerClient">
		<p>
			<label>Nom :</label>
			<form:input path="nom" />
		</p>
		<p>
			<label>Pr�nom :</label>
			<form:input path="prenom" />
		</p>
		<input type="submit" value="Cr�er">
	</form:form>
</body>
</html>