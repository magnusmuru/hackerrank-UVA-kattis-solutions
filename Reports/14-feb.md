# 14. Veebruar

Osaliselt inglise keeles kuna eelmise nädala omas oli ta mul inglise keeles ning ei jäänud aega kirjutada ümber seda.

## 1. ArrayList vs Linkedlist

Arraylist on suurust muutev array, mis põhineb enamasti array tüübil. Suuruse muutmiseks tuleb teha taustal uus array
kuhu uued objektid lisada.

Linkedlist on järjestikune list kus andmed on seotud nodedega. Igale nodele järgneb uus node ning andmete sisestamiseks
tuleb lihtsalt muuta seos kahe bloki vahel.

Suurim erinevus on erinevata operatsioonide tegemise kiirus. ArrayListi päring on O(1) keerukusega, samas kui
sisestamine ja kustutamine on O(n). Linkedlistil samas päring O(n) ja sisestamine ja kustutamine O(1). Arraylist on väga
hea andmete lugemiseks, kuna ei nõua palju aega, et leida sobivat infot. Samas Linkedlisti eelis on see, kuna ta on
linkitu nodedest, siis sinna uute andmete sisestamine (nt kahe node vahele) või eemaldamine on kordades kiire. See on
selletõttu, et arraylistis oleks vaja vahele pannes või eemaldades liigutada kõigi listi väärtuste mälus olevaid
aadresse edasi või tagasi.

## 2. Queue vs Stack

Stack on andmestruktuur kuhu viimasena sisenenud andmed lahkuvad sealt esimesena. Ehk kui sinna stackida numbrid {1,2,3}
antud järjestuses oleks esimene .Pop() tagastanud sellest numbri 3, siis 2 ja siis alles 1.

Queue on andmestruktuur kuhu esimesena sisenenud andmed lahkuvad sealt esimesena. Ehk kui sinna stackida numbrid {1,2,3}
antud järjestuses oleks esimene .Dequeue() tagastanud sellest numbri 1, siis 2 ja siis alles 3.

Mõlemad andmestruktuurid jagavad enamasti Peek() funktsiooni mis võimaldab vaadata esimesena lahkuvat elementi selles,
ilma et seda peaks välja viskama.

## 3. Hinda keerukust

```int find_c(int n)
  int i,j,c
  for(i=0; i < 3*n; i++)
    for(j=n; j < n*n; j++)
      c++
  for(i=c; i > 0; i--)
    if(even(random(0...999)))
      for(j=0; j < 3*n; j++)
        c++
    else
      for(j=n; j < n*n; j *= 3)
        c++
  return c
```

Esimene tsükkel:

```
for(i=0; i < 3*n; i++)
    for(j=n; j < n*n; j++)
        c++
```

Keerukus sisemisel loopil on O(n), kuna alustame juba n-ist, käime tsükli läbi n korda. Välimine tsükkel on ka O(3*n)
ning kuna kordajat ei vaadata O keerukuse arvutamisel, siis tsükli keerukus on O(n^2)

Teine tsükkel:

```
for(i=c; i > 0; i--)
    if(even(random(0...999)))
      for(j=0; j < 3*n; j++)
        c++
    else
      for(j=n; j < n*n; j *= 3)
        c++
```

Sisemise tsükli keerukus on juhuslikult valitud, ehk tuleks vaadata kehvima juhu tulemit. Kuigi alumine esimesel pilgul
tundub O(n^2), siis tsükkel käiakse läbi 3 korda kiiremini j *= 3 tõttu. Ehk see on O(log n). Teine on samas tavaline O(
n)
funktsioon nagu ka eelmises loopis. Välimine tsükkel on sõltuv eelmisest suurest tsüklist ning kuna c on vaadeldav kui n
siin juhul siis on tsükli keerukus ka O(n). Kokku O(n^2).

Tsüklite sõltuvuse tõttu on nad omavahel seoses, ehk nende keerukus tulebk kokku arvutada omavahel korrutades. Ehk: O(
n^2) * O(n^2) = O(n^4)

Tsükli keerukus: O(n^4)

### 4. Miks binaarotsingul võrdleme just keskmise elemendiga?

See võimaldab välistada koheselt pooled elemendid või leida kohe õige vastuse. Kui keskmine element peale sorteerimist
on vastus, siis saab koheselt otsingu lõpetada. Kui mitte, siis saab välistada pooled elemendid otsingust, ning jätkata
ülejäänud sobiva poolega. Seda protsessi saab jätkata kuni sobiv element leitakse, võttes jälle keskmise väärtuse
järelejäänud pooltest ning poolitades edasi nagu varasemalt kirjeldatud.

## 5. Tunniülesanded

### Insert a node at a specific position in a linked list

Reference: https://www.geeksforgeeks.org/insert-a-node-at-a-specific-position-in-a-linked-list/

Used above article as a good reference point for the task. Overall quite a simple task that can be used for the other
tasks that come later.

