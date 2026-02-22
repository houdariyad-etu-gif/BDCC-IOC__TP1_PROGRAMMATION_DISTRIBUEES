# Compte Rendu : TP1 - Inversion de Contrôle (IoC) et Injection de Dépendances

## 1. Introduction
Ce TP porte sur la mise en œuvre de l'Inversion de Contrôle (IoC) et de l'Injection de Dépendances. L'objectif principal est de concevoir une application modulaire où les composants (DAO et Métier) sont faiblement couplés grâce à l'utilisation d'interfaces.

## 2. Structure du Projet
L'organisation des dossiers suit la structure standard d'un projet Maven :

```text
TP1
├── src
│   └── main
│       ├── java
│       │   └── net
│       │       └── riyad
│       │           ├── dao
│       │           │   ├── IDao.java
│       │           │   └── DaoImpl.java
│       │           ├── ext
│       │           │   └── DaoImplV2.java
│       │           ├── metier
│       │           │   ├── IMetier.java
│       │           │   └── MetierImpl.java
│       │           └── pres
│       │               ├── Pres1.java
│       │               ├── Pres2.java
│       │               ├── PresSpringAnnotation.java
│       │               └── PresSpringXML.java
│       └── resources
│           └── config.xml
├── config.txt
└── pom.xml
```
## 3. Architecture du Projet
Le projet respecte une architecture multicouche avec la répartition suivante :
- **net.riyad.dao** : Contient l'interface `IDao` et son implémentation `DaoImpl`. C'est la couche qui simule l'accès aux données.
- **net.riyad.metier** : Contient l'interface `IMetier` et l'implémentation `MetierImpl`. Cette couche contient la logique de calcul et dépend de `IDao`.
- **net.riyad.ext** : Contient `DaoImplV2`, une implémentation alternative de `IDao` permettant de tester la flexibilité de l'injection sans modifier le code métier.
- **net.riyad.pres** : Regroupe les différentes méthodes de test pour l'injection des dépendances.

## 4. Méthodes d'Injection de Dépendances implémentées

### A. Instanciation Statique (Pres1)
Utilisation directe de l'opérateur `new`. Cette approche est simple mais rigide car elle lie le code à une implémentation spécifique à la compilation.

### B. Instanciation Dynamique (Pres2)
Utilisation de la réflexion Java via un fichier de configuration externe (`config.txt`). 
- On lit le nom de la classe.
- On charge la classe en mémoire avec `Class.forName`.
- On instancie les objets dynamiquement.
Cela permet de changer d'implémentation sans recompiler le projet.

### C. Framework Spring via XML
Utilisation de `ClassPathXmlApplicationContext` et d'un fichier `config.xml`. Les beans y sont déclarés et l'injection est gérée par le conteneur Spring via le constructeur (`<constructor-arg>`).

### D. Framework Spring via Annotations
Approche la plus moderne utilisant le scan de composants :
- Emploi des annotations `@Repository` (DAO) et `@Service` (Métier).
- Utilisation de `@Qualifier` pour lever l'ambiguïté entre `DaoImpl` et `DaoImplV2`.
- Privilégie l'injection par constructeur pour assurer la robustesse de l'objet `MetierImpl`.

## 5. Conclusion
Le TP démontre l'importance de l'IoC dans le développement d'applications extensibles. L'utilisation d'un framework comme Spring simplifie considérablement la gestion des dépendances et permet de se concentrer sur la logique métier plutôt que sur l'instanciation des objets.
