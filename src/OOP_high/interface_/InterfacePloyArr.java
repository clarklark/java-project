package OOP_high.interface_;

public class InterfacePloyArr {
    public static void main(String[] args) {
        Usb []usb=new Usb[2];
        //编译类型usb,运行类型Phone
        usb[0]=new Phone();
        usb[1]=new Camera();
        for(int i=0;i< usb.length;i++){
            usb[i].work();
            //instanceof用于判断运行类型是否一致
            if(usb[i] instanceof Phone){
                ((Phone) usb[i]).call();
            }
        }
    }
}

interface Usb{
    public void work();
}
class Phone implements Usb{
    @Override
    public void work() {
        System.out.println("手机工作");
    }
    public void call(){
        System.out.println("手机可以打电话");
    }

}
class Camera implements Usb{
    @Override
    public void work() {
        System.out.println("相机工作");
    }
}