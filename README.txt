1. Hvordan skal programmet kompileres?
- Kompiler filene: 'javac *.java'
- Test med x antall noder: 'java BSTtest <tilfeldigTallFeks30>' || 'java BSTtest 30'
- Test med argument 0, da adder programmet selv: 'java BSTtest 0'


2. Hvilken fil inneholder main metoden?
-  Filen 'BSTtest.java' inneholder main metoden.


3 + 4. Hvilke særegenheter inneholder din implementasjon?  + Hvilke antakelser har du gjort når du løste oppgaven?
- Jeg har kommentert der jeg føler koden trenger forklaring, og det er mest for min egen del på metoder jeg har slitt mye med. Da kommenterer jeg for å tydeliggjøre stegene for meg selv. Så noen metoder har lite kommentering fordi jeg synes det ikke trengtes der og da... mens andre har mer kommentering fordi jeg har slitt med de.

- I add metoden har jeg brukt >= til å alltid plassere en ny node til høyre

- I remove metoden har jeg ikke tatt hensyn til om det er 2 like tall etter hverandre når jeg traverserer gjennom en intern node, og første til høyre 

- Jeg har ikke tatt hensyn til om det skal være et balansert tre i add eller remove.


5. Hva fungerer ikke som det skal?
- Hovedprogrammet er litt rart? Jeg tester ikke alle metoder i det, og synes hele oppsettet har vært litt vanskelig å forholde seg til, og obligteksten var i mine øyne ikke tydelig nok på hva hovedprogrammet skulle vise frem. Men jeg har gjort noen konfigureringer i det utdelte hovedprogrammet med mine egne enhetstester og metodene mine skal fungere, jeg bare ser ikke helt hva du får ut av hovedprogrammet som en helhet.

- Fikk en OutOfMemory Error i main programmet, og har derfor fjernet 3 nuller fra 'ant <= 1000000;' på linje 21... 


6. Hva du helst vil ha tilbakemelding fra din retter om?
- Kunne tenkt meg en tilbakemelding på hvordan man kunne ha løst remove metoden (mer) rekursivt :)

- Tar også imot forbedrings tips til rekursive metoder. De er løst på litt ulike måter, og for hver rekursive metode jeg har skrevet har læringskurven økt - så jeg ser forskjell på første rekursive metoden jeg skrev versus siste. Men kom gjerne med tips til forbedringer og bedre effektivitet, særlig hvis det er noen som er tungvinte og bruker lang tid.

- Hvis det er ting/ småpirk du ser som kunne vært skrevet bedre, ala 1010 basics, er det bare å gi meg tilbakemelding på det. Jeg har fokusert mye på lesbar kode, og legger mye tanke i variabelnavn og sånn. Burde jeg feks kommentere mer i koden? Så hvis det er annet småpirk, eller forbedringsområder tar jeg imot konstruktive tilbakemeldinger med åpne armer.  :)

- Er det noe teori/ pensum jeg kunne ha implementert i obligen, som åpenbart/ kunne ha vært med - men som jeg ikke har implementert?


