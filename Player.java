package com.chatbot;

    /*
    * Players will send and receive messages.
     */
public interface Player {

    /* returns the player name */
    String getName();

    /*
    * to send a message to another player
    */
    String sendMessageToPlayer(Player toPlayer, String message);

    /*
    * to receive message from another player
    */
    String receiveMessageFromPlayer(Player fromPlayer, String message);
}
