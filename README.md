# ACRA : Algorithms of Creation of Random Area
## Projet personnel 2, TSI 2017, Antoine Moutou

### Introduction

La bibliothèque ACRA permet de générer aléatoirement des MNT et de les exporter aux formats ASC et GeoTiff.
ACRA permet de générer un MNT selon 3 méthodes différentes :
+ le bruit de Perlin,
+ la méthode diamant-carré,
+ un aléatoire pur.

### Prérequis

+ JRE 8 ou plus récent

+ (Conseillé) Maven

### Installation à l'aide de maven

Après téléchargement et décompresion de l'archive du projet, ouvrir un terminal dans le dossier acra, et lancer la commande
```sh
$ mvn install
```

### Ajout de la dépendance à votre projet Maven 

Après installation de GAMA, dans votre projet Maven, rajouter entre les balises <dependencies> de votre pom.xml les lignes suivantes :
```xml
<dependency>
     <groupId>eu.ensg.tsi</groupId>
     <artifactId>acra</artifactId>
     <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Utilisation de la bibliothèque ACRA pour la génération de MNT

Un utilisateur normal de ACRA n'utilise que la classe Area de la bibliothèque. N'oubliez donc pas d'ajouter la ligne
```java
import eu.ensg.tsi.acra;
```
au début de votre fichier java utilisant la bibliothèque.

#### Construction de l'objet Area

Pour construire un objet Area à partir d'un fichier géographique il nous faut définir :

+ le chemin vers le fichier (String)
+ le nom de la méthode utilisée (String) à choisir parmi "random" / "perlinNoise" / "diamondSquare"  (attention sensible à la casse).
+ l'extension du fichier souhaité comme export (String) à choisir parmi "zip" / "asc" (également sensible à la casse).
+ et la résolution souhaité du MNT soit la taille en mètre d'un pixel (int) 

Exemple : 

	```java
	int resolutionDuMnt = 100;
	Area myRasterArea = new Area("/chemin/vers/mon/fichier.tif", "perlinNoise", "asc", resolutionDuMnt);
	Area MyVectorArea = new Area("/chemin/vers/mon/fichier.tif", "diamondSquare", "tif", resolutionDuMnt);
	```

Les types supportés sont ceux supportés par l'API GeoTools (http://docs.geotools.org/stable/userguide/geotools.html)
	

#### Générer le MNT
Une fois votre objet Area prêt à générer le MNT souhaité, utiliser la commande
```java
aera.generate();
```

Si vous souhaitez changez la méthode de génération il vous suffit d'utiliser la commande
```java
aera.setMethodTag("nouvelleMéthode");
```
puis de réutiliser la commande generate() pour obtenir un nouveau MNT.

#### Exporter le MNT
Pour exporter le MNT généré, utiliser les fonction suivantes :
```java
aera.export();
```

Si vous souhaitez changez le format d'export il vous suffit d'utiliser la commande
```java
aera.setExportDataExtension("nouvelleExtention");
```
puis de réutiliser la commande export() pour exporter un nouveau MNT.

Vous n'avez plus qu'à ouvrir le fichier obtenu dans un SIG pour visualiser le résultat.