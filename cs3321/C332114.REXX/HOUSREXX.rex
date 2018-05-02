/* REXX */
/*
   THIS PROGRAM TAKES IN THE LIST OF THE HOUSE OF REPRESENTIIVES
   AND THE USER PUTS IN THE INPUT OF A STATE AND OUTPUT IS THAT
   STATES REPRESENTITIVES.
   AUTHOR: JAMES HUND
   VERSION: 04/02/18
   FILE: C332114.REXX(HOUSREXX) -- MAY NEED TO CHANGE THIS NAME AS NEEDED
   INPUT: C332114.TEMP(SENATE)
 */
CLRSCN
USERNAME = SYSVAR("SYSUID")   /* USERNAME GETS THE USER'S ID */
OKDSN = USERNAME'.TEMP(SENATE)'
PARSE ARG A
SAY 'ENTER A STATE ABBREVIATION'
PULL STATE
IF DATATYPE(A) == 'CHAR' THEN
   STATE = A

/* OKDSN HAS VALUE C3321XX.TEMP(TEXTIN)   */

/* ALLOCATE COMMAND ESTABLISHES A CONNECTION
   BETWEEN THE PHYSICAL DATASET OKDNS AND THE SYMBOLIC NAME INFILE,
   REUSE MEANS THE PROGRAM MAY REASSIGN OR REUSE INFILE
*/

"ALLOCATE DDN(INFILE) SHR REUSE DSN('"OKDSN"')"

/* SOME VARIABLES WE WILL BE USING */

INPUT.0 = 0

/* NEXT COMMAND WILL READ TILL END OF FILE ITS
   CONTENT RECORD BY RECORD
   INTO THE ARRAY INPUT.I, I= 1,2,3,...
   INPUT.0 WILL STORE THE NUMBER OF LINES(RECORDS)READ. FINIS
   MEANS AT THE END CLOSE THE FILE  */
/* NEXT COMMAND IN THE IF STATEMENT WILL READ TILL END OF FILE
   (* MEANS READ TILL EOF) ITS
   CONTENT RECORD BY RECORD
   INTO THE ARRAY OR STEM CALLED INPUT.I, I= 1,2,3,...
   INPUT.0 WILL STORE THE NUMBER OF LINES( OR RECORDS) READ, FINIS
   MEANS AT THE END CLOSE THE FILE  */

/* IF ALLOCATE IS SUCCESS, RC = 0 */

IF RC = 0 THEN
   "EXECIO * DISKR INFILE (STEM INPUT. FINIS)"
ELSE
   SAY 'READ OF ' OKDSN ' FAILED'
"FREE DDN(INFILE)"   /* CLOSE THE FILE, NEED FINIS AND FREE */
DO I = 1 TO INPUT.0
   ST = INPUT.I
   PARSE VAR ST S1";"S2";"S3
   IF S2 = STATE THEN
      FOUND = 0
   ELSE
      FOUND = 1
   IF FOUND = 0 THEN DO
      SAY S1
   END
END I

EXIT