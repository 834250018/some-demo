package com.ywy.demo.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author 83425
 * @date 2020/11/15 16:26
 */
public class ActorDemo extends UntypedActor {
    public static void main(String[] args) {

        // exception
        //        ActorDemo actorDemo = new ActorDemo();

        // 每个应用都要创建一个ActorSystem
        ActorSystem actorSystem = ActorSystem.create();

        // actor不能重名
        // 创建一个actor的引用
        ActorRef actorDemo = actorSystem.actorOf(Props.create(ActorDemo.class));

        // 创建Props有两种方法,1.直接创建 2.重写akka.japi.Creator接口
        Props.create(ActorDemo.class);
        Props.create(ActorDemo.class);

    }

    @Override public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            // 通过context创建子actor
            ActorRef actorRef = getContext().actorOf(Props.create(ChildActor.class));
            System.out.println(message);
            System.out.println("发送者是:" + getSender());
            getSender().tell("copy that", getSelf());
        } else {
            unhandled(message);
        }
    }

}
