/* REXX */
/* THIS PROGRAM TAKES THE SUM OF ALL N EVENS AND THE SUM OF ALL N ODDS.
   AUTHOR: JAMES HUND
   VERSION: 03/05/18
*/

SAY 'ENTER A NUMBER'
PULL N
EVEN = 0
ODD = 0

IF N >= 0 THEN DO
   COPY = N
   DO WHILE COPY >= 0
      IF COPY//2 = 0 THEN
         EVEN = EVEN + COPY
      IF COPY//2 = 1 THEN
         ODD = ODD + COPY
      COPY = COPY - 1
   END
   SAY 'THE EVEN SUM IS '||EVEN
   SAY 'THE ODD SUM IS ' ||ODD
END