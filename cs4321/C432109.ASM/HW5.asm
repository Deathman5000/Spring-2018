*                                                                    *
* A program taking an array and sorts it from greatest to least.
* It displays each value.
*                                                                    *
**********************************************************************
         TITLE 'Author: James Hund Version: 3/25/18'
HW5      START 0            ;first line of the program
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
         L  2,COUNT                *Sets R2 to count
         ST 2,COPY                 *Gets a copy of count
         ST 2,PERM                 *Gets a static copy
         SR  8,8                   *Clears R8 for future use
MAIN     L  3,TAB(1)               *Grabs the first number
         ST 3,MAX
         C  2,ONE
         BE ONLYONE
         S  2,ONE
         A  1,FOUR                 *Moves to the next element in array
         L  3,TAB(1)               *Gets the element to be printed
         ST 3,HOLDER
         S  2,ONE
         C  3,MAX
         BH MAXINIT
         BL LOOP
MAXINIT  L  4,HOLDER
         ST 4,MAX                  *LOADS VALUE OF NUMBER TO BE STORED
         A  1,FOUR                 *GOES TO NEXT ELEMENT
         B  LOOP                   *GO TO LOOP
LOOP     L  3,TAB(1)              *NEXT ELEMENT
         ST 3,HOLDER               *Saves it
         C  3,MAX                  *COMPARES IT WITH MAX
         BH MAXLOOP                *IF >MAX GO TO MAXLOOP
         BL CONTINUE
CONTINUE A  1,FOUR                 *GO TO NEXT ELEMENT
         S  2,ONE                  *INCREASES COUNT
         ST 2,COUNT
         C  2,ZERO               *COMPARES COUNT TO NUMBER IN ARRAY
         BNE LOOP                  *IF LESS THAN ARRAY LOOP
         BE  PRINT                   *ELSE GO TO END
NEXT     SR  1,1                   *This method sets the current max
         L   0,ZERO                *to 0 and replaces it in the array
AGAIN    L  3,TAB(1)
         C  3,MAX
         BE CLEAR
         A  1,FOUR
         C  3,MAX
         BNE AGAIN
CLEAR    ST 0,TAB(1)
         L  1,ZERO
         L  2,COUNT
         SR  8,8
         B  MAIN
MAXLOOP  ST 3,MAX                  *STORE NEW ELEMENT INTO MAX
         B  CONTINUE               *GO TO CONTINUE
PRINT    L  3,MAX
         L  8,COPY
         L  2,PERM
         ST 2,COUNT
         S  8,ONE
         ST 8,COPY
         PRINTOUT 3,Header=NO
         C  8,ZERO
         BNE NEXT
         BE  END
END      PRINTOUT *,Header=NO  ; terminate quietly
ONLYONE  PRINTOUT 3,Header=NO
         PRINTOUT *,Header=NO

TAB      DC F'80,10,7,33,22'
HOLDER   DC F'0'
ZERO     DC F'0'
ONE      DC F'1'
COUNT    DC F'5'
FOUR     DC F'4'
NUMBER   DC F'0'
MAX      DC F'0'
MIN      DC F'0'
POSI     DC F'0'
COPY     DC F'0'
PERM     DC F'0'
         END HW5