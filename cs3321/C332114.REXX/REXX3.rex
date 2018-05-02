/* REXX */
/* THIS PROGRAM DETERMINES IF A NUMBER IS PRIME AND DISPLAYS 10
        ON A LINE.
   AUTHOR: JAMES HUND
   VERSION: 02/28/18
*/

CLRSN   /*CLEARS THE SCREEN ON EXECUTION*/
SAY 'ENTER A NUMBER'
PULL N

IF N >=0 THEN DO
   COUNT = 0
   ST = ''
   DO I = 2 TO N
      FLAG = 0
      DO J = 2 TO I-1
         IF I//J = 0 THEN DO
            FLAG = 1
            LEAVE
         END
      END J
      IF FLAG = 0 THEN DO
         ST = ST || I || ' '
         COUNT = COUNT + 1
      END
      IF COUNT >= 10 THEN DO
         SAY ST
         ST = ''
         COUNT = 0
      END
   END I
   IF COUNT > 0 THEN
      SAY ST
END
ELSE
   SAY 'YOU ENTERED A NON-PRIME NUMBER'
EXIT