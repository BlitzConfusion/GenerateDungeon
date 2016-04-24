#Viikolle 4 viikkoraportti.

Tällä viikolla ongelmia on riittänyt. Kuumeen lisäksi olen turhaan yrittänyt kamppailla Java-pohjaista Java Applicaatiotani 
Maven-pohjaiseksi Java Applicaatioksi PIT-raporttien luomista varten. Suora muutos ei onnistu. Ohjeiden seuraus ei-Maven pohjassa ei toiminut. 
Ohjeiden seuraaminen kunnolla ja luotujen luokkie siirto valmiiseen pohjaan kaatuu Clean&Build:n epäonnistumiseen.  
Samoin yrittäen pohjan siirtoa alkuperäiseen. On suorastaan ihmeellistä miten paljon aikaa tällaiseen saa kulumaan räkäisenä.

Varsinaisen koodin puolella einoa takapakki oli se, että jouduin toistaiseksi poistamaan oksahuoneiden painotuksiin perustuvan sijaintimuutoksen.
Jostain syystä nykyinen koodini sijoittaa tulevia huoneita kuin ne eivät vaihtaisi paikkaa, mutta valmiista puusta hakemisessa olisivat. Hämmentävää.

##Edistys

Olen saanut tehtyä ylimääräisten reittien implementaatiota. Tämä on toiminut hyvin tähän mennessä, mutta aion vielä muuttaa myöhemmin 
tätä koodia niin, että uudet referoidut huoneet ovat ajan tasalla. Tämä ei sinänsä näy nykyisellä aukikirjoituksella mitenkään, mutta 
jos tätä puuta yritettäisiin navigoida manuaalisesti, nämä ylimääräiset reitit veisivät käytännössä (käsittääkseni) toiseen, reiteiltään vajaavaisempaan puuhun.
 En tosin ole varma, asiaa täytyy tutkia lisää. Painotuksen puutetta lukuunottamatta varsinainen puunmuodostus ja aukitulostus vaikuttaa toimivan käytännössä täysin.
 
 Metodeja on hieman siistitty. Jotkin metodit, kuten tulostusmetodi, ovat vielä hieman pitkiä, ja niiden siistiminen onkin seuraava toimenpide. 
 Myös satunnaismuuttujaa voisi lisätä puun muodostukseen jos aikaa jää.
 
 Myös testauskoodia täytyy ehdottomasti lisätä huomattavasti. Mainitut esteet ja takapakit ovat hidastaneet testauksen kirjoitusta ihan liikaa.
 
 Ja viimeisenä kannattanee aloitella käyttöliittymää. Periatteessahan tätä ei välttämättä käytettäisi manuaalisesti, mutta tämä helpottaa 
 rajausta valideihin inputteihin huomattavasti.
