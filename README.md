# Teaching-HEIGVD-RES-2019-Labo-SMTP

## Description du projet

Le but de cette application est de définir un client SMTP qui envoie automatiquement des mails forgés à une liste de victimes
* L'application choisit aléatoirement parmi une liste d'e-mails un groupe de victime comme destinataires ainsi qu'un e-mail d'envoi.

* un email est également choisi aléatoirement pour chaque destinataire et est envoyé en spam sur un seveur Mock pour éviter de surcharger de réels serveurs



## Configuration

Les différents dossiers de configuration sont les suivants:

* **properties.properties** contient les informations sur les ports à utiliser.

* **messages.utf8** contient la liste des e-mails à envoyer.

* **listVictims** contient tous les emails susceptibles d'être spammés




## Execution en ligne de commandes avec docker 

* exécuter la commande 
```bash
Docker build -t smtp
```

puis 

```bash
sudo docker run -it -p 2525:2525 -p 8080:8080 smtp -p 2525 -h 8080 
```

pour lancer le container docker

