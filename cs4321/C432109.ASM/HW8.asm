**********************************************************************
*    An assembler program to find the last ten primes of to a number.
**********************************************************************
         TITLE 'Author: James Hund Version: 4/19/16'
HW8      START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
BEGIN    READCARD CARDOUT   READ A LINE
         CONVERTI 9,NUM
         ST 9,NUMCPY
         L 1,COUNT
LOOP     SR 5,5            ;this checks if it is prime
         L 4,NUMCPY
         C 4,=F'3'
         BE PRIME
         C 4,=F'2'
         BE PRIME
         SRDA 4,1
         C 5,=F'0'
         BE NOTPRIME
         L 9,NUMCPY
         ST 9,PRIMECT
         B  CONTINUE
CONTINUE SR 5,5            ;if passes first test it come here
         L 4,NUMCPY       ;for further testing to see if prime
         SRDL 4,32
         L 6,DIVISOR
         D 4,DIVISOR
         A 6,=F'1'
         ST 6,DIVISOR
         C 4,=F'0'
         BE NOTPRIME
         C 6,PRIMECT
         BE PRIME
         BL CONTINUE
NOTPRIME L 4,NUMCPY
         S 4,=F'1'
         ST 4,NUMCPY
         L 14,=F'3'
         ST 14,DIVISOR
         B LOOP
PRIME    L 4,NUMCPY
         L 12,POS
         ST 4,PRIMEAR(12)
         A 12,=F'4'
         ST 12,POS
         S 4,=F'1'
         ST 4,NUMCPY
         L 1,COUNT
         A 1,=F'1'
         ST 1,COUNT
         L 14,=F'3'
         ST 14,DIVISOR
         C 1,=F'10'
         BL LOOP
         L 12,POS
         L 1,=F'0'
         ST 1,COUNT
PLOOP    S 12,=F'4'
         L 4,PRIMEAR(12)
         PRINTOUT 4,HEADER=NO
         A 1,=F'1'
         C 1,=F'10'
         BL PLOOP
         PRINTOUT *,HEADER=NO


*
CARDOUT  DC 0CL80' '
NUM      DS CL10
*NUM     DC F'29'
FILL    DS CL70
PRIMECT DS F
COUNT   DC F'0'
COPY    DC F'0'
DIVISOR DC F'3'
NUMCPY  DC F'0'
POS     DC F'0'
PRIMEAR DC F'0,0,0,0,0,0,0,0,0,0'
*

        END HW8