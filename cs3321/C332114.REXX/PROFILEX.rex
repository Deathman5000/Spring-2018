/*  REXX   */
/* USING BUILT-IN COMMANDS TO GET SYSTEM INFORMATION
   SOURCE: C332100.REXX(PROFILEX)
   INPUT: INSTREAM
   JCL: C332100.WORK.JCL(PROFILEX)
*/
USER = USERID()
SAY 'YOUR USERID =..................' USER
SAY 'THE SYSTEM DATE =..............' DATE()
SAY 'THE SYSTEM TIME = .............' TIME()
/* DISPLAYS THE VERSION OF Z/OS RUNNING */
SAY 'SYSTEM OS   = .................' MVSVAR('SYSOPSYS')
SAY 'SYSTEM MVS LEVEL = ............' MVSVAR('SYSMVS')
SAY 'SYSTEM NAME = .................' MVSVAR('SYSNAME')
SAY 'SYSTEM SYSPLEX NAME = .........' MVSVAR('SYSPLEX')
PARSE VALUE TIME() WITH S1":"S2":"S3
SECONDS = S1*60*60 + S2*60 + S3
SAY 'TIME IN SECONDS IS ' || SECONDS