/* REXX */
/* THIS PROGRAM DISPLAYS THE PAY RAISE FOR AN EMPLOYEE
   AUTHOR: JAMES HUND
   VERSION: 02/28/18
*/

SAY 'ENTER NAME AND PAY'
PULL NAME PAY

IF PAY < 80000 THEN DO
   IF NAME == 'SUE' THEN
      PAY = PAY * 1.5
   ELSE
      PAY = PAY * 1.2
   SAY NAME ||' YOUR PAY IS '||PAY
END
ELSE DO
   PAY = PAY + 500
   SAY NAME ||' YOUR PAY IS '||PAY
END

EXIT