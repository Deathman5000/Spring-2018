//C332114R JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//*******************************************************************
//* JCL TO READ C332114.DATA(FOOD)
//* THIS JCL SHOW HOW TO RUN A REXX PROGRAM AS A BATCH JOB.
//******************************************************************
//* REXX PROGRAM TO BE EXECUTED
//STEP1 EXEC PGM=IRXJCL,PARM='QUIZ3A',TIME=1
//* SYSTSIN IS THE INPUT DATASET IF NEEDED
//* DD FOR DATA SET INPUT, NEED TO CHANGE THIS TO C332114.DATA(FOOD)
//SYSTSIN DD DSN=C332114.DATA(FOOD),DISP=SHR
//*SYSTSIN DD *
//* THE ABOVE LINE IS WITHOUT AN EXTERNAL INPUT DATASET
//* SYSTSPRT IS THE OUTPUT DATASET WHICH IS INSTREAM IN THIS CASE
//SYSTSPRT DD SYSOUT=*
//* DD THAT SPECIFIES PDS CONTAINING YOUR REXX PROGRAM, MAY NEED TO
//* CHANGE THIS NAME
//SYSEXEC DD DSN=C332114.REXX,DISP=SHR