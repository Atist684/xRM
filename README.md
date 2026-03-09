
## Útmutató:
* A repository már tartalmazza a lefordított Angular és Spring-Boot állományokat, ezért fordítani nem kell.

* Amennyiben mégis szükséges az újra buildelés akkor azt a "frontend" mappában az "ng build" paranccsal a "backend" mappában a 
"mvnw.cmd package -f ./pom.xml" paranccsal lehetséges. (Feltételezve, hogy az Angulárhoz szükséges node és node modulok valamint a Spring-Boothoz szükséges JDK már telepítve van)

* Az indítás a "docker-compose up" paranccsal történik. A leálítás a "docker-compose down" paranccsal lehetséges.

## Arhitektúra:
- Három különálló egységre bontható az anguálárra, az adatbázisra és a springre
- Mindhárom egy-egy docker containerben fut.
- A containerek egy közös hálózatra kapcsolódnak.
- "kintről" (a dockeren kívülről) csak a 80-as port érhető el.
- A a DB <--> backend <--> nginx kommunikáció a belsőhálózaton történik.

## Technológia
-   OpenAPI-t
    * A gyors api fejelsztés miatt választottam. Segítettette a frontend és backend közti típus biztonságot. Továbbá a szükséges DTO fájloakt is létrehozta.
-   Material Design
    * Korábban már volt vele tapasztalatom, az Angulár keretrendszerhez jól illeszkedik.
-   Security
    * Mivel az authentikáció és authorizácó nem volt szempont ezért nem került implementálásra.
-   Angular
    * A projekt mérete alapján az angulár web kiszolgálása megvalósítható lett volna a springben is, de úgy gondolom, hogy a leválasztás egy jobban átlátható és skálázhatóbb megoldást biztosít, ezért az angulárt külön konténerben egy nginx szolgálja ki.
    * A projekt mérete nem indokolta az SSR használatát, ezért maradtam a kliens oldali renderelésen.
    * Az adatokat (partner/tevékenység/...) a service rétegben signalokban tároltam, hogy a különböző komponensek együtt tudjanak működni.

## Kompromisszumok
-   DTO <--> Entity
    * Érdemes lett volna használni egy DTO<-->Entity mapper lib-et. Az idő rövidsége miatt ezt megtalálni, megérteni és magbiztosan használni nem volt idő. Ezért saját mappert írtam.
-   Absztrakció/Boilerplate
    * Kevés absztrakció valósúlt meg. Gyakori a kód ismétlés. Alaposabb tervezéssel átláthatóbb kód készíthető.
-   Design
    * A desgin-ra nem jutott idő. 
-   API
    * Az API dokumentációja elmaradtt.
    * Pagination és rendezés nincs
