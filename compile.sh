rm -r logger/bin
mkdir logger/bin
javac -d logger/bin $(find logger/src -name *.java)

rm -r banking/bin
mkdir banking/bin
javac -classpath logger/bin -d banking/bin $(find banking/src -name *.java)
