# GreedyStudent

### Kuvaus

Helsingin yliopiston ohjelmistotekniikka kurssia varten luodun sovelluksen repositio

### releaset

[Viikko 5](https://github.com/Mikxdi/OTharkkatyo19/releases)

[Viikko 6](https://github.com/Mikxdi/OTharkkatyo19/releases/tag/viikko6)

### Testaus

Testaus suoritetaan komennolla 

``` 
mvn test
```

Jacoco raportti saadaan ajamalla terminaalissa komento


```
mvn jacoco:report
```

Ohjelman checkstyle raportin saa komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Kyseisen raportin saa luettua esimerkiksi komennolla

```
chromium-browser target/site/checkstyle.html
```

### Ohjelman suorittaminen

Ohjelman suorittaminen tapahtuu syöttämällä terminaaliin komennon

```
mvn compile exec:java -Dexec.mainClass=greedystudent.ui.GreedystudentUi 
```

### Pakkauksen luominen

Ohjelmasta saa suoritetavan jar tiedoston komennolla 

```
mvn package
```

####  Linkki tuntikirjanpitoon
[Tuntikirjanpito](https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Tuntikirjanpito.md)

#### Linkki Arkkitehtuuri kuvaukseen
[Arkkitehtuuri](https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Arkkitehtuuri.md)

#### Linkki vaatimusmäärittelyyn
[Vaatimusmäärittely](https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Vaatimusmaarittely.md)

#### Linkki käyttöohjeisiin
[Käyttöohje](https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Kayttoohje.md)

#### Linkki Testausdokumenttiin
[Testaus](https://github.com/Mikxdi/OTharkkatyo19/blob/master/documentation/Testausdokumentti.md)
