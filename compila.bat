@echo off

if not exist bin (
	echo *** Criando Diretorio bin ***
	mkdir bin
)

echo *** Compilando projeto ***
javac -cp lib/jdom-2.0.5.jar -sourcepath src -d bin src\br\udesc\gdc\view\ViewPrincipal.java