atualDir=$PWD
numero_parametros=$#
if [ $numero_parametros -ne 1 ];
then
  echo "Parametros inválidos:"
  tput setaf 1;echo "Use: ./geometrics.sh <programa.aux>"
  echo ""
  exit
else
	programa=$1
	FILE=$PWD/examples/$programa
	if test -f "$FILE";
	then
		cd src/geometrics
		antlr4-build
	 	antlr4-run ../../examples/$programa 2> $atualDir/error.txt
		nlinhas=`cat $atualDir/error.txt |wc -l`
		if [ $nlinhas -gt 0 ];
		then
			cat $atualDir/error.txt && rm $atualDir/error.txt
		else
			rm $atualDir/error.txt
			tput setaf 2; echo "$programa compiled successfully!!"
			tput setaf 4;echo "Press <Enter key> to execute $programa "
			tput setaf 7;
			read x
			./Output.py
		fi		
	else
		tput setaf 1;echo "File $programa not found"
		exit
	fi 
fi
