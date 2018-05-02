***************************************************************  *
*                                                                *
*  PROGRAM TO FIND THE number of steps needed to reduce an input *
*  number to 1 using the rules                                   *
*  Rule 1: if the number is odd replace it with 3*mumber + 1     *
*  Rule 2: if the number is even divide it by 2 and replace it   *
*                                                                *
**************************************************************** *
         TITLE 'Author: R Alex Version: 3/21/16'
HW6      START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
         READCARD CARDOUT
         CONVERTI 5,N      GR5 = N
         XR 1,1            GR1 = 0
         LR 7,5            GR7 = N

LOOP     XR 9,9            GR9 = 0
         C 5,=F'1'         TEST IS GR5 == 1
         BE FIN
         LR 8,5            GR8 = GR5
         SRDL 8,1          DIVIDE GR8 BY 2
         C 9,=F'0'         IS GR8 EVEN
         BE NLOOP
         LR 2,5
         AR 5,5
         AR 5,2            GR5 = 3*GR5
         A 5,=F'1'         ADD 1 TO GR5
         A 1,=F'1'         ADD 1 TO COUNT
         B LOOP

NLOOP    LR 5,8            GR5 = GR5/2
         A 1,=F'1'         ADD 1 TO COUNT
         B LOOP
FIN      CONVERTO 1,NTH    CONVERT COUNT FOR DISPLAY
LAST     PRINTOUT OUTPUT,*,HEADER=NO
*
CARDOUT  DC 0CL80' '
N        DS CL5
FILL     DS CL75
OUTPUT   DC 0CL28
FI       DC C'NUMBER OF STEPS '
NTH      DS CL12
         END HW6