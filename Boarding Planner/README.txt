TEMA 1
BUCUR CALIN-ANDREI

Am implementat tema folosind 6 clase.
In toate cel 6 clase am incercat pe cat posibil sa am datele private

Clasa PriorityQueue este main class. Metoda main am impartit-o in 2 metode.
Prima citeste toate persoanele si le pune intr-un array gata de a fi inserate in heap.
A doua citeste comezile si le executa corespunzator.

Clasa Heap implementeaza coada de prioritate printr-un heap.
Heap-ul este implementat prin vector.
Clasa contine metodele cerute: insert, embark, list, delete si alte metode auxiliare cum ar fi:
-Constructor
-Metoda ce gaseste parintele/ copiii
-Metoda ce verifica daca un nod e frunza
-Metoda de interschimbare noduri
-Metoda de rearanjare heap
-Metoda de parcurgere in pre-ordine

Clasa abstracta Passenger reprezinta toate tipurile de pasageri
Contine metoda abstracta care calculeaza prioritatea.
Din ea deriva clasa fiecarui pasager si anume: Single, Group si Family.

Clasa Single contine toata informatia aferenta unei persoane.
Suprascrie metoda de calcul a prioritatii.

Clasele Group si Family sunt asemanatoare.
Ele contin un array de Single.
Prioritatea lor este calculata folosind metoda definita in Single

TEMA RULEAZA PERFECT LOCAL, DAR NU SI PE VMCHECKER.
NU AM REUSIT SA GASESC O SOLUTIE.
VA ROG TESTATI LOCAL TEMA.