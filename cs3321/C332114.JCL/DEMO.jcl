//C332114B JOB 1,'JAMES HUND',NOTIFY=&SYSUID
//********************************************************************
//* JCL FOR ARITHMETIC OPERATIONS ON RECORDS USING THE SORT PROGRAM
//* OPERATION: (COL2 - COL3). STORE RESUTL IN 10
//* POSITIONS BEGINNING AT POSITION 30.
//* SORT CONTROL USING FIRST COL CHAR AND SUM COLS THAT HAVE
//* THE SAME CONTROL FIELD VLAUES, BY WRITING ONE RECORD FOR
//* FOR EACH VALUE
//* FILE: C332114.JCL(DEMO)
//********************************************************************
//SORT1 EXEC PGM=SORT
//SYSOUT  DD SYSOUT=*
//SORTOUT DD SYSOUT=*
//SORTIN  DD *
A    00022.32 00011.32
A    00022.32 00011.32
B    11111.99 00920.35
C    03567.23 00038.60
D    00760.25 00575.57
//SYSIN   DD *
  INREC OVERLAY=(6:6,8,UFF,TO=ZD,LENGTH=8,
                   15:15,8,UFF,TO=ZD,LENGTH=8,
                   30:30,10,UFF,TO=ZD,LENGTH=10)
    SORT FIELDS=(1,1,CH,A)
    SUM  FIELDS=(6,8,ZD,15,8,ZD,30,10,ZD)
  OUTREC OVERLAY=(1:1,29,
       (6,8,ZD,SUB,15,8,ZD),
       LENGTH=10,EDIT=(III,ITT.TT),
       6:6,8,ZD,LENGTH=8,EDIT=(IIITT.TT),
       15:15,8,ZD,LENGTH=8,EDIT=(IIITT.TT))