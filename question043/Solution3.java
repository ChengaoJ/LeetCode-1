package question043;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82710845
 */
public class Solution3 {

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 1 && Integer.parseInt(num1) == 0) {
            return num1;
        }
        if (n2 == 1 && Integer.parseInt(num2) == 0) {
            return num2;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder[] stringBuilders = new StringBuilder[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            int flag = 0;
            for (int j = n1 - 1; j >= 0; j--) {
                Integer integer = Integer.parseInt(num1.substring(j, j + 1)) * Integer.parseInt(num2.substring(i, i + 1));
                stringBuilder.append((integer + flag) % 10);
                flag = (integer + flag) / 10;
            }
            if (flag > 0) {
                stringBuilder.append(flag);
            }
            stringBuilders[n2 - i - 1] = stringBuilder;
        }
        int flag = 0;
        for (int i = 0; i < stringBuilders[n2 - 1].length() + n2 - 1; i++) {
            int sum = 0;
            for (int j = 0; j < n2; j++) {
                if (i - j < stringBuilders[j].length() && i - j >= 0) {
                    sum += Integer.parseInt(stringBuilders[j].substring(i - j, i - j + 1));
                }
            }
            int num = (sum + flag) % 10;
            flag = (sum + flag) / 10;
            result.append(num);
        }
        if (flag > 0) {
            result.append(flag);
        }
        return result.reverse().toString();
    }
}
