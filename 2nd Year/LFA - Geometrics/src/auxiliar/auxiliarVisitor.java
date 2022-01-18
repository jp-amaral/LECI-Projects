// Generated from auxiliar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link auxiliarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface auxiliarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link auxiliarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(auxiliarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link auxiliarParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(auxiliarParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link auxiliarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatCreateFig(auxiliarParser.StatCreateFigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link auxiliarParser#createFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFigureObj(auxiliarParser.CreateFigureObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCircle(auxiliarParser.CreateCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRect(auxiliarParser.CreateRectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSquare(auxiliarParser.CreateSquareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLine(auxiliarParser.CreateLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link auxiliarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriangle(auxiliarParser.CreateTriangleContext ctx);
	/**
	 * Visit a parse tree produced by {@link auxiliarParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(auxiliarParser.AttributeContext ctx);
}