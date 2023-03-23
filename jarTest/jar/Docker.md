# Werken met Docker

## Dockerfile

Met een Dockerfile, geen extensie, kan je opdrachten aan Docker geven. 

Daarna kan je op de commandline het volgende uitvoeren: 

     docker build -t project:latest . 

Hiermee word een project gebuild op basis van de Dockerfile in dezelfde directory.
(Let op de punt achteraan!) Er wordt een image van gemaakt binnen de Docker-omgeving.

### List docker images:

Met het volgende commando worden de images in de Dockeromgeving getoond:

    docker images

### Uitvoeren docker image:

Met het volgende commando kan een image worden uitgevoerd:

    docker run project:latest

## Docker compose

Om meerdere commando's binnen Docker samen te voegen, is Dockercompose in het leven geroepen.
Hiermee kunnen meerdere containers worden gemaakt, of netwerken en volumes. Zo is met één commando, van alles mogelijk.

plaats de docker-compose file ergens. Vul hem met de juiste argumenten

Roep vanuit dezelfde directory het volgende commando aan om uit te voeren:

    docker-compose up

