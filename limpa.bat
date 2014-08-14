@echo off

if exist bin (
	echo *** Apagando Diretorio bin ***
	rmdir bin /s /q
) else (
	echo *** Diretorio bin ao existe
)

if exist jar (
	echo *** Apagando Diretorio jar ***
	rmdir jar /s /q
) else (
	echo *** Diretorio jar ao existe
)