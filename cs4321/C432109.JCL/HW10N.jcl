//C432109A JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//**************//
//** ASSEMBLE **//
//**************//
//ASSEMBLE EXEC PGM=ASMA90
//SYSIN    DD DSN=&SYSUID..ASM(HW10N),DISP=SHR
//SYSLIB   DD DSN=SYS1.MACLIB,DISP=SHR
//         DD DSN=&SYSUID..MACLIB,DISP=SHR
//         DD DSN=&SYSUID..MACROLIB,DISP=SHR
//SYSLIN   DD DSN=&&OBJ,DISP=(,PASS)
//SYSUT1   DD DSN=&&SYSUT1,DISP=(,PASS)
//SYSPRINT DD SYSOUT=*
//**********//
//** LINK **//
//**********//
//LINK     EXEC PGM=HEWL,PARM='MAP,LET,LIST,NCAL',COND=(8,LT,ASSEMBLE)
//SYSLIN   DD DSN=&&OBJ,DISP=SHR
//SYSUT1   DD DSN=&&SYSUT1,DISP=(,PASS)
//SYSLMOD  DD DSN=&SYSUID..LOAD(HW10N),DISP=(OLD,CATLG)
//SYSPRINT DD SYSOUT=*
//*********//
//** GO ***//
//*********//
//RUN      EXEC PGM=HW10N,TIME=1
//SYSIN    DD DSN=&SYSUID..TEXT(HW10IN),DISP=SHR
//STEPLIB  DD DSN=&SYSUID..LOAD,DISP=SHR
//SYSPRINT DD SYSOUT=*