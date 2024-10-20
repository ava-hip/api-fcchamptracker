# Utilise une image de base Maven pour la construction
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copie le fichier pom.xml et télécharge les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copie le reste de l'application et compile
COPY src ./src
RUN mvn clean package -DskipTests

# Utilise une image JDK allégée pour l'exécution
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copie le JAR généré depuis l'étape de construction
COPY --from=build /app/target/*.jar app.jar

# Expose le port 8080 (port par défaut de Spring Boot)
EXPOSE 8080

# Commande pour exécuter le JAR
ENTRYPOINT ["java", "-jar", "app.jar"]