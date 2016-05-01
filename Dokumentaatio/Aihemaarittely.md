#GenerateDungeon Aihemäärittely

GenerateDungeon luo puumaisen luolaston, jossa aluksi luodaan semi-leveyslisäyksellä solmut, ja myöhemmin voidaan muokata solmujen välisiä yhteyksiä vähemmän geneerisen muodon saavuttamiseksi.

Solmuina toimii erityyppisiä huoneita, joiden konkreettista sisältöä ohjelma ei määritä. Dungeon on abstraktilla tasolla, eli ohjelma joka käyttää sitä saa itse määrittää konkreettiset yksityiskohdat kuten huoneiden sisällön, huoneiden "ovien" paikat ja "käytävien" (yhteyksien) tilan (abstrakti tai konkreettinen).

Jos haluaa ajatella konkreettisen kuvan avulla, käytännössä Gate-huoneesta roikkuu kaksi erillistä binääripuuta, jotka joiden välillä on joidenkin huoneiden välillä lanka (extra-pohjainen yhteys).

Ohjelma on semi-leveyssuuntainen sillä tavalla, että uusi huone lisätään tai tungetaan aina oksaan johon viimeksi ei lisätty tai tungettu.
Näin puussa yksi kerros täyttyy aina ennen seuraavan aloittamista, ja huonetyyppien sekoittamisen pitäisi tapahtua helpommin. Viimeisenä huoneena lisätään aina exit, eli Dungeonilla on kaksi kulkureittiä, Gate ja Exit.

Lähteet tulevat merkityiksi sitä mukaa kun löydän hyödyllisiä lähteitä. Tähän mennessä olen tehnyt tätä päästäni.

Ohjelman Aikavaativuus on suoraan verrannollinen luolaston kokoon. Uuden huoneen sijoittamisen aikavaativuus riippuu "syvyydestä", joka kasvaa erittäin hitaasti, koska tarvitaan aina kaksinkertainen määrä huoneita uuden kerroksen täyttöön ennen seuraavan aloittamista.

Dungeon aukikirjoitetaan syvyyssuuntaisesti, kuitenkin vanhemmat (root) ensin intuitiivisen lukemisen helpottamiseksi.

Kun generointi lopetetaan, ohjelma lukee omatekoisesta IntArraysta auki kuinka kaukana Gatesta kkukin huone on.
