package com.ywy.demo.akka;

import akka.actor.*;

/**
 * @author 83425
 * @date 2020/11/15 18:01
 */
public class LookupActor extends UntypedActor {
    private ActorRef target = getContext().actorOf(Props.create(TargetActor.class), "targetActor");

    @Override public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            if ("find".equals(message)) {
                System.out.println(1111);
                ActorSelection as = getContext().actorSelection("targetActor");
                as.tell(new Identify("A001"), getSelf());
            }
        } else if (message instanceof ActorIdentity) {
            System.out.println(2222);
            ActorIdentity ai = (ActorIdentity)message;
            if (ai.correlationId().equals("A001")) {
                ActorRef ref = ai.getRef();
                if (ref != null) {
                    System.out.println("ActorIdentity11:" + ai.correlationId() + ref);
                    ref.tell("hello target", getSelf());
                }
            }
        } else {
            unhandled(message);
        }

    }
}
