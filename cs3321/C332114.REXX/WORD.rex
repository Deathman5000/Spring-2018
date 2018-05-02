/*REXX*/
/* This script will allow the user to enter a word
   and display the occurrence of each letter in the word
   author: rajan alex
   version: 03/22/18
*/
CLRSCN
PARSE ARG A
SAY 'ENTER A WORD'
PULL MESSAGE
IF DATATYPE(A) == 'CHAR' THEN
   MESSAGE = A
/*
PARSE ARG STR
MESSAGE = STR
*/
N = LENGTH(MESSAGE)
COUNT. = 0   /* TELLS REXX COUNT IS A STEM INITIALIZED TO UNKNOWN */
LETTER. = 0
J = 0
DO I = 1 TO N BY 1
  X = SUBSTR(MESSAGE,I,1)
  IF COUNT.X = 0 THEN DO
     COUNT.X = 1
     COUNT.0 = COUNT.0 + 1
     J = J + 1
     LETTER.J = X
  END
  ELSE
     COUNT.X = COUNT.X + 1
END
DO I = 1 TO COUNT.0 BY 1
 X = LETTER.I
 SAY X COUNT.X
END
DROP COUNT. LETTER.
EXIT