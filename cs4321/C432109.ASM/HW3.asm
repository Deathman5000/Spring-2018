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


BEGIN    L  1,ZERO                 *Sets R1 to zero
         L  2,COUNT                *Sets R2 to count=0
         SR  8,8                   *Clears R8 for future use
         L  7,TAB(1)               *Grabs number of elements
         ST 7,NUMBER
         L  1,FOUR                 *Moves to the next element in array
GetNum   L  3,TAB(1)               *Gets the element to be printed
         ST 3,HOLDER               *Saves it
         PRINTOUT 3,Header=NO      *Prints it
         A  8,HOLDER               *Adds it to the total
         ST 8,TOTAL                *Stores it in total
         A  1,FOUR                 *Moves on to next element
         A  2,ONE                  *Adds one to count
         ST 2,COUNT                *Stores it back
         C  2,NUMBER
         BNE GetNum           *Branches if the R2 isn't equal to NUMBER
         L  8,TOTAL                *Loads the total into R8 to print
         PRINTOUT 8,Header=NO
         PRINTOUT *,Header=NO  ; terminate quietly

TAB      DC F'10, 1, 5, 7, 22, 33, 20, 6, 8, 2, 30'
HOLDER   DC F'0'
ZERO     DC F'0'
ONE      DC F'1'
TOTAL    DC F'0'
SUM      DC F'0'
COUNT    DC F'0'
FOUR     DC F'4'
NUMBER   DC F'0'
         END HW3