# 21. Veebruar

## 1. Mis iseloomustab ahnet algoritmi? Millal sellist strateegiat võib kasutada?

Ahne algoritm on algoritm, mis valib igal sammul oma eesmärgi täitmiseks parima valiku. Samaaegselt, see valik ei pruugi
alati olla valik, mis viib õige vastuseni. Valiku tunnus on alati kõige otsesemalt selgem parim tulemus (nt
suurem/väiksem väärtus, lühim ahel, jne).

Sellist strateegiat võib kasutada näiteks tee otsimisel nt Djikstra algoritm on lühima tee otsimiseks kahe graafil oleva
tipu vahel.

## 2. Mis on vahe priorityQueue ning tavalise queue vahel?

Kui tavaline Queue on FIFO (esimesena sisse, esimesena välja) tüüpi andmestruktuur, siis PriorityQueue puhul on
esimesena välja võetav väärtus on seotud tema prioriteediga. Traditsioonilselt (ehk kui PriorityQueue pole kahanevas
järjestuses või kasustatakse eraldi kohandatud prioriteedi implementatsiooni) võetakse esimesena välja madalaima
prioriteediga element. PriorityQueuesse lisamisel, järjestatakse objekt vastavalt oma prioriteedile ning PriorityQueue
järjestamise meetodile, ehk tavaliselt väiksema prioriteediga elemendid esimesena ja suuremad viimasena (kasvavas
järjestuses). järjekorras)

## 3. Kuidas toimub elemendi lisamine kuhja?

Element lisatakse kuhja lõppu. Kuhja lõpp liigub visuaalselt vasakult paremale ning igal elemendil on kaks järgmist
elementi. Sellele järgnevalt üritatakse element saada õigesse kohta, selle jaoks võrreldes lisatud elemendi vanemat
elementi ja teda ennast. Juhul kui vanem element on väiksem kui lisatud element, siis nende kohad vahetatakse. Seda
protsessi jätkatakse kuni element jõuab kuhjas kohta, kus tema vanem element on temast suurem ning tema alla kuuluvad
elemendid on väiksemad.

NB! Võrdlemine on õige MAX-kuhja puhul, MIN-kuhja puhul peaks võrdlused olema vastupidised (ehk kui vanem element on
väiksem kui alumine)

## 4. Kuidas toimub kuhjast elemendi kustutamine?

Kustutamisel kustutatakse kuhjast element ära ning siis asendatakse see kõige viimase kuhja elemendiga. Siis hakatakse
võrdlema vanemate elementidega kuhjas, kas seal on vaja teha vahetusi sarnaselt lisamisele. Kui seda ei ole vaja teha,
siis vaadetakse ka kuhjas allapoole, kas all olevad väärtused on suuremad kui asendatud väärtus. Protsessi jätkatakse
kuni kuhi on tagasi oma tavapärases olekus.

NB! Nagu ka lisamisel, on kustutamisel võrdlemine tagurpidine MIN-kuhja puhul.

## 5. Kuidas on HeapSort implementeeritud?

Heapsort on implementeeritud kuhja põhjal. Kõik elemendid lisatakse kuhja, ning seejärel korrastatakse kuhi vastavalt
kas MIN (et saada kahanev järjestus) või MAX viisil (et saada kasvav järjestus). Siis sorteerimiseks eemaldatakse päis
element vahetades ta viimase elemendiga, lisatakse ta tagasi andmestruktuuri samale kohale kus ta oli kuhjas (ehk
viimasele) ning eemaldatakse kuhjast. Kuhi korrastatakse ja protsessi korratakse, lisades järgmise elemendi n-1 kohale.
Protsess lõppeb kuni pannakse indeksile 0 tagasi viimane element kuhjast ning kuhi kustutatakse. Andmestruktuur on nüüd
sorteeritud vastavalt soovitud sorteeringule.

## 6. Tunniülesanded

### Nädal 3

Kuna Hackerrank ei toeta C# uuemaid versioone kus on olemas PriorityQueue, siis ei saanud seda kasutada.

### Jesse and Cookies

Lihtne Priorityqueue kuhu kõik väärtused sisse panna, juhul kui esimene väärtus on suurem kui soovitud magusus siis
tagastad jooksva operatsioonide arvu alates 0st. Kui size on 1, siis tagastad -1. Juhul kui on võimalik liita, siis
lisad uue küpsise tagasi queuesse ning suurendad operatsioonide arvu

### Find the Running Median

Min/Max heapiga lahendatav ülesanne. Min heap tavaline PriorityQueue, Max heap reverseorderiga PriorityQueye. Kui listis
olev integer on suurem kui hetke mediaan, siis lisad minimumheapi, vastasel juhul maksimumi. Balanseerimiseks, kui ühe
heapi suurus on kahe võrra suurem, tuleb esimene element üle kanda teise heapi. Mediaani leidmiseks võtad suurima
elemendi arvudega heapist väärtuse. See toimib juhul kui on paarituarv listi liikmeid läbi käidud. Kui on paarisarv,
siis võetakse mõlema heapi esimene element ning jagatakse nende summa kahega läbi. Tagastatakse jooksva mediaani list.

