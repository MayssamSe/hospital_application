# Hospital Application

Ce projet est une **application de gestion hospitalière** développée avec **Spring Boot**, pensée pour être claire, robuste et facile à maintenir.  
Elle offre un ensemble complet de fonctionnalités permettant de gérer les patients d’un hôpital ainsi que les utilisateurs et leurs rôles, tout en appliquant des contrôles d’accès basés sur les rôles grâce à **Spring Security**.

L’application assure notamment :
- L’affichage dynamique des patients avec pagination et recherche.
- L’ajout, la modification et la suppression de patients par l’administrateur.
- Une interface de connexion sécurisée avec gestion des rôles (administrateur et utilisateur simple).
- Une protection des routes sensibles pour garantir un accès restreint selon le rôle de l’utilisateur.
- Une validation des formulaires pour garantir la cohérence et la qualité des données saisies.

L’application repose sur un ensemble de technologies modernes et bien intégrées :
- **Spring Boot** : Framework principal pour simplifier la configuration et le déploiement de l’application.
- **Spring MVC** : Pour structurer les couches contrôleur et vue.
- **Thymeleaf** : Pour le rendu dynamique des pages HTML et une meilleure expérience utilisateur.
- **Spring Data JPA** : Pour la persistance des données avec une approche orientée objet et des requêtes simplifiées.
- **Spring Security** : Pour gérer l’authentification et l’autorisation des utilisateurs.
- **Lombok** : Pour réduire la verbosité du code avec des annotations générant automatiquement getters, setters, constructeurs, etc.
- **Jakarta Bean Validation** : Pour valider les données saisies par les utilisateurs et garantir leur intégrité.

Grâce à cette architecture, l’application offre une base solide pour étendre ses fonctionnalités et évoluer facilement.

## Description du code

### Entité Patient

- Classe Java annotée avec `@Entity`.
- Champs principaux : `id`, `nom`, `dateNaissance`, `malade`, `score`.
- Validation :
  - `@NotEmpty`, `@Size`, `@DecimalMin`.

### Repository PatientRepository

- Interface JPA pour manipuler les patients.
- Méthodes de recherche avec pagination et requêtes personnalisées.

### Sécurité

- Classe `SecurityConfig` : configure l’authentification, les filtres et les autorisations.
  - Page de login personnalisée (`/login`).
  - Page `/notAuthorized` pour les accès interdits.
  - `/deletePatient/**` réservé aux admins.

### Gestion des utilisateurs

- Entités :
  - `AppUser` : utilisateur avec username et rôles.
  - `AppRole` : rôle avec un nom.
- Repositories : CRUD pour gérer les utilisateurs et rôles.

### Initialisation de l’application

- Classe `HospitalApplication` avec `CommandLineRunner` pour injecter des patients au démarrage.
- `PasswordEncoder` pour sécuriser les mots de passe.


## Fonctionnement général

Lancement de l’application : la base est remplie avec des patients et utilisateurs.  
Authentification : `/login` pour se connecter.  
Autorisation : certains endpoints protégés par rôles.  
Interface utilisateur : formulaires pour créer, éditer et supprimer des patients.

## Tests et captures d'écran

localhost:8088/login
# Documentation de l'Application de Gestion des Patients

## Connexion Administrateur

Connectez-vous avec le nom d’utilisateur **admin** et le mot de passe **1234**.  
![Login](images/adminLogin.PNG)

## Accueil Administrateur

La page d’accueil de l’administrateur affiche la liste des patients avec des options pour :  
- Ajouter un patient  
- Modifier un patient  
- Supprimer un patient  
- Rechercher un patient par nom

![Accueil](images/adminHome.PNG)

---

## Ajouter un Patient

1. Cliquez sur **Nouveau**.  
   ![Nouveau](images/adminAdd.PNG)

2. Remplissez les informations du patient et cliquez sur **Save**.  
   ![Ajouter](images/add.PNG)

3. Utilisez la barre de recherche pour vérifier l’ajout du patient.  
   ![Chercher](images/apresAdd.PNG)

---

## Modifier un Patient

1. Cliquez sur le bouton **Edit** pour modifier un patient.  
   Avant modification :  
   ![avantMod](images/avantEdit.PNG)

2. Effectuez les modifications et sauvegardez.  
   Après modification :  
   ![aprestMod](images/apresEdit.PNG)

3. Recherchez le patient modifié pour vérifier la mise à jour.  
   ![aprestModification](images/recherche.PNG)

---

## Supprimer un Patient

1. Cliquez sur l’icône de la poubelle rouge.  
   Un message d’alerte apparaît pour confirmer la suppression.  
   ![SupprimerMsg](images/suprimAlerte.PNG)

2. Confirmez l’opération, puis recherchez le patient supprimé.  
   ![apresSup](images/apresSupp.PNG)

---

## Déconnexion

Cliquez sur **Logout** pour vous déconnecter.  
![Logout](images/optAdmin.PNG)

---

## Connexion Utilisateur Simple

Connectez-vous avec le nom d’utilisateur **user2** et le mot de passe **1234**.  
![userLog](images/userLog.PNG)

Après authentification, la page d’accueil affiche la liste des patients, mais :  
- L’utilisateur simple ne peut ni ajouter, ni modifier, ni supprimer un patient.  
- Il peut uniquement visualiser la liste et rechercher un patient par nom.  

![Acueil](images/userHome.PNG)  
![noAdd](images/noAdd.PNG)  
![Chercher](images/userChercher.PNG)

Si l’utilisateur tente une action interdite (comme supprimer un patient), un message d’avertissement s’affiche.  
![notAuthorized](images/notAthorized.PNG)

## Conclusion

Cette application illustre l’utilisation de Spring Boot et Spring Security pour développer une application hospitalière complète avec gestion des patients et des utilisateurs, sécurisée et conviviale.

