
class TV{

    boolean power; // 전원상태(on/off)
    int channel;    // 채널

    void power() { power = !power;}
    void channelUp() { channel++;}
    void channelDown() { channel--;}
}

class SmartTV extends TV {  // SmartTV는 TV에 캡션(자막)을 보여주는 기능 있음
    boolean caption;        // 캡션상태(on/off)
    void displayCaption(String text){
        if(caption){        // 캡션 상태가 on(true)일 떄만 text를 보여준다.
            System.out.println(text);
        }
    }
}


class Ch7_example {
    public static void main(String[] args) {
        SmartTV stv = new SmartTV();
        stv.channel = 10;   // 조상 클래스로부터 상속받은 멤버
        stv.channelUp();    // 조상 클래스로부터 상속받은 멤버
        System.out.println(stv.channel);
        stv.displayCaption("Hello, world");
        stv.caption = true; // 캡션(자막) 기능을 켠다.
        stv.displayCaption("Hello, world");
    }
}