### Fraudulent Activity Notifications

Pythoniga kõvasti lihtsam ja kiirem lahendada kuna omab list[start_index:end_index] funktsionaalsust. Eesmärk alustada
päevast kus on tekkinud piisavalt andmeid ning siis vaadata kas eelmiste päevade mediaan on suurem kui notificationi
saatmise piir. Vastavalt uuendada update väärtust, kustutada ära viimane andmekirje mediaani listsit ning lisada uus
kirje päevadest, juhul kui neid veel on. Lõpuks list läbi käies saab tulemuse.

### Nädal 4

### Luck Balance

Lihtne ülesanne, lihtsalt lisad kõik 0 importance contestid lõppsummasse, teised lisad uute listi. Juhul kui 1
importance võistlusi pole, tagastad lihtsalt lõppsumma. Juhul kui neid on vähem kui lubatud kaotusi, siis lisad kõik
lõppsummasse. Juhul kui neid on rohkem, siis sorteerid kahanevalt listi, võtad esimesed lubatud väärtused ning lisad nad
lõppsummasse, ning ülejäänud lahutad sellest lõppsummast.

Seda viimast osa oleks olnud veidi lihtsam teha pythonis sama nagu Fraudulent Activity Notificationites, aga tahtsin
testida funktsionaalsust ka C#s GetRange() näol.

### Largest Permutation

Siin oli vaja kasutada sõnaraamatut. Kõige olulisem on lisada kõik väärtused järjest sõnaraamatusse ning anda neile
asukohad sõnaraamatus. Seejärel tuleb alustada järjest kõige suurema elemendi lisamist esimeseks. Kuna alati on teada
suurim element läbi pikkuse on vaja leida ainult selle asukoht ning vahetada ära see n, n+1, n+2, ... asukohaga kuni
sobivad liigutused lõppevad. Sõnaraamat lihtsustab nende asukoha leidmist ilma et peaks kutsuma indeksi leidmise
funktsioone.

### Candies

Üpriski lihtne ülesanne. Tuleb luua uus list 1 väärtustega ning järjest mõlemat pidi läbi käia laste väärtused. Esimesel
korral kui järgnev laps omab suuremat väärtust, siis panna tema kommide väärtuseks eelmise lapse kommide väärtus + 1.
Tagasi tulles juhul kui eelneva lapse väärtus on väiksem kui järgneva, siis tuleb eelneva lapse väärtust suurendada.

Tagastada tuli Long, kuna osad tulemused olid suuremad kui 32-bit numbri väärtused oleks lubanud.

### Cutting Boards

Märkus: Olen õppinud füüsikat ja nüüd lõpetan informaatikat, aga selle ülesande kirjelduse arusaamiseks tunnen et pean
omama PhD tuumafüüsikas. Discussions õnneks aitas. Palun järgmine kord mitte selliste keerukate kirjeldustega ülesandeid
sisse panna.

Järjekordne Pythonile kohasem ülesanne. Eesmärk oli panna kõik lõiked kahanevasse järjekorda ning hakata sealt võtma
kõige kallemaid lõikeid esimesena kuna jättes need viimaseks, kulutavad need kõige rohkem. Eesmärk oli hoida mälus mitu
lõiget on vaja teha üle mitme tüki ning siis korrutada see lõike raskusega. Siis lihtsalt eemaldada lõiked vastava suuna
listist ning kuni kõik on lõigatud. Siis lihtsalt tagastada modulo % 10^9 + 7.

## 7. Koduülesanded

Valisin Orchestral Scores kuna oli arusaadavam kui teine ülesanne.

Esialgu proovisin Javaga nagu eelmine kord. Kahanevasse Priorityqueuesse kõik liikmed ning siis jaotasin nende vahel
esimese portsu instrumente ja siis jagasin esimest nii floor kui ceil operatsioonidega tagasi queuesse kuni kõik
jaotused olid kasutatud. Nagu tüüpiliselt Javale, see lahenduskäik oli liiga ajakulukas. uDebugi sõnul tootis see ka
valesid lahenusi ehk seekord proovisin C++ lahenduskäiku. uDebug andis hea vihje:

```
The key observation is, that it is easy to verify, whether and answer is suitable - 
simply iterate over all nodes and check, whether sum of 1+(A[i]-1)/Answer is lesser/equal to "p"
```

Eesmärk oli luua array kuhu mahuksid kõik liikmed ära ning nad sinna sisse salvestada, samaajal mäletades maksimumi.
Seejärel teha loop kus uuendatakse keskväärtus igakord. Selle keskväärtuse põhjal on võimalik vaadata kas on vaja
poolitada osasid bändiliikmeid. Selle põhjal saab lisada mitmekordsed poolitamised bändiliikmetele ning uuendada
maksimumi ning miinimumi. Juhul kui lõpuks miinimum ületab maksimumi, on teada et on jõutud edukalt kõik bändiliikmed
ära jaotada ning edasi pole võimalik inimesi jaotada. Siis tagastatakse output.