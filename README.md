# Projet 7 - Développez le nouveau système d’information de la bibliothèque d’une grande ville

### Spécifications
L'application a été développée suivant une architecture microservice.   
Projet Spring-boot maven multi module contenant :
* https://github.com/vancharlotte/projet7-biblio.git
    * Une Api Rest permettant la gestion d'une bibliothèque et qui communique avec les base de données. 
    * Un Batch qui envoie de mails automatiques en cas de retour d'emprunt en retard.
* https://github.com/vancharlotte/projet7-client.git
    * Une application web pour que les utilisateurs du site web puissent consulter leurs emprunts en cours ainsi que les livres disponibles à la location. 

### Développement

Cette application a été développé avec :
- Intellij IDEA
- Java jdk 8
- Tomcat 
- MySQL 
- Apache Maven 
- Spring boot
- Spring DATA JPA
- oauth2
- spring security


### Déploiement
##### 1 - Importez tous les microservices du repository "projet7-biblio" et du repository "projet7-client".

##### 2 - Créez les 3 bases de données et un utilisateur : 
- dbauth pour le microservice auth-server
- dbbook pour le microservice library-book
- dbloan pour le microservice library-loan
- user : 
    *   username : admin
    *   mot de passe : admin123!

Les scripts des BDD se trouvent dans le dossier "livrables" du repository "projet7-biblio".   
Vous pouvez modifier la configuration des bases de données dans le fichier src/main/resources/application.properties
du module concerné.

Pré défini : 
- url de la bdd du module auth-server  
spring.datasource.url=jdbc:mysql://localhost:3306/dbauth?createDatabaseIfNotExist=true
- url de la bdd du module library-loan  
spring.datasource.url=jdbc:mysql://localhost:3306/dbloan?createDatabaseIfNotExist=true
- url de la bdd du module library-book  
spring.datasource.url=jdbc:mysql://localhost:3306/dbbook?createDatabaseIfNotExist=true


##### 3 - Lancez l'application : démarrez "library-eureka" en premier et "library-batch" et "library-client" en dernier.

Dans votre navigateur, vous pouvez accéder au site web à l'adresse http://localhost:8000/. 

Vous pouvez modifier le port d'un module dans le fichier src/main/resources/application.properties du module concerné.   
Les ports ont été pré-défini pour chaque microservice : 
- eureka : port 8761
- auth-server : port 9191
- library-book : port 9001
- library-loan : port 9002
- zuul-server : port 9004
- library-batch : port 9005
- library-client : port 8000.
