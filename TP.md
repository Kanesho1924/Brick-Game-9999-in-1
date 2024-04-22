
# Examen Intégration Continue

Ce fichier .md consiste à expliquer les étapes du Jenkinsfile, ce qui a été / voulu être implémenté.

## Membres du groupe 

L'examen a été fait par :

- Axel Vandewalle
- Florian Dufly
- Théo Beauvois
- Thomas Pourchel

## Ce que le Jenkinsfile fait déjà 

La pipeline Jenkins vérifie toutes les minutes si une nouvelle version du répo Github a été mise à jour

Si oui : 
- On crée des variables d'outils ( Maven et Java ) afin d'avoir les bons outils pour faire la prochaine commande.

`maven 'Maven'`

`MAVEN_HOME = "${tool 'Maven'}"`

- On clone le répo Github via la commande 

```jenkins
  git 'https://github.com/Kanesho1924/Brick-Game-9999-in-1.git'
```

- On fait la partie Tests ( Selon l'OS, on prend un différent chemin d'accès ) avec mvn clean package. On récupère alors seulement les fichiers .jar du dossier target.

```jenkins
  archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
```
## Les idées qu'on a voulu rajouter 

- La récupération des résultats du build via le xml 

```jenkins
  junit '**/target/surefire-reports/TEST-*.xml'
```

- L'envoi de mail à une adresse mail ( ici avande764@gmail.com ) pour informer le/les développeurs si le build a réussi ou non 

```jenkins
mail to: 'avande764@gmail.com',
    subject: "SUCCÉS: Build #${env.BUILD_NUMBER}",
    body: "Le build a réussi. Veuillez regarder les détails dans ${env.BUILD_URL}"
```