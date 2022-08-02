import javax.print.DocFlavor.STRING;

class Ch9_valueOf {
    public static void main(String[] args) {
        int iVal = 100;
        String strVal = String.valueOf(iVal);   // int를 String로 변환한다.
        // String strVal = iVal + "";

        double dVal = 200.0;
        String strVal2 = dVal + "";     // int를 String로 변환한다.

        double sum = Integer.parseInt("+"+strVal) + Double.parseDouble(strVal2);

        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

        System.out.println(String.join("", strVal,"+", strVal2,"=")+sum);

        System.out.println(strVal+"+"+strVal2+"="+sum2);

    }
}