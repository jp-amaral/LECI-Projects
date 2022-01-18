// Generated from /home/viegas/Desktop/geometrics-lfa-11/src/auxiliar/auxiliar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class auxiliarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Integer=14, Param=15, ID=16, COMMENT=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "Integer", "Param", "ID", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "'circle'", "'('", "','", "')'", "':'", "';'", 
			"'rectangle'", "'square'", "'line'", "'triangle'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "Integer", "Param", "ID", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public auxiliarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "auxiliar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\5\17_\n\17\3\17\6\17b\n"+
		"\17\r\17\16\17c\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u0080\n\20\3\21\3\21\7\21\u0084\n\21\f\21\16\21\u0087\13\21"+
		"\3\22\3\22\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\5\22"+
		"\u0093\n\22\3\22\3\22\3\22\3\22\3\23\6\23\u009a\n\23\r\23\16\23\u009b"+
		"\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\"+
		"aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u00a7\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2"+
		"\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13\64\3\2\2\2\r\66\3\2\2\2\178\3"+
		"\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25>\3\2\2\2\27H\3\2\2\2\31O\3\2\2\2\33"+
		"T\3\2\2\2\35^\3\2\2\2\37\177\3\2\2\2!\u0081\3\2\2\2#\u0088\3\2\2\2%\u0099"+
		"\3\2\2\2\'(\7}\2\2(\4\3\2\2\2)*\7\177\2\2*\6\3\2\2\2+,\7?\2\2,\b\3\2\2"+
		"\2-.\7e\2\2./\7k\2\2/\60\7t\2\2\60\61\7e\2\2\61\62\7n\2\2\62\63\7g\2\2"+
		"\63\n\3\2\2\2\64\65\7*\2\2\65\f\3\2\2\2\66\67\7.\2\2\67\16\3\2\2\289\7"+
		"+\2\29\20\3\2\2\2:;\7<\2\2;\22\3\2\2\2<=\7=\2\2=\24\3\2\2\2>?\7t\2\2?"+
		"@\7g\2\2@A\7e\2\2AB\7v\2\2BC\7c\2\2CD\7p\2\2DE\7i\2\2EF\7n\2\2FG\7g\2"+
		"\2G\26\3\2\2\2HI\7u\2\2IJ\7s\2\2JK\7w\2\2KL\7c\2\2LM\7t\2\2MN\7g\2\2N"+
		"\30\3\2\2\2OP\7n\2\2PQ\7k\2\2QR\7p\2\2RS\7g\2\2S\32\3\2\2\2TU\7v\2\2U"+
		"V\7t\2\2VW\7k\2\2WX\7c\2\2XY\7p\2\2YZ\7i\2\2Z[\7n\2\2[\\\7g\2\2\\\34\3"+
		"\2\2\2]_\7/\2\2^]\3\2\2\2^_\3\2\2\2_a\3\2\2\2`b\t\2\2\2a`\3\2\2\2bc\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2d\36\3\2\2\2ef\7e\2\2fg\7q\2\2gh\7n\2\2hi\7"+
		"q\2\2i\u0080\7t\2\2jk\7v\2\2kl\7j\2\2lm\7k\2\2mn\7e\2\2no\7m\2\2op\7p"+
		"\2\2pq\7g\2\2qr\7u\2\2r\u0080\7u\2\2st\7h\2\2tu\7k\2\2uv\7n\2\2vw\7n\2"+
		"\2wx\7g\2\2x\u0080\7f\2\2yz\7j\2\2z{\7k\2\2{|\7f\2\2|}\7f\2\2}~\7g\2\2"+
		"~\u0080\7p\2\2\177e\3\2\2\2\177j\3\2\2\2\177s\3\2\2\2\177y\3\2\2\2\u0080"+
		" \3\2\2\2\u0081\u0085\t\3\2\2\u0082\u0084\t\4\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\"\3"+
		"\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\61\2\2\u0089\u008a\7\61\2\2\u008a"+
		"\u008e\3\2\2\2\u008b\u008d\n\5\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0093\7\17\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3"+
		"\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\f\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\b\22\2\2\u0097$\3\2\2\2\u0098\u009a\t\6\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\b\23\2\2\u009e&\3\2\2\2\n\2^c\177\u0085\u008e\u0092"+
		"\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}