/*REXX*/
/*
   A PROGRAM THAT WILL LIST OFF THE PRIME NUMBERS BETWEEN
   A LOW VALUE AND A HIGH VALUE.
   AUTHOR: JAMES HUND
   VERSION: 04/04/18
*/

CLRSCN
PARSE ARG A ',' B
SAY 'ENTER YOUR LOWER AND UPPER BOUNDS FOR THE PRIMES'
PULL N
PULL M
IF DATATYPE(A) == 'NUM' THEN
   N = A
IF DATATYPE(A) == 'NUM' THEN
   M = B

IF N >=0 THEN DO
   COUNT = 0
   ST = ''
   IF N <= 1 THEN
      N = 2
   DO I = N TO M
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
EXIT