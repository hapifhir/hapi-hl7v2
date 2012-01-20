package testpanel;

import jsyntaxpane.lexers.*;
import jsyntaxpane.Token;
import jsyntaxpane.TokenType;

@SuppressWarnings("unused")

%%

%public
%class Er7Lexer
%extends DefaultJFlexLexer
%final
%unicode
%char
%type Token
%caseless

%{

	private boolean myReturnNewlines;
	
    /**
     * Default constructor is needed as we will always call the yyreset
     */
    public Er7Lexer() {
        super();
    }

    /**
     * Default constructor is needed as we will always call the yyreset
     */
    public Er7Lexer(boolean theReturnNewlines) {
        super();
        myReturnNewlines = theReturnNewlines;
    }

	@Override
    public int yychar() {
        return yychar;
    }
    

%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]+

Comment = {EndOfLineComment}

EndOfLineComment = "#" {InputCharacter}* {LineTerminator}?

SegmentName = [A-Z][A-Z0-9]{2}

Message = "MSH"

Number = [-0-9\.]+(\||\^|\&|\~|\\)
NumberAtEnd = [-0-9\.]+(\r|\n|\r\n)

EscapeSequence = (\\[\.a-zA-Z0-9 ]+\\)

FieldDelim = "|"
ComponentDelim = "^"
SubComponentDelim = "&"
RepDelim = "~"
EscapeDelim = "\\"

OneChar = .

/*AnythingElse = [a-zA-Z0-9]+*/

AnythingElse = .+(\||\^|\&|\~|\\)
AnythingElseAtEnd = .+(\r|\n|\r\n)


/*%state START_DATA*/
/*%state IN_DATA*/
/*%state START_SEGMENT*/

%state AT_START_OF_VALUE
%state WITHIN_VALUE
%state AT_DELIM

%%

<YYINITIAL> {

  /*{Message}						 { if (yychar == 0) return token(TokenType.KEYWORD); }*/
  {Message}						 { return token(TokenType.KEYWORD); }

  {SegmentName}					 { return token(TokenType.KEYWORD); }

  {FieldDelim}                   |
  {SubComponentDelim}            |
  {RepDelim}                     |
  {EscapeDelim}                  |
  {ComponentDelim}               { yybegin(AT_START_OF_VALUE); return token(TokenType.TYPE); }
  
  {Comment}                      { return token(TokenType.COMMENT); }

}

<AT_DELIM> {

  {OneChar}                      { yybegin(AT_START_OF_VALUE); return token(TokenType.TYPE); }

}

<AT_START_OF_VALUE> {
  
  {FieldDelim}                   |
  {SubComponentDelim}            |
  {RepDelim}                     |
  {EscapeDelim}                  |
  {ComponentDelim}               { yybegin(AT_START_OF_VALUE); return token(TokenType.TYPE); }
  
  {LineTerminator}				 { yybegin(YYINITIAL); return token(TokenType.DEFAULT); }

  {Number}				         { yypushback(1); yybegin(AT_DELIM); return token(TokenType.TYPE2); }
  {NumberAtEnd}				     { yybegin(YYINITIAL); return token(TokenType.TYPE2); }
  
  {EscapeSequence}			     { return token(TokenType.TYPE3); }

  {OneChar}						 { yybegin(WITHIN_VALUE); return token(TokenType.DEFAULT); }
  
}

<WITHIN_VALUE> {
  
  {FieldDelim}                   |
  {SubComponentDelim}            |
  {RepDelim}                     |
  {EscapeDelim}                  |
  {ComponentDelim}               { yybegin(AT_START_OF_VALUE); return token(TokenType.TYPE); }
  
  {LineTerminator}				 { yybegin(YYINITIAL); return token(TokenType.DEFAULT); }

  {EscapeSequence}			     { return token(TokenType.TYPE3); }
  
  {OneChar}						 { yybegin(WITHIN_VALUE); return token(TokenType.DEFAULT); }
  
}


/* error fallback */
.|\n                             { return token(TokenType.OPERATOR); }
<<EOF>>                          { return null; }
