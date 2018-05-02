**********************************************************************
*    SUM 3 INTEGERS FROM FILE C4321XX.TEXT(SOMEDATA)
*    DATA RECORD FORMAT
*    DESCRIPTION     COLUMN     LENGTH
*    FIRST NUMBER    1          4
*    SECOND NUMBER   5          4
*    THIRD NUMBER    9          4
*    FILLER         13          68
*    EACH DATA RECORD HAS LENGTH 80 AND THERE ARE 8 RECORDS
**********************************************************************
         TITLE 'Author: James Hund Version: 3/26/16'
SUMINT   START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
         SR 6,6             SET R6  TO 0
LOOP     READCARD CARDOUT   READ A LINE
         CONVERTI 2,X1      EXTRACT THE FIRST NUMBER INTO R2
         CONVERTI 3,X2      EXTRACT SECOND NUMBER INTO R3
         LR 4,2
         AR 4,3             R4 = R4+R3
         CONVERTI 5,X3      EXTRACT THIRD NUMBER INTO R5
         AR 4,5             R4 = R4+R5
         CONVERTO 2,XOUT    CONVERT R2 TO A CHAR STRING, STORE AT XOUT
         CONVERTO 3,YOUT    CONVERT R3 TO A CHAR STRING, STORE AT YOUT
         CONVERTO 5,ZOUT    CONVERT R5 TO A CHAR STRING, STORE AT ZOUT
         CONVERTO 4,SOUT    CONVERT R4 TO A CHAR STRING, STORE AT SOUT
         PRINTOUT OUT,HEADER=NO    DISPLAY OUTPUT
*         PRINTLIN SUMOF
         A 6,=F'1'
         C 6,=F'8'
         BL LOOP            GO TO LOOP TO READ NEXT LINE
         PRINTOUT *,HEADER=NO
CARDOUT  DC 0CL80' '
X1       DS CL4
X2       DS CL4
X3       DS CL4
FILL     DS CL68
OUT    DC 0CL57
XOUT     DS CL12
         DC C' + '
YOUT     DS CL12
         DC C' + '
ZOUT     DS CL12
EQ       DC C' = '
SOUT     DS CL12
         END   SUMINT