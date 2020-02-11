package com.ping;

/**
 * @author:lyp
 * @date 2020/2/11-18:50
 * 静态代理
 */
//代理对象和被代理对象公共接口
interface  ClothFactory{
    //生产衣服
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    //代理实质就是使用被代理类调用
    @Override
    public void produceCloth() {

        System.out.println("开始调用静态代理。。。");
        clothFactory.produceCloth();
        System.out.println("结束调用静态代理。。。");
    }
}

//被代理类
class NikeFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("生产耐克。。。。");
    }
}

//测试静态代理
public class StaticProxyDemo{
    public static void main(String[] args) {
       NikeFactory nikeFactory=new NikeFactory();
       ProxyClothFactory proxyClothFactory=new ProxyClothFactory(nikeFactory);
       proxyClothFactory.produceCloth();
    }
}
