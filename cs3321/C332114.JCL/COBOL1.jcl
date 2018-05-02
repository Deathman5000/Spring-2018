//C332114C JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//**************************************************
//* COMPILE LINK AND GO FOR A SIMPLE COBOL PROGRAM
//**************************************************
//STEP1 EXEC IGYWCLG
//COBOL.SYSIN DD DSN=&SYSUID..TEMP(COBOL1),DISP=SHR
//GO.SYSOUT DD SYSOUT=*