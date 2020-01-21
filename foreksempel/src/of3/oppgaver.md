# Øvingsforelesning 3    

**Læringsmål:**
- Bli kjent med innkapsling    
- Vite forskjellen på private og public    
    
## Oppgaver    

### Oppgave 1  

I denne oppgaven skal vi skrive kode for representere biler. Vedlagt til forelesningen er en påbegynt **Car**-klasse fra forrige øvingsforelesning. Der lagde vi en konstruktør og et sett med felter.

#### a)  

For å kunne ha noen nytte av **Car**-klassen må det være mulig å hente ut informasjon fra **Car**-objekter.  

**Lag getter-metoder for alle variablene i Car-klassen**  

#### b)  

Flere av variablene til **Car**-klassen vil aldri endre seg (merke, modell og produksjonsår), og det gir dermed ikke mening å lage setter-metoder for disse. Andre variable vil derimot kunne endre seg (antall kilometer kjørt, vekt og registreringsnummer), og bør derfor ha en form for setter-metoder.   

**Skriv setter-metoder for vekt og registreringsnummer variablene**

#### c)

**Skriv en passende toString-metode til Car-klassen**


#### d)  

Det gir ikke mening å la det være mulig å sette kilometerstanden til en bil, da denne bare skal kunne øke. I steden for bør det finnes en metode som øker kilometerstanden med et gitt antall kilometer.  

**Lag en metode som øker kilometerstanden med et gitt antall kilometer. Hvis et negativt antall kilometer blir gitt inn, skal ikke kilometerstanden endre seg.**  

#### e)  

En bil står ikke bare stille. Hele poenget med en bil er å kunne kjøre rundt. Vi ønsker å kunne representere om en gitt bil står stille eller om den er i bevegelse. Dette kan vi for eksempel gjøre med å ta vare på farten til en bil. Når man lager en ny bil står denne som regel stille, så farten kan settes til 0 til å starte med. For å endre på farten kan man for eksempel lage metoder for akselerasjon og bremsing.  

**Lag en variabel for å holde styr på farten til en bil og en getter-metode for denne. Lag også metoder for akselerering og bremsing som tar inn hvor mye farten henholdsvis øker eller minskes. Ingen av disse metodene skal endre farten hvis den gitte endringen er negativ.**  

*Pass på at farten ikke kan bli mindre enn 0 ved bremsing.*  

#### f)  

I **d)** lagde vi en metode som økte kilometerstanden med et gitt antall kilometer. Med den metoden må vi selv regne ut hvor mange kilometer bil har kjørt, noe som er litt tungvindt. Vi ønsker derfor å lage en metode som regner ut dette for oss.  

**Lag en metode som tar inn antall minutter det kjøres i, og som legger til kilometerstanden den avstanden som blir kjørt (altså den nåværende hastigheten til bilen ganget med antall minutter det kjøres i).**  

#### g)  

Vår nåværende kode støtter kun kjøring fremover, men en bil kan også rygge. En enkel måte å representere dette på er å bruke negativ hastighet for rygging og positiv hastighet for vanlig kjøring. Dette er derimot ikke direkte intuitivt med hvordan våre akselerere- og bremsemetoder fungerer, da dette vil gjøre at vi må bruke bremse-metoden for å rygge. Vi ønsker derfor heller å holde styr på om vi rygger ved hjelp av en egen variabel. Når man rygger, går man fra å kjøre fremover til å kjøre bakover, så vi kan anta at bilen må stå stille for at det er mulig å skifte mellom rygging eller ikke.  

**Lag en variable som indikerer om bilen rygger, og tilhørende getter- og setter-metoder.**  

#### h)  

Slik koden fungerer nå er det ingen begrensinger på hvor raskt bilen kan kjøre. Dette er ganske urealistisk så vi ønsker å sette en maksgrense på hvor raskt en bil kan kjøre. I tillegg er som regel makshastighet forskjellig for vanlig kjøring og rygging.  

**Utvid Car-klassen slik at vi tar vare på makshastighet for vanlig kjøring og rygging, og at det ikke er mulig å akselerere over denne. Velg makshastigheter selv.**  

#### i)  

Vi begynner å få ganske mange variabler for en bil og skal vi lage mange biler, så kan det være tungvindt å måtte gi inn alle disse variablene per bil. Spesielt, hvis man skulle finne ut at makshastigheten til en gitt model er litt lavere eller høyere enn tidligere antatt, er det mye jobb å skulle endre på alle bilene individuelt. Vi ønsker derfor å skille ut en del av disse variablene i en egen klasse for biltypen. Det vil si variablene for merke, modell og de to makshastighetene. En bil vil kun ta vare på en _instans_ av denne klassen som vi skiller ut, og hente dataen fra instansen når den trenger disse.  

**Lag en klasse for biltype og endre Car-klassen til å bruke denne som et felt**  

#### j)  

En bil eies som regel av en person, og det kan være greit å kunne finne ut hvem som eier bilen fra **Car**-klassen.   

**Lag en Person klasse som tar vare på detaljer om en person, og utvid Car-klassen til å bruke denne for å ta vare på informasjon om eieren av bilen.**
