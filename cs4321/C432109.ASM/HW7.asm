**********************************************************************
*    An assembler program to find if the number at the end of
*    a fibinachi sequences is prime or not.
**********************************************************************
         TITLE 'Author: James Hund Version: 4/06/16'
HW7      START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
BEGIN    READCARD CARDOUT   READ A LINE
         CONVERTI 9,NUM
         ST 9,NUMCPY
         L 1,COUNT
         L 6,PRENUM
         L 1,COUNT
LOOP     L 4,NEXTNUM        ;this loop finds the last number
         ST 4,COPY
         A 4,PRENUM
         ST 4,NEXTNUM
         L  6,COPY
         ST 6,PRENUM
         A 1,=F'1'
         ST 1,COUNT
         CR  1,9
         BE DONE
         BL LOOP
DONE     SR 5,5            ;this checks if it is prime
         L 4,NEXTNUM
         SRDA 4,1
         C 5,=F'0'
         BE NOTPRIME
         L 9,NEXTNUM
         ST 9,PRIMECT
         B  CONTINUE
CONTINUE SR 5,5            ;if passes first test it come here
         L 4,NEXTNUM       ;for further testing to see if prime
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
NOTPRIME L 4,NEXTNUM
         L 9,NUMCPY
         CONVERTO 9,NTH
         CONVERTO 4,FIBOUT
         CONVERTO 4,NPNUM
         PRINTOUT OUTPUT,HEADER=NO
         PRINTOUT NP,*,HEADER=NO
PRIME    L 4,NEXTNUM
         L 9,NUMCPY
         CONVERTO 9,NTH
         CONVERTO 4,FIBOUT
         CONVERTO 4,ISPNUM
         PRINTOUT OUTPUT,HEADER=NO
         PRINTOUT ISP,*,HEADER=NO

*
CARDOUT  DC 0CL80' '
NUM     DS CL5
FILL    DS CL75
PRIMECT DS F
COUNT   DC F'2'
NEXTNUM DC F'1'
PRENUM  DC F'1'
COPY    DC F'0'
DIVISOR DC F'3'
NUMCPY  DC F'0'
*
OUTPUT  DC 0CL31
FIBO    DC C'FIB '
NTH     DS CL12
EQ      DC C' = '
FIBOUT  DS CL12
*
NP      DC 0CL25
NPNUM   DS CL12
NOPRIME DC C' IS NOT PRIME'
*
ISP     DC 0CL21
ISPNUM  DS CL12
ISPRIME DC C' IS PRIME'
        END HW7