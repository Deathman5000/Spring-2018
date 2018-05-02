*                                                                    *
* A program taking an array and finding the max and min.
* It displays the max and min.
*                                                                    *
**********************************************************************
         TITLE 'Author: James Hund Version: 3/05/18'
HW4      START 0            ;first line of the program
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


BEGIN    L  1,ZERO                 *Sets R1 to zero
         L  2,COUNT                *Sets R2 to count=0
         SR  8,8                   *Clears R8 for future use
         L  7,TAB1(1)               *Grabs number of elements
         ST 7,NUMBER
         L  1,FOUR                 *Moves to the next element in array
         L  3,TAB1(1)              *Gets the element to be printed
         ST 3,MAX                  *INITIALIZES THE FIRST NUMBER TO MAX
         A  1,FOUR                 *GOES TO NEXT ELEMENT
         A  2,ONE                  *ADDS ONE TO COUNT
         ST 2,COUNT                *STORES IT
         L  3,TAB1(1)              *GRABS NEXT ELEMENT
         ST 3,HOLDER
         C  3,MAX                  *COMPARES IT WITH MAX
         BL MININIT                *IF LESS THAN MAX GO TO MININIT
         BH MAXINIT                *IF GREATER THAN MAX GO TO MAXINIT
MININIT  L  4,HOLDER               *LOADS VALUE OF NUMBER TO BE STORED
         ST 4,MIN                  *NEW MIN VALUE
         A  1,FOUR                 *GOES TO NEXT ELEMENT
         A  2,ONE                  *INCREASES COUNT
         ST 2,COUNT
         B  LOOP                   *GO TO LOOP

MAXINIT  L  4,MAX                  *LOADS VALUE OF NUMBER TO BE STORED
         ST 4,MIN                  *OLD MAX BECOMES NEW MIN
         L  5,HOLDER
         ST 5,MAX                  *NEW MAX VALUE
         A  1,FOUR                 *GOES TO NEXT ELEMENT
         A  2,ONE                  *INCREASES COUNT
         ST 2,COUNT
         B  LOOP                   *GO TO LOOP
LOOP     L  3,TAB1(1)              *NEXT ELEMENT
         ST 3,HOLDER               *Saves it
         C  3,MAX                  *COMPARES IT WITH MAX
         BH MAXLOOP                *IF >MAX GO TO MAXLOOP
         C  3,MIN                  *COMPARES IT WITH MIN
         BL MINLOOP                *IF <MIN GO TO MINLOOP
CONTINUE A  1,FOUR                 *GO TO NEXT ELEMENT
         A  2,ONE                  *INCREASES COUNT
         ST 2,COUNT
         C  2,NUMBER               *COMPARES COUNT TO NUMBER IN ARRAY
         BNE LOOP                  *IF LESS THAN ARRAY LOOP
         BE  END                   *ELSE GO TO END

MAXLOOP  ST 3,MAX                  *STORE NEW ELEMENT INTO MAX
         B  CONTINUE               *GO TO CONTINUE
MINLOOP  ST 3,MIN                  *STORE NEW ELEMENT INTO MIN
         B  CONTINUE               *GO TO CONTINUE
END      PRINTOUT MAX,MIN,Header=NO
         PRINTOUT *,Header=NO  ; terminate quietly

TAB1     DC F'7,100,11,20,31,80,10,1'
HOLDER   DC F'0'
ZERO     DC F'0'
ONE      DC F'1'
COUNT    DC F'0'
FOUR     DC F'4'
NUMBER   DC F'0'
MAX      DC F'0'
MIN      DC F'0'
         END HW4