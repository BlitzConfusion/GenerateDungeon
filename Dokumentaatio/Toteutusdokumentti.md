#GenerateDungeon toteutusdokumentti

Ohjelma koostuu yksinkertaisuudessaan puuluokasta ja huoneluokista. Huoneluokat ovat abstraktin huoneluokan alaisia, ja useimmat eivät itseasiassa
 sisällä eriävää toiminnallisuutta nimeä lukuunottamatta.
 
 Tällä hetkellä ohjelma suoriutuu suurimistakin syötteistä alle sekunnin suoritusajassa. Tämä muuttunee kunhan lisätoiminnallisuus koodataan.
 Työ tapahtuu nyt ajassa O(sqrt.n), jossa huoneiden määrä on n. Uuden huoneen sijoittaminen on verrannollinen olemassa olevan puun syvyyteen, joka 
 kasvaa erittäin hitaasti. Tämä johtuu siitä, että lisäys on vain osaltaan eriävä leveyssuuntaisesta lisäyksestä, eli kukin kerros valmistuu
 ennen uuden kerroksen aloittamista.
 
 Puun aukikirjoittaminen tapahtuu ajassa O(n), sillä kyseessä syvyyssuuntainen läpikäynti.
 
 Lähteitä ei tällä hetkellä ole.
