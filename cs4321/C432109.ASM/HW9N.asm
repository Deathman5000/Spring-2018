***********************************************************************
*                                                                     *
* A SIMPLE CALCULATOR PROGRAM, INPUT DATASET                          *
* C4321XX.TEXT(HW9NIN), XX is the last two digit of your user-id.     *
* THE PROGRAM WILL USE THE SUBROUTINE C4321XX.MACROLIB(LAB9SUB)       *
* THE CALLING PROGRAM MUST PASS THE BEGINNING ADDRESS OF              *
* FOUR CONSECUTIVE WORDS IN GR1. FIRST WORD IS OPERAND 1, SECOND WORD *
* IS OPERAND 2, THIRD WORD IS OPERATION SYMBOL. THE SUBROUTINE        *
* WILL PLACE THE RESULT OF THE OPERATION IN THE FOURTH WORD.          *
*                                                                     *
***********************************************************************
         TITLE 'Author: R Alex Version: 4/15/18'
HW9N     START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
         L 10,=F'0'
LOOP     READCARD CARDOUT   READ A RECORD
         CONVERTI 2,AIN
         CONVERTI 4,BIN
         XR 1,1
         IC 1,OPIN
         ST 2,A             STORE FIRST OPERAND IN A
         ST 4,B             STORE SECOND OPERAND IN B
         ST 1,OP            STORE OPERATOR IN OP
         LA 1,A             PREPARE TO MAKE SUBROUTINE CALL
         LAB9SUB 1          CALL LAB9SUB
         L 2,0(0,1)         PREPARE TO PRINTOUT
         CONVERTO 2,AOUT
         L 5,8(0,1)
         STCM 5,B'0001',SIGN
         L 3,4(0,1)
         CONVERTO 3,BOUT
         L 2,12(0,1)
         CONVERTO 2,COUT
         PRINTOUT OUTPUT,HEADER=NO
         L 2,16(0,1)         PREPARE TO INCREMENT COUNTER
         A 2,=F'1'
         C 2,=F'5'           IF COUNT IS < 5 BRANCH TO LOOP
         BL LOOP
FINISH   PRINTOUT *,HEADER=NO
*
A        DS F                STORE FIRST OPERAND
B        DS F                STORE SECOND OPERAND
OP       DS F                STORE OPERATOR +, -, / OR *
ANS      DS F                STORE RESULT
COUNT    DC F'0'             A COUNTER VARIABLE
*
CARDOUT  DC 0CL80            USED TO READ INPUT 8O CHARS
AIN      DS CL8
BIN      DS CL8
FL       DS CL7
OPIN     DS C
FILL     DS CL56
*
OUTPUT   DC 0CL44            DISPLAY RECORD
AOUT     DS CL12             FIRST OPERAND
S1       DC 3C' '            SPACES
SIGN     DC C' '             OPERATOR
BOUT     DS CL12             SECOND OPERAND
S2       DC 3C' '            SPACES
S3       DC C'='             EQUAL SYMBOL
COUT     DS CL12             RESULT
         END HW9N