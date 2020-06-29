import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {

        // 北京大学对本科生的成绩施行平均学分绩点制（GPA）。
        // 既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
        // 公式如下：
        // 实际成绩 绩点
        // [90, 100] 4.0
        // [85, 89] 3.7
        // [82, 84] 3.3
        // [78, 81] 3.0
        // [75, 77] 2.7
        // [72, 74] 2.3
        // [68, 71] 2.0
        // [64, 67] 1.5
        // [60, 63] 1.0
        // [59, 0] 0
        //  1．一门课程的学分绩点 = 该课绩点 * 该课学分
        //  2．总评绩点 = 所有学科绩点之和 / 所有课程学分之和
        //  现要求你编写程序求出某人 A 的总评绩点（GPA）。

        // 输入描述:
        // 第一行 总的课程数 n（n < 10）；
        // 第二行 相应课程的学分（两个学分间用空格隔开）；
        // 第三行 对应课程的实际得分；
        // 此处输入的所有数字均为整数。
        // 输出描述:
        // 输出有一行，总评绩点，精确到小数点后 2 位小数。[printf("%.2f",GPA)]

        //示例:
        //输入
        //5
        //4 3 4 2 3
        //91 88 72 69 56
        //输出
        //2.52

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] credit = new int[n]; // 存放相应课程的学分
        int[] score = new int[n]; // 存放对应课程的实际得分
        double[] creditPoint = new double[n]; // 存放对应课程的学分绩点
        double point = 0; // 绩点
        double GPA = 0; // 总评绩点
        for (int i = 0; i < n; i++) {
            credit[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            // 判定对应课程所得绩点
            if (score[i] <= 100 && score[i] >= 90) {
                point = 4.0;
            }else if (score[i] <= 89 && score[i] >= 85) {
                point = 3.7;
            }else if (score[i] <= 84 && score[i] >= 82) {
                point = 3.3;
            }else if (score[i] <= 81 && score[i] >= 78) {
                point = 3.0;
            }else if (score[i] <= 77 && score[i] >= 75) {
                point = 2.7;
            }else if (score[i] <= 74 && score[i] >= 72) {
                point = 2.3;
            }else if (score[i] <= 71 && score[i] >= 68) {
                point = 2.0;
            }else if (score[i] <= 67 && score[i] >= 64) {
                point = 1.5;
            }else if (score[i] <= 63 && score[i] >= 60) {
                point = 1.0;
            }else {
                point = 0;
            }
            creditPoint[i] = point * credit[i]; // 计算对应课程的学分绩点
        }
        double creditPointSum = 0; // 所有学科绩点之和
        double creditSum = 0; // 所以课程学分之和
        // 计算 GPA
        for (int i = 0; i < n; i++) {
            creditSum += credit[i];
            creditPointSum += creditPoint[i];
        }
        GPA = creditPointSum / creditSum;
        System.out.printf("%.2f", GPA);
    }

    public static void main(String[] args) {

        // 人民币转换
        // 1. 中文大写金额数字前应标明 "人民币" 字样。
        // 中文大写金额数字应用 壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
        // 2. 中文大写金额数字到 "元" 为止的，在 "元" 之后，应写 "整" 字，如 ￥ 532.00 应写成 "人民币伍佰叁拾贰元整"。
        // 在 "角" 和 "分" 后面不写 "整" 字。
        // 3. 阿拉伯数字中间有 "0" 时，中文大写要写 "零" 字，阿拉伯数字中间连续有几个 "0" 时，中文大写金额中间只写一个 "零"字
        // 如 ￥6007.14，应写成 "人民币陆仟零柒元壹角肆分"。

        // 输入描述:
        // 输入一个 double 数
        // 输出描述:
        // 输出人民币格式

        // 示例:
        // 输入
        // 151121.15
        // 输出
        // 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            double money = sc.nextDouble();
            String[] character = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
            StringBuffer buffer = new StringBuffer(); // 临时空间
            int hundredMillon = (int) (money / 100000000); // 亿
            int tenThousand = (int) ((money - hundredMillon * 100000000) / 10000); // 万
            int thousand = (int) (money - hundredMillon * 100000000 - tenThousand * 10000); // 千
            System.out.print("人民币");
            if (hundredMillon != 0) {
                buffer.append(count(hundredMillon) + "亿");
            }
            if (tenThousand != 0) {
                buffer.append(count(tenThousand) + "万");
            }
            if (thousand != 0) {
                buffer.append(count(thousand) + "元");
            }

            // 小数部分的整数
            int decimal = (int) ((money - hundredMillon * 100000000 - tenThousand * 10000 - thousand + 0.001) * 100);
            int jiao = decimal / 10; // 角
            int fen = decimal % 10; // 分
            if (jiao != 0 && fen != 0) {
                buffer.append(character[jiao] + "角" + character[fen] + "分");
            }else if(jiao != 0 && fen == 0) {
                buffer.append(character[jiao] + "角");
            }else if (jiao == 0 && fen != 0) {
                buffer.append(character[fen] + "分");
            }else if (jiao == 0 && fen == 0) {
                buffer.append("整");
            }
            System.out.println(buffer.toString());
        }
        sc.close();
    }

    public static String count(int a) {
        String[] character = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾" };
        int thousand = a / 1000;
        int hundred = (a - thousand * 1000) / 100;
        int ten = (a - thousand * 1000 - hundred * 100) / 10;
        int one = a - thousand * 1000 - hundred * 100 - ten * 10;
        StringBuffer stringbuffer = new StringBuffer();
        if (thousand != 0) {
            stringbuffer.append(character[thousand] + "仟");
        }
        if (hundred != 0) {
            stringbuffer.append(character[hundred] + "佰");
        } else if (thousand != 0 && hundred == 0 && (ten != 0 || one != 0)) {
            stringbuffer.append("零");
        }
        if (ten != 0 && ten != 1) {
            stringbuffer.append(character[ten] + "拾");
        } else if (hundred != 0 && one != 0) {
            stringbuffer.append("零");
        }
        if(ten == 1 && (thousand != 0|| hundred != 0)){
            stringbuffer.append(character[ten] + "拾");
        }
        if(ten == 1 && thousand == 0 && hundred == 0){
            stringbuffer.append("拾");
        }
        if (one != 0) {
            stringbuffer.append(character[one]);
        }
        String s = stringbuffer.toString();
        return s;
    }
}
