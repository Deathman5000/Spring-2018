****************************************************************
*        This program computes word ratio = length of a word
*        divided by the no of distinct chars in it.
*        The program will read 10 words saved in
*        C4321**.TEXT(HW10IN) and display length of each word,
*        number of distinct chars and the word ratio.
*
****************************************************************
         TITLE 'Author: Rajan Alex Version:4/11/18'
HW10N    START 0                     FIRST LINE OF THE PROGRAM
         PRINT NOGEN
         BASR 15,0                   ESTABLISH A BASE REGISTER
         USING *,15                  INFORM THE ASSEMBLER
*
BEGIN     L 13,=F'10'                GR13 = 10, NUMBER OF WORDS
*
*
TOP      READCARD CARDIN
         LA 14,WLEN
L1       WORD2 14
         L 10,WLEN                   PREPARE FOR DISPLAY
         CONVERTO 10,AOUT
         L 10,WCOUNT
         CONVERTO 10,BOUT
         L 10,WRATIO
         CONVERTO 10,COUT
         PRINTOUT OUTPUT,HEADER=NO   DISPLAY
         JCT 13,TOP                  LOOP BACK TO TOP IF GR13 > 0
FINISH   PRINTOUT *,HEADER=NO
*
WLEN     DC F'0'         TO STORE WORD LENGTH AFTER A CALL WORD2
WCOUNT   DC F'0'         TO STORE WORD COUNT AFTER A CALL WORD2
WRATIO   DC F'0'         TO STORE WORD RATIO AFTER A CALL WORD2
COUNT    DC 26F'0'       AN ARRAY TO KEEP TRACK OF DISTINCT CHARS
LETTERS  DC C'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
CARDIN   DC 0CL80        TO READ INPUT
CARD     DS CL80
OUTPUT   DC 0CL36        TO WRITE OUTPUT TO THE OUT STREAM IN THE JCL
AOUT     DS CL12
BOUT     DS CL12
COUT     DS CL12
         END HW10N