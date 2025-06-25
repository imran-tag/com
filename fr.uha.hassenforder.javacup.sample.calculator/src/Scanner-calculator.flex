%%

%package fr.uha.hassenforder.javacup.sample.calculator.reader
%class Lexer
%public
%cupJHMH
%%

[ \t\f]					{ }
\r\n|\r|\n				{ return symbol (ETerminal.EOLN); }
"="						{ return symbol (ETerminal.EQUAL); }
"+"						{ return symbol (ETerminal.PLUS); }
"-"						{ return symbol (ETerminal.MINUS); }
"*"						{ return symbol (ETerminal.TIMES); }
"/"						{ return symbol (ETerminal.DIVIDE); }
"("						{ return symbol (ETerminal.LPAREN); }
")"						{ return symbol (ETerminal.RPAREN); }
   
[0-9]+      			{ return symbol (ETerminal.NUMBER, Integer.parseInt(yytext())); }
[A-Za-z_][A-Za-z_0-9]*	{ return symbol (ETerminal.ID, yytext()); }
   
[^]                     { throw new Error("Illegal character <"+yytext()+">"); }
