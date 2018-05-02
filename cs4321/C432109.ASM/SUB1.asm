**********************************************************************
*    THE PROGRAM WILL ADD TWO NUMBER USING A MACRO ADD2
*    THE PROGRAM WILL PASS TWO NUMBERS IN GR3, GR4 AND
*    RETURN GR2 = GR3 + GR4
*    THIS DATASET: C432100.ASM(SUB1)
*    MACRO DATASET: C432100.MACROLIB(ADD2)
**********************************************************************
         TITLE 'Author: James Hund Version:4/16/18'
SUB1     START 0              FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0            ESTABLISH A BASE REGISTER
         USING *,15           INFORM THE ASSEMBLER
*
BEGIN    L 3,X
         L 4,Y
L1       ADD2 2,3,4           CALLING THE MACRO ADD2
         ST 2,RESULT
         PRINTOUT RESULT,HEADER=NO
END      PRINTOUT *,Header=NO TERMINATE PROGRAM
*
X        DC F'123'
Y        DC F'12'
RESULT   DS F
         END SUB1