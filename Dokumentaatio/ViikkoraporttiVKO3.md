#Toinen viikkoraportti VKO 3.

Koska viimeisimmästä palautuksesta on hyvin vähän aikaa, on edistys ollut vastaavasti vähäisempää.

Olen luonut suurimman osan oleellisista testeistä huoneille (Room). Lisäksi korjasin viimeisen huoneen numeroon tulleen virheen (yksi liian iso).

Nyt Dungeon luo kaikkia huonetyyppejä epäsäännöllisellä tyylillä. Vielä en ole laittanut random seediä laittamaan erittäin suurten huonemäärien
 generaatioon lisää satunnaisuutta, mutta tämä ei näy liikaa. Epäonnistuin lisähuonereittien implementaatiossa. Uskon että ongelma johtuu siitä
, että yritin tehdä liitoksen metodilla, joka yrityksistäni huolimatta yritää palauttaa abstraktin instanssin, ei konkreettista. En ole varma tästä. 
Pitää selvittää kuinka saan laitettua metodin joka palauttaa pakettien välillä ei-ennaltamäärätyn huonetyypin. Jos mikään muu ei toimi, 
laitan yhden huonetyypeistä olemaan ainoa validi tähän kytkentään.

Lisäksi sain implementoitua huoneiden painojärjestäytymisen, jossa arvoltaan isompi oksahuoneista järjestyy lähemmäs "keskustaa" puussa. 
Tämä lisää Dungeonin satunnaisuutta hieman, ja tekee siitä "tarinallisesti" uskottavamman.
