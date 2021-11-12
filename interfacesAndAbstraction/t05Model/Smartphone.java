package interfacesAndAbstraction.t05Model;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sbBrowse = new StringBuilder();
        this.urls.forEach(url -> {
            boolean isDigit = false;
            if (url.equals("")) {
                isDigit = true;
            }
            char[] symbols = url.toCharArray();

            for (int i = 0; i < symbols.length; i++) {
                char currentSymbol = symbols[i];
                if(Character.isDigit(currentSymbol)) {
                    isDigit = true;
                    break;
                }
            }
            if (!isDigit) {
                sbBrowse.append("Browsing: ").append(url).append(System.lineSeparator());
            } else {
                sbBrowse.append("Invalid URL!").append(System.lineSeparator());
            }
        });

        return sbBrowse.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sbCall = new StringBuilder();

        this.numbers.forEach(n -> {
            boolean isNotDigit = false;
            if (n.equals("")) {
                isNotDigit = true;
            }

            char[] digits = n.toCharArray();
            for (int i = 0; i < digits.length; i++) {
                char currentSymbol = digits[i];
                if(!Character.isDigit(currentSymbol)) {
                    isNotDigit = true;
                    break;
                }
            }
            if (!isNotDigit) {
                sbCall.append("Calling... ").append(n).append(System.lineSeparator());
            } else {
                sbCall.append("Invalid number!").append(System.lineSeparator());
            }
        });

        return sbCall.toString().trim();
    }
}
