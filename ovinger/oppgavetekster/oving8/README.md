# Øving 08: Observatør-Observert og Delegering
**Øvingsmål**
* Lære hva observatør-observert-teknikken er, dens bruksområder og fordeler
* Lære bruk av delegering for å utføre oppgaver i en klasse

**Øvingskrav**
* Kunne definere og implementere et observatørgrensesnitt
* Kunne la en observert klasse fortelle dens observatører om endringer
* Kunne la en klasse delegere utførelsen av oppgaver til interne objekter

## Dette må du gjøre

Denne øvingen omfatter både [delegeringsteknikken](https://www.ntnu.no/wiki/display/tdt4100/Delegeringsteknikken) og
[observatør-observert-teknikken](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=66879660). Minstekravet for å få øvingen
godkjent er å gjennomføre **mint én** av de fire oppgavene under. Det anbefales derimot på det *sterkeste* å gjøre minst én oppgave
fra hvert av de to temaene, siden dette må til for å dekke hele pensum.

Gjennomfør enten *minst én* av oppgavene om delegering:
* [The Office (ovinger/src/patterns.delegation.office)](./Office.md) (anbefalt)
* [Logger (ovinger/src/patterns.delegation)](./Logger.md)

ELLER *minst én* av oppgavene om observatør-observert-teknikken:
* [StockListener (ovinger/src/patterns.observable)](./StockListener.md)
* [Highscore (ovinger/src/patterns.observable)](./HighscoreList.md)

Oppgavene skal lagres i mappene som er spesifisert i parentes etter oppgavene.

**I tillegg til oppgaven(e) ovenfor skal du levere en tekstfil hvor du gjør kort rede for delegeringsteknikken og observatør-observert-teknikken.**

### Hjelp / mistanke om bugs
Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](https://piazza.com/).

### Godkjenning
Last opp kildekode og `.ex`-filene på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for en læringsassistent innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.

### Exercise-panelet
For hver oppgave finnes det en tilsvarende `.ex`-fil, som beskriver hvilke aktiviteter, f.eks. koderedigering, kjøring av tester osv, som er en del av oppgaven. Når en jobber med en oppgave, så kan en åpne `.ex`-fila for oppgaven i Exercise-panelet. Dette gjøres enten ved å høyreklikke på fila og velge `Exercise > Open Exercise View` eller å åpne panelet med `Window > Show View > Other > Exercise View` og så dra og slippe `.ex`-fila i panelet. Filen ligger i mappen `tests`, og videre i pakke med samme navn som klassen den hører til. Hver `.ex`-fil åpnes i en egen fane, så en kan jobbe med flere oppgaver samtidig. Disse `.ex`-filene, én for hver oppgave, må leveres inn sammen med kildekoden i øvinger hvor det er spesifisert.
