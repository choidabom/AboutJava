# Chapter 9. java.lang 패키지와 유용한 클래스
## 1. Object 클래스
### 1. Object 클래스의 메서드

- 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다.
- **notify(), wait()** 등은 쓰레드와 관련된 메서드이다. (쓰레드는 13장)
- equals(), hashCode(), toString()은 적절히 오버라이딩해야 한다.

### 2. equals(Object obj)
- 객체 자신(this)와 주어진 객체(obj)를 비교한다.
- 반환 타입은 boolean, 같으면 true, 다르면 false
- Object 클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)

```java
 public boolean equals(Object obj){
   return (this==obj);
   // 주소가 같아야 true
 }
```
```java
   class Value {
      int value;
      Value(int value){
         this.value = value;
      }
      // 오버라이딩을 안 했기 때문에 조상인 Object의 toString()을 그대로 씀
   }

   class Ex9_1{
      public static void main(String[] args){
         // 값이 같은 Value 객체 두 개 만듬
         Value v1 = new Value(10);
         Value v2 = new Value(10);
      }
      System.out.println(v1.equals(v2));
      // v1과 v2는 서로 다른 객체는 항상 주소가 다르다.
      // v1 == v2 -> 0x1234 == 0x2345 -> false
   }
```
### 3. equals(Object obj)의 오버라이딩
- 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야 한다.
- cv: 객체마다 공통(공유)
- iv: 객체마다 다름(개별)

```java
   class Person{
      long id; // 주민번호

      public boolean equals(Object obj){  // equals() 오버라이딩
         if(obj instanceof Person){
            return id == ((Person)obj).id;
         }
         else return false;
      }
      Person(long id){
         this.id = id;
      }
   }
   // Person p1 = new Person(8011081111222L);
   // Person p1 = new Person(8011081111222L);
   // 원래 Object의 equals()는 주소 비교를 했기에 false가 나옴.
   // iv 값이 나오도록 오버라이딩을 해줘야 한다.
```
### 4. hashCode()

- 객체의 **해시코드(hash code)**를 반환하는 메서드
- 해시코드 -> 정수값
- Object 클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
```java
   public class Object{
      public native int hashCode();
      
      // native 메서드: OS의 메서드(C언어)
      // 이미 작성되어 있는 메서드를 호출하는 것이기 때문에 내용이 없다.
   }
```
- equals()를 오버라이딩하면, hashCode()도 오버라이딩해야 한다. **equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문**
```java
   String str1 = new String("abc");
   String str2 = new String("abc");
   System.out.println(str1.equals(Str2)); // true
   System.out.println(str1.hashCode());   // 96354
   System.out.println(str1.hashCode());   // 96354
```
- System.identity.HashCode(Object obj)는 Object클래스의 hashCode()와 동일

### 5. toString(), toString()의 오버라이딩
- toStirng(): 객체를 문자열(String)으로 변환하기 위한 메서드

객체==iv집합이므로 객체를 문자열로 변환한다는 것은 iv의 값을 문자열로 변환한다는 것과 같다.



## 2. String 클래스
### 1. String 클래스 
- String 클래스: 문자열을 다루기 위한 클래스
- String 클래스 = 데이터(char[]) + 메서드(문자열 관련) 
- **내용을 변경할 수 없는 불변(immutable) 클래스**

 => 내용 변경 불가, 새로운 객체 생성

- **덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐**
- 문자열의 결합이나 변경이 잦다면, **내용을 변경가능한 StringBuffer**를 사용

```java
   String a = "a";   // 주소값 = 0x100
   String b = "b";   // 주소값 = 0x200
   a = a + b;        // 주소값 = 0x300
   // 문자열 결합을 할 때마다 a가 ab로 바뀌는게 아니라 새로운 문자가 만들어짐.
```

### 2. 문자열의 비교 
- `String str = "abc";`와 `String str = new String("abc");`의 비교
```java
   String str1 = "abc";  // 문자열 리터럴 "abc"의 주소가 str1에 저장됨
   String str2 = "abc";  // 문자열 리터럴 "abc"의 주소가 str2에 저장됨
   String str3 = new String("abc"); // 새로운 String 인스턴스를 생성
   String str4 = new String("abc"); // 새로운 String 인스턴스를 생성

   str1 == str2 ? true     // ==는 주소 비교
   str1.equals(str2) ? true   // equals는 내용 비교

   str3 == str4 ? false    // 서로 다른 객체라 주소가 달라 false가 나옴
   str3.equals(str4) ? true   // equals는 내용 비교

```
=> new 연산자를 사용하면 항상 새로운 객체가 생성된다.

### 3. 문자열 리터럴
- 문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(constant pool에 저장)
- 원래 String은 클래스이니깐 `new String("abc");` 이렇게 객체 생성을 해야하는데 문자열 리터럴로 적은 것은 프로그램 실행시 자동으로 `new String("abc");`가 생성된다.
- 프로그램에 있는 모든 상수는 constant pool에 저장된다. constant pool = 상수 저장소
- 같은 내용의 문자열 리터럴은 하나만 만들어진다.

```java
   class Ex9_7{
      public static void main(String args[]){
         String s1 = "AAA";
         String s2 = "AAA";
         String s3 = "AAA";
         String s4 = "BBB";
      }
   }
```
### 4. 빈 문자열("", empty string)
- 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열
```java
   String str = "";  // str을 빈 문자열로 초기화
```
- 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능
- 자바에서는 크기가 0인 배열을 생성하는거 허용함
```java
   char[] chArr = new char[0];   // 길이가 0인 char배열
   int[] iArr = {};              // 길이가 0인 int배열
```
- 문자(char)와 문자열(String)의 초기화
```java
   String s = null;
   char c = '\u0000';

   String s = ""; // 빈 문자열로 초기화
   char c = ' ';   // 공백으로 초기화
```

