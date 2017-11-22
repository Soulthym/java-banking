# **Projet de Programmation Orientée Objet**
## **Gestionnaire de compte en banque**
### Alabarbe - Gaspard - Piot --- 2017 - 2018


----------
#### **Lancement du programme**
-------------

Pour lancer le programme, l’exécution de ces deux scripts (**dans l'ordre**) est requis : 
> - Le script <i class="icon-file"></i>**Compile.sh**, chargé de créer l'arborescence et de compiler les fichiers *.java. 
> - Le script <i class="icon-file"></i>**Launch_banking.sh**, qui appellera la class *main* et fera tourner le programme.


----------
#### **Les points d'entrée du code**
----------
La classe main de notre programme va créer les éléments nécessaires à l'initiation du dialogue avec l'utilisateur en l'invitant à faire une action. Une fois ses actions effectuées, l'utilisateur a le choix entre continuer (en tapant "c") ou quitter (en tapant "q"). Le main s'assure alors que le programme n'est pas quitter avant que l'utilisateur n'ai pressé la touche "q". 

----------
#### **Les problèmes rencontrés et leurs solutions**
----------
##### **Logger**
Nous avons décidés de ne pas suivre à la lettre le modèle donné lors des TP et dans l'énoncé du projet. En effet, il n'y a pas de logger debug et l'organisation des différentes classes est plus simple à nos yeux. Banking commence par créer deux objets : FIleLogger et ConsoleLogger, et se contente simplement de les appeler à chaque fois qu'il en a besoin. 
##### **Banking**
##### **Tests**