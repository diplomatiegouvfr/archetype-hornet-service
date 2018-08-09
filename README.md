# archetype-hornet-service

## Description

Il s'agit d'un [archétype maven](https://maven.apache.org/archetype/index.html) permettant de générer un projet maven type. Ce projet contient la configuration et les sources nécessaires à l'implémentation de services REST en Java dans le cadre de l'architecture Hornet JS.
 
## Initialisation d'un projet

Exécuter la commande Maven suivante pour démarrer l'initialisation d'un nouveau projet basé sur Hornet Service :

```shell
$ mvn org.apache.maven.plugins:maven-archetype-plugin:3.0.0:generate -DarchetypeCatalog=PROTOCOL://HOST_REPOSITORY/repository-mvn/archetype-catalog.xml -DarchetypeGroupId=fr.gouv.diplomatie.hornet -DarchetypeArtifactId=archetype-hornet-service -DarchetypeVersion=${hornetservicesversion}
```

Le générateur va vous demander plusieurs informations nécessaires à l'initialisation de votre projet Hornet Service :

* « Define value for property `groupId`  » : l'identifiant de groupe Maven pour votre projet, généralement de la forme : `fr.gouv.diplomatie.nom-application`
* « Define value for property `artifactId` » : l'identifiant d'artefact (nom technique du module) pour votre projet.
* « Define value for property `version`:  `1.0-SNAPSHOT` » : la version de votre module projet (par défaut `1.0-SNAPSHOT`).
* « Define value for property `package`:  `fr.gouv.diplomatie.app` » : l'arborescence des packages des classes Java dans les sources de votre projet (par défaut, identique à la valeur renseignée pour `groupId`).
* « Define value for property `hornetVersion` » : la version du framework hornet à utiliser.

__Résultat__ : 

Le générateur produit l'arborescence projet de base suivante, exposant un seul service REST d'envoi de mail et de connexion utilisateur :

```
.
├── environment
│   ├── configuration
│   │   ├── DEV-DEB8-RELEASE.properties
│   │   ├── DEV-DEB8-SNAPSHOT.properties
│   │   ├── DEV-DEB9-RELEASE.properties
│   │   ├── DEV-DEB9-SNAPSHOT.properties
│   │   ├── DEVNG-DEB8-RELEASE.properties
│   │   ├── DEVNG-DEB8-SNAPSHOT.properties
│   │   ├── DEVNG-DEB9-RELEASE.properties
│   │   └── DEVNG-DEB9-SNAPSHOT.properties
│   ├── develop
│   │   ├── application.properties
│   │   ├── ehcache.xml
│   │   ├── hibernate.properties
│   │   ├── jdbc.properties
│   │   ├── keys
│   │   │   ├── private8.txt
│   │   │   ├── private.txt
│   │   │   └── public.txt
│   │   ├── keystore
│   │   │   ├── client.ks
│   │   │   ├── client_truststore.jks
│   │   │   ├── serveur.ks
│   │   │   └── serveur_truststore.jks
│   │   ├── logback-hornet.xml
│   │   ├── mail.properties
│   │   ├── mailService.properties
│   │   ├── token.properties
│   │   └── webservices.properties
│   ├── tc-server
│   │   └── context.xml
│   └── templates
│       ├── ehcache.xml
│       ├── hibernate.properties
│       ├── jdbc.properties
│       ├── logback-hornet.xml
│       ├── mail.properties
│       ├── mailService.properties
│       ├── token.properties
│       └── webservices.properties
├── CHANGELOG.md
├── CONTRIBUTING.md
├── Jenkinsfile
├── LICENSE.md
├── pom.xml
├── README.md
├── trigger-rundeck.js
└── src
    ├── main
    │   ├── java
    │   │   └── src
    │   │       ├── business
    │   │       │   ├── bo
    │   │       │   │   ├── Role.java
    │   │       │   │   └── Utilisateur.java
    │   │       │   └── service
    │   │       │       ├── MailContactServiceImpl.java
    │   │       │       ├── MailContactService.java
    │   │       │       ├── UtilisateurServiceImpl.java
    │   │       │       └── UtilisateurService.java
    │   │       ├── integration
    │   │       │   │── conf
    │   │       │   │   ├── DataSourceConf.java
    │   │       │   │   └── JpaRepositoryConf.java
    │   │       │   │── entity
    │   │       │   │   ├── Role.java
    │   │       │   │   └── Utilisateur.java
    │   │       │   └── repository
    │   │       │       ├── utilisateur
    │   │       │       │   ├─ UtilisateurProjection.java
    │   │       │       │   ├─ UtilisateurRepository.java
    │   │       │       │   └─ UtilisateurSpecification.java
    │   │       │       └── SpecificationUtils.java
    │   │       ├── mail
    │   │       │   │── conf
    │   │       │   │   ├── HornetMailConf.java
    │   │       │   │   └── MailConf.java
    │   │       │   └── service
    │   │       │       ├── MailContactService.java
    │   │       │       └── MailContactServiceImlpl.java
    │   │       ├── web
    │   │       │   ├── aspect
    │   │       │   │   ├── ControllerAspect.java
    │   │       │   │   ├── RepositoryAspect.java
    │   │       │   │   └── ServiceAspect.java
    │   │       │   ├── conf
    │   │       │   │   └── WebConfig.java
    │   │       │   ├── controller
    │   │       │   │   ├── ContactController.java
    │   │       │   │   └── UtilisateurController.java
    │   │       │   ├── dto
    │   │       │   │   ├── contact
    │   │       │   │   │   └── ContactEnvoyerDTOIn.java
    │   │       │   │   └── utilisateur
    │   │       │   │       └── AuthDTOIn.java
    │   │       │   ├── filter
    │   │       │   │   └── SimpleCORSFilter.java
    │   │       │   ├── interceptors
    │   │       │   │   └── UserRequestingInterceptor.java
    │   │       │   ├── listener
    │   │       │   │   └── ApplicationContextListener.java
    │   │       │   └── security
    │   │       │       ├── exceptions
    │   │       │       │   └── JwtAuthenticationException.java
    │   │       │       ├── JwtAuthenticationProvider.java
    │   │       │       ├── JwtService.java
    │   │       │       ├── KeyProvider.java
    │   │       │       ├── profile
    │   │       │       │   ├── JwtAuthenticatedProfile.java
    │   │       │       │   ├── Role.java
    │   │       │       │   └── User.java
    │   │       │       └── WebSecurityConfig.java
    │   │       ├── ws
    │   │       │   ├── conf
    │   │       │   │   └── WsConf.java
    │   │       │   ├── factory
    │   │       │   │   └── WebServiceFactory.java
    │   │       │   └── hello
    │   │       │       ├── HelloService.java
    │   │       │       ├── IHelloService.java
    │   │       │       ├── ObjectFactory.java
    │   │       │       ├── package-info.java
    │   │       │       ├── Say.java
    │   │       │       └── SayResponse.java
    │   │       └── Application.java
    │   ├── resources
    │   │   ├── ehcache.xsd
    │   │   ├── spring-appContext-web.xml
    │   │   ├── bouchonwebservice
    │   │   │   └── wsdl
    │   │   │       └── HelloService.wsdl
    │   │   └── business
    │   │       ├── messages_fr.properties
    │   │       └── service
    │   │           └── ModeleMailContact.vm
    │   └── webapp
    │       ├── META-INF
    │       │   └── MANIFEST.MF
    │       └── WEB-INF
    │           ├── services-rest-servlet.xml
    │           └── web.xml
    └── test
        ├── java
        │   └── test
        └── resources


```

## Construction 

Une fois le projet initialisé, vous pouvez lancer la récupération des dépendances Maven avec la commande suivante :

```shell
$ mvn package
```

## Licence

`archetype-hornet-service` est sous [licence cecill 2.1](./LICENSE.md).

Site web : [http://www.cecill.info](http://www.cecill.info/licences/Licence_CeCILL_V2.1-en.html)
