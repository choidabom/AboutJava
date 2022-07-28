class MyPoint3 extends Object{
    int x;
    int y;
    
    // Object클래스의 toString()을 오버라이딩
    public String toString(){
        return "x:"+x+", y"+y;
    }
  }

  public class Ch7_OverrideTest_Object { 
        public static void main(String[] args) {
            MyPoint3 p = new MyPoint3();
            p.x = 3;
            p.y = 5;
            System.out.println(p.toString());
        }
  }