Øving 07: Filbehandling med app
-------------------------------

Oppgaven handler om å utvide appen fra [Øving 4: Objektstrukturer med app](../oving4/README.md) med nye funksjoner. Du skal jobbe i app-packagen fra øving 4, altså `ovinger/src/app`.

# Del 1 - Lagring (60%)

I denne delen skal du implementere lagring av informasjon til appen din. Dette kan for eksempel være valutakurser, tilstanden til et spill så du kan fortsette å spille senere, innholdet i en handlevogn etc. Du må selv finne ut av hvordan du skal organisere informasjonen din som tekst slik du kan skrive og lese den fra fil. For valutakurser kan dette for eksempel være en linje per valutakurs med valuta og kurs separert med mellomrom.

For å gjøre det enklere å bytte til et annet lagringsformat, så skal du definere et grensesnitt (altså et **interface**) knyttet til lagring og lage minst én ny klasse som implementerer grensesnittet. I appen din må du ha en instans av denne klassen som du bruker til å skrive til/lagre fra fil.

## Dette må du gjøre

- Lag et grensesnitt som definerer metoder for å lese og skrive til fil.
    - Du skal ha en metode for å skrive til fil, og en for å lese fra fil.
    -Begge metodene skal ta inn filnavnet det skal skrives til/leses fra og objektet som skal lagres/ leses til.
- Lag en implementasjon av grensesnittet som laster inn informasjon til appen din og lagrer informasjon fra appen.
- Legg til elementer i brukergrensesnittet og metoder i controller-klassen og logikk-klassene dine slik at du kan lagre og lese informasjon fra appen mens den kjører.

Før du går i gang med denne delen kan det være lurt å ta en titt på wikisiden for [Lesing fra og skriving til fil](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=70910423).

Hvis du ønsker en ekstra utfordring kan du se på muligheten for å lese inn informasjon fra nettet i tillegg til fra fil. Dette kan være naturlig i apper som en valutakalkulator o.l.

# Del 2 - Feilhåndtering (40%)

I denne delen skal du legge til feilhåndtering i appen din.

## Dette må du gjøre

- Sørg for at appen din er godt innkapslet slik at den aldri krasjer eller havner i ugyldig tilstand.
- Dette inkluderer at man får fornuftig oppførsel/ fornuftige feilmeldinger hvis man:
    - gir feil input (eks legge inn ord der det skal være tall)
    - gjør ting i feil rekkefølge (f. eks trykke to ganger på `=`-tegnet på en kalkulator)
    - gjør andre brukerfeil (f. eks oversette fra en valuta til den samme valutaen)
- Det inkluderer også at det aldri skal komme røde error-meldinger i konsollen.
