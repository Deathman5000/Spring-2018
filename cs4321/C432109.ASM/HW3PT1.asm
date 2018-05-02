*                                                                    *
* A program taking an array and summing the contents.
* It displays the numbers in the array and the sum as output
*                                                                    *
**********************************************************************
         TITLE 'Author: James Hund Version: 2/26/18'
HW3      START 0            ;first line of the program
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


BEGIN    L    2,TAB     ;GR2=COUNT=10
         SR   1,1       ;GR1=0
         SR   4,4       ;GR4=0
LOOP     A    1,FOUR    ;GR1=4
         L    3,TAB(1)  ;GR3=C TAB+GR1
         PRINTOUT 3,Header=NO
         A    4,3
         SR   2, =F'1'   ;GR2=GR2-1
         BNZ LOOP
         PRINTOUT 4,*,HEADER=NO


TAB      DC F'10, 1, 5, 7, 22, 33, 20, 6, 8, 2, 30'
FOUR     DC F'4'
         END HW3