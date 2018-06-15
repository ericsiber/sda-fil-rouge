CREATE TABLE ADRESSE(ID INT auto_increment primary key, LIGNE1 VARCHAR(255), LIGNE2 VARCHAR(255), CODE_POSTAL INT, VILLE VARCHAR(255));
CREATE TABLE CLIENT(ID INT auto_increment primary key, PRENOM VARCHAR(255), NOM VARCHAR(255), ADRESSE_ID INT);
CREATE TABLE COMMANDE(ID INT auto_increment primary key, NOMBRE_PRODUITS INT, MONTANT INT, DATE_COMMANDE DATE, CLIENT_ID INT);
CREATE TABLE users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

CREATE TABLE authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);