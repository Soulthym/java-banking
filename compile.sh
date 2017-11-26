rm -r logger/bin
mkdir logger/bin
javac -d logger/bin $(find logger/src -name *.java)

rm -r banking/bin
mkdir banking/bin
javac -classpath logger/bin -d banking/bin $(find banking/src -name *.java)

rm -r testframework/bin
mkdir testframework/bin
javac -classpath logger/bin:banking/bin -d testframework/bin $(find testframework/src -name *.java)
