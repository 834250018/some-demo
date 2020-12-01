package com.ywy.demo.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author 83425
 * @date 2020/11/15 17:49
 */
public class ForwardActor extends UntypedActor {
    private ActorRef target = getContext().actorOf(Props.create(TargetActor.class), "targetActor");

    @Override
    public void onReceive(Object message) throws Exception {
        target.forward(message, getContext());
    }
}
