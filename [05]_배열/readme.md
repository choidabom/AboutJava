# Chapter 5. 배열
 
## 1. 배열이란?

- **배열(Array)** 은 선형 자료구조 중 하나
- 동일한 타입의 데이터를 메모리에 연속적으로 저장하여, 하나의 변수로 묶어 관리하기 위함
  - 많은 양의 값(데이터)을 다룰 때 유용하다.
  - 서로 다른 타입의 변수로 구성된 배열을 만들 수 없다.
- 배열의 특징 배열을 구성하는 각 요소의 저장공간이 **연속적으로 배치**된다는 점
- **최초 선언한 길이가 고정**되며, **인덱스(index)**를 통해 데이터에 접근이 가능하다.
  - 인덱스는 배열의 요소마다 붙여진 번호이고, 각 요소를 구분할 때 사용한다.
  - 0부터 시작, 인덱스의 범위는 **0 ~ (배열의 길이 -1)** 까지이다.
- **Heap 메모리에 저장**된다.
 
```java
  int score1, score2, score3, score4;
  int[] score = new int[5];  // 5개의 int값을 저장할 수 있는 배열을 생성한다.
```

## 2. 배열의 선언과 생성
- 배열의 선언: 배열을 다루기 위한 참조변수의 선언
배열을 선언하는 것과 변수를 선언하는 것은 다르다. 
변수를 선언하는 순간 저장공간이 만들어지지만, 
배열을 선언하는 것은 실제 배열의 저장공간이 만들어지는 것이 아니라 배열을 다루기 위한 참조변수가 만들어지는 것이다.

```javaㅁ
  int score1, score2, score3, score4;
  int[] score = new int[5];  // 5개의 int값을 저장할 수 있는 배열을 생성한다.
```

<pre>
<code>
타입[] 변수이름; // 배열을 선언(배열을 다루기 위한 참조변수 선언)
변수이름 = new 타입[길이]; // 배열을 생성(실제 저장공간을 생성)
</code>
</pre>
|선언방법|선언 예|
|---|---|
|타입[] 변수이름;|int [] score;|
|타입[] 변수이름;|string [] name;|
|타입 변수이름[];|int score[];|
|타입 변수이름[];|string name[];|

## 3. 배열의 초기화
- 배열은 생성과 동시에 자동적으로 자신의 타입에 해당하는 기본값으로 초기화되므로 배열을 사용하기 전에 따로 초기화를 해주지 않아도 되지만, 원하는 값을 저장하려면 아래와 같이 각 요소마다 값을 지정해 줘야한다.

## 4. 다차원 배열의 선언과 생성

다차원 배열의 선언 방식은

```java
public class Array {
    String[][] arr = new String[5][5];
}
```

이렇게 선언해주는데 `String[행][렬]` 이라고 보면된다.

그래서 왼쪽은 행을 담당, 오른쪽은 열을 담당한다.

배열 x행 y열의 값을 출력하려면 `println(배열[x][y])` 이 되면 되겠다.

다차원 배열 연습은 [별 찍기](https://www.acmicpc.net/problemset?search=%EB%B3%84+%EC%B0%8D%EA%B8%B0) 가

최고인것 같다고 생각한다.


## 5. 배열의 복사
- 배열은 한번 생성하면 그 길이를 변경할 수 없기 떄문에 더많은 저장공간이 필요하다면 보다 큰 배열을 새로 만들고 이전 배열로부터 내용을 복사해야 함
