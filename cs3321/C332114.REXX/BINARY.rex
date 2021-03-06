/* REXX */
/* THIS PROGRAM TAKES A NUMBER AND CONVERTS IT TO BINARY.
   FILE: C332114.REXX(DECTOBIN)
   AUTHOR: JAMES HUND
   VERSION: 03/28/18
*/

CLRSCN
PARSE UPPER ARG A
SAY 'ENTER A NUMBER'
PULL N
IF DATATYPE(A) = 'NUM' THEN   /* NUM FOR NUMBER OR CHAR FOR CHARACTER*/
   N = A
S = BINARY(N)
SAY 'BINARY REPRESENTATION IS ' || S
EXIT

/* FUNCTION DEFINITION */
BINARY:
ST=''
DO WHILE N > 0
   ST = ST ||(N//2)
   N = N % 2
END
RETURN REVERSE(ST)