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

```java
   
```

## 2. String 클래스


## 3. StringBuffer 클래스


## 4. Math & wrapper 클래스