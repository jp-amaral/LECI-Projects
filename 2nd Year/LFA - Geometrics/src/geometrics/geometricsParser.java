// Generated from geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class geometricsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, BooleanLiteral=50, ENDLINE=51, 
		REAL=52, COMMENT=53, WS=54, String=55, ID=56, Integer=57;
	public static final int
		RULE_program = 0, RULE_statList = 1, RULE_stat = 2, RULE_drawString = 3, 
		RULE_exit = 4, RULE_input = 5, RULE_importFile = 6, RULE_resetTime = 7, 
		RULE_createColor = 8, RULE_drawFigure = 9, RULE_console = 10, RULE_animation = 11, 
		RULE_rotate = 12, RULE_translate = 13, RULE_random = 14, RULE_screenSize = 15, 
		RULE_declaration = 16, RULE_conditional = 17, RULE_loop = 18, RULE_expr = 19, 
		RULE_getPrimitive = 20, RULE_getAttribute = 21, RULE_createFig = 22, RULE_constructor = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statList", "stat", "drawString", "exit", "input", "importFile", 
			"resetTime", "createColor", "drawFigure", "console", "animation", "rotate", 
			"translate", "random", "screenSize", "declaration", "conditional", "loop", 
			"expr", "getPrimitive", "getAttribute", "createFig", "constructor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'drawString'", "'('", "','", "')'", "':'", "'->'", "'exit'", "'input'", 
			"'<<'", "'>>'", "'importFigures'", "'resetTimer'", "'draw:'", "'console'", 
			"'console('", "'translate'", "'from'", "'second'", "'to'", "'rotate'", 
			"'rand'", "'display('", "'if'", "')<<'", "'else<<'", "'forever'", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "'>'", "'<'", "'='", "'/='", "'and'", "'or'", 
			"'>='", "'<='", "'readTimer'", "'collidesEdge'", "'collides'", "'.'", 
			"'figure'", "'circle'", "'line'", "'square'", "'rectangle'", "'triangle'", 
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "BooleanLiteral", "ENDLINE", "REAL", "COMMENT", "WS", "String", 
			"ID", "Integer"
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

	@Override
	public String getGrammarFileName() { return "geometrics.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public geometricsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(geometricsParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			statList();
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatListContext extends ParserRuleContext {
		public List<TerminalNode> ENDLINE() { return getTokens(geometricsParser.ENDLINE); }
		public TerminalNode ENDLINE(int i) {
			return getToken(geometricsParser.ENDLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__25) | (1L << T__43) | (1L << ENDLINE) | (1L << ID))) != 0)) {
				{
				{
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__25) | (1L << T__43) | (1L << ID))) != 0)) {
					{
					setState(51);
					stat();
					}
				}

				setState(54);
				match(ENDLINE);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatDeclContext extends StatContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatDeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatColorContext extends StatContext {
		public CreateColorContext createColor() {
			return getRuleContext(CreateColorContext.class,0);
		}
		public StatColorContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatImportFileContext extends StatContext {
		public ImportFileContext importFile() {
			return getRuleContext(ImportFileContext.class,0);
		}
		public StatImportFileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatImportFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatImportFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatImportFile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAnimateContext extends StatContext {
		public AnimationContext animation() {
			return getRuleContext(AnimationContext.class,0);
		}
		public StatAnimateContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatAnimate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatAnimate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatAnimate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatTranslateContext extends StatContext {
		public TranslateContext translate() {
			return getRuleContext(TranslateContext.class,0);
		}
		public StatTranslateContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatTranslate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatTranslate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatTranslate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatInputContext extends StatContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public StatInputContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatScreenSizeContext extends StatContext {
		public ScreenSizeContext screenSize() {
			return getRuleContext(ScreenSizeContext.class,0);
		}
		public StatScreenSizeContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatScreenSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatScreenSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatScreenSize(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatDrawFigureContext extends StatContext {
		public DrawFigureContext drawFigure() {
			return getRuleContext(DrawFigureContext.class,0);
		}
		public StatDrawFigureContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatDrawFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatDrawFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatDrawFigure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatCondContext extends StatContext {
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public StatCondContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatExitContext extends StatContext {
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public StatExitContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatExit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatExit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatExit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatConsoleContext extends StatContext {
		public ConsoleContext console() {
			return getRuleContext(ConsoleContext.class,0);
		}
		public StatConsoleContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatConsole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatConsole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatConsole(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatCreateFigContext extends StatContext {
		public CreateFigContext createFig() {
			return getRuleContext(CreateFigContext.class,0);
		}
		public StatCreateFigContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatCreateFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatCreateFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatCreateFig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatResetTimeContext extends StatContext {
		public ResetTimeContext resetTime() {
			return getRuleContext(ResetTimeContext.class,0);
		}
		public StatResetTimeContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatResetTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatResetTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatResetTime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatStringContext extends StatContext {
		public DrawStringContext drawString() {
			return getRuleContext(DrawStringContext.class,0);
		}
		public StatStringContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatLoopContext extends StatContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StatLoopContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatRotateContext extends StatContext {
		public RotateContext rotate() {
			return getRuleContext(RotateContext.class,0);
		}
		public StatRotateContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatRotate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatRotate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatRotate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatRandomContext extends StatContext {
		public RandomContext random() {
			return getRuleContext(RandomContext.class,0);
		}
		public StatRandomContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterStatRandom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitStatRandom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitStatRandom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new StatCreateFigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				createFig();
				}
				break;
			case 2:
				_localctx = new StatInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				input();
				}
				break;
			case 3:
				_localctx = new StatImportFileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				importFile();
				}
				break;
			case 4:
				_localctx = new StatResetTimeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				resetTime();
				}
				break;
			case 5:
				_localctx = new StatColorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				createColor();
				}
				break;
			case 6:
				_localctx = new StatDrawFigureContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				drawFigure();
				}
				break;
			case 7:
				_localctx = new StatCondContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				conditional();
				}
				break;
			case 8:
				_localctx = new StatLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(67);
				loop();
				}
				break;
			case 9:
				_localctx = new StatDeclContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(68);
				declaration();
				}
				break;
			case 10:
				_localctx = new StatScreenSizeContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(69);
				screenSize();
				}
				break;
			case 11:
				_localctx = new StatTranslateContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(70);
				translate();
				}
				break;
			case 12:
				_localctx = new StatRotateContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(71);
				rotate();
				}
				break;
			case 13:
				_localctx = new StatAnimateContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(72);
				animation();
				}
				break;
			case 14:
				_localctx = new StatConsoleContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(73);
				console();
				}
				break;
			case 15:
				_localctx = new StatExitContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(74);
				exit();
				}
				break;
			case 16:
				_localctx = new StatRandomContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(75);
				random();
				}
				break;
			case 17:
				_localctx = new StatStringContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(76);
				drawString();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawStringContext extends ParserRuleContext {
		public DrawStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawString; }
	 
		public DrawStringContext() { }
		public void copyFrom(DrawStringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DrawStringPYContext extends DrawStringContext {
		public Token x;
		public Token y;
		public Token size;
		public Token text;
		public Token color;
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public List<TerminalNode> ID() { return getTokens(geometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(geometricsParser.ID, i);
		}
		public DrawStringPYContext(DrawStringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterDrawStringPY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitDrawStringPY(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitDrawStringPY(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DrawStringContext drawString() throws RecognitionException {
		DrawStringContext _localctx = new DrawStringContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_drawString);
		try {
			_localctx = new DrawStringPYContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__0);
			setState(80);
			match(T__1);
			setState(81);
			((DrawStringPYContext)_localctx).x = match(Integer);
			setState(82);
			match(T__2);
			setState(83);
			((DrawStringPYContext)_localctx).y = match(Integer);
			setState(84);
			match(T__2);
			setState(85);
			((DrawStringPYContext)_localctx).size = match(Integer);
			setState(86);
			match(T__3);
			setState(87);
			match(T__4);
			setState(88);
			((DrawStringPYContext)_localctx).text = match(ID);
			setState(89);
			match(T__5);
			setState(90);
			((DrawStringPYContext)_localctx).color = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExitContext extends ParserRuleContext {
		public ExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit; }
	 
		public ExitContext() { }
		public void copyFrom(ExitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExitProgramContext extends ExitContext {
		public ExitProgramContext(ExitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExitProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitContext exit() throws RecognitionException {
		ExitContext _localctx = new ExitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exit);
		try {
			_localctx = new ExitProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UserInputContext extends InputContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public UserInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterUserInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitUserInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitUserInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_input);
		try {
			_localctx = new UserInputContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__7);
			setState(95);
			match(T__4);
			setState(96);
			match(ID);
			setState(97);
			match(T__8);
			setState(98);
			statList();
			setState(99);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportFileContext extends ParserRuleContext {
		public ImportFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFile; }
	 
		public ImportFileContext() { }
		public void copyFrom(ImportFileContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ImportFiguresContext extends ImportFileContext {
		public ImportFiguresContext(ImportFileContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterImportFigures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitImportFigures(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitImportFigures(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportFileContext importFile() throws RecognitionException {
		ImportFileContext _localctx = new ImportFileContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_importFile);
		try {
			_localctx = new ImportFiguresContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResetTimeContext extends ParserRuleContext {
		public ResetTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resetTime; }
	 
		public ResetTimeContext() { }
		public void copyFrom(ResetTimeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ResetTimerContext extends ResetTimeContext {
		public ResetTimerContext(ResetTimeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterResetTimer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitResetTimer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitResetTimer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResetTimeContext resetTime() throws RecognitionException {
		ResetTimeContext _localctx = new ResetTimeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_resetTime);
		try {
			_localctx = new ResetTimerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateColorContext extends ParserRuleContext {
		public CreateColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createColor; }
	 
		public CreateColorContext() { }
		public void copyFrom(CreateColorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColorContext extends CreateColorContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ColorContext(CreateColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateColorContext createColor() throws RecognitionException {
		CreateColorContext _localctx = new CreateColorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_createColor);
		try {
			_localctx = new ColorContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ID);
			setState(106);
			match(T__5);
			setState(107);
			match(T__1);
			setState(108);
			expr(0);
			setState(109);
			match(T__2);
			setState(110);
			expr(0);
			setState(111);
			match(T__2);
			setState(112);
			expr(0);
			setState(113);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawFigureContext extends ParserRuleContext {
		public DrawFigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawFigure; }
	 
		public DrawFigureContext() { }
		public void copyFrom(DrawFigureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DrawFigContext extends DrawFigureContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public DrawFigContext(DrawFigureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterDrawFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitDrawFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitDrawFig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DrawFigureContext drawFigure() throws RecognitionException {
		DrawFigureContext _localctx = new DrawFigureContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_drawFigure);
		try {
			_localctx = new DrawFigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__12);
			setState(116);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConsoleContext extends ParserRuleContext {
		public ConsoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_console; }
	 
		public ConsoleContext() { }
		public void copyFrom(ConsoleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintConsoleContext extends ConsoleContext {
		public Token p;
		public TerminalNode String() { return getToken(geometricsParser.String, 0); }
		public PrintConsoleContext(ConsoleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterPrintConsole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitPrintConsole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitPrintConsole(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintConsoleIDContext extends ConsoleContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public PrintConsoleIDContext(ConsoleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterPrintConsoleID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitPrintConsoleID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitPrintConsoleID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsoleContext console() throws RecognitionException {
		ConsoleContext _localctx = new ConsoleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_console);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new PrintConsoleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(T__13);
				setState(119);
				match(T__1);
				setState(120);
				((PrintConsoleContext)_localctx).p = match(String);
				setState(121);
				match(T__3);
				}
				break;
			case T__14:
				_localctx = new PrintConsoleIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__14);
				setState(123);
				match(ID);
				setState(124);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnimationContext extends ParserRuleContext {
		public AnimationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animation; }
	 
		public AnimationContext() { }
		public void copyFrom(AnimationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnimationTranslateContext extends AnimationContext {
		public Token start;
		public Token end;
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public AnimationTranslateContext(AnimationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterAnimationTranslate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitAnimationTranslate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitAnimationTranslate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnimationRotateContext extends AnimationContext {
		public Token start;
		public Token end;
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public AnimationRotateContext(AnimationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterAnimationRotate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitAnimationRotate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitAnimationRotate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnimationContext animation() throws RecognitionException {
		AnimationContext _localctx = new AnimationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_animation);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AnimationTranslateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(ID);
				setState(128);
				match(T__4);
				setState(129);
				match(T__15);
				setState(130);
				match(T__1);
				setState(131);
				expr(0);
				setState(132);
				match(T__2);
				setState(133);
				expr(0);
				setState(134);
				match(T__3);
				setState(135);
				match(T__16);
				setState(136);
				match(T__17);
				setState(137);
				((AnimationTranslateContext)_localctx).start = match(Integer);
				setState(138);
				match(T__18);
				setState(139);
				((AnimationTranslateContext)_localctx).end = match(Integer);
				}
				break;
			case 2:
				_localctx = new AnimationRotateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(ID);
				setState(142);
				match(T__4);
				setState(143);
				match(T__19);
				setState(144);
				match(T__1);
				setState(145);
				expr(0);
				setState(146);
				match(T__2);
				setState(147);
				expr(0);
				setState(148);
				match(T__2);
				setState(149);
				expr(0);
				setState(150);
				match(T__3);
				setState(151);
				match(T__16);
				setState(152);
				match(T__17);
				setState(153);
				((AnimationRotateContext)_localctx).start = match(Integer);
				setState(154);
				match(T__18);
				setState(155);
				((AnimationRotateContext)_localctx).end = match(Integer);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RotateContext extends ParserRuleContext {
		public RotateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotate; }
	 
		public RotateContext() { }
		public void copyFrom(RotateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RotateObjContext extends RotateContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RotateObjContext(RotateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterRotateObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitRotateObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitRotateObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotateContext rotate() throws RecognitionException {
		RotateContext _localctx = new RotateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rotate);
		try {
			_localctx = new RotateObjContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(ID);
			setState(160);
			match(T__4);
			setState(161);
			match(T__19);
			setState(162);
			match(T__1);
			setState(163);
			expr(0);
			setState(164);
			match(T__2);
			setState(165);
			expr(0);
			setState(166);
			match(T__2);
			setState(167);
			expr(0);
			setState(168);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TranslateContext extends ParserRuleContext {
		public TranslateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translate; }
	 
		public TranslateContext() { }
		public void copyFrom(TranslateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TranslateObjContext extends TranslateContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TranslateObjContext(TranslateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterTranslateObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitTranslateObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitTranslateObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslateContext translate() throws RecognitionException {
		TranslateContext _localctx = new TranslateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_translate);
		try {
			_localctx = new TranslateObjContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ID);
			setState(171);
			match(T__4);
			setState(172);
			match(T__15);
			setState(173);
			match(T__1);
			setState(174);
			expr(0);
			setState(175);
			match(T__2);
			setState(176);
			expr(0);
			setState(177);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RandomContext extends ParserRuleContext {
		public RandomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_random; }
	 
		public RandomContext() { }
		public void copyFrom(RandomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RandNumberContext extends RandomContext {
		public Token inicial;
		public Token fim;
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public RandNumberContext(RandomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterRandNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitRandNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitRandNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RandomContext random() throws RecognitionException {
		RandomContext _localctx = new RandomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_random);
		try {
			_localctx = new RandNumberContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__20);
			setState(180);
			match(T__1);
			setState(181);
			((RandNumberContext)_localctx).inicial = match(Integer);
			setState(182);
			match(T__2);
			setState(183);
			((RandNumberContext)_localctx).fim = match(Integer);
			setState(184);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScreenSizeContext extends ParserRuleContext {
		public ScreenSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_screenSize; }
	 
		public ScreenSizeContext() { }
		public void copyFrom(ScreenSizeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DisplaySizeContext extends ScreenSizeContext {
		public Token x;
		public Token y;
		public Token name;
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public TerminalNode String() { return getToken(geometricsParser.String, 0); }
		public DisplaySizeContext(ScreenSizeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterDisplaySize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitDisplaySize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitDisplaySize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScreenSizeContext screenSize() throws RecognitionException {
		ScreenSizeContext _localctx = new ScreenSizeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_screenSize);
		try {
			_localctx = new DisplaySizeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__21);
			setState(187);
			((DisplaySizeContext)_localctx).x = match(Integer);
			setState(188);
			match(T__2);
			setState(189);
			((DisplaySizeContext)_localctx).y = match(Integer);
			setState(190);
			match(T__3);
			setState(191);
			match(T__4);
			setState(192);
			((DisplaySizeContext)_localctx).name = match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprDeclAttrContext extends DeclarationContext {
		public GetAttributeContext getAttribute() {
			return getRuleContext(GetAttributeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprDeclAttrContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprDeclAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprDeclAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprDeclAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDeclIDStringContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public TerminalNode String() { return getToken(geometricsParser.String, 0); }
		public ExprDeclIDStringContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprDeclIDString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprDeclIDString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprDeclIDString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDeclIDContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprDeclIDContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprDeclID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprDeclID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprDeclID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declaration);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ExprDeclAttrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				getAttribute();
				setState(195);
				match(T__5);
				setState(196);
				expr(0);
				}
				break;
			case 2:
				_localctx = new ExprDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(ID);
				setState(199);
				match(T__5);
				setState(200);
				expr(0);
				}
				break;
			case 3:
				_localctx = new ExprDeclIDStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(ID);
				setState(202);
				match(T__5);
				setState(203);
				match(String);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends ConditionalContext {
		public ExprContext cond;
		public StatListContext trueSL;
		public StatListContext falseSL;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
		}
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public IfStatContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conditional);
		int _la;
		try {
			_localctx = new IfStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__22);
			setState(207);
			match(T__1);
			setState(208);
			((IfStatContext)_localctx).cond = expr(0);
			setState(209);
			match(T__23);
			setState(210);
			((IfStatContext)_localctx).trueSL = statList();
			setState(211);
			match(T__9);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(212);
				match(T__24);
				setState(213);
				((IfStatContext)_localctx).falseSL = statList();
				setState(214);
				match(T__9);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForeverStatContext extends LoopContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public ForeverStatContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterForeverStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitForeverStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitForeverStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_loop);
		try {
			_localctx = new ForeverStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__25);
			setState(219);
			match(T__8);
			setState(220);
			statList();
			setState(221);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public String varName;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.varName = ctx.varName;
		}
	}
	public static class ExprGetIDsContext extends ExprContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public ExprGetIDsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprGetIDs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprGetIDs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprGetIDs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParentContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBooleanContext extends ExprContext {
		public TerminalNode BooleanLiteral() { return getToken(geometricsParser.BooleanLiteral, 0); }
		public ExprBooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExperGetAttrContext extends ExprContext {
		public GetAttributeContext getAttribute() {
			return getRuleContext(GetAttributeContext.class,0);
		}
		public ExperGetAttrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExperGetAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExperGetAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExperGetAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultDivModContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRelationContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprRelationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAddSubContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCollisionContext extends ExprContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public ExprCollisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprCollision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprCollision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprCollision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprReadTimerContext extends ExprContext {
		public ExprReadTimerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprReadTimer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprReadTimer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprReadTimer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCollisionFigsContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(geometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(geometricsParser.ID, i);
		}
		public ExprCollisionFigsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprCollisionFigs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprCollisionFigs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprCollisionFigs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRandomContext extends ExprContext {
		public RandomContext random() {
			return getRuleContext(RandomContext.class,0);
		}
		public ExprRandomContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprRandom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprRandom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprRandom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REAL() { return getToken(geometricsParser.REAL, 0); }
		public ExprRealContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprReal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIntegerContext extends ExprContext {
		public TerminalNode Integer() { return getToken(geometricsParser.Integer, 0); }
		public ExprIntegerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterExprInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitExprInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitExprInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(224);
				match(T__1);
				setState(225);
				expr(0);
				setState(226);
				match(T__3);
				}
				break;
			case 2:
				{
				_localctx = new ExprIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(Integer);
				}
				break;
			case 3:
				{
				_localctx = new ExprRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(REAL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(BooleanLiteral);
				}
				break;
			case 5:
				{
				_localctx = new ExperGetAttrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				getAttribute();
				}
				break;
			case 6:
				{
				_localctx = new ExprReadTimerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(T__39);
				}
				break;
			case 7:
				{
				_localctx = new ExprGetIDsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				match(ID);
				}
				break;
			case 8:
				{
				_localctx = new ExprCollisionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(ID);
				setState(235);
				match(T__4);
				setState(236);
				match(T__40);
				}
				break;
			case 9:
				{
				_localctx = new ExprCollisionFigsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(ID);
				setState(238);
				match(T__4);
				setState(239);
				match(T__41);
				setState(240);
				match(T__4);
				setState(241);
				match(ID);
				}
				break;
			case 10:
				{
				_localctx = new ExprRandomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				random();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						((ExprMultDivModContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(246);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						((ExprMultDivModContext)_localctx).e2 = expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						((ExprAddSubContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(249);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						((ExprAddSubContext)_localctx).e2 = expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelationContext(new ExprContext(_parentctx, _parentState));
						((ExprRelationContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(252);
						((ExprRelationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
							((ExprRelationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						((ExprRelationContext)_localctx).e2 = expr(12);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GetPrimitiveContext extends ParserRuleContext {
		public GetPrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getPrimitive; }
	 
		public GetPrimitiveContext() { }
		public void copyFrom(GetPrimitiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetPrimContext extends GetPrimitiveContext {
		public Token figure;
		public Token objeto;
		public List<TerminalNode> ID() { return getTokens(geometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(geometricsParser.ID, i);
		}
		public GetPrimContext(GetPrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterGetPrim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitGetPrim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitGetPrim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetPrimitiveContext getPrimitive() throws RecognitionException {
		GetPrimitiveContext _localctx = new GetPrimitiveContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_getPrimitive);
		try {
			_localctx = new GetPrimContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			((GetPrimContext)_localctx).figure = match(ID);
			setState(260);
			match(T__42);
			setState(261);
			((GetPrimContext)_localctx).objeto = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetAttributeContext extends ParserRuleContext {
		public GetAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getAttribute; }
	 
		public GetAttributeContext() { }
		public void copyFrom(GetAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetAttrContext extends GetAttributeContext {
		public Token figure;
		public Token objeto;
		public Token param;
		public List<TerminalNode> ID() { return getTokens(geometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(geometricsParser.ID, i);
		}
		public GetAttrContext(GetAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterGetAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitGetAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitGetAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetAttributeContext getAttribute() throws RecognitionException {
		GetAttributeContext _localctx = new GetAttributeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_getAttribute);
		try {
			_localctx = new GetAttrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			((GetAttrContext)_localctx).figure = match(ID);
			setState(264);
			match(T__42);
			setState(265);
			((GetAttrContext)_localctx).objeto = match(ID);
			setState(266);
			match(T__27);
			setState(267);
			((GetAttrContext)_localctx).param = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateFigContext extends ParserRuleContext {
		public CreateFigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFig; }
	 
		public CreateFigContext() { }
		public void copyFrom(CreateFigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateFigureFigContext extends CreateFigContext {
		public List<TerminalNode> ID() { return getTokens(geometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(geometricsParser.ID, i);
		}
		public List<TerminalNode> ENDLINE() { return getTokens(geometricsParser.ENDLINE); }
		public TerminalNode ENDLINE(int i) {
			return getToken(geometricsParser.ENDLINE, i);
		}
		public CreateFigureFigContext(CreateFigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateFigureFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateFigureFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateFigureFig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateFigureObjContext extends CreateFigContext {
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public CreateFigureObjContext(CreateFigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateFigureObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateFigureObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateFigureObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateFigContext createFig() throws RecognitionException {
		CreateFigContext _localctx = new CreateFigContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_createFig);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new CreateFigureObjContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(T__43);
				setState(270);
				match(ID);
				setState(271);
				match(T__1);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(272);
					constructor();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new CreateFigureFigContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(T__43);
				setState(280);
				match(ID);
				setState(281);
				match(T__1);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(282);
					match(ID);
					setState(283);
					match(ENDLINE);
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
	 
		public ConstructorContext() { }
		public void copyFrom(ConstructorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateTriangleContext extends ConstructorContext {
		public Token dest;
		public Token x1;
		public Token y1;
		public Token x2;
		public Token y2;
		public Token x3;
		public Token y3;
		public TerminalNode ENDLINE() { return getToken(geometricsParser.ENDLINE, 0); }
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public CreateTriangleContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateTriangle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateTriangle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateTriangle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateLineContext extends ConstructorContext {
		public Token dest;
		public Token x1;
		public Token y1;
		public Token x2;
		public Token y2;
		public TerminalNode ENDLINE() { return getToken(geometricsParser.ENDLINE, 0); }
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public CreateLineContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateSquareContext extends ConstructorContext {
		public Token dest;
		public Token x1;
		public Token y1;
		public Token lengthx;
		public TerminalNode ENDLINE() { return getToken(geometricsParser.ENDLINE, 0); }
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public CreateSquareContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateSquare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateRectContext extends ConstructorContext {
		public Token dest;
		public Token x1;
		public Token y1;
		public Token lengthx;
		public Token lengthy;
		public TerminalNode ENDLINE() { return getToken(geometricsParser.ENDLINE, 0); }
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public CreateRectContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateRect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateRect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateCircleContext extends ConstructorContext {
		public Token dest;
		public Token x;
		public Token y;
		public Token r;
		public TerminalNode ENDLINE() { return getToken(geometricsParser.ENDLINE, 0); }
		public TerminalNode ID() { return getToken(geometricsParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(geometricsParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(geometricsParser.Integer, i);
		}
		public CreateCircleContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).enterCreateCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof geometricsListener ) ((geometricsListener)listener).exitCreateCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof geometricsVisitor ) return ((geometricsVisitor<? extends T>)visitor).visitCreateCircle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constructor);
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new CreateCircleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((CreateCircleContext)_localctx).dest = match(ID);
				setState(293);
				match(T__5);
				setState(294);
				match(T__44);
				setState(295);
				match(T__1);
				setState(296);
				((CreateCircleContext)_localctx).x = match(Integer);
				setState(297);
				match(T__2);
				setState(298);
				((CreateCircleContext)_localctx).y = match(Integer);
				setState(299);
				match(T__2);
				setState(300);
				((CreateCircleContext)_localctx).r = match(Integer);
				setState(301);
				match(T__3);
				setState(302);
				match(ENDLINE);
				}
				break;
			case 2:
				_localctx = new CreateLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				((CreateLineContext)_localctx).dest = match(ID);
				setState(304);
				match(T__5);
				setState(305);
				match(T__45);
				setState(306);
				match(T__1);
				setState(307);
				((CreateLineContext)_localctx).x1 = match(Integer);
				setState(308);
				match(T__2);
				setState(309);
				((CreateLineContext)_localctx).y1 = match(Integer);
				setState(310);
				match(T__2);
				setState(311);
				((CreateLineContext)_localctx).x2 = match(Integer);
				setState(312);
				match(T__2);
				setState(313);
				((CreateLineContext)_localctx).y2 = match(Integer);
				setState(314);
				match(T__3);
				setState(315);
				match(ENDLINE);
				}
				break;
			case 3:
				_localctx = new CreateSquareContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				((CreateSquareContext)_localctx).dest = match(ID);
				setState(317);
				match(T__5);
				setState(318);
				match(T__46);
				setState(319);
				match(T__1);
				setState(320);
				((CreateSquareContext)_localctx).x1 = match(Integer);
				setState(321);
				match(T__2);
				setState(322);
				((CreateSquareContext)_localctx).y1 = match(Integer);
				setState(323);
				match(T__2);
				setState(324);
				((CreateSquareContext)_localctx).lengthx = match(Integer);
				setState(325);
				match(T__3);
				setState(326);
				match(ENDLINE);
				}
				break;
			case 4:
				_localctx = new CreateRectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(327);
				((CreateRectContext)_localctx).dest = match(ID);
				setState(328);
				match(T__5);
				setState(329);
				match(T__47);
				setState(330);
				match(T__1);
				setState(331);
				((CreateRectContext)_localctx).x1 = match(Integer);
				setState(332);
				match(T__2);
				setState(333);
				((CreateRectContext)_localctx).y1 = match(Integer);
				setState(334);
				match(T__2);
				setState(335);
				((CreateRectContext)_localctx).lengthx = match(Integer);
				setState(336);
				match(T__2);
				setState(337);
				((CreateRectContext)_localctx).lengthy = match(Integer);
				setState(338);
				match(T__3);
				setState(339);
				match(ENDLINE);
				}
				break;
			case 5:
				_localctx = new CreateTriangleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(340);
				((CreateTriangleContext)_localctx).dest = match(ID);
				setState(341);
				match(T__5);
				setState(342);
				match(T__48);
				setState(343);
				match(T__1);
				setState(344);
				((CreateTriangleContext)_localctx).x1 = match(Integer);
				setState(345);
				match(T__2);
				setState(346);
				((CreateTriangleContext)_localctx).y1 = match(Integer);
				setState(347);
				match(T__2);
				setState(348);
				((CreateTriangleContext)_localctx).x2 = match(Integer);
				setState(349);
				match(T__2);
				setState(350);
				((CreateTriangleContext)_localctx).y2 = match(Integer);
				setState(351);
				match(T__2);
				setState(352);
				((CreateTriangleContext)_localctx).x3 = match(Integer);
				setState(353);
				match(T__2);
				setState(354);
				((CreateTriangleContext)_localctx).y3 = match(Integer);
				setState(355);
				match(T__3);
				setState(356);
				match(ENDLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u016a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\5\3\67\n\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0080\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a0\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00cf\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00db"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00f6"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0101\n\25\f\25"+
		"\16\25\u0104\13\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\7\30\u0114\n\30\f\30\16\30\u0117\13\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\7\30\u011f\n\30\f\30\16\30\u0122\13\30\3\30\5\30\u0125"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0168\n\31\3\31"+
		"\2\3(\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\5\3\2\35"+
		"\37\3\2 !\3\2\")\2\u017b\2\62\3\2\2\2\4;\3\2\2\2\6O\3\2\2\2\bQ\3\2\2\2"+
		"\n^\3\2\2\2\f`\3\2\2\2\16g\3\2\2\2\20i\3\2\2\2\22k\3\2\2\2\24u\3\2\2\2"+
		"\26\177\3\2\2\2\30\u009f\3\2\2\2\32\u00a1\3\2\2\2\34\u00ac\3\2\2\2\36"+
		"\u00b5\3\2\2\2 \u00bc\3\2\2\2\"\u00ce\3\2\2\2$\u00d0\3\2\2\2&\u00dc\3"+
		"\2\2\2(\u00f5\3\2\2\2*\u0105\3\2\2\2,\u0109\3\2\2\2.\u0124\3\2\2\2\60"+
		"\u0167\3\2\2\2\62\63\5\4\3\2\63\64\7\2\2\3\64\3\3\2\2\2\65\67\5\6\4\2"+
		"\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28:\7\65\2\29\66\3\2\2\2:=\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=;\3\2\2\2>P\5.\30\2?P\5\f\7\2@P\5"+
		"\16\b\2AP\5\20\t\2BP\5\22\n\2CP\5\24\13\2DP\5$\23\2EP\5&\24\2FP\5\"\22"+
		"\2GP\5 \21\2HP\5\34\17\2IP\5\32\16\2JP\5\30\r\2KP\5\26\f\2LP\5\n\6\2M"+
		"P\5\36\20\2NP\5\b\5\2O>\3\2\2\2O?\3\2\2\2O@\3\2\2\2OA\3\2\2\2OB\3\2\2"+
		"\2OC\3\2\2\2OD\3\2\2\2OE\3\2\2\2OF\3\2\2\2OG\3\2\2\2OH\3\2\2\2OI\3\2\2"+
		"\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\7\3\2\2\2QR\7\3"+
		"\2\2RS\7\4\2\2ST\7;\2\2TU\7\5\2\2UV\7;\2\2VW\7\5\2\2WX\7;\2\2XY\7\6\2"+
		"\2YZ\7\7\2\2Z[\7:\2\2[\\\7\b\2\2\\]\7:\2\2]\t\3\2\2\2^_\7\t\2\2_\13\3"+
		"\2\2\2`a\7\n\2\2ab\7\7\2\2bc\7:\2\2cd\7\13\2\2de\5\4\3\2ef\7\f\2\2f\r"+
		"\3\2\2\2gh\7\r\2\2h\17\3\2\2\2ij\7\16\2\2j\21\3\2\2\2kl\7:\2\2lm\7\b\2"+
		"\2mn\7\4\2\2no\5(\25\2op\7\5\2\2pq\5(\25\2qr\7\5\2\2rs\5(\25\2st\7\6\2"+
		"\2t\23\3\2\2\2uv\7\17\2\2vw\7:\2\2w\25\3\2\2\2xy\7\20\2\2yz\7\4\2\2z{"+
		"\79\2\2{\u0080\7\6\2\2|}\7\21\2\2}~\7:\2\2~\u0080\7\6\2\2\177x\3\2\2\2"+
		"\177|\3\2\2\2\u0080\27\3\2\2\2\u0081\u0082\7:\2\2\u0082\u0083\7\7\2\2"+
		"\u0083\u0084\7\22\2\2\u0084\u0085\7\4\2\2\u0085\u0086\5(\25\2\u0086\u0087"+
		"\7\5\2\2\u0087\u0088\5(\25\2\u0088\u0089\7\6\2\2\u0089\u008a\7\23\2\2"+
		"\u008a\u008b\7\24\2\2\u008b\u008c\7;\2\2\u008c\u008d\7\25\2\2\u008d\u008e"+
		"\7;\2\2\u008e\u00a0\3\2\2\2\u008f\u0090\7:\2\2\u0090\u0091\7\7\2\2\u0091"+
		"\u0092\7\26\2\2\u0092\u0093\7\4\2\2\u0093\u0094\5(\25\2\u0094\u0095\7"+
		"\5\2\2\u0095\u0096\5(\25\2\u0096\u0097\7\5\2\2\u0097\u0098\5(\25\2\u0098"+
		"\u0099\7\6\2\2\u0099\u009a\7\23\2\2\u009a\u009b\7\24\2\2\u009b\u009c\7"+
		";\2\2\u009c\u009d\7\25\2\2\u009d\u009e\7;\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u0081\3\2\2\2\u009f\u008f\3\2\2\2\u00a0\31\3\2\2\2\u00a1\u00a2\7:\2\2"+
		"\u00a2\u00a3\7\7\2\2\u00a3\u00a4\7\26\2\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6"+
		"\5(\25\2\u00a6\u00a7\7\5\2\2\u00a7\u00a8\5(\25\2\u00a8\u00a9\7\5\2\2\u00a9"+
		"\u00aa\5(\25\2\u00aa\u00ab\7\6\2\2\u00ab\33\3\2\2\2\u00ac\u00ad\7:\2\2"+
		"\u00ad\u00ae\7\7\2\2\u00ae\u00af\7\22\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1"+
		"\5(\25\2\u00b1\u00b2\7\5\2\2\u00b2\u00b3\5(\25\2\u00b3\u00b4\7\6\2\2\u00b4"+
		"\35\3\2\2\2\u00b5\u00b6\7\27\2\2\u00b6\u00b7\7\4\2\2\u00b7\u00b8\7;\2"+
		"\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\7;\2\2\u00ba\u00bb\7\6\2\2\u00bb\37"+
		"\3\2\2\2\u00bc\u00bd\7\30\2\2\u00bd\u00be\7;\2\2\u00be\u00bf\7\5\2\2\u00bf"+
		"\u00c0\7;\2\2\u00c0\u00c1\7\6\2\2\u00c1\u00c2\7\7\2\2\u00c2\u00c3\79\2"+
		"\2\u00c3!\3\2\2\2\u00c4\u00c5\5,\27\2\u00c5\u00c6\7\b\2\2\u00c6\u00c7"+
		"\5(\25\2\u00c7\u00cf\3\2\2\2\u00c8\u00c9\7:\2\2\u00c9\u00ca\7\b\2\2\u00ca"+
		"\u00cf\5(\25\2\u00cb\u00cc\7:\2\2\u00cc\u00cd\7\b\2\2\u00cd\u00cf\79\2"+
		"\2\u00ce\u00c4\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cf#"+
		"\3\2\2\2\u00d0\u00d1\7\31\2\2\u00d1\u00d2\7\4\2\2\u00d2\u00d3\5(\25\2"+
		"\u00d3\u00d4\7\32\2\2\u00d4\u00d5\5\4\3\2\u00d5\u00da\7\f\2\2\u00d6\u00d7"+
		"\7\33\2\2\u00d7\u00d8\5\4\3\2\u00d8\u00d9\7\f\2\2\u00d9\u00db\3\2\2\2"+
		"\u00da\u00d6\3\2\2\2\u00da\u00db\3\2\2\2\u00db%\3\2\2\2\u00dc\u00dd\7"+
		"\34\2\2\u00dd\u00de\7\13\2\2\u00de\u00df\5\4\3\2\u00df\u00e0\7\f\2\2\u00e0"+
		"\'\3\2\2\2\u00e1\u00e2\b\25\1\2\u00e2\u00e3\7\4\2\2\u00e3\u00e4\5(\25"+
		"\2\u00e4\u00e5\7\6\2\2\u00e5\u00f6\3\2\2\2\u00e6\u00f6\7;\2\2\u00e7\u00f6"+
		"\7\66\2\2\u00e8\u00f6\7\64\2\2\u00e9\u00f6\5,\27\2\u00ea\u00f6\7*\2\2"+
		"\u00eb\u00f6\7:\2\2\u00ec\u00ed\7:\2\2\u00ed\u00ee\7\7\2\2\u00ee\u00f6"+
		"\7+\2\2\u00ef\u00f0\7:\2\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\7,\2\2\u00f2"+
		"\u00f3\7\7\2\2\u00f3\u00f6\7:\2\2\u00f4\u00f6\5\36\20\2\u00f5\u00e1\3"+
		"\2\2\2\u00f5\u00e6\3\2\2\2\u00f5\u00e7\3\2\2\2\u00f5\u00e8\3\2\2\2\u00f5"+
		"\u00e9\3\2\2\2\u00f5\u00ea\3\2\2\2\u00f5\u00eb\3\2\2\2\u00f5\u00ec\3\2"+
		"\2\2\u00f5\u00ef\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u0102\3\2\2\2\u00f7"+
		"\u00f8\f\17\2\2\u00f8\u00f9\t\2\2\2\u00f9\u0101\5(\25\20\u00fa\u00fb\f"+
		"\16\2\2\u00fb\u00fc\t\3\2\2\u00fc\u0101\5(\25\17\u00fd\u00fe\f\r\2\2\u00fe"+
		"\u00ff\t\4\2\2\u00ff\u0101\5(\25\16\u0100\u00f7\3\2\2\2\u0100\u00fa\3"+
		"\2\2\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103)\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7:\2\2\u0106"+
		"\u0107\7-\2\2\u0107\u0108\7:\2\2\u0108+\3\2\2\2\u0109\u010a\7:\2\2\u010a"+
		"\u010b\7-\2\2\u010b\u010c\7:\2\2\u010c\u010d\7\36\2\2\u010d\u010e\7:\2"+
		"\2\u010e-\3\2\2\2\u010f\u0110\7.\2\2\u0110\u0111\7:\2\2\u0111\u0115\7"+
		"\4\2\2\u0112\u0114\5\60\31\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2"+
		"\2\2\u0118\u0125\7\6\2\2\u0119\u011a\7.\2\2\u011a\u011b\7:\2\2\u011b\u0120"+
		"\7\4\2\2\u011c\u011d\7:\2\2\u011d\u011f\7\65\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0125\7\6\2\2\u0124\u010f\3\2\2\2\u0124"+
		"\u0119\3\2\2\2\u0125/\3\2\2\2\u0126\u0127\7:\2\2\u0127\u0128\7\b\2\2\u0128"+
		"\u0129\7/\2\2\u0129\u012a\7\4\2\2\u012a\u012b\7;\2\2\u012b\u012c\7\5\2"+
		"\2\u012c\u012d\7;\2\2\u012d\u012e\7\5\2\2\u012e\u012f\7;\2\2\u012f\u0130"+
		"\7\6\2\2\u0130\u0168\7\65\2\2\u0131\u0132\7:\2\2\u0132\u0133\7\b\2\2\u0133"+
		"\u0134\7\60\2\2\u0134\u0135\7\4\2\2\u0135\u0136\7;\2\2\u0136\u0137\7\5"+
		"\2\2\u0137\u0138\7;\2\2\u0138\u0139\7\5\2\2\u0139\u013a\7;\2\2\u013a\u013b"+
		"\7\5\2\2\u013b\u013c\7;\2\2\u013c\u013d\7\6\2\2\u013d\u0168\7\65\2\2\u013e"+
		"\u013f\7:\2\2\u013f\u0140\7\b\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7\4"+
		"\2\2\u0142\u0143\7;\2\2\u0143\u0144\7\5\2\2\u0144\u0145\7;\2\2\u0145\u0146"+
		"\7\5\2\2\u0146\u0147\7;\2\2\u0147\u0148\7\6\2\2\u0148\u0168\7\65\2\2\u0149"+
		"\u014a\7:\2\2\u014a\u014b\7\b\2\2\u014b\u014c\7\62\2\2\u014c\u014d\7\4"+
		"\2\2\u014d\u014e\7;\2\2\u014e\u014f\7\5\2\2\u014f\u0150\7;\2\2\u0150\u0151"+
		"\7\5\2\2\u0151\u0152\7;\2\2\u0152\u0153\7\5\2\2\u0153\u0154\7;\2\2\u0154"+
		"\u0155\7\6\2\2\u0155\u0168\7\65\2\2\u0156\u0157\7:\2\2\u0157\u0158\7\b"+
		"\2\2\u0158\u0159\7\63\2\2\u0159\u015a\7\4\2\2\u015a\u015b\7;\2\2\u015b"+
		"\u015c\7\5\2\2\u015c\u015d\7;\2\2\u015d\u015e\7\5\2\2\u015e\u015f\7;\2"+
		"\2\u015f\u0160\7\5\2\2\u0160\u0161\7;\2\2\u0161\u0162\7\5\2\2\u0162\u0163"+
		"\7;\2\2\u0163\u0164\7\5\2\2\u0164\u0165\7;\2\2\u0165\u0166\7\6\2\2\u0166"+
		"\u0168\7\65\2\2\u0167\u0126\3\2\2\2\u0167\u0131\3\2\2\2\u0167\u013e\3"+
		"\2\2\2\u0167\u0149\3\2\2\2\u0167\u0156\3\2\2\2\u0168\61\3\2\2\2\20\66"+
		";O\177\u009f\u00ce\u00da\u00f5\u0100\u0102\u0115\u0120\u0124\u0167";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}