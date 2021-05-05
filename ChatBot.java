package com.chatbot;

/*
    ChatBot class starts new game between the 2 players
    */
public class ChatBot {

     /*
     * Start a new game by creating two players initiator and receiver.
     * initiator sends two messages to receiver, receiver sends one message to initiator and prints the messages.
     */

     public static void main(String[] args) {
         Player initiator = new PlayersChat("initiator");       // create initiator
         Player receiver = new PlayersChat("receiver");         // create receiver

         String messageReceivedFromReceiver = initiator.sendMessageToPlayer(receiver, "Hello, i am " + initiator.getName() + ", what is my message counter");
         String messageReceivedFromInitiator = receiver.sendMessageToPlayer(initiator, "Hello, i am " + receiver.getName() + ", what is my message counter");
         System.out.println("Message sent to player2, message received: " + messageReceivedFromReceiver);

         messageReceivedFromReceiver = initiator.sendMessageToPlayer(receiver, "Hello, i am " + initiator.getName() + ", what is my message counter");
         System.out.println("Message sent to player2, message received: " + messageReceivedFromReceiver);
         System.out.println("Message sent to initator, message received: " + messageReceivedFromInitiator);
        }

}


