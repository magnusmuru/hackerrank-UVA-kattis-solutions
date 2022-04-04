# Aruanne 4 - 4. Aprill

## 1. Millal saab kasutada rekursiooni?

Juhul kui probleemi saab jaotada lihtsamateks alamprobleemideks või juhul kui on vaja lahendada probleemi, mille puhul
tulemus on sõltuv sama tulemuse leidmisel vähendatud sisendist.

## 2. Dünaamilise planeerimise puhul on 2 lähenemist: Top-Down ja Bottom-Up. Kumba eelistada ja millal?

Enamus juhtudel on Bottom-Up eelistatav, kuna Top-Down on rekursiivne lahendus koos mäluga. Top-Down on eelistatav
juhtudel, kus:

* Bottom-Up lahendus tekitab alamprobleeme, mis ei ole lahenduse jaoks olulised ning see suurendab lahendusaega
  võrreldes Top-Down lahendusega.
* Bottom-Up lahenduse puhul võib tekkida juhtumid, kus lahenduse loomisel kasutatakse koheselt rohkem mälu kui
  süsteemile on allokeeritud, sellel puhul on lahenduse dünaamiline loomine ainult Top-Down lahendusega.

## 3. Mis on dünaamilise planeerimise tüüpülesanded?

* 0-1 Knapsack, nt SuperSale koduülesanne
* Fibbonaci jada
* Palindroomide leidmine sõnedes
* Pikimate alamsõnede või kasvavate alamjärjestuste leidmine

## 4. Tunniülesanded

### Nädal 8

#### Coin Change

Lahendus oli leida dünaamiline array kuhu panna kõik lahendid ning neid läbi dünaamilise programmi saada kätte ning
muuta. Hiljem vaadata mitmel viisil on võimalik kätte saada vaadates selle dünaamilise array eelviimast numbrit.

#### Knapsack

Leida endale lower bound millest alla ei tohi minna ning lahendada 0-1 Knapsack probleem. Juhul kui element on väiksem
kui target, siis on võimalik tagastada maksimaalne väärtus selle ning rekursiivselt välja kutsutud sihtmärgi, kas
vähendatud sihtmärgi või sisendiga.

#### Stock Maximize

Eesmärk on leida maximaalse hinna indeks ning arvutada kuni selle hinnani kõikide eelnevalt odavamate päevade puhul
ostetavad aktsiad. Siis saab müügi päeval arvutada juhul kui palju kasumit on teenitud. Juhul kui mitte ühtegi sellist
päeva ei ole, siis tulemiks on null.

### Nädal 9

#### Sam and substrings

Oluline on hoida mälus eelnevate väärtuste summat. Selle põhjal on võimalik dünaamilselt täita järjest stringi läbi
otsides ning kohtasid jälgides arvutada kõikide väärtuste summa kuni sellel hetkel läbi käidud arvudega.

#### Matrix Land

Polnud aega, et põhjalikult head ideed leida sellele ning tüüplahendusi mille põhjal ideed saada polnud väga netist
leida ka.

## 5. Koduülesanded

Valisin SuperSale, UVA 10130.

uDebugi kohaselt 0-1 Knapsack probleem, ehk hakkasin sellega seoses otsima kuidas optimiseerida tavalist 0-1 Knapsacki.

https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/ on suhteliselt hea seletus selle kohta, kuid suht kiirelt sain
aru, et tüüplahendused mis pakuvad jooksevad timeouti.

Ehk eelnevalt on vaja kõikide lahenduste jaoks ühe korra knapsack ära täita maksimaalse kaaluga ostja poolt. Selle jaoks
oli vaja luua 2D array kuhu mahuksid kõik lahendid, mida saaksid inimesed ära kanda. Array viimasesse ritta, koonduvad
kõik tulemid, mille koguses suudavad inimesed ära viia ning nende summa põhjal on võimalik leida kogu tulemus.