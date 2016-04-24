#DungeonGenerator viikko 5

Tärkeimpänä muutoksena vaihdoin Maveniin. Havaitsin, että se syy, miksi en saanut muutosta toimimaan, oli se että jostain syystä versio oli vanha,
eikä jdk1.8 jostain syystä asentunut toistuvista yrityksistä huolimatta oikein. Jouduin siis muokkaamaan odotettua pom.xml:ää niin, 
että odotettu versio on 1.7. Toivottavasti tämä ei tule aiheuttamaan mitään suuria ongelmia muille ohjelman käyttäjille. Jos 1.8 toimii teillä, 
muokatkaa pom.xml vastaavaksenne, ja ohjelman ei pitäisi aiheuttaa hämminkiä.

Tällä viikolla korjasin ylimääräisten huone-relaatioiden muodostusta niin, että huoneet saavat toisensa, eivät vajaavaa kopiota toisistaan. 
Lisäksi lisäsin testejä ja tiivistin koodia. Ongelmaksi testien kirjoittamiselle muodostuu simuloitu epädeterministisyys, eli en tiedä miltä 
kunkin syötteen lopputuloksen tulisi näyttää muuta kuin suurpiirteisesti, ja ohjelma on tolerantti useiden muutosten suhteen
ilman että lopputulos sinänsä kärsii.
