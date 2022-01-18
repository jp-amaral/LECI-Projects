// Generated from auxiliar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link auxiliarParser}.
 */
public interface auxiliarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link auxiliarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(auxiliarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link auxiliarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(auxiliarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link auxiliarParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(auxiliarParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link auxiliarParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(auxiliarParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link auxiliarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatCreateFig(auxiliarParser.StatCreateFigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link auxiliarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatCreateFig(auxiliarParser.StatCreateFigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link auxiliarParser#createFigure}.
	 * @param ctx the parse tree
	 */
	void enterCreateFigureObj(auxiliarParser.CreateFigureObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link auxiliarParser#createFigure}.
	 * @param ctx the parse tree
	 */
	void exitCreateFigureObj(auxiliarParser.CreateFigureObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateCircle(auxiliarParser.CreateCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateCircle(auxiliarParser.CreateCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateRect(auxiliarParser.CreateRectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateRect(auxiliarParser.CreateRectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateSquare(auxiliarParser.CreateSquareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateSquare(auxiliarParser.CreateSquareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateLine(auxiliarParser.CreateLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateLine(auxiliarParser.CreateLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateTriangle(auxiliarParser.CreateTriangleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateTriangle(auxiliarParser.CreateTriangleContext ctx);
	/**
	 * Enter a parse tree produced by {@link auxiliarParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(auxiliarParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link auxiliarParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(auxiliarParser.AttributeContext ctx);
}