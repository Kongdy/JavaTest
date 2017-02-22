package test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;

@Deprecated
public class Test {

	public class E {
		public int is_correct;
		public String name;

		public String getName() {
			return name;
		}
	}

	class Output {
		void op() {
			System.out.println("dadada");
		}
	}

	class MThread extends Thread {

		private Output output;
		private Scanner scanner;

		public MThread(Output output, Scanner scanner) {
			this.output = output;
			this.scanner = scanner;
		}

		@Override
		public void run() {
			// super.run();
			System.out.println("running.......");
			System.out.println("son current:"
					+ Thread.currentThread().getName());
			for (;;) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				String s = scanner.next();
				if (null != s && !"".equals(s.trim())) {
					System.out.println("current:"
							+ Thread.currentThread().getName());
					this.output.op();
				}
			}
		}
	}

	public static String hex2Str(String str)
			throws UnsupportedEncodingException {
		String strArr[] = str.split("\\\\");
		byte[] byteArr = new byte[strArr.length - 1];
		for (int i = 1; i < strArr.length; i++) {
			Integer hexInt = Integer.decode("0" + strArr[i]);
			System.out.println(i + ",byte:" + hexInt);
			byteArr[i - 1] = hexInt.byteValue();
		}
		return new String(byteArr, "UTF-8");
	}

	public class Candidate {
		public boolean editable;
		public int id;
		public String name;
		public String url;
	}

	public class Result<T> {
		public int code;
		public T data;
	}

	public class MyCandidate<T> {
		public List<T> candidates;
	}

	public class Root<T> {
		public String status;
		public T content;
	}

	public class OrderInfoList<T> {
		public int totalCount;
		public List<T> orderInfoList;
	}

	@D2
	private static int bb = 2;

	@Deprecated
	public static void main(String[] args) throws UnsupportedEncodingException {

		/**
		 * 只使用一个循环打印出99乘法表
		 * 并且不使用if和switch
		 */
		int maxFactor = 9;
		for (int i = 1, j = 1; j < maxFactor; j++) {
			int result = i * j;
			System.out.print(i + "*" + j + "=" + result + "\t");
			String symbol = i == j ? "\n" : "\t";
			result = (j == maxFactor - 1 && i == maxFactor)?(maxFactor * maxFactor):result;
			symbol = (j == maxFactor - 1 && i == maxFactor) ? (i + "*" + maxFactor + "=" + result+"\n"):(i == j ? "\n" : "\t");
			int tempI = i;
			int tempJ = j;
			j = tempI == tempJ ? 0 : j;
			i = tempI == tempJ ? i + 1 : i;
			System.out.print(symbol);
		}
		//
		// Gson gson = new Gson();
		// Root<OrderInfoList<HashMap<Object, Object>>> r = gson.fromJson(msg1,
		// new TypeToken<Root<OrderInfoList<HashMap<Object, Object>>>>() {
		// }.getType());
		//
		// System.out.println("r.status:"+r.status+"\tr.content.orderInfoList.size():"+
		// r.content.orderInfoList.size()+"\tr.content.orderInfoList.get(0).order_info:"+r.content.orderInfoList.get(0).get("order_info"));

		// Gson gson = new Gson();
		//
		// Result<MyCandidate<Candidate>> result = gson.fromJson(msg,new
		// TypeToken<Result<MyCandidate<Candidate>>>() {
		// }.getType());
		//
		// result.data.candidates.stream().forEach(c->System.out.println(c.name));
		//

		// /**
		// * 字符解码
		// */
		// String s =
		// "\\xe5\\x85\\xb6\\xe4\\xbb\\x96\\xe6\\x96\\x87\\xe4\\xbb\\xb6\\xe5\\xa4\\xb9";
		// System.out.println(hex2Str(s));
		//

		/**
		 * 线程
		 */

		// Test t = new Test();
		// Scanner scanner = new Scanner(System.in);
		//
		//
		// MThread thread = t.new MThread(t.new Output(),scanner);
		// thread.start();
		//
		//
		// Thread t1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		//
		// }
		//
		// });
		// t1.start();

		/**
		 * 72级地震能量换算
		 * 
		 * 参数1：被除能量的首个数字 参数2：被除能量的幂的次方 即： 参数1*10^参数2
		 * 
		 * 
		 */

		// BigDecimal bd = new BigDecimal("1.4");
		// BigDecimal bd2 = bd.pow(660);
		//
		//
		// Scanner scanner = new Scanner(System.in);
		//
		// double headNum = scanner.nextDouble();
		// int miNum = scanner.nextInt();
		//
		// BigDecimal dbd1 = new BigDecimal(headNum);
		// BigDecimal dbdTen = new BigDecimal(10);
		//
		// BigDecimal resultDbd = dbd1.multiply(dbdTen.pow(miNum));
		//
		// scanner.close();
		//
		// BigDecimal sixShake = new BigDecimal(6.3);
		// bd2 = bd2.multiply(sixShake.multiply(dbdTen.pow(13)));
		//
		// BigDecimal finalNum =
		// bd2.divide(resultDbd,100,BigDecimal.ROUND_HALF_UP);
		//
		// System.out.println("bd result:"+finalNum);
		//

		/**
		 * 扯淡的错误
		 */
		// String str =
		// "[{\"is_correct\": 1, \"name\": \"\\u97ad\\u70ae\\u70df\\u82b1\"}, {\"is_correct\": 0, \"name\": \"\\u5916\u5356\"}, {\"is_correct\": 0, \"name\": \"\\u9c9c\\u82b1\"},"
		// + " {\"is_correct\": 0, \"name\": \"\\u852c\\u679c\"}]";
		// List<LinkedTreeMap<String, Object>> aa = new ArrayList<>();
		// aa = new Gson().fromJson(str, aa.getClass());
		//
		// Stream<String> s = aa.stream().filter(b
		// ->b.get("is_correct").equals(1d)).map(b -> b.get("name")+"");
		// s = aa.stream().map(b
		// ->b.get("is_correct").equals(1d)?b.get("name")+"":"").filter(x ->
		// x!="");
		//
		// s.forEach(System.out::println);
		//
		// StringBuffer sb = new StringBuffer("asdsadsaasfasf");
		// sb.setLength(0);
		// System.out.println(sb.length());
		// System.out.println(sb.toString()+"l:"+sb.toString().length());

		// double x = 0.231223132321611651515d;
		// System.out.println((new
		// DecimalFormat(".00000000")).format(x).substring(1));

		// for(int i = 0;i < 10;i++) {
		// System.out.println((new
		// DecimalFormat(".00000000")).format(Math.random()).substring(1));
		// }

		/**
		 * 找出一个数组、集合中两个不重复的数字 异或算法
		 */
		// int[] temp1 =
		// {1,14,1,2,11,2,3,12,3,4,12,4,5,13,5,6,13,6,7,7,8,14,8,9,15,9,10,10};
		// int singleNum1 = temp1[0];
		// for(int i = 1;i < temp1.length;i++) {
		// singleNum1 = singleNum1^temp1[i];
		// }
		// int oneIndex =
		// Integer.toBinaryString(singleNum1).length()-Integer.toBinaryString(singleNum1).lastIndexOf('1');
		// int firstNum = -1;
		// int secondNum = -1;
		// for(int i = 0;i < temp1.length;i++ ) {
		// if(Integer.toBinaryString(temp1[i]).length() > oneIndex &&
		// Integer.toBinaryString(temp1[i]).charAt(Integer.toBinaryString(temp1[i]).length()-oneIndex)
		// == '1'
		// ) {
		// firstNum = firstNum==-1?temp1[i]:firstNum^temp1[i];
		// } else {
		// secondNum = secondNum==-1?temp1[i]:secondNum^temp1[i];
		// }
		// }
		// System.out.println("firstNum:\t"+firstNum+",secondNum:"+secondNum+",oneIndex:"+oneIndex);

		/**
		 * 找出一个数组、集合中唯一一个没有重复的数字 异或算法
		 */
		// int[] temp =
		// {1,14,1,2,11,2,3,12,3,4,12,4,5,13,5,6,13,6,7,7,8,14,8,9,9,10,10};
		// int singleNum = temp[0];
		// for(int i = 1;i < temp.length;i++) {
		// singleNum = singleNum^temp[i];
		// }
		// System.out.println("singleNum:"+singleNum);

		/**
		 * 100个灯，3的倍数按钮按一次，5的倍数按钮按一次，最后亮多少个灯
		 */
		// a();

		/**
		 * 随机生成一个中文
		 */
		// byte[] c = new byte[2];
		// c[0] = (new Integer((r.nextInt(0xD7)%(0xD7-0xB0))<<8).byteValue());
		// c[1] = (new Integer(r.nextInt(0xD7)%(0xD7-0xB0)).byteValue());
		//
		// try {
		// String str = new String(c,"gb2312");
		// System.out.println(str);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// Test t = new Test();
		// System.out.println("bb:"+bb);
		// Random r = new Random();
		// int count = 0;
		// while(count++ < 50) {
		// byte[] b = {
		// new Integer(0xB0 + Math.abs(r.nextInt(0x27))).byteValue(),
		// new Integer(0xB0 + Math.abs(r.nextInt(0x4D))).byteValue() };
		// System.out.print(new String(b, "gb2312"));
		// }

		//
		// String aaa = new String("123456789");
		// System.out.println("subString:"+aaa.substring(0, 1));
		// System.out.println("org:"+aaa);

		// Gson gson =new Gson();
		// JfMallItemPageDto page = new JfMallItemPageDto();
		// List<JfMallItemDto> dtos = new ArrayList<JfMallItemDto>();
		// page.hasMore = false;
		// page.limit = 1;
		// page.total = 2;
		// for (int i = 0; i < 10; i++) {
		// JfMallItemDto dto = new JfMallItemDto();
		// dto.createdTime = 124557658568L;
		// dtos.add(dto);
		// }
		// page.records = dtos;
		// String msg = gson.toJson(page);
		// System.out.println(msg);
		// StringBuilder newBuilder = new StringBuilder();
		// StringBuilder builder = new StringBuilder();
		// builder.append("61651121616522223");
		// newBuilder.append(builder.substring(0, builder.lastIndexOf("2")));
		// System.out.println(newBuilder.toString());
		// Calendar cal = Calendar.getInstance();
		// cal.setTimeInMillis(-62167219200000L);
		// // System.out.println(cal.toInstant());
		// SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// Date d1 = null;
		// try {
		// d1 = f1.parse("2016-01-02 15:21:23");
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// System.out.println("time:"+d1);
		// boolean flag = (2 & 2) !=1;
		// System.out.println("flag:"+(1 & 2));
		// String text = "100000000000";
		// int s = Integer.parseInt(text,30);
		// System.out.println("result:"+s);
		/*
		 * String str = "00000000000000000000000000000000000"; String regex =
		 * "^0+$"; Pattern pattern = Pattern.compile(regex); Matcher matcher =
		 * pattern.matcher(str);
		 * 
		 * System.out.println(matcher.matches());
		 */
		// Scanner scan = new Scanner(System.in);
		// String s1 = scan.nextLine();
		// String s2 = scan.nextLine();
		// String s3 = scan.nextLine();
		// System.out.println("s1:"+s1+",s2:"+s2+",s3:"+s3);
		// String aa = "asdsds";
		//
		// String cc = bb = aa;
		// System.out.println("aa:"+aa+",bb:"+bb+",cc:"+cc);

		// Stack<Integer> inputStack = new Stack<>();
		// String text = "03809218476170706c69636174696f6e";
		// byte[] aaa = Base64.getDecoder().decode(text);
		// String str = new String(aaa);
		// System.out.println(str);

		// String result = toStringHex("03809218476170706c696361"
		// + "74696f6e2f636f6d2e69636c6f75647576323232352c313331"
		// + "36323333333835342c31383831373530393231322c412c302c302ce69"
		// + "d8ee9b98fe9a39e2c2c2ce9ad8fe88f8a7c6163323031353030322c616964");
		// System.out.println("result:"+result);
		// int a,b,c;
		// a = 5;
		// b = 6;
		// c = 7;
		// System.out.println("hijk\tL\bM\n");

		// String str1 = "http://192.168.0.113:9001/sina/sinaReturn.html";
		// String str2 = "http://192.168.0.133:9001/sina/sinaReturn.html";
		//
		// for(int i = 0;i < str1.length();i++) {
		// char char1 = str1.charAt(i);
		// char char2 = str2.charAt(i);
		// if(char1 == char2) {
		// System.out.println("same:"+char1+","+char2);
		// } else {
		// System.out.println("dif:"+char1+","+char2);
		// }
		// }
		//
		// double i=2, j=2.1, k=2.5, m=2.9;
		//
		// System.out.println("舍掉小数取整:Math.floor(2)=" + (int)Math.floor(i));
		//
		// System.out.println("舍掉小数取整:Math.floor(2.1)=" + (int)Math.floor(j));
		//
		// System.out.println("舍掉小数取整:Math.floor(2.5)=" + (int)Math.floor(k));
		//
		// System.out.println("舍掉小数取整:Math.floor(2.9)=" + (int)Math.floor(m));

		/*
		 * 这段被注释的代码不能正确的实现四舍五入取整
		 * 
		 * System.out.println("四舍五入取整:Math.rint(2)=" + (int)Math.rint(i));
		 * 
		 * System.out.println("四舍五入取整:Math.rint(2.1)=" + (int)Math.rint(j));
		 * 
		 * System.out.println("四舍五入取整:Math.rint(2.5)=" + (int)Math.rint(k));
		 * 
		 * System.out.println("四舍五入取整:Math.rint(2.9)=" + (int)Math.rint(m));
		 * 
		 * 
		 * 
		 * System.out.println("四舍五入取整:(2)=" + new DecimalFormat("0″).format(i));
		 * 
		 * System.out.println("四舍五入取整:(2.1)=" + new
		 * DecimalFormat("0″).format(i));
		 * 
		 * System.out.println("四舍五入取整:(2.5)=" + new
		 * DecimalFormat("0″).format(i));
		 * 
		 * System.out.println("四舍五入取整:(2.9)=" + new
		 * DecimalFormat("0″).format(i));
		 */

		// System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0,
		// BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(2.1)=" + new
		// BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(2.5)=" + new
		// BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(2.9)=" + new
		// BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("凑整:Math.ceil(2)=" + (int)Math.ceil(i));
		//
		// System.out.println("凑整:Math.ceil(2.1)=" + (int)Math.ceil(j));
		//
		// System.out.println("凑整:Math.ceil(2.5)=" + (int)Math.ceil(k));
		//
		// System.out.println("凑整:Math.ceil(2.9)=" + (int)Math.ceil(m));
		//
		// System.out.println("舍掉小数取整:Math.floor(-2)=" + (int)Math.floor(-i));
		//
		// System.out.println("舍掉小数取整:Math.floor(-2.1)=" + (int)Math.floor(-j));
		//
		// System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int)Math.floor(-k));
		//
		// System.out.println("舍掉小数取整:Math.floor(-2.9)=" + (int)Math.floor(-m));
		//
		// System.out.println("四舍五入取整:(-2)=" + new BigDecimal("-2").setScale(0,
		// BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(-2.1)=" + new
		// BigDecimal("-2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(-2.5)=" + new
		// BigDecimal("-2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("四舍五入取整:(-2.9)=" + new
		// BigDecimal("-2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
		//
		// System.out.println("凑整:Math.ceil(-2)=" + (int)Math.ceil(-i));
		//
		// System.out.println("凑整:Math.ceil(-2.1)=" + (int)Math.ceil(-j));
		//
		// System.out.println("凑整:Math.ceil(-2.5)=" + (int)Math.ceil(-k));
		//
		// System.out.println("凑整:Math.ceil(-2.9)=" + (int)Math.ceil(-m));
	}

	public static void a() {
		List<Boolean> numl = Arrays.asList(new Boolean[150]);
		numl = numl.stream().map(b -> b = true).collect(Collectors.toList());
		for (int i = 0; i < numl.size(); i++) {
			if ((i + 1) % 3 == 0)
				numl.set(i, !numl.get(i));
			if ((i + 1) % 5 == 0)
				numl.set(i, !numl.get(i));
		}
		System.out.println(numl.stream().filter(b -> b)
				.collect(Collectors.toList()).size());
	}

	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

}
