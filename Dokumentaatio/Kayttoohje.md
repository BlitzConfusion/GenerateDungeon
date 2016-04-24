#GenerateDungeon käyttöohje.

Tällä hetkellä käyttöliittymää itseään ei ole toteutettu. Tämä tulee muuttumaan.

Ohjelman toimintaa voi kokeilla TreeDungeon pääluokasta, joka sisältää yksinkertaisen käyttötapauksen (luo Dungeon ja kirjoita se). 
Ensimmäinen puun konstruktoriin liittyvä muuttuja määrää huoneiden määrän (numeerinen kokonaislukuarvo tällä hetkellä ainoastaan validi, mutta liian suuret (257+) ja liian pienet (14-) arvot muuttuvat maksimi-/minimiarvoksi (256 ja 15).

Etummainen integeri Konstruktorissa kertoo kuinka suuri puu halutaan; jälkimmäinen on random-seed, joka vaikuttaa tiettyjen huoneiden painotuksiin ja huoneiden lisäyksen määriin.
