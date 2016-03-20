#GenerateDungeon Aihemäärittely

GenerateDungeon tulee tekemään 2D-Luolaston tietylle alueelle (oletus 100x100), joka tulee sisältämään tietyssä suhteessa erilaisia huoneita,
jotka tulevat johtamaan aluksi Exit A:sta myöhemmin generoitavaan Exit B:hen.

Ohjelma saa syötteenä ainakin koon. Jos koko on liian pieni kunnollisen kompleksin rakentamiseen, ohjelma saattaa generoida vain käytävän A:sta B:hen.
Tavoitteena on järjellisillä syötteillä saada generointiaika mahtumaan 5-7:ään sekunttiin, kymmeneen jos generoidaan muutakin kuin vain huoneet itsessään.

Ohjelma pyrkii aluksi semi-syvyyssuuntaiseen (pientä mutkittelua, ettei reitistä tule putkea) läpikäyntiin, jotta saadaan aikaiseksi pakollinen onnistunut reitti välillä Exit A ja Exit B.
Kun tämä tavoite on saavutettu, ohjelma pyrkii puolisatunnaisesti semi-leveyssuuntaisesti "leventämään" luolaston muuksikin kuin kiemurtelevaksi putkijuoksuksi. Ohjelma lakkaa kun tietty määrä annettua luolastopinta-alaa on hyödynnetty loppuun. Vaihtoehtoinen lopetus on, ettei uusia huoneita mahdu enempää.

Lähteet tulevat merkityiksi sitä mukaa kun löydän hyödyllisiä lähteitä.

Ohjelman Aikavaativuus kasvaa suhteessa generoituihin huoneisiin ja luolaston kokoon. Tilavaatimus tulee lopuksi olemaan suoraan verrannollinen 
luolaston pinta-alaan; ajon aikana lisäksi tarvitaan tila "käytäväruutujen" sijainnille ja tyypille, sekä sallituille huonetyypeille, joka on suoraan verrannollinen huoneiden määrään.
