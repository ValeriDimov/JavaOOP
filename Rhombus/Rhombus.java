package Rhombus;

public class Rhombus {
    private final int size;

    public Rhombus(int size) {
        this.size = size;
    }


    public void printRhombus(int size) {
        System.out.println(this.printTop(size));
        System.out.println(this.printMiddle(size));
        System.out.println(this.printBottom(size));
    }

    public String printTop(int n) {
        StringBuilder sb = new StringBuilder();
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n - r; c++) {
                sb.append(" ");
            }
            for (int cS = n - r; cS < n; cS++) {
                sb.append("* ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String printMiddle(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("* ");
        }
        return sb.toString();
    }

    public String printBottom(int n) {
        StringBuilder sb = new StringBuilder();
        for (int r = n - 1; r >= 1; r--) {
            for (int c = 0; c < n - r; c++) {
                sb.append(" ");
            }
            for (int cS = n - r; cS < n; cS++) {
                sb.append("* ");
            }
            sb.append(System.lineSeparator());
        }
       return sb.toString();
    }

}
