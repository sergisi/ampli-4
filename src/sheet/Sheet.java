package sheet;

import expression.Expression;
import expression.simple.EitherValue;
import expression.simple.LeftError;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sheet {
    private final int measure;
    private final Pattern pattern;
    private HashMap<String, Cell> map;

    public Sheet(int measure) {
        this.measure = measure;
        map = new HashMap<>();
        pattern = Pattern.compile("^(?<chars>[a-zA-Z]+)(?<numb>\\d+)$");
    }

    public Cell get(String toget) {
        if (safe(toget)) {
            return map.get(toget);
        }
        throw new NoSuchElementException("The reference was outside the sheet! " + toget);
    }

    private boolean safe(String toget) {
        if (map.containsKey(toget))
            return true;
        if (validateString(toget)) {
            map.put(toget, new Cell());
            return true;
        }
        return false;

    }

    public void put(String toput, Expression expression) {
        if (safe(toput)) {
            Cell cell = map.get(toput);
            cell.set(expression);
        } else {
            throw new NoSuchElementException("The reference was outside the sheet! " + toput);
        }
    }

    boolean validateString(String check) {
        Matcher matcher = pattern.matcher(check);
        if (matcher.matches()) {
            int chars = charsToNumbers(matcher.group("chars"));
            int numbs = Integer.parseInt(matcher.group("numb"));
            return 0 < chars && chars <= measure
                    && 0 < numbs && numbs <= measure;
        }
        return false;
    }

    static int charsToNumbers(String chars) {
        int res = 0;
        for (int i : chars.toCharArray()) {
            res = res * 25 + i - 96;
        }
        return res;
    }


    public void clear() {
        map = new HashMap<>();
    }


}
