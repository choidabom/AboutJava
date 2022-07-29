
class Value {
    int value;

    Value(int value){
       this.value = value;
    }
    // 오버라이딩을 안 했기 때문에 조상인 Object의 toString()을 그대로 씀
    // 값을 true로 나오게 하려면 아래와 같이 오버라이딩
    public boolean equals(Object obj){
      // return this==obj; // 주소 비교. 서로 다른 객체는 항상 거짓
      // 참조변수의 형변화 전에는 반드시 instanceof로 확인해야함.
      if(!(obj instanceof Value)) return false;
      
      Value v = (Value)obj;   // obj를 value로 형변환
      
      return this.value==v.value;
    }
}

 class Ex9_1{
    public static void main(String[] args){
       // 값이 같은 Value 객체 두 개 만듬
       Value v1 = new Value(10);
       Value v2 = new Value(10);

       if(v1.equals(v2)){
        System.out.println("v1과 v2는 같습니다.");
       }
       else{
        System.out.println("v1과 v2는 다릅니다..");
       }

    }
    
    // v1과 v2는 서로 다른 객체는 항상 주소가 다르다.
    // v1 == v2 -> 0x1234 == 0x2345 -> false
 }