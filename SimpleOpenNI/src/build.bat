@echo off

cd %cd%
javac -cp "C:\Program Files\processing\core\library\core.jar" SimpleOpenNI\*.java
move /y SimpleOpenNI\*.class build\SimpleOpenNI\
cd build
jar cvfm ..\SimpleOpenNI.jar manifest.txt SimpleOpenNI\*.class

@pause