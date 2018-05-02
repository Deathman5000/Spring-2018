****************************************************************
*                                                              *
*  A PROGRAM TO OUTPUT AIN+ONE and MYNAME                      *
*                                                              *
****************************************************************
         TITLE 'AUTHOR: JAMES HUND VERSION: 02/12/18'
ASM1     START 0            FIRST LINE OF THE PROGRAM AND LABEL ASM1
         PRINT NOGEN        SUPRESS MACRO EXPANSION
*        SAMPLE PROGRAM
         BASR 15,0          ESTABLISH A BASE REGISTER AND
         USING *,15         INFORM THE ASSEMBLER
*
BEGIN    L 2,AIN            LOAD GR2 CONTENT OF AIN
         A 2,ONE            ADD ONE CONTENT TO GR2 AND SAVE IN GR2
         ST 2,AIN           STORE GR2 INTO AIN
         PRINTOUT AIN,MYNAME,* ;DISPLAY AIN, MYNAME AND TERMINATE
*
MYNAME   DC C'JAMES HUND, WELCOME TO ASSEMBLER PROGRAMMING'
AIN      DC F'8'
ONE      DC F'1'
         END ASM1