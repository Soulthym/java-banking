# **Projet de Programmation Orientée Objet**
## **Gestionnaire de compte en banque**
### Alabarbe - Gaspard - Piot --- 2017 - 2018


----------
#### **Lancement du programme**
-------------

Pour lancer le programme, l’exécution de ces deux scripts (**dans l'ordre**) est requis :
> - Le script <i class="icon-file"></i>**Compile.sh**, chargé de créer l'arborescence et de compiler les fichiers *.java.
> - Le script <i class="icon-file"></i>**Launch_banking.sh**, qui appellera la class *banking.Launcher* et fera tourner le programme.
```sh
$ ./compile.sh
$ ./launch_banking.sh
```

----------
#### **Lancement du framework de test**
-------------

Pour lancer le framework de test, l’exécution de ces deux scripts (**dans l'ordre**) est requis :
> - Le script <i class="icon-file"></i>**Compile.sh**, chargé de créer l'arborescence et de compiler les fichiers *.java.
> - Le script <i class="icon-file"></i>**test.sh**, qui appellera la class *test.Run* et fera tourner le framework de test.
```sh
$ ./compile.sh
$ ./test.sh
```

----------
#### **Les points d'entrée du code**
----------
La classe main de notre programme va créer les éléments nécessaires à l'initiation du dialogue avec l'utilisateur en l'invitant à faire une action. Une fois ses actions effectuées, l'utilisateur a le choix entre continuer (en tapant "c") ou quitter (en tapant "q"). Le main s'assure alors que le programme n'est pas quitter avant que l'utilisateur n'ai pressé la touche "q".

Le point d'entrée de l'application banking est ```banking.Launcher```.

Le point d'entrée du framework de test est ```test.Run```.

__exemple__ :
```sh
$ java -cp testframework/bin:banking/bin:logger/bin test.Run test.UserTest
```

----------
#### **Les problèmes rencontrés et leurs solutions**
----------
##### **Logger**
Nous avons décidés de ne pas suivre à la lettre le modèle donné lors des TP et dans l'énoncé du projet. En effet, il n'y a pas de logger debug et l'organisation des différentes classes est plus simple à nos yeux. Banking commence par créer deux objets : FIleLogger et ConsoleLogger, et se contente simplement de les appeler à chaque fois qu'il en a besoin.
##### **Banking**
Le seul véritable problème rencontré pour la partie banking est la gestion d'exceptions personnalisées. Deux avaent été crées : pour les erreurs d'entrées de l'utilisateur et pour les contraintes imposées (comme n'avoir pas plus de deux crédits). Cependant, la dernière a due être abandonnée car cela arrêtait tout le programme quelle que soit notre solution. Nous avons donc opté pour une méthode plus classique avec un while tant que la condition n'est pas remplie.
##### **Tests**
Le développent sous différents IDE entraine une gestion différente des packages. Il a fallu s'y reprendre à plusieurs reprises pour configurer le projet correctement et selon le "plan" donné, combiner les parties et rendre le tout fonctionnel. Des problèmes dus au manque de communication dans l'équipe très probablement.
