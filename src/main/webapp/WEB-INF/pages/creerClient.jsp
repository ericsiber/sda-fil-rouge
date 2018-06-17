<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Création d'un client</title>
</head>
<body>
	<form:form method="POST" commandName="client" action="creerClient">
		<p>
			<label>Nom :</label>
			<form:input path="nom" />
		</p>
		<p>
			<label>Prénom :</label>
			<form:input path="prenom" />
		</p>
		<input type="submit" value="Créer">
	</form:form>
</body>
</html>