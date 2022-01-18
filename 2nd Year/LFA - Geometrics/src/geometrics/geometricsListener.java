// Generated from geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link geometricsParser}.
 */
public interface geometricsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link geometricsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(geometricsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link geometricsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(geometricsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link geometricsParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(geometricsParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link geometricsParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(geometricsParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatCreateFig(geometricsParser.StatCreateFigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatCreateFig}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatCreateFig(geometricsParser.StatCreateFigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatInput}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatInput(geometricsParser.StatInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatInput}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatInput(geometricsParser.StatInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatImportFile}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatImportFile(geometricsParser.StatImportFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatImportFile}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatImportFile(geometricsParser.StatImportFileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatResetTime}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatResetTime(geometricsParser.StatResetTimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatResetTime}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatResetTime(geometricsParser.StatResetTimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatColor}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatColor(geometricsParser.StatColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatColor}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatColor(geometricsParser.StatColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatDrawFigure}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatDrawFigure(geometricsParser.StatDrawFigureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatDrawFigure}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatDrawFigure(geometricsParser.StatDrawFigureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatCond}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatCond(geometricsParser.StatCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatCond}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatCond(geometricsParser.StatCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatLoop}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatLoop(geometricsParser.StatLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatLoop}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatLoop(geometricsParser.StatLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatDecl}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatDecl(geometricsParser.StatDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatDecl}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatDecl(geometricsParser.StatDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatScreenSize}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatScreenSize(geometricsParser.StatScreenSizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatScreenSize}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatScreenSize(geometricsParser.StatScreenSizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatTranslate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatTranslate(geometricsParser.StatTranslateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatTranslate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatTranslate(geometricsParser.StatTranslateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatRotate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatRotate(geometricsParser.StatRotateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatRotate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatRotate(geometricsParser.StatRotateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAnimate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAnimate(geometricsParser.StatAnimateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAnimate}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAnimate(geometricsParser.StatAnimateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatConsole}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatConsole(geometricsParser.StatConsoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatConsole}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatConsole(geometricsParser.StatConsoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatExit}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExit(geometricsParser.StatExitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatExit}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExit(geometricsParser.StatExitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatRandom}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatRandom(geometricsParser.StatRandomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatRandom}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatRandom(geometricsParser.StatRandomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatString}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatString(geometricsParser.StatStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatString}
	 * labeled alternative in {@link geometricsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatString(geometricsParser.StatStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DrawStringPY}
	 * labeled alternative in {@link geometricsParser#drawString}.
	 * @param ctx the parse tree
	 */
	void enterDrawStringPY(geometricsParser.DrawStringPYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DrawStringPY}
	 * labeled alternative in {@link geometricsParser#drawString}.
	 * @param ctx the parse tree
	 */
	void exitDrawStringPY(geometricsParser.DrawStringPYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExitProgram}
	 * labeled alternative in {@link geometricsParser#exit}.
	 * @param ctx the parse tree
	 */
	void enterExitProgram(geometricsParser.ExitProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExitProgram}
	 * labeled alternative in {@link geometricsParser#exit}.
	 * @param ctx the parse tree
	 */
	void exitExitProgram(geometricsParser.ExitProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UserInput}
	 * labeled alternative in {@link geometricsParser#input}.
	 * @param ctx the parse tree
	 */
	void enterUserInput(geometricsParser.UserInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UserInput}
	 * labeled alternative in {@link geometricsParser#input}.
	 * @param ctx the parse tree
	 */
	void exitUserInput(geometricsParser.UserInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importFigures}
	 * labeled alternative in {@link geometricsParser#importFile}.
	 * @param ctx the parse tree
	 */
	void enterImportFigures(geometricsParser.ImportFiguresContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importFigures}
	 * labeled alternative in {@link geometricsParser#importFile}.
	 * @param ctx the parse tree
	 */
	void exitImportFigures(geometricsParser.ImportFiguresContext ctx);
	/**
	 * Enter a parse tree produced by the {@code resetTimer}
	 * labeled alternative in {@link geometricsParser#resetTime}.
	 * @param ctx the parse tree
	 */
	void enterResetTimer(geometricsParser.ResetTimerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code resetTimer}
	 * labeled alternative in {@link geometricsParser#resetTime}.
	 * @param ctx the parse tree
	 */
	void exitResetTimer(geometricsParser.ResetTimerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Color}
	 * labeled alternative in {@link geometricsParser#createColor}.
	 * @param ctx the parse tree
	 */
	void enterColor(geometricsParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Color}
	 * labeled alternative in {@link geometricsParser#createColor}.
	 * @param ctx the parse tree
	 */
	void exitColor(geometricsParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code drawFig}
	 * labeled alternative in {@link geometricsParser#drawFigure}.
	 * @param ctx the parse tree
	 */
	void enterDrawFig(geometricsParser.DrawFigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code drawFig}
	 * labeled alternative in {@link geometricsParser#drawFigure}.
	 * @param ctx the parse tree
	 */
	void exitDrawFig(geometricsParser.DrawFigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printConsole}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 */
	void enterPrintConsole(geometricsParser.PrintConsoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printConsole}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 */
	void exitPrintConsole(geometricsParser.PrintConsoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printConsoleID}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 */
	void enterPrintConsoleID(geometricsParser.PrintConsoleIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printConsoleID}
	 * labeled alternative in {@link geometricsParser#console}.
	 * @param ctx the parse tree
	 */
	void exitPrintConsoleID(geometricsParser.PrintConsoleIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code animationTranslate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 */
	void enterAnimationTranslate(geometricsParser.AnimationTranslateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code animationTranslate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 */
	void exitAnimationTranslate(geometricsParser.AnimationTranslateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code animationRotate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 */
	void enterAnimationRotate(geometricsParser.AnimationRotateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code animationRotate}
	 * labeled alternative in {@link geometricsParser#animation}.
	 * @param ctx the parse tree
	 */
	void exitAnimationRotate(geometricsParser.AnimationRotateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rotateObj}
	 * labeled alternative in {@link geometricsParser#rotate}.
	 * @param ctx the parse tree
	 */
	void enterRotateObj(geometricsParser.RotateObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rotateObj}
	 * labeled alternative in {@link geometricsParser#rotate}.
	 * @param ctx the parse tree
	 */
	void exitRotateObj(geometricsParser.RotateObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code translateObj}
	 * labeled alternative in {@link geometricsParser#translate}.
	 * @param ctx the parse tree
	 */
	void enterTranslateObj(geometricsParser.TranslateObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code translateObj}
	 * labeled alternative in {@link geometricsParser#translate}.
	 * @param ctx the parse tree
	 */
	void exitTranslateObj(geometricsParser.TranslateObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code randNumber}
	 * labeled alternative in {@link geometricsParser#random}.
	 * @param ctx the parse tree
	 */
	void enterRandNumber(geometricsParser.RandNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code randNumber}
	 * labeled alternative in {@link geometricsParser#random}.
	 * @param ctx the parse tree
	 */
	void exitRandNumber(geometricsParser.RandNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code displaySize}
	 * labeled alternative in {@link geometricsParser#screenSize}.
	 * @param ctx the parse tree
	 */
	void enterDisplaySize(geometricsParser.DisplaySizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code displaySize}
	 * labeled alternative in {@link geometricsParser#screenSize}.
	 * @param ctx the parse tree
	 */
	void exitDisplaySize(geometricsParser.DisplaySizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDeclAttr}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterExprDeclAttr(geometricsParser.ExprDeclAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDeclAttr}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitExprDeclAttr(geometricsParser.ExprDeclAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDeclID}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterExprDeclID(geometricsParser.ExprDeclIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDeclID}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitExprDeclID(geometricsParser.ExprDeclIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDeclIDString}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterExprDeclIDString(geometricsParser.ExprDeclIDStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDeclIDString}
	 * labeled alternative in {@link geometricsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitExprDeclIDString(geometricsParser.ExprDeclIDStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link geometricsParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(geometricsParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link geometricsParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(geometricsParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code foreverStat}
	 * labeled alternative in {@link geometricsParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterForeverStat(geometricsParser.ForeverStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code foreverStat}
	 * labeled alternative in {@link geometricsParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitForeverStat(geometricsParser.ForeverStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprGetIDs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprGetIDs(geometricsParser.ExprGetIDsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprGetIDs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprGetIDs(geometricsParser.ExprGetIDsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(geometricsParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(geometricsParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBoolean(geometricsParser.ExprBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBoolean(geometricsParser.ExprBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExperGetAttr}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExperGetAttr(geometricsParser.ExperGetAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExperGetAttr}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExperGetAttr(geometricsParser.ExperGetAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(geometricsParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(geometricsParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRelation}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRelation(geometricsParser.ExprRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRelation}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRelation(geometricsParser.ExprRelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(geometricsParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(geometricsParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCollision}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCollision(geometricsParser.ExprCollisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCollision}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCollision(geometricsParser.ExprCollisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReadTimer}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReadTimer(geometricsParser.ExprReadTimerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReadTimer}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReadTimer(geometricsParser.ExprReadTimerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCollisionFigs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCollisionFigs(geometricsParser.ExprCollisionFigsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCollisionFigs}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCollisionFigs(geometricsParser.ExprCollisionFigsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRandom}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRandom(geometricsParser.ExprRandomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRandom}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRandom(geometricsParser.ExprRandomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReal}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReal(geometricsParser.ExprRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReal}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReal(geometricsParser.ExprRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(geometricsParser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link geometricsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(geometricsParser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getPrim}
	 * labeled alternative in {@link geometricsParser#getPrimitive}.
	 * @param ctx the parse tree
	 */
	void enterGetPrim(geometricsParser.GetPrimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getPrim}
	 * labeled alternative in {@link geometricsParser#getPrimitive}.
	 * @param ctx the parse tree
	 */
	void exitGetPrim(geometricsParser.GetPrimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetAttr}
	 * labeled alternative in {@link geometricsParser#getAttribute}.
	 * @param ctx the parse tree
	 */
	void enterGetAttr(geometricsParser.GetAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetAttr}
	 * labeled alternative in {@link geometricsParser#getAttribute}.
	 * @param ctx the parse tree
	 */
	void exitGetAttr(geometricsParser.GetAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 */
	void enterCreateFigureObj(geometricsParser.CreateFigureObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createFigureObj}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 */
	void exitCreateFigureObj(geometricsParser.CreateFigureObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createFigureFig}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 */
	void enterCreateFigureFig(geometricsParser.CreateFigureFigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createFigureFig}
	 * labeled alternative in {@link geometricsParser#createFig}.
	 * @param ctx the parse tree
	 */
	void exitCreateFigureFig(geometricsParser.CreateFigureFigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateCircle(geometricsParser.CreateCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createCircle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateCircle(geometricsParser.CreateCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateLine(geometricsParser.CreateLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createLine}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateLine(geometricsParser.CreateLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateSquare(geometricsParser.CreateSquareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createSquare}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateSquare(geometricsParser.CreateSquareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateRect(geometricsParser.CreateRectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createRect}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateRect(geometricsParser.CreateRectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterCreateTriangle(geometricsParser.CreateTriangleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTriangle}
	 * labeled alternative in {@link geometricsParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitCreateTriangle(geometricsParser.CreateTriangleContext ctx);
}