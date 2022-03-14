# Aruanne 3 - 14. Märts

Olen hetkel haige, ehk üritan vastused panna lühemalt, aga mõtte edasi saada

## 1. Millal eelistada ahnet algoritmi Lee ja A*algoritmidele, kui on vaja labürindist leida lühimat teed kahe ruudu vahel?

Juhul kui Ülesandes on väga vähe hargnevaid teid, siis on ahne alati kiirem kui teised, kuna need üritavad ka analüüsida
läbikäidud teekonda.

## 2. Mis on "hargne ja kärbi" (branch and bound) strateegia idee?

Optimeerimisstrateegia, kus objekte jaotatakse jah ja ei kategooriateks, enamasti jaotatakse kogu element puu peale
laiali ning siis otsustatakse kas element jääb ülemise ning alumise piiri vahele. Kui olemasolev alampuu on kehvem kui
olemasolev parim, siis seda ignoreeritakse. Selle põhjal otsitakse parim tulemus tegemaks kahte tegevust.

## 3. Mis juhul kasutaksite min-max algoritmi?

Enamasti kasutatakse seda mängu algorütmides. Selle jaoks on enamasti vaja kahte kasutajat/sisendit, üks millest on min
ja teisest max. Iga kasutaja/sisendi võimalused antud olukorras hinnatakse seoses eelneva olukorraga, ning neile antakse
väärtus otsustuspuul. Algorütmi eesmärk on maksimaliseerida mängiva kasutaja max väärtusi, samal ajal jätta vastasele
võimalikult suur min väärtus. Nt males. Vajadusel backtrackitakse, kui seis ei ole enam hea (vastase min on suur või
mängija max on madal)

## 4. Tunniülesanded

### Nädal 5

Olen eelnevalt masinõppe aines lahendanud sarnaseid probleeme ehk suuresti võtsin olemasolevad lahendid ning kohandasin
nad Hackerrankile

#### A*

Põhimõtteliselt sarnane BFS lahendusega, lihtsalt lisanduv prioriteet, mis annab tulemusele ka lisaks kas algoritm jõuab
lähemale või mitte, mille põhjal hiljem analüüsida asukohta. Kuna siin ei olnud niipalju vaja lisaandmeid printida, siis
lihtne reverse läbikäidud alale ning printida iga rida.

#### BFS

Vaja oli muuta järjestus mis pidi otsib lahendus, kuna hackerrankis oli see kindlalt paika pandud. Sisuliselt lood queue
frontieriga, mis otsib läbi järjest kohti kuni lahenduseni. Kui lahendus leitud, siis hackerrank nõudis kohest
peatamist, mille jaoks ma tegin kiire hacki, et ta prindiks hoopis kuni lõpptulemuseni leitud kohad, mitte kõik sammul
leitud kohad. Pathi printimiseks vaja reverse teha ning printida leitud path, mis võtab arvesse kust frontier sinna
liikus ning kuidas jõuda tagasi algusesse minimaalse kiirusega.

### Nädal 7

See nädal jäi alustamata, kuna olen haige ja teised tähtajad jooksevad selga. 21.03 tähtajaks plaan ära teha.

## 5. Koduülesanded

Valisin Grocery Store, UVA 11236.

Üpriski lihtne oli aru saada, et see ülesanne tuleb lahendada 4 loopiga. Aga teades kompleksusest, siis O(n^4) keerukus
kohe kindlasti ei suuda seda õige aja sees ära teha. Ehk optimeerimiseks tuli ülesandele väljumised loopist panna, et
limiteerida otsitavat väärtus.

Suhteliselt lihtne oli leida loogika et summad ei tohiks kokku liituda omavahel 2000ks, ehk 20ks euroks ning
kontrollida, et hind 3 ei ületaks hind 4ja. Aga keerulisem oli leida optimeerimine, et limiteerida väärtust varakult.
Selle abiks tuli mulle hea link uDebugist https://www.udebug.com/UVa/11236/hints, mis seletas häguselt ära, et ülesannet
saab lahendada võrrandit lahendades. See seletas ka loogika, kuidas vaadelda tulemust nagu korrutist, mis aitas
lahendada valemi. Sisuliselt on lahendus p1 + p2 + p3 + p4 = p1 * p2 * p3 * p4, ehk permutatsioonide kogu - selleni
jõudmine mitte nii lihtne. Aga sellest valemist, saab tuletada olulised faktid nagu see, et sendi esituses on saab olla
ainult kindel limiit arvule, mis vähendab otsitava vahemiku juba 10^6 piiresse. Sealt edasi saab tuletada 4 sendi
väärtuse juhul kui esimese kolme sendi summa ning korrutis vastab teatud tingimustele. Need on:

* Konstandi ja 3 arvu summa jagatis 3 arvu korrutise ja konstandi vahega peab jaguv olema kuna meil ei ole
  fraktsionaalseid sente
* Esimese 3 arvu korrutis viimasega ei tohi ületada hindade hard limiiti 10^9
* Nagu eelnevalt mainitud, ei tohi neljas arv ületada kahte tingimust: väiksem kui kolmas arv ja summa ei tohi ületada
  2000

Kui need kolm asja arvesse võetud on ning tingimused täidetud, siis on tegemist sobiva nelja hinna järjestusega ning
selle võib printida. Ning kui nii läbi käia limiteerides otsingu piirkonda läbi eelmise arvu suurusega, siis leiab
vastuse circa 0.5s