**활용**
1) 숫자를 문자로 바꿔줄 때 사용 가능 `String str = ""+ 5;` => "5"

2) null 이용 안 하고 배열 초기화 가능

### 5. String 클래스의 생성자와 메서드

1) **String(String s)**

주어진 문자열(s)을 갖는 String 인스턴스를 생성한다.

```java
   String s = new String("Hello"); 

   결과) s = "Hello";
```

2) **String(char[] value)**

주어진 문자열(value)을 갖는 String 인스턴스를 생성한다.

```java
   // char 배열을 생성자에 넣으면 문자열이 만들어짐
   char[] c = {'H', 'e', 'l', 'l', 'o'};
   String s = new String(c); 

   결과) s = "Hello";

   // String => char 배열 로 바꿀 때 toCharArrya() 사용
```

3) **String(StringBuffer buf)**

StringBuffer 인스턴스가 갖고 있는 문자열과 같은 내용의 String 인스턴스를 생성한다. (StringBuffer => 내용 변경 가능)

```java
   StringBuffer sb = new StringBuffer("Hello");
   String s = new String(sb);

   결과) s = "Hello";
```

4) **char charAt(int idex)**

지정된 위치(index)에 있는 문자를 알려준다. (index는 0부터 시작)/**문자 한 개 반환**

```java
   Stinrg s = "Hello";
   Stinrg n = "0123456";
   char c = s.charAt(1);
   char c2 = n.charAt(1);

   결과) c = 'e';
   c2 = '1';
```

5) **int compareTo(String str)**

문자열(str)과 사전순서로 비교한다. 같으면 0을, 사전순으로 이전이면 음수를, 이후면 양수를 반환한다.

```java
   int i = "aaa".compareTo("aaa");
   int i2 = "aaa".compareTo("bbb");
   int i3 = "aaa".compareTo("aaa");

   결과) 
   i = 0    // 같으면
   i2 = -1  // 왼쪽이 작으면
   i3 = 1   // 오른쪽이 크면
```
6) **String concat(String str)**

문자열(str)을 뒤에 덧붙인다.

```java
   String s = "Hello";
   String s2 = s.concat(" World");

   결과) 
   s2 = Hello World
```

7) **boolean contains(CharSequence s)**

지정된 문자열(s)이 포함되었는지 검사한다.

```java
   String s = "abcdefg";
   String b = s.concat("bc");

   결과) 
   b = true
```
- CharBuffer, Segment, String, StringBuffer, StringBuilder => 공통 조상이 없음
- Interface CharSequence를 매개변수로 해놓으면 [CharBuffer, Segment, String, StringBuffer, StringBuilder]이 클래스들이 다 매개변수로 들어갈 수 있다.
- 인터페이스 장점: 서로 관계없는 클래스들의 관계를 맺어줄 수 있다.
- 

8) **boolean endsWith(Stirng suffix)**

지정된 문자열(suffix)로 끝나는지 검사한다.

```java
   String file = "Hello.txt";
   String b = file.endsWith("txt");

   결과) 
   b = true
```
- endsWith의 반대로 startsWidth가 있다.

9) **boolean equals(Object obj)**

매개변수로 받은 문자열(obj)과 String 인스턴스의 문자열을 비교한다. obj가 String이 아니거나 문자열이 다르면 false를 반환한다.

```java
   String s = "Hello";
   String b = s.equals("Hello");
   String b2 = s.equals("hello");

   결과) 
   b = true
   b2 = false
```

10) **boolean equalsIgnoerCase(String str)**

문자열과 String 인스턴스의 문자열을 대소문자 구분없이 비교한다.

```java
   String s = "Hello";
   boolean b = s.equalsIgnoerCase("HELLO");
   String b2 = s.equalsIgnoerCase("hello");

   결과) 
   b = true
   b2 = true
```

11) **int indexOf(int ch)**

주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.(index는 0부터 시작)

```java
   String s = "Hello";
   int idx1 = s.indexOf('o');
   int idx2 = s.indexOf('k');

   결과) 
   idx1 = 4
   idx2 = -1
```

12) **int indexOf(int ch, int pos)**

13) **int indexOf(String str)**

14) **int lastIndexOf(int ch)**

15) **int lastIndexOf(String str)**

16) **int length()**

17) **String[] split(String regex)**

18) **String[] split(String regex, int limit)**

19) **boolean starsWidth(String prefix)**

20) **String substring(int begin)**/**String substring(int begin, int end)**

21) **String toLowerCase()**

22) **String toUpperCase()**

23) **String trim()**

### 6. join()과 StringJoiner
- join()은 여러 문자열 사이에 구분자를 넣어서 결합한다.

```java
   String animals = "dog, cat, bear";
   String[] arr =  animals.split(","); // 문자열을 ',' 구분자로 배열에 저장
   String str = String.join("-", arr); // 배열의 문자열을 '-'로 구분해서 결합
   System.out.println(str);   // dog-cat-bear
```

### 7. 문자열과 기본형 간의 변환
- 숫자를 문자열로 바꾸는 방법
```java
   int i = 100;
   String str1 = i + "";            // 100을 "100"으로 변환하는 방법1(편리)
   String str2 = String.valueOf(i); // 100을 "100"으로 변환하는 방법2(속도가 빠름)
```

- 문자열을 숫자로 바꾸는 방법
```java
   int i = Integer.parseInt("100");
   int i2 = Integer.valueOf("100");
   Integer i2 = Integer.valueOf("100");
```

## 3. StringBuffer 클래스


## 4. Math & wrapper 클래스