Since position is given at start then first check should be for a new head of the list. Just a quick if block to check
for `pos == 0`. After that just loop through the whole linkedlist one by one, updating the head each time you swap to a
new link and then setting the new node as the next for the previous node and the head for the tail of the list if there
is one.

### Reverse a linked list

Reference: https://www.geeksforgeeks.org/reverse-a-linked-list/

Another article from GeeksforGeeks again, though not really necessary. Just speeds up the writing process.

In essence, it is similar to the last task but just requires to loop through the whole linkedlist. Start by finding the
head and checking the next node, then reference the original node to null as it would be the end of the loop. From there
you can just move on to referencing the second node to the first and so forth until you end on the original lists end
node. There just reference it to the second to last node and put it as the new head of the linkedlist. Now the list is
in reverse.

### Reverse a doubly linked list

Reference: https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/

Same as before. In here just on linking need to make sure that we link up both sides. So we give the node we previously
linked back to being the next in line to have a head of the node we are currently working on. Not much to say compared
to the single linked list just an extra step. Null endpoints don't get linked back to nodes since they are well, null.

### Cycle Detection

No reference here. Done originally on Java, but I also saw it had a working C# template, so I also did that. Allowed for
some null safe checks to reduce the if statement overhead. Simply just use a high performance data structure with O(1)
search speeds such as a HashSet. Add all the already visited nodes into it and compare if a similar node shows up. This
result is really fast due to Java/C# saving a memory pointer to the object rather than the object itself. Just loop
through the whole list, look for nodes that show up again, if it does, return true, else just let the loop run to
conclusion and return false. Also check for null loops.

### Sparse Arrays

The best exercise yet. I had a blast with this, it was such a joy to write in C#. Java would have required some
streaming and other stuff. With C# just make a new List, count all the occurrences of the query string in the string
list and add them to the new list. Simple 4 lines of code.

### Maximum Element

Lihtne ülesanne, mis vajas natukene lisalahendusi, et HackerRanki compilerist läbi saada. Mälus tasub hoida praegust
maximumi igal hetkel. Siis saab pärimise kordades kiiremaks ja ei tule timeout. C# switch lahendus operatsiooni jaoks
ning output Listi kõik max stackis oleva objekti pärimised. Queue.Max() pärimist üritasin limiteerida, et saada
võimalikult palju aega kokku säästa.

### Queue using Two Stacks

Põhimõtteliselt 1:1 sarnane eelmise probleemiga, ainult maximumi pole vaja hoida ning salvestada Queue pealmised numbrid
Listi Queue.Peek() funktsiooniga. Sama lahendus, lihtsalt lühem.

### Balanced brackets

Algselt üritasin lihtsalt .Count kui on sama arv bracketeid, aga sain ülesande sisust valesti aru. Tasub lihtsalt
eemaldada bracketite paare (ehk '[]' '()' '{}') kuni sisendstringi length enam ei muutu. Siis kontrollida kas pikkus on
0, ja tagastada vastav lahendusväärtus returniga.

### Equal Stacks

Lemmikülesanne. Võttis kõige rohkem pusimist. Kõige lihtsam lahendus siin on panna iga stacki kõrgused (ehk selle hetke
blokkide summa) järjest blokke eemaldades uude listi. Siis leida nende kolme listi vahel .Intersect() (funktsioon mis
leiab ühised arvud) ning tagastada neist esimene. Hästi lihtne lahendus mis võttis omajagu optimeerimist, et kirjutada
nii puhtalt.

## 6. Koduülesanded

Out of the two exercises I picked UVA-12192 Grapevine. Currently, I got it to work with the example provided in the pdf
but I am going over the 3s time limit. I first created a data structure that would ingest and hold the problems that
would come in with the solution. Took a while to figure out what was necessary to get the Runtime errors to stop in
UVA (turns out its the public in Main). After that I just made a way to loop through the whole list of items and check
for the largest boxes. This is causing the solution to run way too long, and I didn't have much idea how to optimize
this.

I have recently realized I should be checking diagonally instead of everything to save massive time, and I will try to
finish it still today before midnight. Usually I loop over the whole data since I would be accessing a database to find
items where there would not be any discernible patterns such as this exercise provides.

Uuendus: Veebruar 14. Sain lahenduskäigu toimima korrektselt uDebug sisendiga, outputid olid võrdsed. Aga Java on liiga
aeglane. Implementeerida C++ga oleks võimalik kiiremini ning üks C++ lahendust kasutasin inspiratsiooniks.

Lahendus ise: Tuleb kontrollida reas kas on midagi mis on üle alumise päringu ning kontrollida kas diagonaalis vastavalt
sellega liikudes on väärtus päringu suuruste vahel. Suurima diagonaali puhul tagastada. Kiire escape kirjutada ka siis
kui suurim diagonaal ületab järelejäänud ridade arvu, ehk vähendada otsimist kui juba maksimaalne diagonaal on leitud.