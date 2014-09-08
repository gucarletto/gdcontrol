@echo off

if exist bin (
	call compila.bat
) 

if not exist jar (
	echo *** Criando Diretorio jar ***
	mkdir jar
)

echo *** Empacotando projeto ***
cd bin
jar cvfe ..\jar\gdcontrol.jar ViewPrincipal *.class
cd ..