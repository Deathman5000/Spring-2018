***********************************************************************
*   THIS PROGRAM CONVERTS A CELSIUS TO FAHRENHEIT TEMP AND
*   A FAHRENHEIT TO CELSIUS TEMP. INPUT VARIABLES
*   ARE STORED AS DC VARIABLES AND OUTPUT USING PRINTOUT
*   NOTE PRINTOUT USES 16-31 TO REPRSENT 64-BIT REGISTER GG0-GG15
*   AND 32-64 TO REPRESENT FP0-FP15
***********************************************************************
         TITLE 'Author R Alex  Version: 4/20/18'
ASMFP1   START 0            FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0          ESTABLISH A BASE REGISTER
         USING *,15         INFORM THE ASSEMBLER
CONV1    LE 2,CEL           FPER1 = CEL
         LE 3,=E'9.0'       FPER3 = 9.0
         DE 3,=E'5.0'       FPER3 = 9.0/5.0
*         STE 3,FAR
*         PRINTOUT FAR,35    THE MACRO USES 35 TO REPRESENT FP3
         MER 2,3            FPER2 = CEL*9.0/5.0
*         STE 2,FAR
*         PRINTOUT FAR,34    THE MACRO USES 35 TO REPRESENT FP2
         LE 4,=E'32.0'      FPER4 = 32.0
         AER 2,4            FPER2 = CEL*9.0/5.0 + 32.0
         STE 2,FAR
         PRINTOUT FAR,34,HEADER=NO
CONV2    LE 2,FH            FPER2 = FH
         SER 2,4            FPER2 = FH-32.0
         ME 2,=E'5.0'       FPER2 = (FH-32.0)*5.0
         DE 2,=E'9.0'       FPER2 = (FH-32.0)*5.0/9.0
         STE 2,CL
         PRINTOUT CL,34,HEADER=NO
STOP     PRINTOUT *,Header=NO     it's all over here

CEL      DC E'20.0'
FAR      DS E
FH       DC E'70.0'
CL       DS E
         END ASMFP1