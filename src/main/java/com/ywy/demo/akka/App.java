package com.ywy.demo.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author 83425
 * @date 2020/11/15 17:24
 */
public class App {
    public static void main(String[] args) {
        // 每个应用都要创建一个ActorSystem
        ActorSystem system = ActorSystem.create("system");

        /*ActorRef actorDemo = system.actorOf(Props.create(ActorDemo.class), "actorDemo");
        actorDemo.tell("Abc", ActorRef.noSender());
        System.out.println("ok");
*/
        /*ActorRef askActorDemo = system.actorOf(Props.create(AskActorDemo.class), "askActorDemo");
        Timeout timeout = new Timeout(Duration.create(2, TimeUnit.SECONDS));
        Future<Object> akka_ask = Patterns.ask(askActorDemo, "akka ask", timeout);
        System.out.println("ask....");
        akka_ask.onSuccess(new OnSuccess<Object>() {
            @Override public void onSuccess(Object result) throws Throwable {
                System.out.println("收到消息:" + result);
            }
        }, system.dispatcher());

        System.out.println("continue...");

        system.actorOf(Props.create(ForwardActor.class)).tell("abccc", ActorRef.noSender());*/

        // 查找一个actor,不同于ActorRef,通信用法上相同
        //        ActorSelection actorSelection = system.actorSelection();
        // 如果要拿到actorRef,发送一个Identify消息
        ActorRef lookupActor = system.actorOf(Props.create(LookupActor.class), "lookupActor");
        lookupActor.tell("find", ActorRef.noSender());
    }
}
