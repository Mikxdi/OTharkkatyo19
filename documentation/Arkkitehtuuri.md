# Arkkitehtuurikuvaus

## Pakkausrakenne

Pakkausrakenteeltaan ohjelma noudattaa seuraavaa, jossa Ui sisältää javafx pohjaisen käyttöliittymän sekä pelin animoinnin
ja domain sisältää varsinaisen sovelluslogiikan pelin taustalla


<img src="https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Pictures/Arkkitehtuurikuvaus.png" width="600" heigth="600" />


## Käyttäliittymä

Pelin käyttöliittymä koostuu neljästä eri näkymästä.

* Päävalikko
* Kenttävälikko
* Pelinäkymä
* Voitto- ja häviönäkymät

Kukin näistä on toteutettu Ui:n puolella omana scene olionaa ja niiden muodostamiset ja Stageen sijoittamiset tapahtuvat omissa metodeissaan.

Käyttöliittymä ei vastaa animaatiota ja päivityslooppia lukuunottamatta pelilogiikasta vaan kutsuu domainista update metodia, joka päivittää pelin tapahtumat


## Sovelluslogiikka 

Sovelluksen päätoiminnallisuudesta vastaa gameLogic luokka, joka kutsuu update-metodin avulla sille parametreiksi annettuja Level ja Student luokkien metodeja.

## Sekvenssikaavio

Yksinkertainen kuvaus pelin toiminnasta 

<img src="https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Pictures/Sekvenssikaavio.png" width="600" heigth="600" />

## Tiedostot
	
Pelin kentät ovat txt tiedostoja, joissa on kahdeksan riviä, joista kullakin on 20 merkkiä. Jokaisen merkin välillä on välilyönti inputin oikein lukemiseksi.
Merkit ovat arvoiltaan joko 0, 1 tai 2, jotka kuvastavat mitä kyseisen merkin kohdalle piirtyy kentään.


