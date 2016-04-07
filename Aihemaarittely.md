#GenerateDungeon Aihemäärittely

GenerateDungeon luo puumaisen luolaston, jossa aluksi luodaan semi-leveyslisäyksellä solmut, ja myöhemmin voidaan muokata solmujen välisiä yhteyksiä vähemmän geneerisen muodon saavuttamiseksi.

Ohjelma on semi-leveyssuuntainen sillä tavalla, että uusi huone lisätään tai tungetaan aina suuntaan johon viimeksi ei lisätty tai tungettu.
Näin puussa yksi kerros täyttyy aina ennen seuraavan aloittamista, ja huonetyyppien sekoittamisen pitäisi tapahtua helpommin. Viimeisenä huoneena lisätään aina exit, eli Dungeonilla on kaksi kulkureittiä.

Myöhemmässä vaiheessa tullaan yhteyksien muokkauksen lisäksi mahdollisesti muokkaamaan huoneiden sijaintien todennäköisyyksiä, jos aikaa riittää.

Lähteet tulevat merkityiksi sitä mukaa kun löydän hyödyllisiä lähteitä. Tähän mennessä olen tehnyt tätä päästäni.

Ohjelman Aikavaativuus on suoraan verrannollinen luolaston kokoon. Uuden huoneen sijoittamisen aikavaativuus riippuu "syvyydestä", joka kasvaa erittäin hitaasti, koska tarvitaan aina kaksinkertainen määrä huoneita uuden kerroksen täyttöön ennen seuraavan aloittamista.

Dungeon aukikirjoitetaan syvyyssuuntaisesti, kuitenkin vanhemmat ensin.
