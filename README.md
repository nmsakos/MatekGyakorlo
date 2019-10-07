# Matek gyakorló feladatsor generátor

Ezzel az alkalmazással matematika gyakorló feladatokat generálhatsz. A feladatok az áltlános iskola alsó tagozatos tanulóinak ideális. 

A generált műveletek: Összeadás, kivonás, szorzás, osztás

A program futtatásához az alábbi példa parancs használható:

`java -jar MatekGyakorlo.jar muveletekSzama=10 szamkor=100 kimenet=FILE muveletek=+-*:`

Futtatáshoz `java11` szükséges.

## A program paraméterei:
| Paraméter | Leírás | Lehetséges értékek |
|---|---|---|
| `muveletekSzama` | Megadja, hogy az egyes művelet fajtákból hány darab legyen | pozitív egész szám (alapértelmezett: `10`)|
| `szamkor` | Milyen számkőrben legyenek a műveletek eredményei. Összeadás, kivonásra igaz. Szorzás, osztás jelenleg legfeljebb 10 es szozót gyakoroltatja. | Pozitív egész szám (alapértelmezett: `100`)|
| `kimenet` | Megadja, hogy hol jelenjen meg a program kimenete | `FILE` esetén `muveletek.txt` fájlba íródik az eredmény, `CONSOLE` esetén pedig a konzolra  (alapértelmezett: `FILE`)|
| `muveletek` | Milyen műveleteket generáljon a progam | Egy jelsorozat mely tartamazz legalább egyet a műveletek közül (lásd Müveletek táblázat)(alapértemezett: `+-*:`)

## Műveletek
| Jel | Megnevezés |
|---|---|
| `+` | Összeadás |
| `-` | Kivonás |
| `*` | Szorzás |
| `:` | Osztás |
