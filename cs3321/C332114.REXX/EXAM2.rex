/*REXX*/
/* This program takes input from a JCL file and will get the ratio
   of letters to length of the individual words.

   Author: James Hund
   Version: 04/18/18
*/

WORD. = 0
DO K = 1 TO 10
   PULL ST
   ST= STRIP(ST)
   WORD.1=ST
   N = LENGTH(ST)
   COUNT. = 0
   LETTER. = 0
   J = 0
   DO I = 1 TO N BY 1
      X = SUBSTR(ST,I,1)
      IF COUNT.X = 0 THEN DO
         COUNT.X = 1
         COUNT.0 = COUNT.0 + 1
         J = J + 1
         LETTER.J = X
      END
   END
   LETTERS = COUNT.0
   RATIO = N/LETTERS
   SAY LEFT('THE RATIO FOR '||WORD.1||' IS:',33)||FORMAT(RATIO,4,2)
   WORD. = 0
END
DROP COUNT. LETTER. WORD.