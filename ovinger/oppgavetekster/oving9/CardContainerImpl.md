# Arv - CardContainerImpl-oppgave

Denne oppgaven handler om å lage en felles superklasse `CardContainerImpl`
for `CardDeck`- og `CardHand`-klassene, laget i [Card-oppgaven](../oving5/Card.md)
og [CardContainer-oppgaven](../oving6/CardContainer.md).

**Merk:** Om du ikke har gjort Card-oppgaven og CardContainer-oppgaven allerede,
kan du bruke løsningsforslaget som er lagt ut for disse under `lf/src/interfaces`.

### Del 1 - Superklassen CardContainerImpl
Lag en `CardContainerImpl`-superklasse, som implementerer grensesnittet
`CardContainer` (se [CardContainer-oppgaven](../oving6/CardContainer.md)) og
inneholder koden som er felles for `CardDeck` og `CardHand`.

La `CardDeck` og `CardHand` arve `CardContainerImpl` og gjør nødvendige endringer
i disse klassene, slik at totaloppførselen er som før. F.eks. skal `CardDeck`
-objektet ha samme konstruktør som før, som skal sikre samme initielle tilstand
(men ikke nødvendigvis med samme konstruktør-kode).

Merk at målet er at mest mulig kode skal flyttes til *superklassen* og gjenbrukes
i *subklassene*. Det er viktig å bruke innkapsling rett
(hint: `protected`-modifikatoren) for å nyttiggjøre seg superklassen i størst
mulig grad.

### Del 2 - Regler for maksimalt antall kort
Anta at en ønsker å unngå at instanser av `CardContainerImpl` (eller av en av
subklassene) inneholder for mange kort. Legg til et *privat* `maxCardCount`-felt
i `CardContainerImpl`, en konstruktør som *initialiserer* feltet og en *getter*
for å lese verdien. Legg så til evt. endre kode i `CardContainerImpl` som sikrer
at antall kort ikke overstiger dette tallet og at subklassene ikke kan omgå
denne valideringen.

`CardContainerImpl`-subklassene `CardDeck` og `CardHand` skal sette maks-antallet
som følger: `CardDeck` skal sette makstallet til *52* og `CardHand` skal ta
inn maks-antallet i *sin* konstruktør. Hvis man forsøker å legge til flere kort
enn hva som er tillatt i `CardHand`, skal det utløses en `IllegalStateException`.

Testkode for oppgavene finner du her: [inheritance/CardDeckTest.java](../../tests/inheritance/CardDeckTest.java) og [inheritance/CardHandTest.java](../../tests/inheritance/CardHandTest.java). Originalkoden (jextest) for testene finner du her: [CardDeck.jextest](../../tests/inheritance/CardDeck.jextest) og [CardHand.jextest](../../tests/inheritance/CardHand.jextest).

### Exercise-panelet
Bruk av Exercise-panelet er obligatorisk for denne øvingen. Du må ha panelet
åpent med `CardContainerImpl.ex`-filen (`tests > inheritance> CardContainerImpl.ex`)
i før du begynner med oppgaven. For mer informasjon/hjelp, se nederst på
forrige side, altså hovedsiden for [Øving 9](./README.md).











