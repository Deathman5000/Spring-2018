//C432109A JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//**************//
//** ASSEMBLE **//
//**************//
//ASSEMBLE EXEC PGM=ASMA90
//SYSIN    DD DSN=C432109.ASM(SUB1),DISP=SHR
//SYSLIB   DD DSN=SYS1.MACLIB,DISP=SHR
//         DD DSN=C432109.MACLIB,DISP=SHR
//         DD DSN=C432109.MACROLIB,DISP=SHR
//SYSLIN   DD DSN=&&OBJ,DISP=(,PASS)
//SYSUT1   DD DSN=&&SYSUT1,DISP=(,PASS)
//SYSPRINT DD SYSOUT=*
//**********//
//** LINK **//
//**********//
//LINK     EXEC PGM=HEWL,PARM='MAP,LET,LIST,NCAL',COND=(8,LT,ASSEMBLE)
//SYSLIN   DD DSN=&&OBJ,DISP=SHR
//SYSUT1   DD DSN=&&SYSUT1,DISP=(,PASS)
//SYSLMOD  DD DSN=C432109.LOAD(SUB1),DISP=(OLD,CATLG)
//SYSPRINT DD SYSOUT=*
//*********//
//** GO ***//
//*********//
//RUN      EXEC PGM=SUB1
//STEPLIB  DD DSN=C432109.LOAD,DISP=SHR
//SYSPRINT DD SYSOUT=*