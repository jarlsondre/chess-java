# Øving 4: Objektstrukturer med app


### ***`OBS: DENNE ØVINGEN MÅ GJØRES FOR Å FÅ ØVINGSOPPLEGGET GODKJENT!`***
```
Dette er grunnet i at du må ha 750 poeng av 1000 mulige poeng for å kunne gå opp til eksamen. 
Dermed må du gjøre enten øving 7, øving 10 eller begge for å kunne ta eksamen. 
Disse bygger begge videre på det du gjør i øving 4, så om du ikke gjør øvingen innen fristen, 
må du uansett gjøre den senere.
```

**Øvingsmål**
- Lære å tenke ut en oppdeling av et program i flere interagerende klasser
- Lære å tenke rundt og programmere et program som skaper flere objektinstanser under kjøring

**Øvingskrav**
- Kunne programmere meningsfulle og fungerende objektstrukturer
- Kunne grunnleggende konfigurere en JavaFX-controller til å fungere med programmet

## Dette må du gjøre
Filene for denne øvingen skal du lagre i `ovinger/src/app`. Her ligger det allerede en `App`-klasse og en `FXML`-fil som utgangspunkt. 

**I denne øvingen skal du lage en app som du skal fortsette å jobbe med i øving 7 og 10. Det er dermed *veldig sterkt* oppfordret 
til å gjøre denne øvingen, siden den uansett må gjøres senere for å få øvingsopplegget godkjent.** 

Denne oppgaven er veldig åpen, og består av to deler. Etter endt øving, skal du ha laget en app som oppfyller følgende **minstekrav**:

* Appen må ha et brukergrensesnitt (realisert i en FXML-fil).
* Appen må ha to eller flere interagerende klasser som står for logikken/databehandlingen i appen. 
Her stilles det også krav til at det må være noe kalkulasjoner av et eller annet, altså kan du ikke ha to rene dataklasser.
* I tillegg til de interagerende klassene skal appen ha en controller-klasse som kobler sammen brukergrensesnittet og klassene fra punktet over.
* Appen må ha mulighet for å utvides med en form for lagring i form av skriving til og lesing fra fil.
* Du må også ha en app-klasse som kun brukes til å starte appen. 

<br>

Eksempler på apper man kan lage:
* Spill (f.eks. bondesjakk, sokoban, minesweeper, yatzy)
* Standard mobilapper som kalender, klokke, påminnelser, etc.

Hva man kan lagre av data:
* For spill kan det være relevant å lagre tilstanden til spillet slik at man kan fortsette senere
* For mobilapper som kalender, klokke og påminnelser, kan det være relevant å lagre henholdsvis avtaler, alarmer og påminnelser

I denne øvingen legger oppgavetekstene mindre føringer for hvordan koden din skal struktureres enn tidligere. 
Det er meningen du skal få øvelse i å tenke ut objektstrukturer som passer til å løse oppgaven selv. 
Det er også mer fritt hva slags metoder du vil ha og form på input. Derfor kan det være lurt å starte med øvingen tidlig,
slik at du rekker å få hjelp hos stud.ass dersom du sitter fast.


## Del 1 (20%) *(Du MÅ gjøre og levere del 1 innen fristen for å få noe uttellig på del 2)*
I del 1 av øvingen skal du lage en plan/dokumentasjon over hva appen din skal inneholde. 
Denne dokumentasjonen har følgende **minstekrav**:
*  Hvordan du ser for deg brukergrensesnittet til appen din
*  Hvilke klasser appen din skal bestå av
*  Hva de forskjellige klassene skal gjøre
*  Hvilke hovedmetoder som vil inngå i klassene
*  Spesifiser hvilke kalkulasjoner som vil innegå i klassen(e). (Minst én av klassene MÅ inneholde noe kalkulasjoner av et eller annet)
*  Hvilken type lagring appen skal utvides med i øving 7

**Lever inn en PDF-fil med planen din som svarer på punktene over innen *12. februar*. 
Legg merke til at godkjenningsfristen er den samme som innleveringsfristen!**


## Del 2 (80%) *(Du MÅ ha fått del 1 godkjent for å få noe uttelling her)*
Del 2 av øvingen består av å implementere klassene spesifisert i dokumentasjonen din, i tillegg til å lage resterende brukergrensesnitt, 
controller-klasse, og app-klasse som spesifisert under minstekrav. Du trenger ***IKKE*** implementere lagring i denne øvingen. 
Dette er noe som først skal gjøres i øving 7.

**Lever inn kildekoden din (controller-klasse, app-klasse, grensesnitt, FXML-fil, og alle resterende klasser du har skrevet) innen 
*19. februar*. Øvingen må godkjennes av stud.assen din innen *26. februar*.**

<br>

## ***OBS! LES DETTE:*** Nyttig informasjon relatert til øvingen  
I øving 7 skal du utvide appen med noe ekstra funksjonalitet og en form for persistens, altså at appen lagrer data 
utenfor appen. Ha dermed i bakhodet at det bør være noe data i appen som er naturlig å lagre. 
Eksempler på dette kan være valutakurser, tilstanden til et spill slik at du kan fortsette å spille neste gang du starter appen, 
events i en kalender-app eller alarmer i en klokke-app.

I øving 10 skal du skrive tester som validerer oppførselen til appen.

Det kan være lurt å lese [App-programmering](https://www.ntnu.no/wiki/display/tdt4100/App-programmering) og 
[Enkel app-programmering med JavaFX og FXML](https://www.ntnu.no/wiki/display/tdt4100/Enkel+app-programmering+med+JavaFX+og+FXML)-sidene 
før du begynner.

Du bør også **[Installere SceneBuilder](https://www.ntnu.no/wiki/display/tdt4100/Installere+SceneBuilder)**. 
Scenebuilder er et program som gjør det veldig lett å lage brukergrensesnittet til appen. 

<br>

## Hjelp / mistanke om bugs
Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller 
legge ut et innlegg på Piazza.


## Godkjenning
**Del 1**: Last opp dokumentasjon på BlackBoard og få planen din godkjent av *egen* stud.ass innen **12. februar**. 

**Del 2**: Last opp kildekode på Blackboard innen **19. februar**. Innlevert kode skal demonstreres for stud.ass 
innen én uke etter innleveringsfrist. 

Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende 
øvingsreglementet.