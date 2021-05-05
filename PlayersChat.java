package com.chatbot;

import java.util.HashMap;
import java.util.Map;

/*
 * PlayersChat class implements a Player which is able to send and receive message with other players.
 */
public class PlayersChat implements Player {
    /**
     *  Player name
     */
    private final String name;
    /**
     * Keep track of received messages for each other player using hashmap.
     */
    private final Map<Player, Integer> receivedMessages = new HashMap<>();

    /**
     * Create a new player with the provided name
     */
    public PlayersChat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    /**
     * Sends a message to another player
     * returns message + counter (messages sent to otherPlayer)
     */
    @Override
    public String sendMessageToPlayer(Player toPlayer, String message) {
        LoggingMessages.writeLog(this.name + " sent a message '" +message + "' to " +toPlayer.getName(), PlayersChat.class.getName());
        return toPlayer.receiveMessageFromPlayer(this, message);
    }

    /**
     * Receives a message from another player.
     * If the number of messages received from this player is 10 exit the program gracefully
     * returns message + counter (messages received from otherPlayer)
     */
    @Override
    public String receiveMessageFromPlayer(Player fromPlayer, String message) {
        Integer counter = receivedMessages.getOrDefault(fromPlayer, 0) + 1;
        receivedMessages.put(fromPlayer, counter);
        LoggingMessages.writeLog(this.name + " received a (counter: "+counter+") message '" +message + "' from " +fromPlayer.getName(), PlayersChat.class.getName());
        if (counter == 10) {
            System.exit(0);
        }
        return message + counter;
    }
}