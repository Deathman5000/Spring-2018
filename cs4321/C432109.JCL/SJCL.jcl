//C332114S JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//********************************************************************
//*    JCL TO SORT C332114.DATA(DATA1) BY THE FIRST                  *
//*    THREE CHARACTER FIELDS AND WRITE OUTPUT                       *
//*    TO C332114.DATA(OUT1), NEED TO CHANGE **                      *
//********************************************************************
//MYSORT EXEC PGM=SORT
//SORTIN DD DISP=SHR,DSN=C432109.DATA(DATA1)
//SORTOUT DD DISP=SHR,DSN=C432109.DATA(OUT1)
//SYSOUT DD SYSOUT=*
//SYSIN DD *
  SORT FIELDS=(1,3,CH,A)