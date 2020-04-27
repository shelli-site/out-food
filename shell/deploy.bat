@echo off
echo clean install...
cd C:\Users\shinelon\Desktop\demo\study\el\eladmin
D:\Com\Java\jdk1.8.0_201\bin\java.exe -Dmaven.multiModuleProjectDirectory=C:\Users\shinelon\Desktop\demo\study\el\eladmin -Dmaven.home=D:\Com\env\apache-maven-3.5.4 -Dclassworlds.conf=D:\Com\env\apache-maven-3.5.4\bin\m2.conf "-Dmaven.ext.class.path=D:\Com\JetBrains\IntelliJ IDEA 2020.1\plugins\maven\lib\maven-event-listener.jar" "-javaagent:D:\Com\JetBrains\IntelliJ IDEA 2020.1\lib\idea_rt.jar=54810:D:\Com\JetBrains\IntelliJ IDEA 2020.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Com\env\apache-maven-3.5.4\boot\plexus-classworlds-2.5.2.jar org.codehaus.classworlds.Launcher -Didea.version2020.1 -s D:\Com\env\apache-maven-3.5.4\conf\settings.xml -Dmaven.repo.local=D:\Com\Java\maven\repository clean install
echo package...
cd C:\Users\shinelon\Desktop\demo\study\el\eladmin\eladmin-start
D:\Com\Java\jdk1.8.0_201\bin\java.exe -Dmaven.multiModuleProjectDirectory=C:\Users\shinelon\Desktop\demo\study\el\eladmin\eladmin-start -Dmaven.home=D:\Com\env\apache-maven-3.5.4 -Dclassworlds.conf=D:\Com\env\apache-maven-3.5.4\bin\m2.conf "-Dmaven.ext.class.path=D:\Com\JetBrains\IntelliJ IDEA 2020.1\plugins\maven\lib\maven-event-listener.jar" "-javaagent:D:\Com\JetBrains\IntelliJ IDEA 2020.1\lib\idea_rt.jar=54908:D:\Com\JetBrains\IntelliJ IDEA 2020.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Com\env\apache-maven-3.5.4\boot\plexus-classworlds-2.5.2.jar org.codehaus.classworlds.Launcher -Didea.version2020.1 -s D:\Com\env\apache-maven-3.5.4\conf\settings.xml -Dmaven.repo.local=D:\Com\Java\maven\repository package
echo build copy file...
cd target
echo %date:~0,4%-%date:~5,2%-%date:~8,2%
copy *.jar C:\Users\shinelon\Desktop\demo\study\el\eladmin\shell
cd C:\Users\shinelon\Desktop\demo\study\el\eladmin\shell
ren eladmin-start-2.4.jar [lmj-out-food]%date:~0,4%-%date:~5,2%-%date:~8,2%.jar
pause