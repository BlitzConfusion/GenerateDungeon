#Alustava GenerateDungeon-testausdokumentti

On manuaalisesti testattu, että valideilla (eli numeerisilla) syötteillä ohjelma ei hämmenny. Tämä tehtiin luomalla esimerkkipuita ja tarkistamalla yksityiskohtia. Ohjelma myöskin aina asettaa Nexuksen, mikä tapahtuu vain muiden huoneiden puutteessa, eli pienillä syötteillä olisi teoreettisesti mahdollista ettei Nexus ehtisi mukaan. Näin ei kuitenkaan käy.

On testattu valideilla, negatiivisilla ja ylisuurilla numeerisilla syötteillä.

Sekä Room- että Tree-luokille on luotu testausluokat. Puun itsensä yksityiskohtaisessa testaamisessa on se ongelma, että pyritään simuloituun semi-epädeterministiseen puuhun, eli ei ole tarkkaa tietoa huoneiden sijainnista ja/tai määrästä, ja epädeterministinen huonemuodostus olisikin itseasiassa tavoitteen kannalta positiivista. On pyritty katsomaan että sekä Gate, Nexus että Exit luodaan. Käytännössä usein kuitenkin testataan huoneiden testauksen kautta.

Huoneiden Testaamisessa on pyritty lähinnä tarkistamaan huoneiden välisten relaatioiden korrekti toiminta. Eli esimerkiksi tulevatko kerrokset oikein, laitetaanko oksat oikein, merkitäänkö vanhempi oikein ja tällaista.
