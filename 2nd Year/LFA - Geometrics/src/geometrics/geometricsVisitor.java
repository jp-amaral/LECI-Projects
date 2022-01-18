// Generated from geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link geometricsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface geometricsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link geometricsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(geometricsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link geometricsParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(geometricsParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatCreateFig(geometricsParser.StatCreateFigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatInput}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatInput(geometricsParser.StatInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatImportFile}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatImportFile(geometricsParser.StatImportFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatResetTime}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatResetTime(geometricsParser.StatResetTimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatColor}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatColor(geometricsParser.StatColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatDrawFigure}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatDrawFigure(geometricsParser.StatDrawFigureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatCond}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatCond(geometricsParser.StatCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatLoop}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatLoop(geometricsParser.StatLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatDecl}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatDecl(geometricsParser.StatDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatScreenSize}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatScreenSize(geometricsParser.StatScreenSizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatTranslate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatTranslate(geometricsParser.StatTranslateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatRotate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatRotate(geometricsParser.StatRotateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAnimate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAnimate(geometricsParser.StatAnimateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatConsole}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatConsole(geometricsParser.StatConsoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatExit}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExit(geometricsParser.StatExitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatRandom}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatRandom(geometricsParser.StatRandomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatString}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatString(geometricsParser.StatStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DrawStringPY}
	 * labeled alternative in {@link geometricsParser#drawString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawStringPY(geometricsParser.DrawStringPYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExitProgram}
	 * labeled alternative in {@link geometricsParser#exit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitProgram(geometricsParser.ExitProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UserInput}
	 * labeled alternative in {@link geometricsParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserInput(geometricsParser.UserInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importFigures}
	 * labeled alternative in {@link geometricsParser#importFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFigures(geometricsParser.ImportFiguresContext ctx);
	/**
	 * Visit a parse tree produced by the {@code resetTimer}
	 * labeled alternative in {@link geometricsParser#resetTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetTimer(geometricsParser.ResetTimerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Color}
	 * labeled alternative in {@link geometricsParser#createColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(geometricsParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code drawFig}
	 * labeled alternative in {@link geometricsParser#drawFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawFig(geometricsParser.DrawFigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printConsole}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintConsole(geometricsParser.PrintConsoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printConsoleID}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintConsoleID(geometricsParser.PrintConsoleIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code animationTranslate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimationTranslate(geometricsParser.AnimationTranslateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code animationRotate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimationRotate(geometricsParser.AnimationRotateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rotateObj}
	 * labeled alternative in {@link geometricsParser#rotate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotateObj(geometricsParser.RotateObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code translateObj}
	 * labeled alternative in {@link geometricsParser#translate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslateObj(geometricsParser.TranslateObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code randNumber}
	 * labeled alternative in {@link geometricsParser#random}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandNumber(geometricsParser.RandNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code displaySize}
	 * labeled alternative in {@link geometricsParser#screenSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplaySize(geometricsParser.DisplaySizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDeclAttr}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDeclAttr(geometricsParser.ExprDeclAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDeclID}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDeclID(geometricsParser.ExprDeclIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDeclIDString}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDeclIDString(geometricsParser.ExprDeclIDStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link geometricsParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(geometricsParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreverStat}
	 * labeled alternative in {@link geometricsParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeverStat(geometricsParser.ForeverStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprGetIDs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGetIDs(geometricsParser.ExprGetIDsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(geometricsParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBoolean(geometricsParser.ExprBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExperGetAttr}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExperGetAttr(geometricsParser.ExperGetAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(geometricsParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelation}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelation(geometricsParser.ExprRelationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(geometricsParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCollision}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCollision(geometricsParser.ExprCollisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprReadTimer}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReadTimer(geometricsParser.ExprReadTimerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCollisionFigs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCollisionFigs(geometricsParser.ExprCollisionFigsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRandom}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRandom(geometricsParser.ExprRandomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprReal}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReal(geometricsParser.ExprRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInteger(geometricsParser.ExprIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getPrim}
	 * labeled alternative in {@link geometricsParser#getPrimitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetPrim(geometricsParser.GetPrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetAttr}
	 * labeled alternative in {@link geometricsParser#getAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetAttr(geometricsParser.GetAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFigureObj(geometricsParser.CreateFigureObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createFigureFig}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFigureFig(geometricsParser.CreateFigureFigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCircle(geometricsParser.CreateCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLine(geometricsParser.CreateLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSquare(geometricsParser.CreateSquareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRect(geometricsParser.CreateRectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriangle(geometricsParser.CreateTriangleContext ctx);
}