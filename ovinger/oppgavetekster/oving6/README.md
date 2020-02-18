# Øving 6: Grensesnitt

**Øvingsmål**
* Lære hva grensesnitt er og hvordan disse defineres
* Lære hvordan man implementerer et grensesnitt
* Kjenne til grunnleggende funksjonelle grensesnitt

**Øvingskrav**
* Kunne lage grensesnitt og implementere disse med andre klasser
* Kunne bruke grensesnittene Comparable<T> og Comparator<T>
* Kunne bruke grensesnittene Iterable<T> og Iterator<T>

## Dette må du gjøre
### Del 1: Programmering
Gjør **minst to** av oppgavene under. Oppgavene (unntatt Twitter) skal lagres i `ovinger/src/interfaces`. 
Filer til Twitter-oppgaven skal lagres i `ovinger/src/interfaces.twitter`.

* [CardContainer](./CardContainer.md) 
* [CardComparison](./CardComparison.md)
* [CardPredicate](./CardPredicate.md)
* [Twitter](./Twitter.md)
* [Named](./Named.md)
* [BinaryComputingIterator](./BinaryComputingIterator.md) 
* [StringGrid](./StringGrid.md)
* [RPNKalkulator med funksjonelle grensesnitt](./RPNCalc.md)

Disse oppgavene har noe ulik vanskelighetsgrad og omfang, og trolig stigende (i.e. CardContainer den enkleste og StringGrid den vanskeligste). 
Alle er høyst eksamensrelevante og det anbefales følgelig å ta en titt på alle sammen.

### Del 2: Debugging
Gjør følgende oppgave om debugging og vis frem løsningen til studass på sal: 

*  [StringMergingIterator](./StringMergingIterator.md)

### Del 3: Sekvensdiagram
Lag et [sekvensdiagram](https://www.ntnu.no/wiki/display/tdt4100/Sekvensdiagrammer) som viser samhandlingen mellom et 
`StringMergingIterator`-objekt og dens argumenter. Dvs. lag et [sekvensdiagram](https://www.ntnu.no/wiki/display/tdt4100/Sekvensdiagrammer) 
som viser hvordan `StringMergingIterator` gjennom metodekall fletter verdiene fra de to gitte iteratorene (som blir tatt inn som argumentene til 
`StringMergingIterator`-objektet).

### Hjelp / mistanke om bugs

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](https://piazza.com/).

### Godkjenning

Last opp kildekode og `.ex`-filene på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for en læringsassistent innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.

### Exercise-panelet

For hver oppgave finnes det en tilsvarende `.ex`-fil, som beskriver hvilke aktiviteter, f.eks. koderedigering, kjøring av tester osv, som er en del av oppgaven. Når en jobber med en oppgave, så kan en åpne `.ex`-fila for oppgaven i Exercise-panelet. Dette gjøres enten ved å høyreklikke på fila og velge `Exercise > Open Exercise View` eller å åpne panelet med `Window > Show View > Other > Exercise View` og så dra og slippe `.ex`-fila i panelet. Filen ligger i mappen `tests`, og videre i pakke med samme navn som klassen den hører til. Hver `.ex`-fil åpnes i en egen fane, så en kan jobbe med flere oppgaver samtidig. Disse `.ex`-filene, én for hver oppgave, må leveres inn sammen med kildekoden i øvinger hvor det er spesifisert.