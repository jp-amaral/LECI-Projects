// Generated from auxiliar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class auxiliarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Integer=14, Param=15, ID=16, COMMENT=17, 
		WS=18;
	public static final int
		RULE_program = 0, RULE_statList = 1, RULE_stat = 2, RULE_createFigure = 3, 
		RULE_constructor = 4, RULE_attribute = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statList", "stat", "createFigure", "constructor", "attribute"
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

	@Override
	public String getGrammarFileName() { return "auxiliar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public auxiliarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(auxiliarParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			statList();
			setState(13);
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
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitStatList(this);
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
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(15);
				stat();
				}
				}
				setState(20);
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
	public static class StatCreateFigContext extends StatContext {
		public CreateFigureContext createFigure() {
			return getRuleContext(CreateFigureContext.class,0);
		}
		public StatCreateFigContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterStatCreateFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitStatCreateFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitStatCreateFig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			_localctx = new StatCreateFigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			createFigure();
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

	public static class CreateFigureContext extends ParserRuleContext {
		public CreateFigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFigure; }
	 
		public CreateFigureContext() { }
		public void copyFrom(CreateFigureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateFigureObjContext extends CreateFigureContext {
		public Token id;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public CreateFigureObjContext(CreateFigureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateFigureObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateFigureObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateFigureObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateFigureContext createFigure() throws RecognitionException {
		CreateFigureContext _localctx = new CreateFigureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_createFigure);
		int _la;
		try {
			_localctx = new CreateFigureObjContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((CreateFigureObjContext)_localctx).id = match(ID);
			setState(24);
			match(T__0);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(25);
				constructor();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			match(T__1);
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
		public Token id;
		public Token x1;
		public Token y1;
		public Token x2;
		public Token y2;
		public Token x3;
		public Token y3;
		public Token param;
		public AttributeContext attr;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(auxiliarParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(auxiliarParser.Integer, i);
		}
		public List<TerminalNode> Param() { return getTokens(auxiliarParser.Param); }
		public TerminalNode Param(int i) {
			return getToken(auxiliarParser.Param, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public CreateTriangleContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateTriangle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateTriangle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateTriangle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateSquareContext extends ConstructorContext {
		public Token id;
		public Token x1;
		public Token y1;
		public Token lengthx;
		public Token param;
		public AttributeContext attr;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(auxiliarParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(auxiliarParser.Integer, i);
		}
		public List<TerminalNode> Param() { return getTokens(auxiliarParser.Param); }
		public TerminalNode Param(int i) {
			return getToken(auxiliarParser.Param, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public CreateSquareContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateSquare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateLineContext extends ConstructorContext {
		public Token id;
		public Token x1;
		public Token y1;
		public Token x2;
		public Token y2;
		public Token param;
		public AttributeContext attr;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(auxiliarParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(auxiliarParser.Integer, i);
		}
		public List<TerminalNode> Param() { return getTokens(auxiliarParser.Param); }
		public TerminalNode Param(int i) {
			return getToken(auxiliarParser.Param, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public CreateLineContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateRectContext extends ConstructorContext {
		public Token id;
		public Token x1;
		public Token y1;
		public Token lengthx;
		public Token lengthy;
		public Token param;
		public AttributeContext attr;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(auxiliarParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(auxiliarParser.Integer, i);
		}
		public List<TerminalNode> Param() { return getTokens(auxiliarParser.Param); }
		public TerminalNode Param(int i) {
			return getToken(auxiliarParser.Param, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public CreateRectContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateRect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateRect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateCircleContext extends ConstructorContext {
		public Token id;
		public Token x;
		public Token y;
		public Token r;
		public Token param;
		public AttributeContext attr;
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public List<TerminalNode> Integer() { return getTokens(auxiliarParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(auxiliarParser.Integer, i);
		}
		public List<TerminalNode> Param() { return getTokens(auxiliarParser.Param); }
		public TerminalNode Param(int i) {
			return getToken(auxiliarParser.Param, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public CreateCircleContext(ConstructorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterCreateCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitCreateCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitCreateCircle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constructor);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new CreateCircleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				((CreateCircleContext)_localctx).id = match(ID);
				setState(34);
				match(T__2);
				setState(35);
				match(T__3);
				setState(36);
				match(T__4);
				setState(37);
				((CreateCircleContext)_localctx).x = match(Integer);
				setState(38);
				match(T__5);
				setState(39);
				((CreateCircleContext)_localctx).y = match(Integer);
				setState(40);
				match(T__5);
				setState(41);
				((CreateCircleContext)_localctx).r = match(Integer);
				setState(42);
				match(T__6);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(43);
					match(T__0);
					setState(49); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(44);
						((CreateCircleContext)_localctx).param = match(Param);
						setState(45);
						match(T__7);
						setState(46);
						((CreateCircleContext)_localctx).attr = attribute();
						setState(47);
						match(T__8);
						}
						}
						setState(51); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Param );
					setState(53);
					match(T__1);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new CreateRectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((CreateRectContext)_localctx).id = match(ID);
				setState(61);
				match(T__2);
				setState(62);
				match(T__9);
				setState(63);
				match(T__4);
				setState(64);
				((CreateRectContext)_localctx).x1 = match(Integer);
				setState(65);
				match(T__5);
				setState(66);
				((CreateRectContext)_localctx).y1 = match(Integer);
				setState(67);
				match(T__5);
				setState(68);
				((CreateRectContext)_localctx).lengthx = match(Integer);
				setState(69);
				match(T__5);
				setState(70);
				((CreateRectContext)_localctx).lengthy = match(Integer);
				setState(71);
				match(T__6);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(72);
					match(T__0);
					setState(78); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(73);
						((CreateRectContext)_localctx).param = match(Param);
						setState(74);
						match(T__7);
						setState(75);
						((CreateRectContext)_localctx).attr = attribute();
						setState(76);
						match(T__8);
						}
						}
						setState(80); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Param );
					setState(82);
					match(T__1);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				_localctx = new CreateSquareContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((CreateSquareContext)_localctx).id = match(ID);
				setState(90);
				match(T__2);
				setState(91);
				match(T__10);
				setState(92);
				match(T__4);
				setState(93);
				((CreateSquareContext)_localctx).x1 = match(Integer);
				setState(94);
				match(T__5);
				setState(95);
				((CreateSquareContext)_localctx).y1 = match(Integer);
				setState(96);
				match(T__5);
				setState(97);
				((CreateSquareContext)_localctx).lengthx = match(Integer);
				setState(98);
				match(T__6);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(99);
					match(T__0);
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(100);
						((CreateSquareContext)_localctx).param = match(Param);
						setState(101);
						match(T__7);
						setState(102);
						((CreateSquareContext)_localctx).attr = attribute();
						setState(103);
						match(T__8);
						}
						}
						setState(107); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Param );
					setState(109);
					match(T__1);
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				_localctx = new CreateLineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				((CreateLineContext)_localctx).id = match(ID);
				setState(117);
				match(T__2);
				setState(118);
				match(T__11);
				setState(119);
				match(T__4);
				setState(120);
				((CreateLineContext)_localctx).x1 = match(Integer);
				setState(121);
				match(T__5);
				setState(122);
				((CreateLineContext)_localctx).y1 = match(Integer);
				setState(123);
				match(T__5);
				setState(124);
				((CreateLineContext)_localctx).x2 = match(Integer);
				setState(125);
				match(T__5);
				setState(126);
				((CreateLineContext)_localctx).y2 = match(Integer);
				setState(127);
				match(T__6);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(128);
					match(T__0);
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(129);
						((CreateLineContext)_localctx).param = match(Param);
						setState(130);
						match(T__7);
						setState(131);
						((CreateLineContext)_localctx).attr = attribute();
						setState(132);
						match(T__8);
						}
						}
						setState(136); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Param );
					setState(138);
					match(T__1);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 5:
				_localctx = new CreateTriangleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				((CreateTriangleContext)_localctx).id = match(ID);
				setState(146);
				match(T__2);
				setState(147);
				match(T__12);
				setState(148);
				match(T__4);
				setState(149);
				((CreateTriangleContext)_localctx).x1 = match(Integer);
				setState(150);
				match(T__5);
				setState(151);
				((CreateTriangleContext)_localctx).y1 = match(Integer);
				setState(152);
				match(T__5);
				setState(153);
				((CreateTriangleContext)_localctx).x2 = match(Integer);
				setState(154);
				match(T__5);
				setState(155);
				((CreateTriangleContext)_localctx).y2 = match(Integer);
				setState(156);
				match(T__5);
				setState(157);
				((CreateTriangleContext)_localctx).x3 = match(Integer);
				setState(158);
				match(T__5);
				setState(159);
				((CreateTriangleContext)_localctx).y3 = match(Integer);
				setState(160);
				match(T__6);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(161);
					match(T__0);
					setState(167); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(162);
						((CreateTriangleContext)_localctx).param = match(Param);
						setState(163);
						match(T__7);
						setState(164);
						((CreateTriangleContext)_localctx).attr = attribute();
						setState(165);
						match(T__8);
						}
						}
						setState(169); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Param );
					setState(171);
					match(T__1);
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(auxiliarParser.ID, 0); }
		public TerminalNode Integer() { return getToken(auxiliarParser.Integer, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof auxiliarListener ) ((auxiliarListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof auxiliarVisitor ) return ((auxiliarVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u00b9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\7\3\23\n\3\f"+
		"\3\16\3\26\13\3\3\4\3\4\3\5\3\5\3\5\7\5\35\n\5\f\5\16\5 \13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\64"+
		"\n\6\r\6\16\6\65\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6Q\n\6\r\6\16\6R"+
		"\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6l\n\6\r\6\16\6m\3\6\3\6\7\6r\n\6\f\6\16"+
		"\6u\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\6\6\u0089\n\6\r\6\16\6\u008a\3\6\3\6\7\6\u008f\n\6\f\6\16\6"+
		"\u0092\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00aa\n\6\r\6\16\6\u00ab\3\6\3\6\7"+
		"\6\u00b0\n\6\f\6\16\6\u00b3\13\6\5\6\u00b5\n\6\3\7\3\7\3\7\2\2\b\2\4\6"+
		"\b\n\f\2\3\4\2\20\20\22\22\2\u00c2\2\16\3\2\2\2\4\24\3\2\2\2\6\27\3\2"+
		"\2\2\b\31\3\2\2\2\n\u00b4\3\2\2\2\f\u00b6\3\2\2\2\16\17\5\4\3\2\17\20"+
		"\7\2\2\3\20\3\3\2\2\2\21\23\5\6\4\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22"+
		"\3\2\2\2\24\25\3\2\2\2\25\5\3\2\2\2\26\24\3\2\2\2\27\30\5\b\5\2\30\7\3"+
		"\2\2\2\31\32\7\22\2\2\32\36\7\3\2\2\33\35\5\n\6\2\34\33\3\2\2\2\35 \3"+
		"\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\7\4\2\2"+
		"\"\t\3\2\2\2#$\7\22\2\2$%\7\5\2\2%&\7\6\2\2&\'\7\7\2\2\'(\7\20\2\2()\7"+
		"\b\2\2)*\7\20\2\2*+\7\b\2\2+,\7\20\2\2,;\7\t\2\2-\63\7\3\2\2./\7\21\2"+
		"\2/\60\7\n\2\2\60\61\5\f\7\2\61\62\7\13\2\2\62\64\3\2\2\2\63.\3\2\2\2"+
		"\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\4\2\28"+
		":\3\2\2\29-\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\u00b5\3\2\2\2=;\3\2"+
		"\2\2>?\7\22\2\2?@\7\5\2\2@A\7\f\2\2AB\7\7\2\2BC\7\20\2\2CD\7\b\2\2DE\7"+
		"\20\2\2EF\7\b\2\2FG\7\20\2\2GH\7\b\2\2HI\7\20\2\2IX\7\t\2\2JP\7\3\2\2"+
		"KL\7\21\2\2LM\7\n\2\2MN\5\f\7\2NO\7\13\2\2OQ\3\2\2\2PK\3\2\2\2QR\3\2\2"+
		"\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\4\2\2UW\3\2\2\2VJ\3\2\2\2WZ\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y\u00b5\3\2\2\2ZX\3\2\2\2[\\\7\22\2\2\\]\7\5\2\2"+
		"]^\7\r\2\2^_\7\7\2\2_`\7\20\2\2`a\7\b\2\2ab\7\20\2\2bc\7\b\2\2cd\7\20"+
		"\2\2ds\7\t\2\2ek\7\3\2\2fg\7\21\2\2gh\7\n\2\2hi\5\f\7\2ij\7\13\2\2jl\3"+
		"\2\2\2kf\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\4\2\2pr\3"+
		"\2\2\2qe\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\u00b5\3\2\2\2us\3\2\2"+
		"\2vw\7\22\2\2wx\7\5\2\2xy\7\16\2\2yz\7\7\2\2z{\7\20\2\2{|\7\b\2\2|}\7"+
		"\20\2\2}~\7\b\2\2~\177\7\20\2\2\177\u0080\7\b\2\2\u0080\u0081\7\20\2\2"+
		"\u0081\u0090\7\t\2\2\u0082\u0088\7\3\2\2\u0083\u0084\7\21\2\2\u0084\u0085"+
		"\7\n\2\2\u0085\u0086\5\f\7\2\u0086\u0087\7\13\2\2\u0087\u0089\3\2\2\2"+
		"\u0088\u0083\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\4\2\2\u008d\u008f\3\2\2\2\u008e"+
		"\u0082\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u00b5\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\22\2\2\u0094"+
		"\u0095\7\5\2\2\u0095\u0096\7\17\2\2\u0096\u0097\7\7\2\2\u0097\u0098\7"+
		"\20\2\2\u0098\u0099\7\b\2\2\u0099\u009a\7\20\2\2\u009a\u009b\7\b\2\2\u009b"+
		"\u009c\7\20\2\2\u009c\u009d\7\b\2\2\u009d\u009e\7\20\2\2\u009e\u009f\7"+
		"\b\2\2\u009f\u00a0\7\20\2\2\u00a0\u00a1\7\b\2\2\u00a1\u00a2\7\20\2\2\u00a2"+
		"\u00b1\7\t\2\2\u00a3\u00a9\7\3\2\2\u00a4\u00a5\7\21\2\2\u00a5\u00a6\7"+
		"\n\2\2\u00a6\u00a7\5\f\7\2\u00a7\u00a8\7\13\2\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u00a4\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00a3\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4#\3\2\2\2\u00b4>\3\2"+
		"\2\2\u00b4[\3\2\2\2\u00b4v\3\2\2\2\u00b4\u0093\3\2\2\2\u00b5\13\3\2\2"+
		"\2\u00b6\u00b7\t\2\2\2\u00b7\r\3\2\2\2\17\24\36\65;RXms\u008a\u0090\u00ab"+
		"\u00b1\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}