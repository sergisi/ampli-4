package spreadsheet;

import expression.Expression;
import expression.composable.Operation;
import expression.simple.EitherValue;
import expression.simple.Reference;
import expression.simple.RightValue;
import sheet.Sheet;

public class SpreadSheet {
    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(Expression expr1, Expression expr2) {
        return Operation.sum(expr1, expr2);
    }

    public static Expression plus(Expression expr1, int value2) {
        return Operation.sum(expr1, new RightValue(value2));
    }

    public static Expression plus(Expression expr1, String ref2) {
        return Operation.sum(expr1, new Reference(SHEET.get(ref2)));
    }

    public static Expression plus(int value2, Expression expr1) {
        return Operation.sum(expr1, new RightValue(value2));
    }


    public static Expression plus(int value1, int value2) {
        return Operation.sum(new RightValue(value1), new RightValue(value2));
    }


    public static Expression plus(int value1, String ref2) {
        return Operation.sum(new Reference(SHEET.get(ref2)), new RightValue(value1));
    }


    public static Expression plus(String ref2, Expression expr1) {
        return Operation.sum(expr1, new Reference(SHEET.get(ref2)));
    }

    public static Expression plus(String ref1, int value2) {
        return Operation.sum(new Reference(SHEET.get(ref1)), new RightValue(value2));
    }

    public static Expression plus(String ref1, String ref2) {
        return Operation.sum(new Reference(SHEET.get(ref1)), new Reference(SHEET.get(ref2)));
    }

    public static Expression mult(Expression expr1, Expression expr2) {
        return Operation.mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, int value2) {
        return Operation.mult(expr1, new RightValue(value2));
    }

    public static Expression mult(Expression expr1, String ref2) {
        return Operation.mult(expr1, new Reference(SHEET.get(ref2)));
    }

    public static Expression mult(int value2, Expression expr1) {
        return Operation.mult(expr1, new RightValue(value2));
    }


    public static Expression mult(int value1, int value2) {
        return Operation.mult(new RightValue(value1), new RightValue(value2));
    }


    public static Expression mult(int value1, String ref2) {
        return Operation.mult(new Reference(SHEET.get(ref2)), new RightValue(value1));
    }


    public static Expression mult(String ref2, Expression expr1) {
        return Operation.mult(expr1, new Reference(SHEET.get(ref2)));
    }

    public static Expression mult(String ref1, int value2) {
        return Operation.mult(new Reference(SHEET.get(ref1)), new RightValue(value2));
    }

    public static Expression mult(String ref1, String ref2) {
        return Operation.mult(new Reference(SHEET.get(ref1)), new Reference(SHEET.get(ref2)));
    }

    public static EitherValue get(String name){
        return SHEET.get(name).evaluate();
    }

    public static void put(String name, Expression expr){
        SHEET.put(name, expr);
    }

    public static void put(String name, int value){
        SHEET.put(name, new RightValue(value));
    }

    public static void put(String name, String refName){
        SHEET.put(name, new Reference(SHEET.get(refName)));
    }

    public static void clear(){
        SHEET.clear();
    }
}
