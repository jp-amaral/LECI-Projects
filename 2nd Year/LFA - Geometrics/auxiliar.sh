numero_parametros=$#
if [ $numero_parametros -ne 1 ];
then
  tput setaf 1;echo "Parametros inválidos:"
  echo "Use: ./auxiliar.sh <programa.aux>"
  echo ""
  exit
else
	programa=$1
	FILE=$PWD/examples/$programa
	if test -f "$FILE";
	then
		cd src/auxiliar
	 	antlr4-run ../../examples/$programa
	else
		tput setaf 1;echo "File $programa not found"
		exit
	fi 
fi
