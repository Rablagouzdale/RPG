README — RPG Java

## 📖 Description
Ce projet est un mini jeu RPG développé en Java dans le but de mettre en pratique la programmation orientée objet.

Le joueur peut :
- Créer une nouvelle partie
- Se déplacer sur un plateau
- Combattre des monstres
- Gagner de l’expérience et progresser
- Sauvegarder et charger une partie

Le jeu est conçu pour être simple, modulable et facilement améliorable.

---



##  📁 Structure du projet 
````
src/
└── rpg_java/
├── classe/
│ ├── Attaque.java
│ ├── Guerrier.java
│ ├── Mage.java
│ ├── Monstre.java
│ └── Personnage.java
├── Combat.java
├── Deplacement.java
├── Jeu.java
├── Main.java
├── ChargerMonstre.java
├── Sauvegarde.java
├── Plateau.java
├── FichierMonstresInvalideException.java
├── MonstreIntrouvableException.java
├── monstre.csv
└── sauvegarde.txt
````
---




## 🎮 Lancer le projet :

1 - Ouvrir le projet dans IntelliJ IDEA

2 - Exécuter la classe : " rpg_java.Main "

3 - Le menu principal doit apparaitre comme celui ci :

1) Nouvelle partie
2) Charger sauvegarde



## 🐉 Format du fichier :

- Le fichier monstre.csv contient la liste des monstres disponibles dans le jeu.


- Chaque ligne représente un monstre, et respècte le format suivant :


| Champ     | Type   | Description                 |
| --------- | ------ | --------------------------- |
| nom       | texte  | Nom du monstre              |
| niveauMin | entier | Niveau minimum d’apparition |
| niveauMax | entier | Niveau maximum d’apparition |
| pv        | entier | Points de vie               |
| attaque   | entier | Valeur d’attaque            |
| defense   | entier | Valeur de défense           |


### Exemple complet :

Rat,1,2,8,3,1

Gobelin,1,3,12,4,2

Loup,2,4,16,5,2

Orc,3,6,22,7,3

Troll,5,9,30,9,4

---

## Règles de validation appliquées par le programme

Le programme vérifie si :

-- La ligne contient 6 valeurs

-- Les valeurs numériques sont bien des nombres

-- niveauMin n’est pas supérieur à niveauMax

-- Le fichier n’est pas vide

-- Aucune ligne n’est incomplète

### ⚠️ Exceptions

- `FichierMonstresInvalideException` → fichier mal formaté
- `MonstreIntrouvableException` → aucun monstre trouvé

---


# 💾 Format du fichier de sauvegarde

Le fichier `sauvegarde.txt` contient :


nom=titi

classe=Guerrier

attaque=5

defense=3

vie=20

xp=2

lvl=1

---



# 🧠 Choix de conception

- Architecture orientée objet
- Séparation des responsabilités :
    - `Jeu` → logique du jeu
    - `Combat` → combats
    - `Deplacement` → déplacements
    - `Sauvegarde` → gestion des fichiers
- Exceptions personnalisées
- Plateau linéaire :

J........M

- Système d’attaques avec portée
- Sauvegarde automatique après combat

---

## 🎯 Objectifs du projet

Ce projet met en pratique :

- Programmation orientée objet (POO) en java
- L'héritage et polymorphisme
- La Gestion des collections et des fichiers
- Gestion des exceptions
- Un mini‑jeu complet avec déplacement, combat et progression


---

## Fonctionnalité Bonus :

- Ajout d'une nouvelle classe 