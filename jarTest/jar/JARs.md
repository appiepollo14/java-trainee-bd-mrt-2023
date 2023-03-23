# Werken met JAR's:

Simpel compileren van je project met meerdere klasses
* Compileren:

    
    javac src/main/java/nl/avasten/**/*.java

* Runnen:

    
    java -cp ./src/main/java nl.avasten.Main

#### Naar een specifieke map: "Out" compileren

* Compileren:


    javac -d ./  src/main/java/nl/avasten/**/*.java

* Runnen:

    
    java -cp ./out  nl.avasten.Main

## Jar maken:

### Non executable JAR 
Onderstaand commando maakt een non-executable jar, dus zonder manifest

    jar cf ./out/jar/JarExample.jar nl/avasten/**/*.class

Deze jar uitvoeren kan, alleen door een main class op te geven uit de jar

    java -cp ./out/jar/JarExample.jar nl.avasten.Main

### Executable JAR
Creëer een MANIFEST.MF file ergens. Zet daarin onderstaande code:
Denk aan carriage return als laatste regel in file.

    Main-Class: nl.avasten.Main

Creëer de jar met een verwijzing naar de Manifest:

    jar ufm ./out/jar/JarExample.jar ./nl/avasten/MANIFEST.MF nl/avasten/**/*.class

Deze is uit te voeren met het volgende commando, zonder een main class op te geven:

    java -jar ./out/jar/JarExample.jar