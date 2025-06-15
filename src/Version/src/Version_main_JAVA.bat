@echo on
rem -------------------------------------------------------------------
rem
rem -------------------------------------------------------------------
chcp 65001

rem -------------------------------------------------------------------
:A_P1_1
if "%1" == "" goto A_P1_2
set P1="%1"
goto A_P1_Exit
:A_P1_2
set P1=C:\Program Files\Far Manager\Far.exe
:A_P1_Exit
rem -------------------------------------------------------------------

:Begin
"C:\Program Files\Java\jdk-19\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2\lib\idea_rt.jar=62802:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2\bin" -Dfile.encoding=windows-1251 -classpath D:\PROJECTS_LYR\CHECK_LIST\DESKTOP\Java\PROJECTS_JAVA\TOOLS_JAVA\out\production\TOOLS_JAVA;D:\PROJECTS_LYR\CHECK_LIST\DESKTOP\Java\PROJECTS_JAVA\TOOLS_JAVA\out\production\Version;D:\PROJECTS_LYR\CHECK_LIST\DESKTOP\Java\PROJECTS_JAVA\LIB\jcommander\jcommander-1.82.jar Version -P1 "C:\Program Files\Far Manager\Far.exe"

:Exit
