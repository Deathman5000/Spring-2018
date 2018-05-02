*                                                                    *
* a program showing a simple loop using BC and Mask.
* It displays 3,2,1, and then 'blast off' as output
*                                                                    *
**********************************************************************
         TITLE 'Author: R Alex Version: 2/10/18'
ASM2     START 0            ;first line of the program
         PRINT NOGEN        ; suppresses expansion of macros used
         BASR 15,0          ; This and next are required
         USING *,15
**********************************************************************
* The first five lines and the last line together is
*  boilerplate code, the label from first line is needed in
* the last line.
* BASR 15,0 says GR15 holds the address of BEGIN statement
* USING statement tells GR15 is the base register. That is,
* BASR and USING statements established GR15 as the base register
* which has the address of the statement with label BEGIN
**********************************************************************
BEGIN    L 2,N              ;load GR2 with value of N
LOOP     ST 2,COUNT         ;store GR2 into count
         PRINTOUT COUNT,Header=NO   ;display COUNT
         S 2,ONE            ;subtract 1 from GR2
         C 2,ZERO           ;compare GR2 and content of ZERO
         BC B'0010',LOOP    ;branch if GR2 > ZERO to LOOP
         PRINTOUT MYMSG,Header=NO ;if BC false display MYMSG
         PRINTOUT *,Header=NO  ; terminate quietly
**********************************************************************
* please note that PRINTOUT *,Header=NO is to terminate the program
* and is required in every program.
**********************************************************************
MYMSG    DC C'BLAST OFF'
N        DC F'3'
ONE      DC F'1'
ZERO     DC F'0'
COUNT    DS F
         END ASM2